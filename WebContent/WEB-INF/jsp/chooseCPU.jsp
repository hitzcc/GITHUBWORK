<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="hitwh.zcc.CA.pojo.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose CPU</title>
</head>
<body>
<h1>Choose CPU</h1>
<table border="2" width="500">
<tr> 
	<th> 部件编号</th>
	<th> CPU型号</th>
	<th> CPU用途</th>
	<th> CPU价格</th>
</tr>

<s:iterator value="#request.cpuList"> 
<tr>
	<td><s:property value="id" /> </td>
	<td><s:property value="model" /> </td>
	
	<td><s:property value="usage1" /> </td>
	<td><s:property value="price" /> </td>
</tr>

</s:iterator>


</table>
<s:form action="AA_chooseCPU">
<s:textfield label="部件型号" name="componentId"/>
<s:submit value="输入型号"/>
</s:form>
</body>
</html>