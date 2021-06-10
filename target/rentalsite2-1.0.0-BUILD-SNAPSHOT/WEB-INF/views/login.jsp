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
</head>
<body>
<h1>ログイン</h1>
<hr/>
<form:form modelAttribute="user">
<form:input path="name">名前</form:input>
<form:input path="password">パスワード</form:input>
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