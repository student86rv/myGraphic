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
        selected = ball;
        selected.setSelected(true);
    }
    public void addSquare() {
        Shape square = new Square(gc, 10, 10);
        shapes.add(square);
        selected = square;
        selected.setSelected(true);


    }

    public void select(int index) {
        for (Shape shape : shapes) {
            shape.setSelected(false);
        }
        if (index <= shapes.size()) {
            selected = shapes.get(index - 1);
            selected.setSelected(true);
        }
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
