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
   
	<%
	String res = request.getParameter("t1");
	if(res != null){
		out.println("<center><font face=verdana color=red>"+res+"</center></font>");
	}%>
						
						<table align="center" width="30%" >

						<tr><td><b>Report&nbsp;Type</b></td>
						<td><select name="t1">
						<option value="All">All</option>
						<option value="Date Wise">Date Wise</option>
						</select>
						</td></tr>

		<tr><td><b>From&nbsp;Date</b></td>
		<td><select name="dd">
		<%for(int i=1;i<=31;i++){
			if(i<=9){%>
			<option value="<%="0"+i%>"><%="0"+i%></option>
			<%} else {%>
	        <option value="<%=i%>"><%=i%></option>
			<%}}%>
        </select>

		<select name="mm">
		<%for(int i=1;i<=12;i++){
			if(i<=9){%>
			<option value="<%="0"+i%>"><%="0"+i%></option>
			<%} else {%>
	        <option value="<%=i%>"><%=i%></option>
			<%}}%>
        </select>

		<select name="yy">
		<%for(int i=2019;i<=2050;i++){
			if(i<=9){%>
			<option value="<%="0"+i%>"><%="0"+i%></option>
			<%} else {%>
	        <option value="<%=i%>"><%=i%></option>
			<%}}%>
        </select>
		</td></tr>

		<tr><td><b>To&nbsp;Date</b></td>
		<td><select name="dd1">
		<%for(int i=1;i<=31;i++){
			if(i<=9){%>
			<option value="<%="0"+i%>"><%="0"+i%></option>
			<%} else {%>
	        <option value="<%=i%>"><%=i%></option>
			<%}}%>
        </select>

		<select name="mm1">
		<%for(int i=1;i<=12;i++){
			if(i<=9){%>
			<option value="<%="0"+i%>"><%="0"+i%></option>
			<%} else {%>
	        <option value="<%=i%>"><%=i%></option>
			<%}}%>
        </select>

		<select name="yy1">
		<%for(int i=2019;i<=2050;i++){
			if(i<=9){%>
			<option value="<%="0"+i%>"><%="0"+i%></option>
			<%} else {%>
	        <option value="<%=i%>"><%=i%></option>
			<%}}%>
        </select>
		</td></tr>
		<tr><td></td><td><input type="submit" value="View Reports"></td>
			</table>
				</div>	
					
				</div>
				
					
	</body>
</html>