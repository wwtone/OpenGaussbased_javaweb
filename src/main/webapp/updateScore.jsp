<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">

<head>
    <!-- Required Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Document Title, Description, and Author -->
    <title>教师成绩查询</title>
    <meta name="description" content="Console is a Free Bootstrap Admin Template.">

    <!-- Favicon and Touch Icons -->
    <link rel="icon" type="image/png" sizes="512x512" href="./assets/favicon/opengause.png">

    <!-- Google Fonts Files -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- CSS Files -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/jsvectormap/dist/css/jsvectormap.min.css">
    <link rel="stylesheet" href="./assets/css/console-analytics-bsb.css">

    <!-- BSB Head -->

</head>

<body>
<!-- Header -->
<header id="header" class="bg-white border-bottom border-light-subtle sticky-top bsb-tpl-header-sticky">
    <nav class="navbar navbar-expand-md bsb-navbar-3 bsb-tpl-navbar-sticky" data-bsb-sticky-target="#header">
        <div class="container">
            <ul class="navbar-nav">
                <li class="nav-item me-3">
                    <a class="nav-link" href="#!" data-bs-toggle="offcanvas" data-bs-target="#bsbSidebar1" aria-controls="bsbSidebar1">
                        <i class="bi-filter-left fs-3 lh-1"></i>
                    </a>
                </li>
            </ul>
            <a class="navbar-brand" href="teacher_index.jsp">
                <img src="./assets/img/branding/console-logo.svg" class="bsb-tpl-logo" alt="Logo">
            </a>
            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#bsbNavbar" aria-controls="bsbNavbar" aria-label="Toggle Navigation">
                <i class="bi bi-three-dots"></i>
            </button>
            <div class="collapse navbar-collapse" id="bsbNavbar">
                <ul class="navbar-nav bsb-dropdown-menu-responsive ms-auto align-items-center">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle bsb-dropdown-toggle-caret-disable" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-circle"></i><p style="display: inline; margin: 0; margin-left: 8px;">bean_name</p>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-md-end bsb-dropdown-animation bsb-fadeIn">
                            <li>
                                <h6 class="dropdown-header fs-7 text-center">Welcome, bean_name</h6>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <li>
                                <a class="dropdown-item" href="pages-profile.html">
                    <span>
                      <i class="bi bi-person-fill me-2"></i>
                      <span class="fs-7">View Profile</span>
                    </span>
                                </a>
                            </li>

                            <li>
                                <a class="dropdown-item" href="pages-faqs.html">
                    <span>
                      <i class="bi bi-question-circle-fill me-2"></i>
                      <span class="fs-7">Help Center</span>
                    </span>
                                </a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a class="dropdown-item text-center" href="LogoutServlet">
                    <span>
                      <span class="fs-7">Log Out</span>
                    </span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main id="main">
    <!-- Section - Bootstrap Brain Component -->
    <!-- Breadcrumb -->
    <section class="py-3 py-md-4 py-xl-5 bg-light">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1 class="h4">主菜单</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb m-0 fs-7">
                            <li class="breadcrumb-item"><a class="link-primary text-decoration-none" href="teacher_index.jsp">Home</a></li>
                            <li class="breadcrumb-item">信息查询/平均成绩查询</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </section>


    <!-- Section - Bootstrap Brain Component -->
    <section class="bg-light">
        <div class="container">
            <form class="form-horizontal"  action="QueryScoreServlet" method="post">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-md-auto">
                            <i class="bi bi-pencil" style="font-size:larger;"></i>
                        </div>
                        <div class="col-md-10">
                            <h2>学生成绩查询与更新</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <div class="form-group">
                            <label for="courseId">课程编号:</label>
                            <input type="text" id="courseId" name="courseId" class="form-control" placeholder="输入课程编号">
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="form-group">
                            <label class="control-label" for="academicYear">学年:</label>
                            <select id="academicYear" name="academicYear" class="form-control">
                                <option value="2023/2024">2023/2024</option>
                                <option value="2022/2023">2022/2023</option>
                                <option value="2021/2022">2021/2022</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="form-group">
                            <label class="control-label" for="semester">学期:</label>
                            <select id="semester" name="semester" class="form-control">
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-2 form-group">
                        <button type="submit" class="btn btn-outline-primary " id="searchButton" style="margin-top: 24px;">查询</button>
                    </div>
                </div>

            </form>
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>教师编号</th>
                        <th>学生编号</th>
                        <th>学生姓名</th>
                        <th>课程编号</th>
                        <th>课程名称</th>
                        <th>学期</th>
                        <th>成绩</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${scores}" var="score">
                        <tr>
                            <form action="new_UpdateScoreServlet" method="post">
                                <td>${score.teacherId}</td>
                                <td>${score.studentId}</td>
                                <td>${score.studentName}</td>
                                <td>${score.courseId}</td>
                                <td>${score.courseName}</td>
                                <td>${score.semester}</td>
                                <td>
                                    <input type="text" class="form-control score-input" name="score" value="${score.score}">
                                    <input type="hidden" name="teacherId" value="${score.teacherId}">
                                    <input type="hidden" name="studentId" value="${score.studentId}">
                                    <input type="hidden" name="courseId" value="${score.courseId}">
                                    <input type="hidden" name="semester" value="${score.semester}">
                                </td>
                                <td><button type="submit" class="btn btn-success">更新成绩</button></td>
                            </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>

