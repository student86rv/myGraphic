package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Shape {

    public Ball(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    @Override
    public void draw() {

        if (isSelected) {
            gc.setFill(Color.BLUE);
        }
        else {
            gc.setFill(Color.RED);
        }

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillOval(x, y, SIZE, SIZE);
        gc.strokeOval(x, y , SIZE, SIZE);
    }
}
