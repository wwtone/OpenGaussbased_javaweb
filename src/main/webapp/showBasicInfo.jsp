<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <!-- Required Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Document Title, Description, and Author -->
    <title>个人信息</title>
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
            <a class="navbar-brand" href="stu_index.jsp">
                <img src="./assets/img/branding/console-logo.svg" class="bsb-tpl-logo" alt="Logo">
            </a>
            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#bsbNavbar" aria-controls="bsbNavbar" aria-label="Toggle Navigation">
                <i class="bi bi-three-dots"></i>
            </button>
            <div class="collapse navbar-collapse" id="bsbNavbar">
                <ul class="navbar-nav bsb-dropdown-menu-responsive ms-auto align-items-center">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle bsb-dropdown-toggle-caret-disable" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-circle"></i><p style="display: inline; margin: 0; margin-left: 8px;">${basicInfo.name}</p>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-md-end bsb-dropdown-animation bsb-fadeIn">
                            <li>
                                <h6 class="dropdown-header fs-7 text-center">Welcome, ${basicInfo.name}</h6>
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
    <section class="py-3 py-md-4 py-xl-5 bg-light">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1 class="h4">Profile</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb m-0 fs-7">
                            <li class="breadcrumb-item"><a class="link-primary text-decoration-none" href="stu_index.jsp">Home</a></li>
                            <li class="breadcrumb-item">个人信息</li>
                            <li class="breadcrumb-item active" aria-current="page">个人信息查询</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </section>

    <!-- Section - Bootstrap Brain Component -->
    <section class="pb-3 pb-md-4 pb-xl-5 bg-light">
        <div class="container">
            <div class="row gy-4 gy-lg-0">
                <div class="col-12 col-lg-4 col-xl-3">
                    <div class="row gy-4">
                        <div class="col-12">
                            <div class="card widget-card border-light shadow-sm">
                                <div class="card-header text-bg-primary">Welcome, ${basicInfo.name}</div>
                                <div class="card-body">
                                    <h5 class="text-center mb-1">${basicInfo.name}</h5>
                                    <ul class="list-group list-group-flush mb-4">
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <h6 class="m-0">学号</h6>
                                            <span>${basicInfo.studentID}</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <h6 class="m-0">姓名</h6>
                                            <span>${basicInfo.name}</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-lg-8 col-xl-9">
                    <div class="card widget-card border-light shadow-sm">
                        <div class="card-body p-4">
                            <ul class="nav nav-tabs" id="profileTab" role="tablist">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link active" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="true">Profile</button>
                                </li>
                            </ul>
                            <div class="tab-content pt-4" id="profileTabContent">
                                <div class="tab-pane fade show active" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
                                    <form action="BasicInfo_UpdateServlet" class="row gy-3 gy-xxl-4" method="post">
                                        <input type="hidden" name="studentID" value="${basicInfo.studentID}">
                                        <input type="hidden" name="name" value="${basicInfo.name}">
                                        <input type="hidden" name="namePY" value="${basicInfo.namePY}">
                                        <!-- Fields for editing student information -->
                                        <div class="col-12 col-md-6">
                                            <label for="sex" class="form-label">性别</label>
                                            <input type="text" class="form-control" id="sex" name="sex" value="${basicInfo.gender}">
                                        </div>
                                        <div class="col-12 col-md-6">
                                            <label for="nation" class="form-label">民族</label>
                                            <input type="text" class="form-control" id="nation" name="nation" value="${basicInfo.nation}">
                                        </div>
                                        <div class="col-12 col-md-6">
                                            <label for="date" class="form-label">籍贯</label>
                                            <input type="text" class="form-control" id="date" name="date" value="${basicInfo.birthDate}">
                                        </div>
                                        <div class="col-12 col-md-6">
                                            <label for="nativePlace" class="form-label">籍贯</label>
                                            <input type="text" class="form-control" id="nativePlace" name="nativePlace" value="${basicInfo.nativePlace}">
                                        </div>
                                        <div class="col-12 col-md-6">
                                            <label for="politicalStatus" class="form-label">政治面貌</label>
                                            <input type="text" class="form-control" id="politicalStatus" name="politicalStatus" value="${basicInfo.politicalStatus}">
                                        </div>
                                        <div class="col-12 col-md-6">
                                            <label for="Type" class="form-label">证件类型</label>
                                            <input type="text" class="form-control" id="Type" name="Type" value="${basicInfo.IDType}">
                                        </div>
                                        <div class="col-12 col-md-6">
                                            <label for="IDNumber" class="form-label">证件号码</label>
                                            <input type="text" class="form-control" id="IDNumber" name="IDNumber" value="${basicInfo.IDNumber}">
                                        </div>
                                        <!-- Additional fields as required -->
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-primary">保存修改</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


</main>


<!-- Aside -->
<aside class="bsb-sidebar-1 offcanvas offcanvas-start" tabindex="-1" id="bsbSidebar1" aria-labelledby="bsbSidebarLabel1">
    <div class="offcanvas-header">
        <a class="sidebar-brand" href="stu_index.jsp">
            <img src="./assets/img/branding/console-logo.svg" id="bsbSidebarLabel1" class="bsb-tpl-logo" alt="Logo">
        </a>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body pt-0">
        <hr class="sidebar-divider mb-3">
        <ul class="navbar-nav">

            <li class="nav-item mt-3">
                <h6 class="py-1 text-secondary text-uppercase fs-7">个人信息</h6>
            </li>
            <li class="nav-item">
                <a class="nav-link link-primary active" aria-current="page" href="BasicInfoServlet">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">个人信息查询</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="ClassSchedule.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">班级开课</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="stu_teacherSchedule.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">教师课表</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="StudentScoreSearch.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">成绩查询</span>
                </a>
            </li>

            <li class="nav-item mt-3">
                <h6 class="py-1 text-secondary text-uppercase fs-7">更改</h6>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="showBasicInfo.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">个人信息更改</span>
                </a>
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
