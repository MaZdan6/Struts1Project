package org.zdanek.struts.calculations;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MathAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
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

}