</main>


<aside class="bsb-sidebar-1 offcanvas offcanvas-start" tabindex="-1" id="bsbSidebar1" aria-labelledby="bsbSidebarLabel1">
    <div class="offcanvas-header">
        <a class="sidebar-brand" href="teacher_index.jsp">
            <img src="./assets/img/branding/console-logo.svg" id="bsbSidebarLabel1" class="bsb-tpl-logo" alt="Logo">
        </a>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body pt-0">
        <hr class="sidebar-divider mb-3">
        <ul class="navbar-nav">

            <li class="nav-item mt-3">
                <h6 class="py-1 text-secondary text-uppercase fs-7">成绩录入</h6>
            </li>
            <li class="nav-item">
                <a class="nav-link link-primary active" aria-current="page" href="updateScore.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">成绩录入</span>
                </a>
            </li>

            <li class="nav-item mt-3">
                <h6 class="py-1 text-secondary text-uppercase fs-7">信息查询</h6>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="teacher_search_score.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">成绩查询</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="teacher_search_avg.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">课程平均成绩统计</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="teacher_teacherSearchSchedule.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">课表查询</span>
                </a>
            </li>
            <li class="nav-item mt-3">
                <h6 class="py-1 text-secondary text-uppercase fs-7">更改</h6>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="reset.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">密码更改</span>
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


<!-- Footer -->
<footer class="footer py-3 border-top border-light-subtle">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="py-3">
                    wwt
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- Javascript Files: Vendors -->
<script src="https://unpkg.com/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.9/index.global.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@fullcalendar/bootstrap5@6.1.9/index.global.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
<script src="https://cdn.jsdelivr.net/npm/jsvectormap"></script>
<script src="https://cdn.jsdelivr.net/npm/jsvectormap/dist/maps/world-merc.js"></script>

<!-- Javascript Files: Controllers -->
<script src="./assets/controller/console-analytics-bsb.js"></script>
<script src="./assets/controller/calendar-1.js"></script>
<script src="./assets/controller/chart-5.js"></script>
<script src="./assets/controller/chart-6.js"></script>
<script src="./assets/controller/chart-7.js"></script>
<script src="./assets/controller/chart-8.js"></script>
<script src="./assets/controller/chart-9.js"></script>
<script src="./assets/controller/chart-10.js"></script>
<script src="./assets/controller/map-3.js"></script>

<!-- BSB Body End -->
</body>

</html>
