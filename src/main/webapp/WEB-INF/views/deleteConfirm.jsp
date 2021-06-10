<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>レンタルサイト／退会手続き</title>
</head>
<body>
<h1>退会手続き</h1>
<p>${user.name }さん、本当に退会しますか？</p>
<form:form>
<input type="submit" value="退会"></input>
</form:form>
<a href="mainMenu">メインメニューへ</a>
</body>
</html>