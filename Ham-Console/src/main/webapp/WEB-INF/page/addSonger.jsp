<<<<<<< HEAD
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
=======
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
>>>>>>> d755f9b... console
<%@include file="header.jsp" %>
<html>
<head>
    <title>tx 音乐是生活的调味剂</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<<<<<<< HEAD
    <link rel="stylesheet" href="/console/style/screen.css" media="screen"/>
    <link rel="stylesheet" href="/console/style/lightbox.css" media="screen"/>
=======
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/style/screen.css" media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/style/lightbox.css" media="screen"/>
>>>>>>> d755f9b... console

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script>
        $(function () {
            $("#submitSonger").click(function () {
                $("#songerForm").submit();
            })
        });


        function submitFile() {
            $("#location").val($("#i-file").val());
            $("#songerForm").ajaxSubmit({
                url: "/console/singer/uploadFile.go",
                data: {
                    fileType: "picfile"
                },
                dataType: "json",
                success: function (json) {
                    if ("error" == json) {
                        window.prompt("对不起,上传歌曲出现问题,请详细管理员修复");
                    }
                    let parse = JSON.parse(json);
                    $("#songerImg").attr("src", parse.realPath);
                    $("#a_pic").attr("href", parse.realPath);
                    $("#lastImg").val(parse.realPath);
                    $("#pic").val(parse.relativePath);
                }
            })
        }
    </script>
</head>
<body>
<div class="container">
    <div class="top-navbar header b-b"><a data-original-title="Toggle navigation" class="toggle-side-nav pull-left"
                                          href="#"><i class="icon-reorder"></i> </a>
        <div class="brand pull-left"><a href="index.html"><img
                src="${pageContext.servletContext.contextPath}/images/logo.png" width="147" height="33"/></a></div>
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
                    <li><a href="#"> <span class="photo"> <img src="../../images/profile.png" width="34"
                                                               height="34"/></span> <span class="subject"> <span
                            class="from">John Doe</span> <span class="time">Just Now</span> </span> <span class="text"> Consetetur sadipscing elitr... </span>
                    </a></li>
                    <li><a href="#"> <span class="photo"><img src="../../images/profile.png" width="34"
                                                              height="34"/></span> <span class="subject"> <span
                            class="from">John Doe</span> <span class="time">35 mins</span> </span> <span class="text"> Sed diam nonumy... </span>
                    </a></li>
                    <li><a href="#"> <span class="photo"><img src="../../images/profile.png" width="34"
                                                              height="34"/></span> <span class="subject"> <span
                            class="from">John Doe</span> <span class="time">5 hours</span> </span> <span class="text"> No sea takimata sanctus... </span>
                    </a></li>
                    <li class="footer"><a href="#">View all messages</a></li>
                </ul>
            </li>
            <li class="dropdown user  hidden-xs"><a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
                    class="icon-male"></i> <span class="username">John Doe</span> <i class="icon-caret-down small"></i>
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
<div class="wrapper">

    <jsp:include page="menu.jsp"></jsp:include>
    <div class="page-content">
        <div class="content container">
            <div class="row">
                <div class="col-lg-12">
                    <c:choose>
                        <c:when test="${SRID!=null}">
                            <h2 class="page-title">更新艺人信息<small> 明星闪耀</small></h2>
                        </c:when>
                        <c:otherwise>
                            <h2 class="page-title">添加艺人<small> 明星闪耀</small></h2>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="widget">
                        <div class="widget-header"><i class="icon-user"></i>
                            <h3>User Profile</h3>
                        </div>
                        <form data-validate="parsley"
                              action="${pageContext.servletContext.contextPath}/singer/addSinger.go" method="post"
                              novalidate="" class="form-horizontal label-left" id="songerForm"/>

                        <div class="widget-content">

                            <div class="body">

                                <fieldset>
                                    <input id="ipt_SRID" type="hidden" value="${songer.SRID}">
                                    <legend class="section">艺人信息</legend>

                                    <div class="control-group">
                                        <label for="srname" class="control-label">艺人名字 <span
                                                class="required">*</span></label>
                                        <div class="controls form-group">
                                            <input type="text" class="col-sm-6 col-xs-12 parsley-validated" required=""
                                                   name="SRNAME" id="srname" value="${songer.SRNAME}"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label for="area" class="control-label">地区</label>
                                        <div class="controls form-group">
                                            <input type="text" class="col-sm-6 col-xs-12" name="AREA" id="area"
                                                   value="${songer.AREA}"/>
                                        </div>
                                    </div>


                                    <div class="control-group">
                                        <label for="tid" class="control-label">流派<span class="required">*</span></label>
                                        <div class="controls form-group">
                                            <div data-toggle="buttons" class="btn-group col-sm-2 ">
                                                <select id="tid" name="TID" class="form-control ">
                                                    <c:forEach items="${mtypes}" var="mtype">
                                                        <option value="${mtype.TID}" ${songer.TID==mtype.TID?"selected='selected'":""}>${mtype.TNAME}</option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label for="isHot" class="control-label">是否热歌<span
                                                class="required">*</span></label>
                                        <div class="controls form-group">
                                            <div data-toggle="buttons" class="btn-group col-sm-2">
                                                <select id="isHot" name="IS_HOT" class="form-control ">
                                                    <option value="1" ${songer.IS_HOT==1?"selected='selected'":""}>
                                                        是
                                                    </option>
                                                    <option value="0" ${songer.IS_HOT==0?"selected='selected'":""}>
                                                        否
                                                    </option>
                                                </select>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="description">个人简介</label>
                                        <div class="controls form-group">
                                            <textarea class="form-control" name="INTRO" rows="3"
                                                      id="description">${songer.INTRO}</textarea>
                                        </div>
                                    </div>


                                    <div class="control-group">
                                        <label class="control-label">头像<span class="required">*</span></label>
                                        <div class="controls form-group">
                                            <div class="col-sm-4 col-md-2">
                                                <div class="image-row">
                                                    <div class="image-set">
                                                        <a class="example-image-link" id="a_pic" target="_blank"
                                                                <c:choose>
