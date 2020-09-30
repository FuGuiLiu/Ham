<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/layui/css/layui.css" media="all">
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet" media="screen"/>
    <link href="${pageContext.servletContext.contextPath}/css/thin-admin.css" rel="stylesheet" media="screen"/>
    <link href="${pageContext.servletContext.contextPath}/css/font-awesome.css" rel="stylesheet" media="screen"/>
    <link href="${pageContext.servletContext.contextPath}/style/style.css" rel="stylesheet" media="screen"/>
    <link href="${pageContext.servletContext.contextPath}/style/dashboard.css" rel="stylesheet" media="screen"/>
    <link href="${pageContext.servletContext.contextPath}/style/nestable.css" rel="stylesheet" media="screen"/>
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap-datetimepicker.css" rel="stylesheet"
          media="screen"/>

    <script src="${pageContext.servletContext.contextPath}/assets/js/html5shiv.js"></script>
    <script src="${pageContext.servletContext.contextPath}/assets/js/respond.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.1.1.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/jquery.form.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/bootstrap-datetimepicker.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/layui/layui.js" charset="utf-8"></script>

    <c:set var="localPicturesPath" value="http://localhost:9092/pictures/"></c:set>
    <c:set var="localSongsPath" value="http://localhost:9092/songs/"></c:set>

    <c:set var="localPicturesPath" value="http://localhost:8080/pictures/"></c:set>
    <c:set var="localSongsPath" value="http://localhost:8080/songs/"></c:set>

</head>
<body>

</body>
</html>
