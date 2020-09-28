<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div>
    <h3 style="margin-left:40%;">
        <c:choose>
            <c:when test="${ not empty errors}">
                <c:forEach items="${errors}" var="errors">
                    ${errors.defaultMessage}<br>
                </c:forEach>
            </c:when>
            <c:when test="${ not empty error}">
                ${error}
            </c:when>
        </c:choose>
    </h3>
    <hr>
    <h3 style="margin-left:40%;"><a href="javascript:;" style="text-decoration:none;" onclick="history.back()">返回</a>
    </h3>
</div>
</body>
</html>