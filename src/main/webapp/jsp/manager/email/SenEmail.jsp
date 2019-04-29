<%--
  Created by IntelliJ IDEA.
  User: poyu
  Date: 2019/4/24/0024
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">

    </style>
</head>
<body>
<section style="text-align:center;">
    <form action="SendEmail" method="post">
        邮箱：<input type="text" name="receptor" class="text" MaxLength=""><br/><br>

        内容：<textarea type="textarea" name="Content" class="text" MaxLength=""></textarea>
        <input type="submit" value="提交">
    </form>
</section>
</body>
</html>
