package model;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.ExcelGenerator;
import utility.PDFGenerator;
import utility.UserDAOImpl;
import utility.UserDTO;

public class DownloadAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String choise = request.getParameter("choise");
		String username = (String)session.getAttribute("uname");
		Integer billNo = (Integer)session.getAttribute("billno");
		
		UserDTO userDTO = new UserDAOImpl().findByUname(username);
		OutputStream out;
		
		try {
			out = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
			return "download.failure";
		}
		if(choise.endsWith("pdf")) {
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment; filename=invoice.pdf");
			PDFGenerator.execute(userDTO, billNo, out);
			return "download.success";
		}
		else if(choise.endsWith("xls")) {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename=invoice.xls");
			ExcelGenerator.execute(userDTO, billNo, out);
			return "download.success";
		}
		
		return "download.failure";
	}
	
}
