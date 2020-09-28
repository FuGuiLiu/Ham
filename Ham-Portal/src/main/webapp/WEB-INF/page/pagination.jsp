<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/25
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav aria-label="...">
    <ul class="pagination">
        <input type="hidden" value="${currentNo}" name="currentNo" id="pageNo">
        <input type="hidden" id="totalPage" value="${totalPageCount}">
        <li class="page-item" id="prev">
            <a class="page-link" href="#" id="a_prev">Prev</a>
        </li>
        <c:forEach begin="1" end="${totalPageCount}" var="thisNo">
            <li class="page-item <c:if test="${thisNo==currentNo}">active</c:if>">
                <a class="page-link" pageNoButton href="#">${thisNo}</a>
            </li>
        </c:forEach>
        <li class="page-item" id="next">
            <a class="page-link" href="#" id="a_next">Next</a>
        </li>
        <li class="page-item disabled">
            <a class="page-link" href="#">当前页${currentNo}/总页数${totalPageCount}</a>
        </li>
    </ul>
</nav>
</body>
</html>
