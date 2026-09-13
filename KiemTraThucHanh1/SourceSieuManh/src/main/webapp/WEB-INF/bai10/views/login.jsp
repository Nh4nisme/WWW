<%--
  Created by IntelliJ IDEA.
  User: HuuNhan
  Date: 9/13/2026
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><title>Đăng nhập - Shopping Cart CDI</title></head>
<body>
<h1>Đăng nhập</h1>
<p>Tài khoản demo: <strong>student</strong> / <strong>123456</strong></p>
<p style="color:red">${error}</p>

<form method="post" action="${pageContext.request.contextPath}/bai10/login">
    <label>Tên đăng nhập</label><br>
    <input name="username" value="${username}" required autofocus><br><br>
    <label>Mật khẩu</label><br>
    <input name="password" type="password" required><br><br>
    <button type="submit">Đăng nhập</button>
</form>
</body>
</html>