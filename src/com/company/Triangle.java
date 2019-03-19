package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    public Triangle(GraphicsContext gc, double size, double x, double y) {
        super(gc, size, x, y);
    }

    @Override
    public void draw() {
        double[] xPoints = {x, x + size / 2, x + size};
        double[] yPoints = {y + size, y, y + size};
        int nPoints = 3;

        if (isSelected) {
            gc.setFill(Color.BLUE);
        } else {
            gc.setFill(Color.ORANGE);
        }

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillPolygon(xPoints, yPoints, nPoints);
        gc.strokePolygon(xPoints, yPoints, nPoints);
    }
}
