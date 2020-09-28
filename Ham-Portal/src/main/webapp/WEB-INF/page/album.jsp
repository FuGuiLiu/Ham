<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<<<<<<< HEAD
<c:set var="localPicturesPath" value="http://localhost:9092/pictures/"></c:set>
<c:set var="localSongsPath" value="http://localhost:9092/songs/"></c:set>
=======
<c:set var="localPicturesPath" value="http://localhost:8080/pictures/"></c:set>
<c:set var="localSongsPath" value="http://localhost:8080/songs/"></c:set>
>>>>>>> d755f9b... console
<html>
<head>
    <title>Title</title>
    <style>
        .swiper-list {
<<<<<<< HEAD
            height: 200px;
            position: relative;
            overflow: hidden;
            border: 1px solid #eee;
=======
            height: 400px;
            position: relative;
            overflow: hidden;

>>>>>>> d755f9b... console
            padding: 30px 0;
        }

        .swiper-main {
            height: 100%;
            position: relative;
        }

        .swiper-main img {
            height: 100%;
            display: block;
            position: absolute;
            top: 0px;
            border-radius: 4px;
            display: inline-block;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        }

        .btns {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            width: 30px;
            height: 30px;
            z-index: 800;
        }

        .leftBtn {
            left: 0px;
        }

        .rightBtn {
            right: 0px;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/page/header.jsp"/>
<div class="container-fluid row">
    <div class="col-lg-12">
        <div class="row">
            <jsp:include page="/WEB-INF/page/menu.jsp"/>
            <div class="col-lg-10">
                <div class="col-lg-3">
                    <div class="input-group mb-3" style="width: 300px;margin-top: 5px;">
                        <input type="text" name="SRNAME" class="form-control" placeholder="查询专辑">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="submit"><img
                                    src="${pageContext.servletContext.contextPath}/Icon/serach.png"
                                    style="width: 24px;height: 24px;"></button>
                        </div>
                    </div>
                </div>
<<<<<<< HEAD
                <p style="font:normal bold  40px black 微软雅黑;">热门专辑列表</p>

                <div class="swiper-list-card swiper-list" style="width: auto;height: 300px;border: none">
                        <div class="swiper-main-card swiper-main row">

                        </div>


                    <a href="#"><img id="prev-card" class="btns leftBtn"
                                     src="${pageContext.servletContext.contextPath}/Icon/left.png" alt=""></a>
                    <a href="#"><img id="next-card" class="btns rightBtn"
                                     src="${pageContext.servletContext.contextPath}/Icon/right.png" alt=""></a>

=======

                <div class="col-lg-7">
                    <p style="font:normal bold  40px black 微软雅黑;">热门专辑列表</p>

                    <div class="swiper-list-card swiper-list"">

                        <div class="swiper-main-card swiper-main">

                        </div>


                        <a href="#"><img id="prev-card" class="btns leftBtn"
                                         src="${pageContext.servletContext.contextPath}/Icon/left.png" alt=""></a>
                        <a href="#"><img id="next-card" class="btns rightBtn"
                                         src="${pageContext.servletContext.contextPath}/Icon/right.png" alt=""></a>
                    </div>
>>>>>>> d755f9b... console
                </div>


            </div>
        </div>
    </div>
</div>
</body>
</html>
<script src="${pageContext.servletContext.contextPath}/js/card_slide.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.10.2.js"></script>
<script>
    var jsons = null;
    let imgArr = [];

<<<<<<< HEAD
    var localPicPath = "http://localhost:9092/pictures/";
=======
    var localPicPath = "http://localhost:8080/pictures/";
>>>>>>> d755f9b... console
    $(function () {
        $.ajax({
            url: "${pageContext.servletContext.contextPath}/album/list.go",
            type: "GET",
            dataType: "text",
            success: function (data) {
                jsons = JSON.parse(data)
                for (let i = 0; i < jsons.length; i++) {
<<<<<<< HEAD
                    imgArr[i] = {"url": "javascript:;", "imgPath": localPicPath + jsons[i].pIC}
=======
                    imgArr[i] = {"url": "javascript:;", "imgPath": localPicPath + jsons[i].pIC, "aname": jsons[i].aNAME,"lang":jsons[i].lANG}
>>>>>>> d755f9b... console
                }

                new Swiper({
                    imgArr: imgArr,
                    imgWidth: 241,
                    aniTime: 1000,
                    intervalTime: 1500,
                    scale: 0.8,
                    autoplay: false,
                    gap: 0,
                    clsSuffix: '-card'
                }).init();
            }
        });
    })

</script>
<script>
    $("#list-album-list").attr("class", "list-group-item list-group-item-action active");
</script>