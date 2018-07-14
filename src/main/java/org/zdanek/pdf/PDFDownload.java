package org.zdanek.pdf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.lowagie.text.pdf.*;
import com.lowagie.text.*;
import java.io.*;


public class PDFDownload extends Action {

	/* forward name="success" path="" */
    private static final String SUCCESS = "success";

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("PDFDownload.execute()");
		
		Document document = new Document();
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=temp.pdf");
		try {
			OutputStream out = response.getOutputStream();
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(new Paragraph("No siema :)"));
			document.close();

		} finally {
			return mapping.findForward(SUCCESS);
		}
	}

}
