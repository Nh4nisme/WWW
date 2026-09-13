<%--
  Created by IntelliJ IDEA.
  User: HuuNhan
  Date: 9/13/2026
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <style>
        body { font-family: Arial; display: flex; justify-content: center; margin-top: 80px; }
        .login-box { border: 1px solid #ccc; padding: 30px; border-radius: 8px; width: 300px; }
        input[type=text], input[type=password] {
            width: 100%; padding: 8px; margin: 6px 0 16px 0; box-sizing: border-box;
        }
        button { width: 100%; padding: 10px; background: #007bff; color: white; border: none; border-radius: 4px; }
        .error { color: red; }
    </style>
</head>
<body>
<div class="login-box">
    <h2>Đăng nhập</h2>
    <% if (request.getAttribute("error") != null) { %>
    <p class="error"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Tên đăng nhập:</label>
        <input type="text" name="username" required>
        <label>Mật khẩu:</label>
        <input type="password" name="password" required>
        <button type="submit">Đăng nhập</button>
    </form>
    <p><small>Tài khoản demo: admin / 123</small></p>
</div>
</body>
</html>
