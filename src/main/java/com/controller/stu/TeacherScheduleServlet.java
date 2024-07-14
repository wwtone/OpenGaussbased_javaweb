package com.controller.stu;

import com.Beans.TeacherSchedule;
import com.Dao.TeacherScheduleDAO;
import com.DaoImpl.TeacherScheduleDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherScheduleServlet")
public class TeacherScheduleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TeacherScheduleDAO teacherScheduleDAO = new TeacherScheduleDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String academicYear = request.getParameter("academicYear");
        String semester = request.getParameter("semester");
        String title = request.getParameter("title");
        String teacher = request.getParameter("teacher");
        String teacherID = request.getParameter("teacherID");

        List<TeacherSchedule> teacherScheduleList = teacherScheduleDAO.getTeacherSchedule(academicYear, semester, title, teacher, teacherID);

        if (teacherScheduleList.isEmpty()) {
            // 如果没有查询结果，重定向到初始页面
            response.sendRedirect("stu_teacherSchedule.jsp");
        } else {
            // 如果有查询结果，将结果传递给JSP页面
            request.setAttribute("teacherScheduleList", teacherScheduleList);
            request.getRequestDispatcher("stu_teacherSchedule.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
