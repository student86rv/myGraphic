package com.company;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private GraphicsContext gc;
    private List<Shape> shapes = new ArrayList<>();
    private Shape selected;

    public Board(GraphicsContext gc) {
        this.gc = gc;
    }

    public void addBall() {
        Shape ball = new Ball(gc, 10, 10);
        shapes.add(ball);
        select(ball);
    }
    public void addSquare() {
        Shape square = new Square(gc, 10, 10);
        shapes.add(square);
        select(square);
    }
    public void addTriangle() {
        Shape triangle = new Triangle(gc, 10, 10);
        shapes.add(triangle);
        select(triangle);
    }

    public void select(Shape shape) {
        for (Shape s : shapes) {
            s.setSelected(false);
        }
        selected = shape;
        selected.setSelected(true);
    }
    public void selectByIndex(int index) {
        if (index <= shapes.size()) {
            select(shapes.get(index - 1));
        }
    }

    public void selectedZoomIn() {
        selected.zoomIn();
    }
    public void selectedZoomOut() {
        selected.zoomOut();
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
