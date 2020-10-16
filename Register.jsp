<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>EHR</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function validate(formObj)
	{
	if(formObj.t1.value.length==0)
	{
	alert("Please Enter Username");
	formObj.t1.focus();
	return false;
	}
	if(formObj.t2.value.length==0)
	{
	alert("Please Enter Password");
	formObj.t2.focus();
	return false;
	}
	if(formObj.t4.value.length==0)
	{
	alert("Please Enter Contact No");
	formObj.t4.focus();
	return false;
	}
	if(isNaN(formObj.t4.value)){
		alert("Contact no  must be numeric");
		formObj.t4.focus();
		return false;
	}
	if(formObj.t4.value.length != 10){
		alert("Contact number must be 10 digits long");
		formObj.t4.focus();
		return false;
	}
	if(formObj.t5.value.length==0)
	{
	alert("Please Enter mail id");
	formObj.t5.focus();
	return false;
	}
	var filter = /^([a-zA-Z0-9_\.\-])+\@([a-z]+\.)+(com)+$/;
    if (!filter.test(formObj.t5.value)) {
		window.alert('Please enter valid email address');
		formObj.t5.focus();
		return false;
	}
	if(formObj.t6.value.length==0)
	{
	alert("Please Enter Address");
	formObj.t6.focus();
	return false;
	}
	formObj.actionUpdateData.value="update";
	return true;
	}
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
            <li class="active"><a href="index.jsp">Home</a></li>
            <li><a href="Login.jsp">Data Owner</a></li>
            <li><a href="Login.jsp">Data User</a></li>
            <li><a href="Register.jsp">New User</a></li>
          </ul>
        </div>
        <div class="hbg"><img src="images/header_images.jpg" width="915" height="286" alt="" /></div>
      				<center>
<form name="f1" method="post" action="Register" onsubmit="return validate(this);"><br/>
   <h2><b>New User Registration Screen</b></h2>
   
	<%
	String res = request.getParameter("t1");
	if(res != null){
		out.println("<center><font face=verdana color=red>"+res+"</center></font>");
	}%>
						
						<table align="center" width="40" >
			 <tr><td><b>Username</b></td><td><input type="text" name="t1" style="font-family: Comic Sans MS" size=20/></td></tr>
         
		  <tr><td><b>Password</b></td><td><input type="password" name="t2" style="font-family: Comic Sans MS" size=20/></td></tr>

		   <tr><td><b>Usertype</b></td><td><select name="t3" style="font-family: Comic Sans MS">
		   <option value="Physician">Physician</option>
		  <option value="Data Owner">Data Owner</option>
		   </select>
		   </td></tr>

		   <tr><td><b>Contact&nbsp;No</b></td><td><input type="text" name="t4" style="font-family: Comic Sans MS" size=20/></td></tr>

		   <tr><td><b>Email&nbsp;ID</b></td><td><input type="text" name="t5" style="font-family: Comic Sans MS" size=20/></td></tr>

		   <tr><td><b>Address</b></td><td><textarea name="t6" style="font-family: Comic Sans MS" rows="6" cols="20"></textarea></td></tr>
         
			<tr><td></td><td><input type="submit" value="Register"></td>
			</table>
				</div>	
					
				</div>
				
					
	</body>
</html>