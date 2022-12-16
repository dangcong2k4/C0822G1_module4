<%--
  Created by IntelliJ IDEA.
  User: buida
  Date: 16/12/2022
  Time: 3:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h1 class="text-center">Trang danh sách</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Ngôn ngữ</th>
        <th scope="col">Kích thước trang</th>
        <th scope="col">bộ lọc thư rác</th>
        <th scope="col">Chữ ký</th>
        <th scope="col">Chỉnh sửa</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="electronicMai" items="${electronicMailList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${electronicMai.languages}</td>
            <td>${electronicMai.pageSize}</td>
            <td>
                <c:if test="${!electronicMai.spamsFilter}">chặn</c:if>
                <c:if test="${electronicMai.spamsFilter}">cho phép</c:if>
            </td>
            <td>${electronicMai.signature}</td>
            <td>
                <a class="btn btn-primary" href="/edit/${electronicMai.id}">Sửa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
