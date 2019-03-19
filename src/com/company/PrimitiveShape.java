package com.company;

public class PrimitiveShape {
	
	public static class PrimitiveBoard {
		
		private List<PrimitiveShape> list;
		
		public PrimitiveBoard {
		}
		
		public void add(PrimitiveShape primitiveShape) {
			list.add(primitiveShape);
		}
	}
    
	private Shape.ShapeType shapeType;
	private double x;
	private double y;
	private double size;
	private List<PrimitiveShape> list;
	
	public PrimitiveShape {	
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
		PrimitiveShape output = new PrimitiveShape;
		if(shape instanceof Shape) {
			Shape tmpShape = shape;
			output.x = tmpShape.getX();
			output.y = tmpShape.getY();
			output.size = tmpShape.getSize();
		}
		if(shape instanceof Ball) {
			output.shapeType = Shape.ShapeType.BALL;
		}
		if(shape instanceof Square) {
			output.shapeType = Shape.ShapeType.SQUARE;
		}
		if(shape instanceof Triangle) {
			output.shapeType = Shape.ShapeType.TRIANGLE;
		}
		if(shape instanceof Group) {
			
		}
		return output;
	}
	
	public static Shape primitiveToShape(PrimitiveShape primitive) {
		double x = primitive.getX();
		double y = primitive.getY();
		double size = primitive.getSize;
		Shape.ShapeType shapeType = primitive.getShapeType();
		switch(shapeType) {
			case BALL:
				board.addBall(x, y, size);
				break;
			case SQUARE:
				board.addSquare(x, y, size);
				break;
			case TRIANGLE:
				board.addTriangle(x, y, size);
				break;
			case GROUP:
			
				break;
			default:
				break;		
		}
	}	
}
