<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="fun" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>tx 音乐是生活的调味剂</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script>
        $("#a_delete").click(function () {
            alert(123);
        });
        var layer

        $(function () {
            layui.use('layer', function () {
                layer = layui.layer;
            });

            var pop;
            $("#addAlbum").click(function () {
                pop = layer.open({
                    type: 1,
                    area: [600, 450],
                    content: $("#albumPop"),
                    cancel: function (index, layero) {
                        /*if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                            layer.close(index)
                        }
                        return false;*/
                    }

                });


            })
            $("#toggleSearch").click(function () {
                var flag = $(this).attr("flag");
                if (flag == 1) {
                    $("#find").show(500);
                    $(this).attr("flag", 2);
                    $(this).html("收缩↑");
                } else {
                    $("#find").hide(500)
                    $(this).attr("flag", 1);
                    $(this).html("展开↓");
                }
            });


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
                $("#pageNo").val(--pageNo);
                $("#txForm").submit();
            })

            $("#next").click(function () {

                $("#pageNo").val(++pageNo);
                $("#txForm").submit();
            })

            $("a[pageNoButton]").click(function () {
                var pageNo = $(this).html();
                $("#pageNo").val(pageNo);
                $("#txForm").submit();

            })


            layui.use('laydate', function () {
                var laydate = layui.laydate;

                //执行一个laydate实例
                laydate.render({
                    elem: '#addPdate'
                });

                //执行一个laydate实例
                laydate.render({
                    elem: '#searchPdate'
                });
            });

        })


    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>

<div class="container">
    <div class="top-navbar header b-b"><a data-original-title="Toggle navigation" class="toggle-side-nav pull-left"
                                          href="#"><i class="icon-reorder"></i> </a>
        <div class="brand pull-left"><a href="${pageContext.servletContext.contextPath}/index.jsp">
            <img src="${pageContext.servletContext.contextPath}/images/logo.png" width="147" height="33"/>
        </a>
        </div>
        <ul class="nav navbar-nav navbar-right  hidden-xs">
            <li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
                    class="icon-warning-sign"></i> <span class="badge">5</span> </a>
                <ul class="dropdown-menu extended notification">
                    <li class="title">
                        <p>You have 5 new notifications</p>
                    </li>
                    <li><a href="#"> <span class="label label-success"><i class="icon-plus"></i></span> <span
                            class="message">New user registration.</span> <span class="time">1 mins</span> </a></li>
                    <li><a href="#"> <span class="label label-danger"><i class="icon-warning-sign"></i></span> <span
                            class="message">High CPU load on cluster #2.</span> <span class="time">5 mins</span> </a>
                    </li>
                    <li><a href="#"> <span class="label label-success"><i class="icon-plus"></i></span> <span
                            class="message">New user registration.</span> <span class="time">10 mins</span> </a></li>
                    <li><a href="#"> <span class="label label-info"><i class="icon-bullhorn"></i></span> <span
                            class="message">New items are in queue.</span> <span class="time">25 mins</span> </a></li>
                    <li><a href="#"> <span class="label label-warning"><i class="icon-bolt"></i></span> <span
                            class="message">Disk space to 85% full.</span> <span class="time">35 mins</span> </a></li>
                    <li class="footer"><a href="#">View all notifications</a></li>
                </ul>
            </li>
            <li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-tasks"></i>
                <span class="badge">7</span> </a>
                <ul class="dropdown-menu extended notification">
                    <li class="title">
                        <p>You have 7 pending tasks</p>
                    </li>
                    <li><a href="#"> <span class="task"> <span class="desc">Preparing new release</span> <span
                            class="percent">30%</span> </span>
                        <div class="progress progress-small">
                            <div class="progress-bar progress-bar-info" style="width: 30%;"></div>
                        </div>
                    </a></li>
                    <li><a href="#"> <span class="task"> <span class="desc">Change management</span> <span
                            class="percent">80%</span> </span>
                        <div class="progress progress-small progress-striped active">
                            <div class="progress-bar progress-bar-danger" style="width: 80%;"></div>
                        </div>
                    </a></li>
                    <li><a href="#"> <span class="task"> <span class="desc">Mobile development</span> <span
                            class="percent">60%</span> </span>
                        <div class="progress progress-small">
                            <div class="progress-bar progress-bar-success" style="width: 60%;"></div>
                        </div>
                    </a></li>
                    <li><a href="#"> <span class="task"> <span class="desc">Database migration</span> <span
                            class="percent">20%</span> </span>
                        <div class="progress progress-small">
                            <div class="progress-bar progress-bar-warning" style="width: 20%;"></div>
                        </div>
                    </a></li>
                    <li class="footer"><a href="#">View all tasks</a></li>
                </ul>
            </li>
            <li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
                    class="icon-envelope"></i> <span class="badge">1</span> </a>
                <ul class="dropdown-menu extended notification">
                    <li class="title">
                        <p>You have 3 new messages</p>
                    </li>
                    <li><a href="#"> <span class="photo"> <img
                            src="${pageContext.servletContext.contextPath}/images/profile.png" width="34"
                            height="34"/></span> <span class="subject"> <span
                            class="from">John Doe</span> <span class="time">Just Now</span> </span> <span class="text"> Consetetur sadipscing elitr... </span>
                    </a></li>
                    <li><a href="#"> <span class="photo"><img
                            src="${pageContext.servletContext.contextPath}/images/profile.png" width="34"
                            height="34"/></span> <span class="subject"> <span
                            class="from">John Doe</span> <span class="time">35 mins</span> </span> <span class="text"> Sed diam nonumy... </span>
                    </a></li>
                    <li><a href="#"> <span class="photo"><img
                            src="${pageContext.servletContext.contextPath}/images/profile.png" width="34"
                            height="34"/></span> <span class="subject"> <span
                            class="from">John Doe</span> <span class="time">5 hours</span> </span> <span class="text"> No sea takimata sanctus... </span>
                    </a></li>
                    <li class="footer"><a href="#">View all messages</a></li>
                </ul>
            </li>
            <li class="dropdown user  hidden-xs"><a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
                    class="icon-male"></i> <span class="username">${sessionScope.txUser.USERNAME}</span> <i
                    class="icon-caret-down small"></i>
            </a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
                    <li><a href="#"><i class="icon-calendar"></i> My Calendar</a></li>
                    <li><a href="#"><i class="icon-tasks"></i> My Tasks</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="icon-key"></i> Log Out</a></li>
                </ul>
            </li>
        </ul>
        <form role="search" class="navbar-form pull-right" id="search-form"/>
        <input type="search" placeholder="Search..." class="search-query" id="search-input"/>
        </form>
    </div>
