<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Computer Advice</title>
</head>
<body>
<h1>Select Functions:</h1>
<ul>
    <li>
        <s:url id="url" action="chooseBudget"></s:url>
        <s:a href="%{url}">自助装机</s:a>
    </li>
    <li>
        <s:url id="url" action="addComponent"></s:url>
        <s:a href="%{url}">添加部件</s:a>
    </li>
</ul>
<s:fielderror/>


</body>
</html>