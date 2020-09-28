<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style>
        #div_media > p, h5 {
            color: #007bff;
            font: normal bold 18px 微软雅黑;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/page/header.jsp"/>
<div class="container-fluid row">
    <div class="col-lg-12">
        <div class="row">
            <jsp:include page="/WEB-INF/page/menu.jsp"/>
            <div class="col-lg-11">

                <div class="media">
                    <img class="align-self-start mr-3" src="http://localhost:8080/pictures/${album.PIC}"
                         alt="Generic placeholder image" style="width: 243px;height: 243px;border-radius: 5%;">
                    <div class="media-body" id="div_media">
                        <h5 class="mt-0">Type:专辑</h5>
                        <p>专辑名称:${album.ANAME}</p>
                        <p>语言:${album.LANG}</p>
                        <p>发行时间:${album.PDATE}</p>
                        <p>所属公司:${album.COMPANY}</p>
                        <p style="display: none;">${album.AID}</p>
                        <button type="button" class="btn btn-outline-primary">Primary</button>
                        <button type="button" class="btn btn-outline-secondary">Secondary</button>
                        <button type="button" class="btn btn-outline-success">Success</button>
                        <button type="button" class="btn btn-outline-danger">Danger</button>
                        <button type="button" class="btn btn-outline-warning">Warning</button>
                        <button type="button" class="btn btn-outline-info">Info</button>
                        <button type="button" class="btn btn-outline-dark">Dark</button>
                    </div>
                </div>

                <c:choose>
                    <c:when test="${songs.size()==0}">
                        <br>
                        <div class="col-lg-12">
                            <h2 style="margin-top: 150px;text-align: center;">对不起,努力制作中,暂无歌曲</h2>
                        </div>

                    </c:when>
                    <c:otherwise>
                        <table class="table " style="margin-top: 3%;width: 100%;">
                            <thead class="thead-light">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">歌名</th>
                                <th scope="col">歌手</th>
                                <th scope="col">热度</th>
                                <th scope="col">#</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${songs}" var="song" varStatus="status">
                                <tr
                                        <c:if test="${status.index%2!=0}">style="background-color: rgba(0,123,255,0.3)" </c:if> >

                                    <td>${status.index+1}</td>
                                    <td>${song.SNAME}</td>
                                    <td>${song.SRNAME}</td>
                                    <td>${song.IS_HOT==1?"热门歌手":(song.IS_HOT==0?"正常热度":"冷门")}
                                    </td>
                                    <td>
                                        <a id="a_play" href="#">
                                            <img src="${pageContext.servletContext.contextPath}/Icon/play.png"
                                                 style="width: 24px;height: 24px;" alt="">
                                        </a>
                                        <a id="a_add" style="margin-right: 8px;margin-left: 8px;" href="#">
                                            <img src="${pageContext.servletContext.contextPath}/Icon/add.png"
                                                 style="width: 24px;height: 24px;" alt="">
                                        </a>
                                        <a id="a_love" href="#">
                                            <img src="${pageContext.servletContext.contextPath}/Icon/love.png"
                                                 style="width: 24px;height: 24px;" alt="">
                                        </a>
                                    </td>
                                </tr>

                            </c:forEach>
                            </tbody>
                        </table>

                    </c:otherwise>
                </c:choose>

                <c:if test="${songs.size()>6}">
                    <jsp:include page="pagination.jsp"/>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $("#list-album-list").attr("class", "list-group-item list-group-item-action active");
</script>