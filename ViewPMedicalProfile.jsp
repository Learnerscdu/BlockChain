<%@page import="com.AccessSmartContract"%>
<%@page import="com.Path,java.io.File"%>
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
            <li><a href="ViewPMedicalProfile.jsp">View Medical Profile</a></li>
			
           	<li><a href="Logout.jsp">Logout</a></li>
          </ul>
        </div>
        <div class="hbg"><img src="images/header_images.jpg" width="915" height="286" alt="" /></div>
      				<center>

   <h2><b>View User Profile Screen</b></h2>
   
	<%
	String res = request.getParameter("t1");
	if(res != null){
		out.println("<center><font face=verdana color=red>"+res+"</center></font>");
	}%>
			<table border="1" align="center" width="100%">
			<tr><th>Person Name</th><th>Access Control</th><th>Problem Description</th><th>Status</th><tr>
	<%
	String pid = session.getAttribute("user").toString();
	String path = getServletContext().getRealPath(File.separator)+"WEB-INF/classes/address.txt";
	Path.setPath(path);
	String data = AccessSmartContract.getAccess(pid);
	System.out.println("data "+data);
	if(data.length() > 0){
	String arr[] = data.split("#");
	for(int i=0;i<arr.length;i++){
		String ar[] = arr[i].split(",");
		%>
	<tr><td><font size="3" color="black"><%=ar[0]%></td>
	<td><font size="3" color="black"><%=ar[1]%></td>
	<td><font size="3" color="black"><%=ar[2]%></td>
	<%if(ar[3].equals("pending")){%>
	<td><a href="AddPrescription.jsp?t11=<%=ar[0]%>"><font size="3" color="black">Add Prescription</font></a></td>
	<%} else {%>
	<td><font size="3" color="black"><%=ar[3]%></td>
	<%}}}%>
	</tr>
	</table>
	</body>
</html>