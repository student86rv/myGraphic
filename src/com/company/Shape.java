package com.company;

import javafx.scene.canvas.GraphicsContext;

public abstract class Shape {

    protected double SIZE = 30;

    protected GraphicsContext gc;
    protected double x;
    protected double y;
    protected boolean isSelected;

    public Shape(GraphicsContext gc, double x, double y) {
        this.gc = gc;
        this.x = x;
        this.y = y;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void move(int xSpeed, int ySpeed) {
        x += xSpeed;
        y += ySpeed;

//        if (x + SIZE < gc.getCanvas().getWidth()) {
//
//        }
//        if (y + SIZE < gc.getCanvas().getHeight()) {
//
//        }
    }

    public abstract void draw();
}
