package com.company;

import javafx.scene.canvas.GraphicsContext;

public abstract class Shape {

    public enum ShapeType {BALL, SQUARE, TRIANGLE, GROUP}

    protected GraphicsContext gc;
    protected double size = 30;
    protected double x;
    protected double y;
    protected boolean isSelected;

    /*public Shape(GraphicsContext gc, double x, double y) {
        this.gc = gc;
        this.x = x;
        this.y = y;
    }*/

    public Shape(GraphicsContext gc, double size, double x, double y) {
        this.size = size;
        this.gc = gc;
        this.x = x;
        this.y = y;

    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
	public double getSize() {
		return size;
	}

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void zoomIn() {
        size++;
    }
    public void zoomOut() {
        size--;
    }

    public void move(int xSpeed, int ySpeed) {

        boolean xValueInBoard = (xSpeed > 0 && x + size < gc.getCanvas().getWidth())
                || (xSpeed < 0 && x > 0);
        boolean yValueInBoard = (ySpeed > 0 && y + size < gc.getCanvas().getHeight())
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
