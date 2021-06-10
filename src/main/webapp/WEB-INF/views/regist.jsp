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
<h1>新規登録</h1>
<hr/>
<p>${message }</p>
<hr/>
<form:form modelAttribute="user">
<form:errors path="name" element="div" cssClass="error"></form:errors>
名前：<form:input path="name" value="${user.name }"></form:input><br/>
<form:errors path="kana" element="div" cssClass="error"></form:errors>
フリガナ：<form:input path="kana" value="${user.kana }"></form:input><br/>
<form:errors path="age" element="div" cssClass="error"></form:errors>
年齢：<form:input path="age" value="${user.age }"></form:input><br/>
<form:errors path="gender" element="div" cssClass="error"></form:errors>
性別：男<form:radiobutton path="gender" value="男"></form:radiobutton>
     女<form:radiobutton path="gender" value="女"></form:radiobutton><br/>
<form:errors path="birthday" element="div" cssClass="error"></form:errors>
生年月日：<form:input path="birthday" value="${user.birthday }"></form:input>例：2000-02-08<br/>
<form:errors path="address" element="div" cssClass="error"></form:errors>
住所：<form:input path="address" value="${user.address }"></form:input><br/>
<form:errors path="phone" element="div" cssClass="error"></form:errors>
電話番号：<form:input path="phone" value="${user.phone }"></form:input>090-1234-5678<br/>
<form:errors path="mail" element="div" cssClass="error"></form:errors>
メールアドレス：<form:input path="mail" value="${user.mail }"></form:input><br/>
<form:errors path="password" element="div" cssClass="error"></form:errors>
パスワード：<form:input path="password" value="${user.password }"></form:input>１文字以上20文字以下で入力してください。<br/>
<input type="submit" value="確認" name="confirm"></input>
</form:form>
<a href="login">ログインページへ</a>
</body>
</html>