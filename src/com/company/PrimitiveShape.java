package com.company;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveShape {

    public static class PrimitiveBoard {

        private List<PrimitiveShape> list = new ArrayList<>();

        public PrimitiveBoard() {
        }

        public void add(PrimitiveShape primitiveShape) {
            list.add(primitiveShape);
        }

        public List<PrimitiveShape> getList() {
            return list;
        }
    }

    private Shape.ShapeType shapeType;
    private double x;
    private double y;
    private double size;
    private List<PrimitiveShape> list;

    public PrimitiveShape() {
    }

    public Shape.ShapeType getShapeType() {
        return shapeType;
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
    public List<PrimitiveShape> getList() {
        return list;
    }

    public static PrimitiveShape shapeToPrimitive(Shape shape) {
        PrimitiveShape output = new PrimitiveShape();
        if (shape instanceof Shape) {
            Shape tmpShape = shape;
            output.x = tmpShape.getX();
            output.y = tmpShape.getY();
            output.size = tmpShape.getSize();
        }
        if (shape instanceof Ball) {
            output.shapeType = Shape.ShapeType.BALL;
        }
        if (shape instanceof Square) {
            output.shapeType = Shape.ShapeType.SQUARE;
        }
        if (shape instanceof Triangle) {
            output.shapeType = Shape.ShapeType.TRIANGLE;
        }
        if (shape instanceof Group) {
            output.shapeType = Shape.ShapeType.GROUP;
            Group group = (Group) shape;
            output.list = new ArrayList<PrimitiveShape>();
            for (Shape tmpShape: group.getShapesInGroup()) {
                output.list.add(shapeToPrimitive(tmpShape));
            }
        }
        return output;
    }

    public static void primitiveToShape(Board board, PrimitiveShape primitive) {
        double x = primitive.getX();
        double y = primitive.getY();
        double size = primitive.getSize();
        List<PrimitiveShape> list = primitive.getList();
        Shape.ShapeType shapeType = primitive.getShapeType();
        switch (shapeType) {
            case BALL:
                board.addBall(size, x, y);
                break;
            case SQUARE:
                board.addSquare(size, x, y);
                break;
            case TRIANGLE:
                board.addTriangle(size, x, y);
                break;
            case GROUP:
                for (PrimitiveShape tmpPrimitive: list) {
                    primitiveToShape(board, tmpPrimitive);
                }
                break;
            default:
                break;
        }
    }
}
