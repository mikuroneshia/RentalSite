<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>レンタルサイト／メインメニュー</title>
<style type="text/css">
.error{
color:#ff0000;
}
</style>
</head>
<body>
<h1>メインメニュー</h1>
<hr/>
<p>ようこそ、${user.name }さん！</p>
<p class="error">${message }</p>
<hr/>
<a href="editAccount">個人情報管理</a><br/>
<a href="logout">ログアウト</a><br/>
<a href="delete">退会はこちらから</a>
</body>
</html>