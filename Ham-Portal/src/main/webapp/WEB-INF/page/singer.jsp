<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="localPicturesPath" value="http://localhost:9092/pictures/"></c:set>
<c:set var="localSongsPath" value="http://localhost:9092/songs/"></c:set>
<c:set var="localPicturesPath" value="http://localhost:8080/pictures/"></c:set>
<c:set var="localSongsPath" value="http://localhost:8080/songs/"></c:set>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/25
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>歌手</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid row">
    <div class="col-lg-12">
        <div class="row">
            <jsp:include page="/WEB-INF/page/menu.jsp"/>
            <div class="col-lg-11">
                <form id="txForm" action="/portal/singer/list.go" method="post">
                    <div class="row">
                        <div class="col-lg-9">
                            <a class="btn btn-primary" href="#" role="button">Link</a>
                            <button class="btn btn-primary" type="submit">Button</button>
                            <input class="btn btn-primary" type="button" value="Input">
                            <input class="btn btn-primary" type="submit" value="Submit">
                            <input class="btn btn-primary" type="reset" value="Reset">
                        </div>
                        <div class="col-lg-3">
                            <div class="input-group mb-3" style="width: 300px;">
                                <input type="text" name="SRNAME" class="form-control" placeholder="查询歌手">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary" type="submit"><img
                                            src="${pageContext.servletContext.contextPath}/Icon/serach.png"
                                            style="width: 24px;height: 24px;"></button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <table class="table table-borderless">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">歌手</th>
                            <th scope="col">图片</th>
                            <th scope="col">地域</th>
                            <th scope="col">是否热门</th>
                            <th scope="col">歌手介绍</th>
                            <th scope="col">#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${singers}" var="singers" varStatus="status">

                            <tr
                                    <c:if test="${status.index%2==0}">style="background-color: rgba(0,123,255,0.3);"</c:if>>
                                <th scope="row">${status.index+1}</th>
                                <td><a href="#">${singers.SRNAME}</a></td>
                                <td>
                                    <a href="#">
                                        <img src="${localPicturesPath}/${singers.PIC}" alt=""
                                             style="width: 50px;height: 50px;">
                                    </a>
                                </td>
                                <td>${singers.AREA}</td>
                                <td>${singers.IS_HOT==1?"热门歌手":"正常"}</td>
                                <td>
                                    <button type="button" class="btn btn-secondary disabled" data-toggle="tooltip"
                                            data-html="true" title="${singers.INTRO}" style="width: 100px;">
                                        悬浮介绍
                                    </button>
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
                    <jsp:include page="pagination.jsp" flush="true"/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function () {
        $("#search").click(function () {
            $("#pageNo").val(1);
            $("#txFrom").submit();
        });

        var pageNo = $("#pageNo").val();
        var totalPage = $("#totalPage").val();

        pageNo = parseInt(pageNo);
        totalPage = parseInt(totalPage);

        if (pageNo == 1 && pageNo == totalPage) {
            $("#prev").addClass("disabled");
            $("#next").addClass("disabled");
        }

        if (pageNo == 1 && pageNo < totalPage) {
            $("#prev").addClass("disabled");
            $("#next").removeClass("disabled");
        }

        if (pageNo > 1 && pageNo < totalPage) {
            $("#prev").removeClass("disabled");
            $("#next").removeClass("disabled");
        }

        if (pageNo > 1 && pageNo == totalPage) {
            $("#prev").removeClass("disabled");
            $("#next").addClass("disabled");
        }


        $("#prev").click(function () {
            pageNo == 1 ? "" : ($("#pageNo").val(--pageNo), $("#txForm").submit());
        })

        $("#next").click(function () {
            pageNo == totalPage ? "" : ($("#pageNo").val(++pageNo), $("#txForm").submit());
        })

        $("a[pageNoButton]").click(function () {
            var pageNo = $(this).html();
            $("#pageNo").val(pageNo);
            $("#txForm").submit();

        })
    })
</script>
<script>
    $("#list-singer-list").attr("class", "list-group-item list-group-item-action active")
    $("a").css({"text-decoration": "none"});
</script>
