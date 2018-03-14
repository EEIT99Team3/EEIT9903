<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value="/Statement/login" />">
<div>帳號：<input type="text" name="login_account" size="20px"><span>${errorslogin.loginaccount}</span></div>
<div>密碼：<input type="password" name="login_password" size="20px"><span>${errorslogin.loginpassword}</span></div>
<div><input type="submit" value="登入" ></div>
<div>${errorslogin.loginresult}</div>
</form>

<form action="<c:url value="/Statement/addnew" />">
<div>帳號：<input type="text" name="s_account" size="20px"><span>${errorsadd.accounterror}</span></div>
<div>密碼：<input type="password" name="s_password" size="20px"><span>${errorsadd.passworderror}</span></div>
<div><input type="submit" value="確認新增" ></div>
</form>

<form action="<c:url value="/Statement/delete" />">
<div>帳號：<input type="text" name="s_delete" size="20px"> </div>
<div><input type="submit" value="確認刪除" ></div>
<div>${errorsdelete.deleteerror}</div>
</form>

</body>
</html>