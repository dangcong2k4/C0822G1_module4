<%--
  Created by IntelliJ IDEA.
  User: buida
  Date: 16/12/2022
  Time: 4:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h1 class="text-center">Trang chỉnh sửa</h1>
<form:form action="/edit" method="post" modelAttribute="electronicMail">
    <form:hidden path="id"/>
    <table style="margin-left: 40%">
        <tr>

            <td>Ngôn Ngữ: </td>
            <td><form:select cssClass="form-control" path="languages" items="${listLanguage}"/></td>
        </tr>
        <tr>
            <td>kích thước trang: </td>
            <td><form:select cssClass="form-control" path="pageSize" items="${listSize}"/></td>
        </tr>
        <tr>
            <td>bộ lọc thư rác: </td>
            <td><form:checkbox path="spamsFilter"/></td>
        </tr>
        <tr>
            <td>Chữ ký: </td>
            <td><form:input cssClass="form-control" path="signature"/></td>
        </tr>

    </table>

        <input style="margin-left: 49%" class="btn btn-success" type="submit" value="Lưu">

</form:form>
</body>
</html>
