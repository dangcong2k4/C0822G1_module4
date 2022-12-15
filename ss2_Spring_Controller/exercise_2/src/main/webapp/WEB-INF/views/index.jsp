<%--
  Created by IntelliJ IDEA.
  User: buida
  Date: 15/12/2022
  Time: 1:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </head>
  <body>
  <form class="text-center" action="/calculator">
    <h1>máy tính</h1>
    <input class="form-control" style="width: 200px;margin-left: 300px" type="number" name="numberOne" placeholder="Số thứ nhất" value="0">
    <input class="form-control" style="width: 200px;margin-left: 300px" type="number" name="numberTwo" placeholder="Số thứ hai" value="0"><br>


    <button class="btn btn-success" name="calculation" value="+">Phép công (+)</button>
    <button class="btn btn-success" name="calculation" value="-">Phép trừ (-)</button>
    <button class="btn btn-success" name="calculation" value="x">Phép nhân (x)</button>
    <button class="btn btn-success" name="calculation" value="/">Phép chia (/)</button>
  </form>
  <marquee><h1 style="font-size: 80px;color: darkturquoise">${display}</h1></marquee>
  </body>
</html>
