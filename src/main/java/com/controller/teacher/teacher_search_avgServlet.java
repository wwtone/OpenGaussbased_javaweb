package com.controller.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.Beans.teacher_search_score;
import com.DaoImpl.Teacher_search_impl;
import com.Beans.teacher_course_average;

@WebServlet("/teacher_search_avgServlet")
public class teacher_search_avgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherID = (String) req.getSession().getAttribute("teacherID");
        String academicYear = req.getParameter("academicYear");
        String semester = req.getParameter("semester");
        String courID = req.getParameter("courseID");
        String time = academicYear + semester;

        // Logic to fetch data based on parameters
        Teacher_search_impl searchImpl = new Teacher_search_impl();
        try {
            List<teacher_course_average> results = searchImpl.search_course_average(teacherID,courID, time);
            req.getSession().setAttribute("results", results);
            req.getRequestDispatcher("/teacher_search_avg.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}