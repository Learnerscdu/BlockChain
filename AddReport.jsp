<%@page import="com.AccessSmartContract"%>
<%@page import="com.Path,java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>EHR</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function validate(formObj)
	{
	if(formObj.t2.value.length==0)
	{
	alert("Please upload report");
	formObj.t2.focus();
	return false;
	}
	
	formObj.actionUpdateData.value="update";
	return true;
	}
	</script>
	 <script language="javascript" type="text/javascript" src="datetimepicker.js">
</script>
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
            <li><a href="AddReport.jsp">Add Reports</a></li>
           <li><a href="Logout.jsp">Logout</a></li>
          </ul>
        </div>
        <div class="hbg"><img src="images/header_images.jpg" width="915" height="286" alt="" /></div>
      				<center>
<form name="f1" method="post" action="AddReport" enctype="multipart/form-data" onsubmit="return validate(this);"><br/>
   <h2><b>Add Reports Screen</b></h2>
   
	<%
	String res = request.getParameter("t1");
	if(res != null){
		out.println("<center><font face=verdana color=red>"+res+"</center></font>");
	}%>
						
						<table align="center" width="30%" >
			
         <tr><td><b>Patient&nbsp;Name</b></td><td><select name="t1">
		  <%
		  String path = getServletContext().getRealPath(File.separator)+"WEB-INF/classes/address.txt";
	Path.setPath(path);
		  String doc[] = AccessSmartContract.getPatients().split("#");
		  for(int i=0;i<doc.length;i++){%>
           <option value="<%=doc[i]%>"><%=doc[i]%></option>
		   <%}%>
		   </select>

          <tr><td><b>Upload&nbsp;Report</b></td><td><input type="file" name="t2"/></td></tr>
			<tr><td></td><td><input type="submit" value="Upload Report"></td>
			</table>
				</div>	
					
				</div>
				
					
	</body>
</html>