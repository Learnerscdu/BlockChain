package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.File;

public class CreateProfile extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	HttpSession session = request.getSession();
	PrintWriter out = response.getWriter();
	String name=request.getParameter("t1").trim();
	String access[]=request.getParameterValues("t2");
	String problem=request.getParameter("t3").trim();
	try{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<access.length;i++){
			sb.append(access[i]+" ");
		}
		String path = getServletContext().getRealPath(File.separator)+"/WEB-INF/classes/address.txt";
		Path.setPath(path);
		String msg = AccessSmartContract.access(name,sb.toString().trim(),problem,"pending");
		if(msg.equals("success")){
			RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1=Profile Created successfully");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1=Error in creating profile");
			rd.forward(request, response);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
