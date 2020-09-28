<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="clearfix text-right">
        <input type="hidden" id="pageNo" name="currentNo" value="${currentNo}">
    <input type="hidden" id="totalPage" value="${totalPageCount}">
    <ul class="pagination no-margin">
        <li id="prev" class="disabled"><a href="#">Prev</a></li>
        <c:forEach begin="1" end="${totalPageCount}" var="myPageNo">
            <li <c:if test="${myPageNo == currentNo}">class="active"</c:if>><a
                    pageNoButton href="#">${myPageNo}</a></li>
        </c:forEach>
        <li id="next"><a href="#">Next</a></li>
    </ul>
</div>
</body>
</html>