</div>
<form id="txForm" action="${pageContext.servletContext.contextPath}/album/list.go" method="post"
      class="form-horizontal">
    <div class="wrapper">

        <jsp:include page="menu.jsp"></jsp:include>

        <div class="page-content">
            <div class="content container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2 class="page-title">歌曲列表 <small>favor song</small></h2>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="widget">
                            <div class="widget-header"><i class="icon-list-ol"></i>
                                <h3>搜索条件</h3>
                            </div>
                            <div class="widget-content">

                                <fieldset id="find">
                                    <!--<legend class="section">Horizontal form</legend>-->
                                    <div class="control-group">
                                        <label for="aname" class="control-label">专辑名</label>
                                        <div class="controls form-group">
                                            <div class="input-group"><span class="input-group-addon"><i
                                                    class="icon-music"></i></span>
                                                <input type="text" value="${album.ANAME}" placeholder="如：thriller"
                                                       name="ANAME" id="aname" class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label for="company" class="control-label">唱片公司</label>
                                        <div class="controls form-group">
                                            <div class="input-group"><span class="input-group-addon"><i
                                                    class="icon-user"></i></span>
                                                <input type="text" value="${album.COMPANY}" placeholder="如：史诗唱片"
                                                       name="COMPANY" id="company" class="form-control"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label for="lang" class="control-label">语种</label>

                                        <div class="controls form-group">
                                            <div class="input-group"><span class="input-group-addon"><i
                                                    class="icon-user"></i></span>
                                                <input type="text" value="${album.LANG}" placeholder="如：英语" name="LANG"
                                                       id="lang" class="form-control"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label for="searchPdate" class="control-label">日期</label>
                                        <div class="controls form-group">
                                            <div class="input-group"><span class="input-group-addon"><i
                                                    class="icon-reorder"></i></span>
                                                <input readonly id="searchPdate"
                                                       value="${album.PDATE}"
                                                       type="text" placeholder="如：1970-01-01" name="PDATE"
                                                       class="form-control"/>
                                            </div>
                                        </div>
                                    </div>


                                </fieldset>
                                <div class="form-actions text-right">
                                    <div>
                                        <button id="search" class="btn btn-primary" type="submit">搜索</button>
                                        <button id="addAlbum" class="btn btn-primary" type="button">添加专辑</button>
                                        <button id="toggleSearch" flag="2" class="btn btn-default" type="button">收缩↑
                                        </button>
                                    </div>
                                </div>


                            </div>
                            <div class="widget-content">
                                <div class="body">
                                    <table class="table table-striped table-images"
                                           style="color: white;font-size: 14px">
                                        <thead>
                                        <tr>
                                            <th class="hidden-xs-portrait">序号</th>
                                            <th>封面</th>
                                            <th>专辑名字</th>
                                            <th class="hidden-xs-portrait">唱片公司</th>
                                            <th class="hidden-xs">发行时间</th>
                                            <th class="hidden-xs">语种</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${albums}" var="albums" varStatus="status">
                                            <tr>
                                                <td class="hidden-xs-portrait">${albums.AID}</td>
                                                <td><img
                                                        src="${localPicturesPath}/${albums.PIC}"/>
                                                </td>
                                                <td> ${albums.ANAME} </td>
                                                <td class="hidden-xs-portrait">${albums.COMPANY}</td>
                                                <td class="hidden-xs"><p><strong>${albums.PDATE}</strong>
                                                </p></td>
                                                <td class="hidden-xs">${albums.LANG}</td>
                                                <td>
                                                    <button class="btn btn-sm btn-primary"><a
                                                            href="${pageContext.servletContext.contextPath}/album/update.go?AID=${albums.AID}">修改</a>
                                                    </button>
                                                    <button class="btn btn-sm btn-warning"><a id="a_delete"
                                                                                              href="${pageContext.servletContext.contextPath}/album/delete.go?AID=${albums.AID}">删除</a>
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <jsp:include page="pagination.jsp"></jsp:include>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<div class="bottom-nav footer"> 拓薪教育出品
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script>$("#album").addClass("current");</script>

