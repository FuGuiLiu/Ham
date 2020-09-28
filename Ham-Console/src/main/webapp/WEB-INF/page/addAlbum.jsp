<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>tx 音乐是生活的调味剂</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/style/screen.css" media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/style/lightbox.css" media="screen"/>
    <style>
        fieldset {
            margin-top: 10px;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<div class="container">
    <div class="top-navbar header b-b"><a data-original-title="Toggle navigation" class="toggle-side-nav pull-left"
                                          href="#"><i class="icon-reorder"></i> </a>
        <div class="brand pull-left"><a href="${pageContext.servletContext.contextPath}/index.jsp"><img
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
                    <li><a href="#"> <span class="photo"> <img
                            src="${pageContext.servletContext.contextPath}/images/profile.png" width="34" height="34"/></span>
                        <span class="subject"> <span class="from">John Doe</span> <span
                                class="time">Just Now</span> </span> <span
                                class="text"> Consetetur sadipscing elitr... </span> </a></li>
                    <li><a href="#"> <span class="photo"><img
                            src="${pageContext.servletContext.contextPath}/images/profile.png" width="34" height="34"/></span>
                        <span class="subject"> <span class="from">John Doe</span> <span
                                class="time">35 mins</span> </span> <span class="text"> Sed diam nonumy... </span> </a>
                    </li>
                    <li><a href="#"> <span class="photo"><img
                            src="${pageContext.servletContext.contextPath}/images/profile.png" width="34" height="34"/></span>
                        <span class="subject"> <span class="from">John Doe</span> <span
                                class="time">5 hours</span> </span> <span
                                class="text"> No sea takimata sanctus... </span> </a></li>
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
                    <h2 class="page-title">更新专辑信息</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="widget">
                        <div class="widget-header"><i class="icon-user"></i>
                            <h3>User Profile</h3>
                        </div>
                        <form method="post" action="${pageContext.servletContext.contextPath}/album/update.go"
                              enctype="multipart/form-data">
                            <div class="widget-content">
                                <div class="body">
                                    <form data-validate="parsley" method="post" novalidate=""
                                          class="form-horizontal label-left" id="user-form"/>

                                    <fieldset>

                                        <div class="control-group">
                                            <div class="controls form-group">
                                                <input type="hidden" class="col-sm-6 col-xs-12" name="AID" id="sname"
                                                       value="${album.AID}"/>
                                            </div>
                                        </div>
                                    </fieldset>

                                    <div class="layui-input-block">
                                        <label class="control-label" style="margin-top: 10px;">专辑名
                                            <span
                                                    class="required">*</span></label>
                                        <input name="ANAME"
                                               style="color: black; border-color: lightgray;background-color: white"
                                               autocomplete="off" value="${album.ANAME}" class="layui-input"
                                               id="\"/>
                                    </div>

                                    <div class="layui-input-block">
                                        <label class="control-label" style="margin-top: 10px;">当前封面 <span
                                                class="required">*</span></label>
                                        <div class="control-group">
                                            <input type="hidden" name="PIC" value="${album.PIC}">
                                            <div class="controls form-group">
                                                <img src="${localPicturesPath}/${album.PIC}"
                                                     style="width: 200px;height: 150px;">
                                            </div>
                                        </div>
                                    </div>


                                    <div class="layui-form-item">


                                        <div id="a_examples" class="section examples-section">
                                            <div class="col-sm-6">
                                                <div class="col-lg-4">
                                                    <div class="input-group">
                                                        <label class="control-label" style="margin-top: 10px;">选择其他封面
                                                            <span
                                                                    class="required">*</span></label>
                                                        <div><input type="file" name="albumPic"></div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>


                                    <div class="layui-form-item">
                                        <label class="layui-form-label" style="width:100px">发行公司</label>
                                        <div class="layui-input-block">
                                            <input name="COMPANY"
                                                   style="color: black; border-color: lightgray;background-color: white"
                                                   lay-verify="company" autocomplete="off" placeholder="请输入公司名"
                                                   class="layui-input" value=" ${album.COMPANY}"/>
                                        </div>
                                    </div>

                                    <fieldset>
                                        <div class="layui-form-item">
                                            <label class="layui-form-label" style="width:100px">发行时间</label>
                                            <div class="layui-input-block">
                                                (格式为:YYYY-MM-DD (例如:2020-01-02))
                                                <input id="addPdate" name="PDATE" style="width: 300px;"
                                                       style="color: black; border-color: lightgray;background-color: white"
                                                       lay-verify="pdate"
                                                       autocomplete="off" placeholder="请输入发行时间"
                                                       class="layui-input" value="${album.PDATE}"/>
                                            </div>
                                        </div>
                                    </fieldset>
                                    <fileset>
                                        <div class="layui-form-item">
                                            <label for="lang1" class="layui-form-label " style="width:100px">语种</label>
                                            <div class="layui-input-block">
                                                <input id="lang1" type="text" name="LANG"
                                                       style="color: black; border-color: lightgray;background-color: white"
                                                       lay-verify="lang"
                                                       autocomplete="off" placeholder="请输入语种" class="layui-input" value="${album.LANG}"/>
                                            </div>
                                        </div>
                                    </fileset>
                                </div>
                                <div class="form-actions text-right">
                                    <button class="btn btn-primary" type="submit">更新专辑信息</button>
                                </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</div>
</body>
</html>

