<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>レンタルサイト／新規登録</title>
</head>
<body>
<h1>新規登録確認</h1>
<p>以下の内容で登録します</p>
<hr/>
<form:form>
<p>名前：${user.name }</p>
<p>フリガナ：${user.kana }</p>
<p>年齢：${user.age }</p>
<p>性別：${user.gender }</p>
<p>生年月日:${user.birthday }</p>
<p>住所：${user.address }</p>
<p>電話番号：${user.phone }</p>
<p>メールアドレス：${user.mail }</p>
<p>パスワード：${user.password }</p>
<input type="submit" value="登録" name="regist"></input>
</form:form>
</body>
</html>