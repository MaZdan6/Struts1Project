package org.zdanek.struts.calculations;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class MathForm extends ActionForm {
	
	private double a,b,c;
	private String operator;
	private double result;
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "MathForm [a=" + a + ", b=" + b + ", c=" + c + ", operator=" + operator + "]";
	}
	
	
/*	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// create a blank ActionErrors
		ActionErrors errors = new ActionErrors();
		
		
		
		if (operator.equals("")) {
			System.out.println("error");
			errors.add("operator", new ActionMessage("operator is mising"));
		}
		

		return errors;
	}*/
}
