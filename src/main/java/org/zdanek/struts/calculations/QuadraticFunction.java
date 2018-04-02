package org.zdanek.struts.calculations;

import java.util.ArrayList;

import antlr.collections.List;

public class QuadraticFunction {
	
	private ArrayList<Point> points;
	Double x1,x2, delta, a,b,c;
	
	
	public ArrayList<Point> getPoints() {
		return points;
	}
	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	public Double getX1() {
		return x1;
	}
	public void setX1(Double x1) {
		this.x1 = x1;
	}
	public Double getX2() {
		return x2;
	}
	public void setX2(Double x2) {
		this.x2 = x2;
	}
	public Double getDelta() {
		return delta;
	}
	public void setDelta(Double delta) {
		this.delta = delta;
	}
	public Double getA() {
		return a;
	}
	public void setA(Double a) {
		this.a = a;
	}
	public Double getB() {
		return b;
	}
	public void setB(Double b) {
		this.b = b;
	}
	public Double getC() {
		return c;
	}
	public void setC(Double c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "QuadraticFunction [ x1=" + x1 + ", x2=" + x2 + ", delta=" + delta + ", a=" + a
				+ ", b=" + b + ", c=" + c + "points=" + points+"]";
	}
	
	
	
	

}
