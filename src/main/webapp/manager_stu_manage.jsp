<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <!-- Required Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Document Title, Description, and Author -->
    <title>学生信息管理</title>
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
            <a class="navbar-brand" href="manager_index.jsp">
                <img src="./assets/img/branding/console-logo.svg" class="bsb-tpl-logo" alt="Logo">
            </a>
            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#bsbNavbar" aria-controls="bsbNavbar" aria-label="Toggle Navigation">
                <i class="bi bi-three-dots"></i>
            </button>
            <div class="collapse navbar-collapse" id="bsbNavbar">
                <ul class="navbar-nav bsb-dropdown-menu-responsive ms-auto align-items-center">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle bsb-dropdown-toggle-caret-disable" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-circle"></i><p style="display: inline; margin: 0; margin-left: 8px;">管理员</p>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-md-end bsb-dropdown-animation bsb-fadeIn">
                            <li>
                                <h6 class="dropdown-header fs-7 text-center">Welcome, 管理员</h6>
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
                            <li class="breadcrumb-item"><a class="link-primary text-decoration-none" href="manager_index.jsp">Home</a></li>
                            <li class="breadcrumb-item">信息管理 / 学生信息管理</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </section>


    <!-- Section - Bootstrap Brain Component -->
    <!-- 教师信息管理部分 -->
    <section class="py-3 py-md-4 py-xl-5 bg-light">
        <div class="container py-3 py-md-4 py-xl-5 bg-light">
            <h3>学生信息管理</h3>
            <!-- Search and Add Form -->
            <div>
                <form class="form-inline mb-3" action="searchStudentServlet" method="post">
                    <!-- Search fields -->
                    <div class="input-group mb-2 mr-sm-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-id-card"></i>学生编号</div>
                        </div>
                        <input type="text" class="form-control" id="studentID" name="studentID" placeholder="请输入学生编号">
                    </div>
                    <div class="input-group mb-2 mr-sm-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-user"></i>学生姓名</div>
                        </div>
                        <input type="text" class="form-control" id="studentName" name="studentName" placeholder="请输入学生姓名">
                    </div>
                    <button type="submit" class="btn btn-outline-primary mb-2">查询</button>
                </form>

                <!-- Add Form -->
            </div>
            <!-- Table to Display Student Data -->
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>班级编号</th>
                        <th>学生编号</th>
                        <th>学生姓名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>家乡</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="student" items="${studentList}">
                        <tr>
                            <td>${student.classID}</td>
                            <td>${student.studentID}</td>
                            <td>${student.studentName}</td>
                            <td>${student.gender}</td>
                            <td>${student.age}</td>
                            <td>${student.hometown}</td>
                            <td>
                                <form action="deleteStudentServlet" method="post" style="display:inline;">
                                    <input type="hidden" name="studentID" value="${student.studentID}">
                                    <button type="submit" class="btn btn-outline-danger" onclick="return confirm('确定要删除这个学生吗？')">删除</button>
                                </form>
                                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#updateModal"
                                        data-classid="${student.classID}"
                                        data-studentid="${student.studentID}"
                                        data-studentname="${student.studentName}"
                                        data-gender="${student.gender}"
                                        data-age="${student.age}"
                                        data-earnedcredits="${student.earnedCredits}"
                                        data-hometown="${student.hometown}">
                                    更新
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
    <!-- Update Modal -->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateModalLabel">更新学生信息</h5>
                </div>
                <form action="updateStudentServlet" method="post">
                    <div class="modal-body">
                        <input type="hidden" id="updateClassID" name="classID">
                        <input type="hidden" id="updateStudentID" name="studentID">
                        <div class="form-group">
                            <label for="updateStudentName">学生姓名</label>
                            <input type="text" class="form-control" id="updateStudentName" name="studentName" required>
                        </div>
                        <div class="form-group">
                            <label for="updateGender">性别</label>
                            <input type="text" class="form-control" id="updateGender" name="gender" required>
                        </div>
                        <div class="form-group">
                            <label for="updateAge">年龄</label>
                            <input type="number" class="form-control" id="updateAge" name="age" required>
                        </div>
                        <div class="form-group">
                            <label for="updateCreditsEarned">已获得学分</label>
                            <input type="number" class="form-control" id="updateCreditsEarned" name="creditsEarned" required>
                        </div>
                        <div class="form-group">
                            <label for="updateHometown">家乡</label>
                            <input type="text" class="form-control" id="updateHometown" name="hometown" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-outline-primary">保存更改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>



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
                <a class="nav-link link-primary active" aria-current="page" href="manager_stu_manage.jsp">
                    <div class="nav-link-icon text-primary-emphasis">
                        <i class="bi bi-arrow-right-short"></i>
                    </div>
                    <span class="nav-link-text">学生信息管理</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link link-secondary" aria-current="page" href="manager_major_manage.jsp">
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
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

<script>
    $(document).ready(function() {
        $('#teacherTable').DataTable({
            paging: true,
            searching: false, // 禁用搜索框
            language: {
                lengthMenu: "每页显示 _MENU_ 条记录",
                zeroRecords: "没有找到记录",
                info: "显示 _START_ 到 _END_ 条记录，共 _TOTAL_ 条记录",
                infoEmpty: "没有记录",
                infoFiltered: "(从 _MAX_ 条记录中筛选)",
                paginate: {
                    first:      "首页",
                    last:       "末页",
                    next:       "下一页",
                    previous:   "上一页"
                }
            }
        });

    });
</script>
<script>
    $('#updateModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var classID = button.data('classid');
        var studentID = button.data('studentid');
        var studentName = button.data('studentname');
        var gender = button.data('gender');
        var age = button.data('age');
        var earnedCredits = button.data('earnedcredits');
        var hometown = button.data('hometown');
        var major = button.data('major');

        var modal = $(this);
        modal.find('.modal-body #updateClassID').val(classID);
        modal.find('.modal-body #updateStudentID').val(studentID);
        modal.find('.modal-body #updateStudentName').val(studentName);
        modal.find('.modal-body #updateGender').val(gender);
        modal.find('.modal-body #updateAge').val(age);
        modal.find('.modal-body #updateCreditsEarned').val(earnedCredits);
        modal.find('.modal-body #updateHometown').val(hometown);
        modal.find('.modal-body #updateMajor').val(major);
    });
</script>
</body>
</html>
