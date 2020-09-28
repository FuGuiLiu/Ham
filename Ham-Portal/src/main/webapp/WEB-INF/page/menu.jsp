<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="data-spm" content="a1z1s"/>
    <meta name="verify-v1" content="gNntuhTm2rH7Qa/GPp6lf0mIp9KQsjejNs+i1LZhG7U="/>
    <meta name="baidu-site-verification" content="xaLcM8mGHG"/>
    <meta name="apple-itunes-app" content="app-id=595594905">
    <meta name="applicable-device" content="pc">

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css">

</head>

<body>

<div class="col-lg-1">
    <div class="list-group" id="list-tab" role="tablist">
        <a class="list-group-item list-group-item-action" id="list-home-list"
           href="${pageContext.servletContext.contextPath}/recommend.jsp" role="tab"
           aria-controls="home">推荐</a>
        <a class="list-group-item list-group-item-action" id="list-album-list"
           href="${pageContext.servletContext.contextPath}/album/info.go" role="tab" aria-controls="profile">专辑</a>
        <a class="list-group-item list-group-item-action" id="list-songs-list"
           href="${pageContext.servletContext.contextPath}/song/list.go" role="tab" aria-controls="messages">歌曲</a>
        <a class="list-group-item list-group-item-action" id="list-singer-list"
           href="${pageContext.servletContext.contextPath}/singer/list.go" role="tab" aria-controls="settings">歌手</a>
        <a class="list-group-item list-group-item-action" id="list-player-list"
           href="${pageContext.servletContext.contextPath}/portals/player.go" role="tab" aria-controls="settings">播放器</a>
    </div>
</div>


</body>
</html>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/popper1.11.0.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
