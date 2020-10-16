<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="java.io.ObjectOutputStream,java.io.ObjectInputStream"%>
<%@page import="java.util.ArrayList,java.io.File,com.Reports"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PHR</title>
</head>
<body>
<%!
byte b[];
%>
<%
String pid = session.getAttribute("user").toString();
String file = request.getParameter("t1").toString();
String path = getServletContext().getRealPath("/")+"WEB-INF";
File temp = new File(path+"/data.txt");
ObjectInputStream oin = new ObjectInputStream(new java.io.FileInputStream(temp));
Object obj = (Object)oin.readObject();
ArrayList<Reports> list = (ArrayList<Reports>)obj;
oin.close();
for(int i=0;i<list.size();i++){
	Reports r = list.get(i);
	if(r.getPatient().equals(pid) && r.getReportname().equals(file)){
		b = r.getData();
		break;
	}
}
response.setHeader("Content-Disposition", "attachment;filename=\"" +file + "\"");
response.setHeader("Content-Type", "application/octet-stream;");
java.io.OutputStream os=response.getOutputStream();
os.write(b,0,b.length);
os.flush();
os.close();
%>
</body>
</html>
	
	
	