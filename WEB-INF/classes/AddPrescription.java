package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
public class AddPrescription extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	PrintWriter out = response.getWriter();
	String doctor=request.getParameter("t1").trim();
	String patient=request.getParameter("t2").trim();
	String prescription=request.getParameter("t3").trim();
	
	try{
		String path = getServletContext().getRealPath(File.separator)+"/WEB-INF/classes/address.txt";
		Path.setPath(path);
		String res = AccessSmartContract.addPrescription(doctor,patient,prescription);
    if(res.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("ViewPMedicalProfile.jsp?t1=Prescription detail added");
		rd.forward(request, response);
	}else{
		RequestDispatcher rd=request.getRequestDispatcher("ViewPMedicalProfile.jsp?t1=Error in adding prescription");
		rd.forward(request, response);
	}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
