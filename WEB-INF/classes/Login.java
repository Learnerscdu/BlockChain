package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.io.File;
public class Login extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	HttpSession session=request.getSession();
	PrintWriter out = response.getWriter();
	String user=request.getParameter("t1");
	String pass=request.getParameter("t2");
	String type=request.getParameter("t3");
	boolean flag = false;
	try{
		if(user.equals("Lab") && pass.equals("Lab") && type.equals("Lab")){
			RequestDispatcher rd=request.getRequestDispatcher("LabScreen.jsp?t1=Welcome "+user);
			rd.forward(request, response);
		} else {
			String path = getServletContext().getRealPath(File.separator)+"/WEB-INF/classes/address.txt";
			Path.setPath(path);
			String msg=AccessSmartContract.login(user,pass,type);
			System.out.println(msg+" "+user+" "+pass+" "+type);
			if(msg.equals("Physician")){
				session.setAttribute("user",user);
				flag = true;
				RequestDispatcher rd=request.getRequestDispatcher("PhysicianScreen.jsp?t1=Welcome "+user);
				rd.forward(request, response);
			}
			if(msg.equals("Data Owner")){
				session.setAttribute("user",user);
				flag = true;
				RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1=Welcome "+user);
				rd.forward(request, response);
			}if(!flag){
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp?t1=Invalid User");
				rd.forward(request, response);
			}
		}

	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
