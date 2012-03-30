<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>毕业寄语</title>
	<link href="ui/css/basic.css" rel="stylesheet" type="text/css" />
	<link href="ui/css/ui.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="metal">
	<div id="top">
		${sessionScope.id} [${sessionScope.name} / ${sessionScope.roleName}]
		<!-- | <a href="account/home.cgi" target="body">账户设置</a>  -->
		 | <a href="../sign/0/out" target="_top">退出</a>
		 | <a href="#">帮助</a>
	</div>
	<div id="header">
		<div style="float:left;font-size: 21px"><font style="font-family: serif;"><font color="blue">Smart</font> <font color="green">Interactiv</font><font class="noShadow" style="color:lightblue;background-color:green;font-style: italic;">e</font><font style="font-family: sans-serif;">&trade;</font></font></div>
		<div style="float:right;font-weight:bold"><h1>后台管理</h1></div>
	</div>
</div>
</body>
</html>