<<<<<<< HEAD
                                                                    <c:when test="${songer.PIC!=null}">href="${localPicturesPath/songer.PIC}"</c:when>
=======
                                                                    <c:when test="${songer.PIC!=null}">href="${localPicturesPath}/${songer.PIC}"</c:when>
>>>>>>> d755f9b... console
                                                                    <c:otherwise>
                                                                        href="${pageContext.servletContext.contextPath}/img/gallery-photo/image-3.jpg"
                                                                    </c:otherwise>
                                                                </c:choose>
                                                           data-lightbox="example-set"
                                                           title="Click on the right side of the image to move forward.">
                                                            <img id="songerImg" class="example-image"
                                                                    <c:choose>
<<<<<<< HEAD
                                                                        <c:when test="${songer.PIC!=null}">src="${localPicturesPath/songer.PIC}"</c:when>
=======
                                                                        <c:when test="${songer.PIC!=null}">src="${localPicturesPath}/${songer.PIC}"</c:when>
>>>>>>> d755f9b... console
                                                                        <c:otherwise>
                                                                            src="${pageContext.servletContext.contextPath}/img/gallery-photo/image-3.jpg"
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                 alt="Plants: image 1 0f 4 thumb" width="300"
                                                                 height="200"/>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <label for="i-file" class="control-label" style="margin-top: 10px;">选择文件 <span
                                                class="required">*</span></label>
                                        <div id="examples" class="section examples-section">
                                            <div class="col-sm-6">
                                                <div class="input-group">
                                                    <input id='location' class="form-control"
                                                           onclick="$('#i-file').click();">
                                                    <label class="input-group-btn">
                                                        <input type="button" id="i-check" value="选择封面"
                                                               class="btn btn-primary" onclick="$('#i-file').click();">
                                                    </label>
                                                </div>
                                            </div>
                                            <input type="hidden" id="pic" name="PIC" lay-verify="pic"
                                                   value="${songer.PIC}">
                                            <input type="hidden" id="lastImg" name="lastImg">
                                            <input type="file" name="picfile" id='i-file' accept=".jpg, .png"
                                                   onchange="submitFile()" style="display: none">
                                        </div>
                                    </div>


                                </fieldset>

                                <div class="form-actions text-right">
                                    <c:choose>
                                        <c:when test="${SRID!=null}">
                                            <button id="updateSonger" class="btn btn-primary" type="button">更新艺人信息
                                            </button>
                                        </c:when>
                                        <c:otherwise>
                                            <button id="submitSonger" class="btn btn-primary" type="submit">添加艺人
                                            </button>
                                        </c:otherwise>
                                    </c:choose>

                                </div>

                            </div>
                            </form>
                        </div>
                    </div>
<<<<<<< HEAD
                    <div class="bottom-nav footer"> 拓薪教育出品</div>
                    <script>$("#songer").addClass("current");</script>
                    <script src="../../javascript/lightbox-2.6.min.js"></script>
                    <script>
                        var _gaq = _gaq || [];
                        _gaq.push(['_setAccount', 'UA-2196019-1']);
                        _gaq.push(['_trackPageview']);

                        (function () {
                            var ga = document.createElement('script');
                            ga.type = 'text/javascript';
                            ga.async = true;
                            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                            var s = document.getElementsByTagName('script')[0];
                            s.parentNode.insertBefore(ga, s);
                        })();
                    </script>
=======
                    <script>$("#songer").addClass("current");</script>
                    <script src="${pageContext.servletContext.contextPath}/javascript/lightbox-2.6.min.js"></script>
>>>>>>> d755f9b... console
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<<<<<<< HEAD

<%--<script src="/console/javascript/jquery-1.10.2.min.js"></script>--%>
<script src="/console/js/singerAdd.js"></script>
=======
<script src="${pageContext.servletContext.contextPath}/js/singerAdd.js"></script>
>>>>>>> d755f9b... console
