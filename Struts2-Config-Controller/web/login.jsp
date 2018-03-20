<%--
  Created by IntelliJ IDEA.
  User: YanoHao
  Date: 2018/2/28
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录操作</title>
  </head>
  <body>
        <h1>集成Struts2和Hibernate登录测试</h1>
    <form action="login" method="post">
        <input name="user.username" type="text" placeholder="用户名">
        <input name="user.password" type="password" placeholder="密码">
        <input type="submit" value="点我测试">
    </form>

    <form action="login2" method="post">
        <input name="username" type="text" placeholder="用户名">
        <input name="password" type="password" placeholder="密码">
        <input type="submit" value="点我测试">
    </form>
  </body>
</html>
