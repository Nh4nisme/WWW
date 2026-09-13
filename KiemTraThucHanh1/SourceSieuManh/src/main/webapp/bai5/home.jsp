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
    <title>Trang chủ</title>
</head>
<body>
<h2>Xin chào, ${sessionScope.user}!</h2>

<p><a href="${pageContext.request.contextPath}/bai5/secure/secret.jsp">Xem trang bí mật</a></p>
<p><a href="${pageContext.request.contextPath}/bai5/logout">Đăng xuất</a></p>

<hr>
<p>Số người đang online: <strong>${applicationScope.activeUsersCount}</strong></p>
</body>
</html>