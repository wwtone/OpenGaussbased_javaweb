package com.controller.manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.Beans.TeacherScoreAvg;
import com.DaoImpl.ScoreManageDaoImpl;

@WebServlet("/adminScoreAvgServlet")
public class ManagerScoreAvgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherID = req.getParameter("teacherID");
        String academicYear = req.getParameter("academicYear");
        String semester = req.getParameter("semester");
        String courID = req.getParameter("courseID");
        String time = academicYear + semester;

        // Logic to fetch data based on parameters
        ScoreManageDaoImpl searchImpl = new ScoreManageDaoImpl();
        try {
            List<TeacherScoreAvg> results = searchImpl.search_course_average(teacherID,courID, time);
            req.getSession().setAttribute("results", results);
            req.getRequestDispatcher("/manager_score_manage.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}