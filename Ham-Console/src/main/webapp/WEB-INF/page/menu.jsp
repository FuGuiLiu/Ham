<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li id="index"><a href="${pageContext.servletContext.contextPath}/index.jsp"> <i class="icon-dashboard"></i>
                控制面板 </a></li>
            <li id="songtype"><a href="${pageContext.servletContext.contextPath}/mType/mType.go"> <i
                    class="icon-table"></i> 流派管理</a></li>
            <li id="song"><a href="${pageContext.servletContext.contextPath}/song/list.go"> <i class="icon-music"></i>
                歌曲管理
            </a></li>
            <li id="songer"><a href="${pageContext.servletContext.contextPath}/singer/list.go"> <i
                    class="icon-user"></i>
                艺人管理 </a></li>
            <li id="album"><a href="${pageContext.servletContext.contextPath}/album/list.go"> <i class="icon-list"></i>
                专辑管理 </a></li>
            <li id="chart"><a href="${pageContext.servletContext.contextPath}/menu/chartReport.go"> <i
                    class="icon-bar-chart"></i> 统计报表 </a></li>
            <li id="login"><a href="${pageContext.servletContext.contextPath}/login.jsp"> <i class="icon-unlock"></i> 登录
            </a></li>
            <li id="fullCalendar"><a href="${pageContext.servletContext.contextPath}/menu/calendar.go"> <i
                    class="icon-calendar"></i> 日历</a></li>
            <li><a href="404-page.html"> <i class="icon-eye-close"></i> 404-page </a></li>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
