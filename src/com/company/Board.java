package com.company;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private GraphicsContext gc;
    private List<Shape> shapes = new ArrayList<>();
    private Shape selected;
    private Group activeGroup;
    private final double DEFAULT_SIZE = 30;

    public Board(GraphicsContext gc) {
        this.gc = gc;
    }

    public void addBall() {
        Shape ball = new Ball(gc, DEFAULT_SIZE, 10, 10);
        shapes.add(ball);
        select(ball);
    }
	public void addBall(double size, double x, double y){
		Shape ball = new Ball(gc, size, x, y);
        shapes.add(ball);
        select(ball);
	}
	
    public void addSquare() {
        Shape square = new Square(gc, DEFAULT_SIZE,10, 10);
        shapes.add(square);
        select(square);
    }
	 public void addSquare(double size, double x, double y) {
        Shape square = new Square(gc, size, x, y);
        shapes.add(square);
        select(square);
    }
	
    public void addTriangle() {
        Shape triangle = new Triangle(gc, DEFAULT_SIZE,10, 10);
        shapes.add(triangle);
        select(triangle);
    }
	public void addTriangle(double size, double x, double y) {
        Shape triangle = new Triangle(gc, size, x, y);
        shapes.add(triangle);
        select(triangle);
    }
	
    public void delete() {
        shapes.remove(selected);
    }

    public void addInGroup() {
        if(activeGroup == null) {
            Group group = new Group(gc, DEFAULT_SIZE, selected.getX(), selected.getY());
            shapes.add(group);
            activeGroup = group;
        }
        activeGroup.add(selected);
        shapes.remove(selected);
        activeGroup.setSelected(true);
    }

    public void disconnectGroup() {
		List<Shape> list = activeGroup.getShapesInGroup();
		for(Shape shape: list) {
			shapes.add(shape);
		}
        shapes.remove(activeGroup);
        selected = shapes.get(0);
    }

    public void selectNext() {
        int selectedIndex = shapes.indexOf(selected);
        selectedIndex++;
        if(selectedIndex >= shapes.size()) {
            selectedIndex = 0;
        }
        select(shapes.get(selectedIndex));
    }
    public void selectPrevious() {
        int selectedIndex = shapes.indexOf(selected);
        selectedIndex--;
        if(selectedIndex < 0) {
            selectedIndex = shapes.size() - 1;
        }
        select(shapes.get(selectedIndex));
    }

    public void select(Shape shape) {
        for (Shape s : shapes) {
            s.setSelected(false);
        }
        selected = shape;
        selected.setSelected(true);
    }

    public void selectedZoomIn() {
        selected.zoomIn();
    }
    public void selectedZoomOut() {
        selected.zoomOut();
    }

    public void save() {

        PrimitiveShape.PrimitiveBoard primitiveBoard = new PrimitiveShape.PrimitiveBoard();

        for (Shape shape: shapes) {
            primitiveBoard.add(PrimitiveShape.shapeToPrimitive(shape));
        }
        FileHelper.writeToFile(primitiveBoard, "savefile.txt");
    }

    public void load() {
        PrimitiveShape.PrimitiveBoard tmpBoard = FileHelper.readFromFile("savefile.txt");
        for (PrimitiveShape primitiveShape: tmpBoard.getList()) {
            PrimitiveShape.primitiveToShape(this, primitiveShape);
        }
        Logger.log("Game loaded from file");
    }

    public void move(int xSpeed, int ySpeed) {
        selected.move(xSpeed, ySpeed);
    }

    public void draw() {
        clean();
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    private void clean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }
}
