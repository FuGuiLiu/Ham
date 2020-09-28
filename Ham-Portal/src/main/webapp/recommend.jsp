<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/page/header.jsp"/>

<div class="container-fluid row">
    <div class="col-lg-12">
        <div class="row">
            <jsp:include page="/WEB-INF/page/menu.jsp"/>
            <div class="col-lg-11">
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="list-home" role="tabpanel"
                         aria-labelledby="list-home-list">
                        <%--                        轮播图效果--%>
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner" style="height: 400px;">
                                <div class="carousel-item active">
                                    <a href=""> <img src="${pageContext.servletContext.contextPath}/test/709511.jpg"
                                                     class="d-block w-100"
                                                     alt="..."></a>

                                </div>
                                <div class="carousel-item">
                                    <a href=""><img src="${pageContext.servletContext.contextPath}/test/711001.jpg"
                                                    class="d-block w-100"
                                                    alt="..."></a>

                                </div>
                                <div class="carousel-item">
                                    <a href=""><img src="${pageContext.servletContext.contextPath}/test/722385.jpg"
                                                    class="d-block w-100"
                                                    alt="..."></a>

                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                               data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button"
                               data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $("#list-home-list").attr("class", "list-group-item list-group-item-action active");
</script>
