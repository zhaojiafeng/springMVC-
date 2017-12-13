<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/12/1
  Time: 上午10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>首页文件上传</h1>
<form action="/upload" method="post" enctype="multipart/form-data">
    描述：<input type="text" name="description">
    选择文件：<input type="file" name="file">
    <input type="submit" value="submit">
</form>

</body>
</html>
