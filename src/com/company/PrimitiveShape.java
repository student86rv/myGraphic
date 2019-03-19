package com.company;

public class PrimitiveShape {
    
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
			
		}
		if(shape instanceof Square) {
			
		}
		if(shape instanceof Triangle) {
			
		}
		if(shape instanceof Group) {
			
		}
		
		return output;
	}
	
	public static Shape primitiveToShape(PrimitiveShape primitive) {
		
	}
	
}
