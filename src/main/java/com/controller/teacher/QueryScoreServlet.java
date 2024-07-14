package com.controller.teacher;

import com.Beans.UpdateScore;
import com.DaoImpl.UpdateScoreDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/QueryScoreServlet")
public class QueryScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = (String) request.getSession().getAttribute("teacherID");
        String academicyear=request.getParameter("academicYear");
        String semester = request.getParameter("semester");
        String courseId = request.getParameter("courseId");
        semester=academicyear+semester;

        UpdateScoreDAOImpl updateScoreDAO=new UpdateScoreDAOImpl();
        List<UpdateScore> scores = updateScoreDAO.findScores(teacherId, semester, courseId);

        request.setAttribute("scores", scores);
        request.getRequestDispatcher("/updateScore.jsp").forward(request, response);
    }
}
