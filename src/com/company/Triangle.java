package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    public Triangle(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    @Override
    public void draw() {
        double[] xPoints = {x, x + SIZE / 2, x + SIZE};
        double[] yPoints = {y + SIZE, y, y + SIZE};
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
