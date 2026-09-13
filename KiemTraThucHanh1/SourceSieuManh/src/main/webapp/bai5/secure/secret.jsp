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
    <title>Trang bí mật</title>
</head>
<body>
<h2>Đây là nội dung bí mật chỉ user đã login mới thấy!</h2>
<p>Xin chào <strong>${sessionScope.user}</strong>, bạn đã vượt qua Filter kiểm tra đăng nhập.</p>
<a href="${pageContext.request.contextPath}/bai5/home.jsp">Về trang chủ</a>
</body>
</html>
