<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="localPicturesPath" value="http://localhost:9092/pictures/"></c:set>
<c:set var="localSongsPath" value="http://localhost:9092/songs/"></c:set>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid row">
    <div class="col-xl-12">
        <div class="row">
            <jsp:include page="/WEB-INF/page/menu.jsp"/>

            <div class="col-lg-10">

                <form id="txForm" action="${pageContext.servletContext.contextPath}/song/list.go" method="post">
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
                                <input type="text" name="SNAME" class="form-control" placeholder="搜索歌曲">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary" type="submit"><img
                                            src="${pageContext.servletContext.contextPath}/Icon/serach.png"
                                            style="width: 24px;height: 24px;"></button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <table class="table">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">歌名</th>
                            <th scope="col">#</th>
                            <th scope="col">歌手</th>
                            <th scope="col">专辑</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${songs}" var="songs" varStatus="status">
                            <tr <c:if test="${status.index%2==0}">style="background-color:rgba(0,123,255,0.2); " </c:if>>
                                <td><a href="#">${songs.SID}</a></td>
                                <td>
                                    <a href="#">${songs.SNAME}</a>
                                </td>
                                <td>
                                    <a href="">
                                        <img src="${localPicturesPath}/${songs.PIC}"
                                             style="width: 50px;height: 50px;">
                                    </a>
                                </td>
                                <td><a href="#">${songs.SRNAME}</a></td>
                                <td><a href="#">${songs.ANAME}</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <jsp:include page="pagination.jsp"/>
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
    $("#list-songs-list").attr("class", "list-group-item list-group-item-action active");
</script>
