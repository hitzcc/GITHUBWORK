<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="hitwh.zcc.CA.pojo.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Component</title>
</head>
<body>
<h1>Add Component</h1>
<s:form action="addNewComponent">
<!--  -->
<s:textfield label="部件名称" name="name"/>
<s:textfield label="部件价格" name="price"/>
<s:textfield label="部件型号" name="model"/>

<s:radio name ="type" list="#request.typeList" 
	label="选择您的部件类型" 
	labelposition="top"
	listKey="id"
	listValue="name"/>
	
<s:radio name ="usage" list="#{1:'办公',2:'学习',3:'开发',4:'游戏'}" 
	label="选择您的部件适合用途" 
	labelposition="top"/>
	
<s:radio name ="level" list="#{1:'入门',2:'普通',3:'专业',4:'发烧'}" 
	label="选择您的部件等级" 
	labelposition="top"/>
	
<s:submit value="添加部件"/>

</s:form>
</body>
</html>