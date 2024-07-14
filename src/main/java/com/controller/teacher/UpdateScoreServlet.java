package com.controller.teacher;

import com.Beans.UpdateScore;
import com.Dao.UpdateScoreDAO;
import com.DaoImpl.UpdateScoreDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/new_UpdateScoreServlet")
public class UpdateScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");
        String semester = request.getParameter("semester");
        String courseId = request.getParameter("courseId");
        String studentId = request.getParameter("studentId");
        int score = (int) Float.parseFloat(request.getParameter("score"));

        // Create an UpdateScore object and set its properties
        UpdateScore updateScore = new UpdateScore();
        updateScore.setTeacherId(teacherId);
        updateScore.setSemester(semester);
        updateScore.setCourseId(courseId);
        updateScore.setStudentId(studentId);
        updateScore.setScore(score);

        // Use UpdateScoreDAO to update the score
        UpdateScoreDAO updateScoreDAO = new UpdateScoreDAOImpl();
        boolean isUpdated = updateScoreDAO.updateScore(updateScore);

        String message;
        if (isUpdated) {
            message = "成绩更新成功";
        } else {
            message = "成绩更新失败";
        }

        // Set the message as a request attribute and forward back to the form
        request.setAttribute("message", message);
        request.getRequestDispatcher("/updateScore.jsp").forward(request, response);
    }
}
