<%--
  Created by IntelliJ IDEA.
  User: buida
  Date: 14/12/2022
  Time: 10:41 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/currency">
    <input style="height: 30px;width: 200px" type="number" name="number1"><br><br>
    <select style="height: 30px;width: 200px" name="number2">
      <option value="1">USD->VND</option>
      <option value="2">VND->USD</option>
    </select>
    <button type="submit">Chuyển đổi</button>
  </form>
  </body>
</html>
