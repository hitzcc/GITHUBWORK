<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="hitwh.zcc.CA.pojo.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果展示</title>
</head>
<body>
<h1>结果展示</h1>

<table border="2" width="500">
<tr> 
	<th> 部件编号</th>
	<th> 部件型号</th>
	<th> 部件用途</th>
	<th> 部件价格</th>
</tr>

<s:iterator value="#session.apc.ccList"> 
<tr>
	<td><s:property value="id" /> </td>
	<td><s:property value="model" /> </td>
	
	<td><s:property value="usage1" /> </td>
	<td><s:property value="price" /> </td>
</tr>

</s:iterator>


</table>

<table border="2" width="500">
<tr> 

	<th> 预算</th>
	<th> 实际价格</th>
</tr>

<tr>
	<td><s:property value="#session.apc.budget"/></td>
	<td><s:property value="#session.apc.realPrice"/></td>
</tr>
</table>

</body>
</html>