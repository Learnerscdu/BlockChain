<%@page import="java.io.ObjectOutputStream,java.io.ObjectInputStream"%>
<%@page import="java.util.ArrayList,java.io.File,com.Reports"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>EHR</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="main">
  <div class="main_resize">
    <div class="header">
      <div class="logo">
        <h1><span>Using Blockchain for Electronic Health Records</span><small></small></h1>
      </div>
    </div>
    <div class="content">
      <div class="content_bg">
        <div class="menu_nav">
        <ul>
            <li><a href="CreateProfile.jsp">Create Profile</a></li>
            <li><a href="ViewProfile.jsp">View Profile</a></li>
			<li><a href="ViewReports.jsp">View Reports</a></li>
			<li><a href="Logout.jsp">Logout</a></li>
          </ul>
        </div>
        <div class="hbg"><img src="images/header_images.jpg" width="915" height="286" alt="" /></div>
      				<center>
<form name="f1" method="post" action="ViewReport.jsp" onsubmit="return validate(this);"><br/>
   <h2><b>View Reports Screen</b></h2>
   
	
						
						<table border="1" align="center" width="100%" >
<tr><th>Patient Name</th><th>Report Name</th><th>Date</th><th>Download Report</th><tr>
<%
String pid = session.getAttribute("user").toString();
String type = request.getParameter("t1").trim();
String dd = request.getParameter("dd").trim();
String mm = request.getParameter("mm").trim();
String yy = request.getParameter("yy").trim();
String dd1 = request.getParameter("dd1").trim();
String mm1 = request.getParameter("mm1").trim();
String yy1 = request.getParameter("yy1").trim();
String from = yy+"-"+mm+"-"+dd;
String to = yy1+"-"+mm1+"-"+dd1;


String path = getServletContext().getRealPath("/")+"WEB-INF";
File temp = new File(path+"/data.txt");
if(temp.exists()){
	ObjectInputStream oin = new ObjectInputStream(new java.io.FileInputStream(temp));
	Object obj = (Object)oin.readObject();
	ArrayList<Reports> list = (ArrayList<Reports>)obj;
	oin.close();
	if(type.equals("All")) {
		for(int i=0;i<list.size();i++){
			Reports r = list.get(i);
			System.out.println(r.getReportname()+" "+r.getDate()+" "+r.getPatient()+" "+pid);
			if(r.getPatient().equals(pid)){
			%>
			<tr>
			<td><font size="3" color="black"><%=r.getPatient()%></font></td>
			<td><font size="3" color="black"><%=r.getReportname()%></font></td>
			<td><font size="3" color="black"><%=new java.sql.Date(r.getDate().getTime())%></font></td>
			<td><a href="DownloadReport.jsp?t1=<%=r.getReportname()%>"><font size="3" color="black">Click Here</font></a></td></tr>

			<%}}} else {
				java.sql.Date fdate = java.sql.Date.valueOf(from);
				java.sql.Date tdate = java.sql.Date.valueOf(to);
				for(int i=0;i<list.size();i++){
					Reports r = list.get(i);
					java.sql.Date date = new java.sql.Date(r.getDate().getTime());
if(r.getPatient().equals(pid) && date.getTime() >= fdate.getTime() && date.getTime() <= tdate.getTime()){%>
					<tr>
			<td><font size="3" color="black"><%=r.getPatient()%></font></td>
			<td><font size="3" color="black"><%=r.getReportname()%></font></td>
			<td><font size="3" color="black"><%=new java.sql.Date(r.getDate().getTime())%></font></td>
			<td><a href="DownloadReport.jsp?t1=<%=r.getReportname()%>"><font size="3" color="black">Click Here</font></a></td></tr>
			<%}}}}%>



			</table>
				</div>	
					
				</div>
				
					
	</body>
</html>