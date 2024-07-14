package com.controller.manager;



import com.Beans.Score;
import com.Dao.ScoreDao;
import com.DaoImpl.ScoreImpl;
import com.DaoImpl.ScoreManageDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String semester = request.getParameter("semester");
        String courseID = request.getParameter("courseID");
        String classID = request.getParameter("classID");

        ScoreImpl scoreManageDao=new ScoreImpl();

        try {
            List<Score> scores = scoreManageDao.getRankedScores(semester, courseID, classID);
            request.setAttribute("scores", scores);
            request.getRequestDispatcher("/manager_scores_rank.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
