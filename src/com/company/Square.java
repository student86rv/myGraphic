package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(GraphicsContext gc, double size, double x, double y) {
        super(gc, size, x, y);
    }

    @Override
    public void draw() {

        if (isSelected) {
            gc.setFill(Color.BLUE);
        } else {
            gc.setFill(Color.GREEN);
        }

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillRect(x, y, size, size);
        gc.strokeRect(x, y, size, size);
    }
}
