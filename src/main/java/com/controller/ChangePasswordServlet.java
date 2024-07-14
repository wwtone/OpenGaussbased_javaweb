package com.controller;
import com.Dao.AdminDao;
import com.DaoImpl.AdminDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        try {
            // 验证旧密码
            String currentRole = adminDao.judgeAdmin(username, sha256(oldPassword));
            if (currentRole != null) {
                // 更新新密码
                adminDao.changePassword(username, sha256(newPassword));
                request.setAttribute("message", "密码修改成功！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "旧密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "密码修改失败！");
        };
        System.out.println(request.getAttribute("message"));
        request.getRequestDispatcher("resetreset.jsp").forward(request, response);
    }

    private String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}
