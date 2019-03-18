package com.company;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class Group extends Shape{

    private List<Shape> shapesInGroup = new ArrayList<>();
    private Board board;

    public Group(GraphicsContext gc, Board board, double x, double y) {
        super(gc, x, y);
        this.board = board;
    }

    public void add(Shape shape) {
        shapesInGroup.add(shape);
    }

    public void returnShapesToBoard() {
        for(Shape shape: shapesInGroup) {
            board.add(shape);
        }
    }

    @Override
    public void setSelected(boolean selected) {
        isSelected = selected;
        for (Shape shape: shapesInGroup) {
            shape.setSelected(selected);
        }
    }

    @Override
    public void draw() {
        for (Shape shape: shapesInGroup) {
            shape.draw();
        }
    }

    @Override
    public void move(int xSpeed, int ySpeed) {
        for (Shape shape : shapesInGroup) {
            shape.move(xSpeed, ySpeed);
        }
    }
}
