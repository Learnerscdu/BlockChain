package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Iterator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
public class AddReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    byte b[]=null;
    String pname,file;
	
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	DiskFileItemFactory factory = new DiskFileItemFactory();
	factory.setSizeThreshold(1*1024*1024);
	factory.setRepository(new File("C:/usr"));
    ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(10*1024*1024);
	ArrayList<String> access = new ArrayList<String>();
	try{
		List fileItems = upload.parseRequest(request);
		Iterator itr = fileItems.iterator();
		while(itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			if(item.isFormField()){
				String name = item.getFieldName();
				String value = item.getString();
				if(name.equals("t1")){
					pname=value;
				}
			}else{
				file = item.getName();
				InputStream in=item.getInputStream();
				b = new byte[in.available()];
				in.read(b,0,b.length);
			}
		}
		HttpSession session=request.getSession();
		String path = getServletContext().getRealPath("/")+"/WEB-INF";
		java.util.Date date = new java.util.Date();
		Reports report = new Reports();
		report.setPatient(pname);
		report.setDate(date);
		report.setReportname(file);
		report.setData(b);
		File temp = new File(path+"/data.txt");
		if(temp.exists()){
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(temp));
			Object obj = (Object)oin.readObject();
			ArrayList<Reports> list = (ArrayList<Reports>)obj;
			list.add(report);
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(temp));
			oout.writeObject(list);
			oout.flush();
			oout.close();
			ReportData.setReport(list);
		} else {
			ArrayList<Reports> list = new ArrayList<Reports>();
			list.add(report);
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(temp));
			oout.writeObject(list);
			oout.flush();
			oout.close();
			ReportData.setReport(list);
		}
		RequestDispatcher rd=request.getRequestDispatcher("AddReport.jsp?t1=Report Details Added");
		rd.forward(request, response);
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
