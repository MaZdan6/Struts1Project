package org.zdanek.struts.calculations;


public class Point {
	
	double x,y;
	
	

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	

	public Point() {
		super();
	}



	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	

}
