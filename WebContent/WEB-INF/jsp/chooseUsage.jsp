<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="hitwh.zcc.CA.pojo.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose Usage</title>
</head>
<body>
<h1>Choose Usage</h1>
<s:form action="AA_chooseUsage">
<s:radio name ="usage" list="#{1:'办公',2:'学习',3:'开发',4:'游戏'}" 
	label="选择您的部件适合用途" 
	labelposition="top"/>
<s:submit value="输入预算"/>
</s:form>
</body>
</html>