<%--
  Created by IntelliJ IDEA.
  User: HuuNhan
  Date: 9/13/2026
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/processFormUpload" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="name"><br>
    Password: <input type="password" name="password"><br>
    Gender:
    <input type="radio" name="gender" value="Male"> Male
    <input type="radio" name="gender" value="Female"> Female<br>
    Hobbies:
    <input type="checkbox" name="hobbies" value="Reading"> Reading
    <input type="checkbox" name="hobbies" value="Sports"> Sports<br>
    Country:
    <select name="country">
        <option>Vietnam</option>
        <option>USA</option>
    </select><br>
    Birth Date: <input type="date" name="birthDate"><br>
    Profile Picture: <input type="file" name="profilePic"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
