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

    public void zoomIn() {
        SIZE += 1;
    }

    public void zoomOut() {
        SIZE -= 1;
    }

    public void move(int xSpeed, int ySpeed) {

        boolean xValueInBoard = (xSpeed > 0 && x + SIZE < gc.getCanvas().getWidth())
                || (xSpeed < 0 && x > 0);
        boolean yValueInBoard = (ySpeed > 0 && y + SIZE < gc.getCanvas().getHeight())
                || (ySpeed < 0 && y > 0);

        if (xValueInBoard) {
            x += xSpeed;
        }
        if (yValueInBoard) {
            y += ySpeed;
        }
    }

    public abstract void draw();
}
