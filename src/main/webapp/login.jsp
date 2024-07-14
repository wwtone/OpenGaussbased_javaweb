<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <!-- Required Meta Tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Document Title, Description, and Author -->
  <title>登录页面</title>
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
      background: url('./assets/img/login.jpg') no-repeat center center fixed;
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
    <!-- Login 13 - Bootstrap Brain Component -->
    <section class="py-3 py-md-5 d-flex justify-content-center align-items-center">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-12 col-sm-10 col-md-8 col-lg-8 col-xl-7 col-xxl-6">
            <div class="card border border-light-subtle rounded-3 shadow-sm">
              <div class="card-body p-3 p-md-4 p-xl-5">
                <div class="text-center mb-3">
                    <img src="./assets/favicon/opengause.png" alt="Logo" width="175" height="175">
                  </a>
                </div>
                <h2 class="fs-6 fw-normal text-center text-secondary mb-4">登录你的账号</h2>

                <form action="/wwt/loginServlet" method="post">
                  <div class="row gy-2 overflow-hidden">
                    <div class="col-12">
                      <div class="form-floating mb-3">
                        <input type="text" class="form-control" name="uid" id="uid" placeholder="name@example.com" required>
                        <label for="uid" class="form-label">学号</label>
                      </div>
                    </div>
                    <div class="col-12">
                      <div class="form-floating mb-3">
                        <input type="password" class="form-control" name="pwd" id="password" value="" placeholder="Password" required>
                        <label for="password" class="form-label">密码</label>
                      </div>
                    </div>
                    <div class="col-12">
                      <div class="d-flex gap-2 justify-content-between">
                        <div class="form-check">
                          <input class="form-check-input" type="checkbox" value="" name="rememberMe" id="rememberMe">
                          <label class="form-check-label text-secondary" for="rememberMe">
                            记住我
                          </label>
                        </div>
                        <a href="auth-reset-password.html" class="link-primary text-decoration-none">忘记密码?</a>
                      </div>
                    </div>
                    <div class="col-12">
                      <div class="d-grid my-3">
                        <button class="btn btn-primary btn-lg" type="submit">登 录</button>
                      </div>
                    </div>
                  </div>

                </form>
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
