package com.controller.manager;

import com.Beans.ClassSchedule;
import com.Dao.StudentScheduleDao;
import com.DaoImpl.StudentScheduleDaoImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentScheduleServlet")
public class StudentScheduleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String academicYear = request.getParameter("academicYear");
        String semester = request.getParameter("semester");
        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");

        // 调用DAO方法获取查询结果
        StudentScheduleDao studentScheduleDao = new StudentScheduleDaoImpl();
        List<ClassSchedule> classScheduleList = studentScheduleDao.getClassSchedule(academicYear, semester, studentId, studentName);
        System.out.println(classScheduleList.size());
        // 将查询结果设置为请求属性
        request.setAttribute("classScheduleList", classScheduleList);

        // 转发请求到JSP页面
        RequestDispatcher dispatcher = request.getRequestDispatcher("manager_studentSchedule.jsp");
        dispatcher.forward(request, response);
    }
}
