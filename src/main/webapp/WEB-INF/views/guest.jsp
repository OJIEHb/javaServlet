<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 27.02.2017
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{padding:10px 5px;border:0px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    </style>

</head>
<form action="add" method="post">
    <table class="tg" >
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Comment</td>
            <td><textarea name="comment" rows="3" cols="20"></textarea></td>
        </tr>
        <tr>
            <td>Mark</td>
            <td><select name="mark">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>




<h3>Guests List</h3>
<c:if test="${!empty guestList}">
    <table class="tg">
        <tr>
            <th width="80">Guest id</th>
            <th width="120">Guest name</th>
            <th width="120">Guest comment</th>
            <th width="90">Guest mark</th>
        </tr>
        <c:forEach items="${guestList}" var="guest">
            <tr>
                <td>${guest.id}</td>
                <td>${guest.name}</td>
                <td>${guest.comment}</td>
                <td>${guest.mark}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
