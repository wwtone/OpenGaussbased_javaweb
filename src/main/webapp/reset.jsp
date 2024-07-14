<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Document Title, Description, and Author -->
    <title>修改密码</title>
    <meta name="description" content="Console is a Free Bootstrap Admin Template.">

    <!-- Favicon and Touch Icons -->
    <link rel="icon" type="image/png" sizes="512x512" href="./assets/favicon/opengause.png">

    <!-- Google Fonts Files -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- CSS Files -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./assets/css/console-analytics-bsb.css">

    <!-- BSB Head -->
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            background: url('./assets/img/reset.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .card {
            background: rgba(255, 255, 255, 0.8); /* White with 80% opacity */
        }
    </style>

</head>

<body>

<!-- Main -->
<main id="main" class="d-flex justify-content-center align-items-center min-vh-100">
    <!-- Change Password Section -->
    <section class="py-3 py-md-5 d-flex justify-content-center align-items-center">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-sm-10 col-md-8 col-lg-8 col-xl-7 col-xxl-6">
                    <div class="card border border-light-subtle rounded-3 shadow-sm">
                        <div class="card-body p-3 p-md-4 p-xl-5">
                            <div class="text-center mb-3">
                                <img src="./assets/favicon/opengause.png" alt="Logo" width="175" height="175">
                            </div>
                            <h5 class="fs-6 fw-normal text-center text-secondary mb-4" style="accent-color: #b6d0f7">修改密码</h5>

                            <form action="/wwt/ChangePasswordServlet" method="post">
                                <div class="row gy-2 overflow-hidden">
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="username" id="username" placeholder="Username" required>
                                            <label for="username" class="form-label">用户名</label>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="password" class="form-control" name="oldPassword" id="oldPassword" placeholder="Old Password" required>
                                            <label for="oldPassword" class="form-label">旧密码</label>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="New Password" required>
                                            <label for="newPassword" class="form-label">新密码</label>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="d-grid my-3">
                                            <button class="btn btn-primary btn-lg" type="submit">修改密码</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div class="text-center mt-3">
                  <span class="text-secondary">
                    <%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>
                  </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</main>

<!-- BSB Body End -->
</body>

</html>
