<%--
  Created by IntelliJ IDEA.
  User: buida
  Date: 15/12/2022
  Time: 11:13 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>các gia vị của bánh sandwich là: </h1>

<c:if test="${lettuce!=null}">
    <p style="border: 1px solid black;width: 200px">+${lettuce}</p>
</c:if>
<c:if test="${tomato!=null}">
    <p style="border: 1px solid black;width: 200px">+${tomato}</p>
</c:if>
<c:if test="${mustard!=null}">
    <p style="border: 1px solid black;width: 200px">+${mustard}</p>
</c:if>
<c:if test="${sprouts!=null}">
    <p style="border: 1px solid black;width: 200px">+${sprouts}</p>
</c:if>



</body>
</html>
