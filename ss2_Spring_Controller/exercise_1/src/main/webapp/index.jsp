<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: buida
  Date: 15/12/2022
  Time: 10:48 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>gia vị bánh sandwich</h1>
  <form action="/sandwich">
    <a><input type="checkbox" name="lettuce" value=" rau diếp"> rau diếp</a>
    <a><input type="checkbox" name="tomato" value=" cà chua"> cà chua</a>
    <a><input type="checkbox" name="mustard" value=" mù tạc"> mù tạc</a>
    <a><input type="checkbox" name="sprouts" value=" rau mầm"> rau mầm</a>
    <button type="submit">Lưu</button>
  </form>


  </body>
</html>
