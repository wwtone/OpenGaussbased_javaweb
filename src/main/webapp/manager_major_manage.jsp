<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>专业信息管理</title>
    <meta name="description" content="Professional Information Management System">

    <link rel="icon" type="image/png" sizes="512x512" href="./assets/favicon/opengause.png">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/jsvectormap/dist/css/jsvectormap.min.css">
    <link rel="stylesheet" href="./assets/css/console-analytics-bsb.css">
</head>

<body>

<header id="header" class="bg-white border-bottom border-light-subtle sticky-top">
    <nav class="navbar navbar-expand-md" data-bs-sticky-target="#header">
        <div class="container">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#bsbNavbar" aria-controls="bsbNavbar" aria-expanded="false" aria-label="Toggle navigation">
                <i class="bi bi-list"></i>
            </button>
            <a class="navbar-brand" href="manager_index.jsp">
                <img src="./assets/img/branding/console-logo.svg" alt="Logo">
            </a>
            <div class="collapse navbar-collapse" id="bsbNavbar">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-circle"></i> 管理员
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li><a class="dropdown-item" href="pages-profile.html">View Profile</a></li>
                            <li><a class="dropdown-item" href="pages-faqs.html">Help Center</a></li>
                            <li><a class="dropdown-item" href="LogoutServlet">Log Out</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main id="main">
    <section class="bg-light py-4">
        <div class="container">
            <h1 class="h4">主菜单</h1>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="manager_index.jsp">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">信息管理 / 专业信息管理</li>
                </ol>
            </nav>
        </div>
    </section>

    <section class="py-4 bg-light">
        <div class="container">
            <h3>专业信息管理</h3>
            <div class="row g-3">
                <div class="col-md-6">
                    <form action="searchMajorServlet" method="post">
                        <div class="input-group">
                            <input type="text" id="majorID" name="majorID" class="form-control" placeholder="请输入专业编号">
                            <input type="text" id="majorName" name="majorName" class="form-control" placeholder="请输入专业名称">
                            <button type="submit" class="btn btn-outline-primary">查询</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-6">
                    <form action="AddMajorServlet" method="post">
                        <div class="input-group">
                            <input type="text" id="newMajorID" name="newMajorID" class="form-control" placeholder="请输入新专业编号">
                            <input type="text" id="newMajorName" name="newMajorName" class="form-control" placeholder="请输入新专业名称">
                            <button type="submit" class="btn btn-outline-success">添加</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="table-responsive mt-4">
                <table id="majorTable" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>专业编号</th>
                        <th>专业名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="major" items="${majorList}">
                        <tr>
                            <td>${major.majorID}</td>
                            <td>${major.majorName}</td>
                            <td>
                                <form action="UpdateMajorServlet" method="post" style="display:inline;">
                                    <input type="hidden" name="oldMajorID" value="${major.majorID}">
                                    <input type="text" name="newMajorID" class="form-control" placeholder="新编号">
                                    <input type="text" name="newMajorName" class="form-control" placeholder="新名称">
                                    <button type="submit" class="btn btn-outline-success">修改</button>
                                </form>
                                <form action="DeleteMajorServlet" method="post" style="display:inline;">
                                    <input type="hidden" name="majorID" value="${major.majorID}">
                                    <button type="submit" class="btn btn-outline-danger" onclick="return confirm('确定要删除这个专业吗？')">删除</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</main>

<!-- Aside -->
<aside class="bsb-sidebar-1 offcanvas offcanvas-start" tabindex="-1" id="bsbSidebar1" aria-labelledby="bsbSidebarLabel1">
    <div class="offcanvas-header">
        <a class="sidebar-brand" href="manager_index.jsp">
            <img src="./assets/img/branding/console-logo.svg" id="bsbSidebarLabel1" class="bsb-tpl-logo" alt="Logo">
        </a>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body pt-0">
        <hr class="sidebar-divider mb-3">
        <ul class="navbar-nav">

            <li class="nav-item mt-3">
                <h6 class="py-1 text-secondary text-uppercase fs-7">成绩管理</h6>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="manager_score_manage.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">教师平均成绩查询</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="manager_score_search.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">学生成绩查询</span>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="#.html">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">学生学业情况统计</span>
                </a>
            </li>
            <li class="nav-item mt-3">
                <h6 class="py-1 text-secondary text-uppercase fs-7">课程管理</h6>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="manager_classSchedule.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">班级开课</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="manager_studentSchedule.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">学生开课</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="manager_teacherSchedule.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">教师开课</span>
                </a>
            </li>

            <li class="nav-item mt-3">
                <h6 class="py-1 text-secondary text-uppercase fs-7">信息管理</h6>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="manager_stu_manage.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">学生信息管理</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-primary active" aria-current="page" href="manager_major_manage.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">专业信息管理</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="manager_teacher_manage.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">教师信息管理</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="adminStudentOrigin">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">生源地统计</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="manager_import_info.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">师生信息导入</span>
                </a>
            </li>
            <li class="nav-item mt-3">
                <h6 class="py-1 text-secondary text-uppercase fs-7">其它</h6>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="LogoutServlet">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">Log Out</span>
                </a>
            </li>
</aside>

<footer class="footer py-3 border-top">
    <div class="container">
        <span>© 2024 Console. All rights reserved.</span>
    </div>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script src="https://unpkg.com/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function() {
        $('#majorTable').DataTable({
            paging: true,
            searching: false,
            language: {
                lengthMenu: "每页显示 _MENU_ 条记录",
                zeroRecords: "没有找到记录",
                info: "显示 _START_ 到 _END_ 条记录，共 _TOTAL_ 条记录",
                infoEmpty: "没有记录",
                infoFiltered: "(从 _MAX_ 条记录中筛选)",
                paginate: {
                    first: "首页",
                    last: "末页",
                    next: "下一页",
                    previous: "上一页"
                }
            }
        });
    });
</script>
</body>
</html>