<div id="albumPop" style="margin-right: 50px;margin-top: 50px; display: none">
    <form method="post" action="/console/album/addAlbum.go" enctype="multipart/form-data">
        <label class="layui-form-label" style="width:100px">专辑名字</label>

        <div class="layui-input-block">
            <input name="ANAME" style="color: black; border-color: lightgray;background-color: white"
                   autocomplete="off" placeholder="请输入专辑名" class="layui-input" id="\"/>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width:100px">发行公司</label>
            <div class="layui-input-block">
                <input name="COMPANY"
                       style="color: black; border-color: lightgray;background-color: white"
                       lay-verify="company" autocomplete="off" placeholder="请输入公司名" class="layui-input"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:100px">发行时间</label>
            <div class="layui-input-block">
                <input id="addPdate" name="PDATE"
                       style="color: black; border-color: lightgray;background-color: white" lay-verify="pdate"
                       autocomplete="off" placeholder="请输入发行时间" class="layui-input"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width:100px">选择文件</label>
            <input type="file" name="picfile"/>
        </div>

        <div class="layui-form-item">
            <label for="lang1" class="layui-form-label " style="width:100px">语种</label>
            <div class="layui-input-block">
                <input id="lang1" type="text" name="LANG"
                       style="color: black; border-color: lightgray;background-color: white" lay-verify="lang"
                       autocomplete="off" placeholder="请输入语种" class="layui-input"/>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input class="layui-btn layui-btn-normal layui-btn-radius" type="submit" value="添加专辑">
            </div>
        </div>
    </form>
    </form>
</div>

</body>
</html>






