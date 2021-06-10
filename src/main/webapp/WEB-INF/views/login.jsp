<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>レンタルサイト／ログイン</title>
<style type="text/css">
p{
color:#ff0000;
}
.error{
color:#ff0000;
}
</style>
</head>
<body>
<h1>ログイン</h1>
<hr/>
<p>${message }</p>
<form:form modelAttribute="user">
<form:errors path="name" element="div" cssClass="error"></form:errors>
名前：<form:input path="name"></form:input><br/>
<form:errors path="password" element="div" cssClass="error"></form:errors>
パスワード：<form:input path="password"></form:input><br/>
<input type="submit" value="ログイン"></input>
</form:form>
<a href="regist">新規登録はこちらから</a>
<hr/>
<c:if test="${usersList!=null }">
<table>
<tr><th>名前</th><th>パスワード</th></tr>
<c:forEach var="user" items="${usersList }">
<tr><td><c:out value="${user.name }"></c:out></td><td><c:out value="${user.password }"></c:out></td></tr>
</c:forEach>
</table>
</c:if>
</body>
</html>