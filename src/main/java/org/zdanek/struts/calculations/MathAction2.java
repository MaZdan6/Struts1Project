package org.zdanek.struts.calculations;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class MathAction2 extends DispatchAction {
	
	
	QuadraticFunction quadratic;


	public ActionForward basicMath(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("execute - start");

		MathForm mathForm = (MathForm) form;
		System.out.println(mathForm.toString());

		String operator = mathForm.getOperator();
		double a=mathForm.getA();
		double b=mathForm.getB();
		double result=0;
		switch (operator) {
		case "+":
			result= a+b;
			break;
		case "-":
			result= a-b;
			break;
		case "*":
			result= a*b;
			break;
		case "/":
			result= a/b;
			break;

		default:
			break;
		}
		
		mathForm.setResult(result);

		return mapping.findForward("success");
	}

	
	public ActionForward quadratic(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("quadratic - start");

		MathForm mathForm = (MathForm) form;
		System.out.println(mathForm.toString());

		
		double a=mathForm.getA();
		double b=mathForm.getB();
		double c=mathForm.getC();
		
		double delta= b*b-4*a*c;
		
		Double x1=null;
		Double x2=null;
		
		if(delta>=0) {
			x1= (-b-Math.pow(delta, -1))/2*a;
			
			x2= (-b+Math.pow(delta, -1))/2*a;
		}
		
		quadratic= new QuadraticFunction();
		
		quadratic.setDelta(delta);
		quadratic.setX1(x1);
		quadratic.setX2(x2);
		
		ArrayList<Point> points= new ArrayList<>();
		for(double x=-10; x<=10;x++) {
			double y= a*x*x+b*x+c;
			points.add(new Point(x,y));
		}
		
		quadratic.setPoints(points);
		
		System.out.println(quadratic.toString());
		
		request.getSession().setAttribute("points",quadratic.getPoints());
		
		double result=0;
		
		
		mathForm.setResult(result);

		return mapping.findForward("success");
	}
	

}
