package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import com.Beans.BasicInfo;
import com.Dao.AdminDao;
import com.Dao.BasicInfoDao;
import com.DaoImpl.AdminDaoImpl;
import com.Beans.Admin;
import com.DaoImpl.BasicInfoImpl;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); // 设置请求编码
        PrintWriter pw = response.getWriter();
        AdminDao dao = new AdminDaoImpl();

        try {
            String number = request.getParameter("uid");
            String password = request.getParameter("pwd");

            // 检查用户名和密码是否为空
            if (number == null || password == null) {
                pw.write("<script language='javascript'>alert('请输入用户名和密码！');window.location.href='login.jsp';</script>");
                return;
            }

            String hashedPassword = getSHA256StrJava(password);
            String type = dao.judgeAdmin(number, hashedPassword);
            System.out.println(type);
//            String hashedPassword=password;
//            String type = dao.judgeAdmin(number, hashedPassword);

            if (type != null) {
                Admin user = new Admin(number, hashedPassword, type);
                HttpSession session = request.getSession();
                synchronized (session) {
                    session.setAttribute("user", user);
                    if(type.equals("学生")){
                        BasicInfoDao basicInfoDao = new BasicInfoImpl();
                        BasicInfo basicInfo = basicInfoDao.getBasicInfo(number);
                        session.setAttribute("basicInfo",basicInfo);
                        session.setAttribute("studentID", number);
                        RequestDispatcher rd = request.getRequestDispatcher("/stu_index.jsp");
                        rd.forward(request, response);
                    }
                    else if(type.equals("教师")){
                        session.setAttribute("teacherID", number);
                        RequestDispatcher rd = request.getRequestDispatcher("/teacher_index.jsp");
                        rd.forward(request, response);
                    } else if (type.equals("系统管理员")) {
                        session.setAttribute("managerID", number);
                        RequestDispatcher rd = request.getRequestDispatcher("/manager_index.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        RequestDispatcher rd = request.getRequestDispatcher("/404.jsp");
                        rd.forward(request, response);
                    }
                }

            } else {
                pw.write("<script language='javascript'>alert('学工号或密码错误！');window.location.href='login.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pw.write("<script language='javascript'>alert('登录失败，请重试！');window.location.href='login.jsp';</script>");
        }
    }

    public static String getSHA256StrJava(String str) { // 密码通过哈希加密
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    public static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
    public static void Main(){
        System.out.println(getSHA256StrJava("123456"));
    }
}
