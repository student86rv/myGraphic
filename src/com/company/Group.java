package com.company;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class Group extends Shape{

    private List<Shape> shapesInGroup = new ArrayList<>();

    public Group(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    public void add(Shape shape) {
        shapesInGroup.add(shape);
    }

	public List<Shape> getShapesInGroup() {
		return shapesInGroup;
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
