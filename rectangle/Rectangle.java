package rEC;

public class Rectangle {
	
	private double width;
	private double height;
	
	public Rectangle() {
		this.width = 1.0;
		this.height = 2.0;
	}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getArea() {
		return this.width * this.height;
	}
	
	public double getPerimeter() {
		return 2 * (this.width + this.height);
	}
	
	public static void main(String[] args) {
		
		Rectangle rectangle1 = new Rectangle(4, 40);
		Rectangle rectangle2 = new Rectangle(3.5, 35.7);
		
		System.out.println("Rectangle 1:");
		System.out.println("Width: " + rectangle1.getWidth());
		System.out.println("Height: " + rectangle1.getHeight());
		System.out.println("Area: " + rectangle1.getArea());
		System.out.println("Perimeter: " + rectangle1.getPerimeter());
		
		System.out.println();
		
		System.out.println("Rectangle 2:");
		System.out.println("Width: " + rectangle2.getWidth());
		System.out.println("Height: " + rectangle2.getHeight());
		System.out.println("Area: " + rectangle2.getArea());
		System.out.println("Perimeter: " + rectangle2.getPerimeter());
	}

}
