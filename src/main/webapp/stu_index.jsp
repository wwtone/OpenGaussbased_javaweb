<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
  <!-- Required Meta Tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Document Title, Description, and Author -->
  <title>主菜单</title>
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
    <!-- Section - Bootstrap Brain Component -->
    <!-- Breadcrumb -->
    <section class="py-3 py-md-4 py-xl-5 bg-light">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1 class="h4">主菜单</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb m-0 fs-7">
                            <li class="breadcrumb-item"><a class="link-primary text-decoration-none" href="stu_index.jsp">Home/</a></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </section>

    <!-- Copy of the first section with consistent container and row classes -->
    <section class="py-3 py-md-4 py-xl-5 bg-light">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-lg-3">
                    <div class="full counter_section margin_bottom_30">
                        <div class="couter_icon">
                            <div> 
                              <i class="bi bi-file-person" style="font-size: 30px;"></i>
                            </div>
                        </div>
                        <div class="counter_no">
                            <div>
                                <p class="no">${basicInfo.studentID}</p>
                                <p class="name">${basIcinfo.name}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="full counter_section margin_bottom_30">
                        <div class="couter_icon">
                            <div> 
                              <i class="bi bi-mortarboard-fill" style="font-size: 30px;"></i>
                            </div>
                        </div>
                        <div class="counter_no">
                            <div>
                                <p class="name">${basicInfo.birthDate}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="full counter_section margin_bottom_30">
                        <div class="couter_icon">
                            <div> 
                              <i class="bi bi-house-check-fill" style="font-size: 30px;"></i>
                            </div>
                        </div>
                        <div class="counter_no">
                            <div>
                                <p class="home_name">${basicInfo.nativePlace}</p>
                                <p class="blank"><br></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="full counter_section margin_bottom_30">
                        <div class="couter_icon">
                            <div> 
                              <i class="bi bi-people-fill" style="font-size: 30px;"></i>
                            </div>
                        </div>
                        <div class="counter_no">
                            <div>
                                <p class="class_no">${basicInfo.politicalStatus}</p>
                                <p class="blank"><br></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Section - Bootstrap Brain Component -->
    <section class="pb-3 pb-md-4 pb-xl-5 bg-light">
      <div class="container">
        <div class="row gy-3 gy-md-4">
          <div class="col-12">
            <div class="row gy-3 gy-md-4">
              <div class="col-12">
                <div class="card widget-card border-light shadow-sm bg-transparent">
                  <div class="card-header bg-white p-4 border-light-subtle">
                    <i class="bi bi-calendar-check-fill" style="font-size: 30px;"></i>
                    <h5 class="card-title widget-card-title m-0">日历</h5>
                  </div>
                  <div class="card-body p-4">
                    <div class="card widget-card border-light shadow-sm">
                      <div class="card-body p-4">
                        <div id="bsb-calendar-1" class="fc fc-media-screen fc-direction-ltr fc-theme-bootstrap5 bsb-calendar-theme"></div>
                      </div>
                    </div>
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
          <a class="nav-link link-secondary" aria-current="page" href="BasicInfoServlet">
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
