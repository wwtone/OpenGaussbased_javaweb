package com.controller.manager;

import com.Beans.StudentSearchScore;
import com.Dao.StudentSearchScoreDAO;
import com.DaoImpl.StudentSearchScoreDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminStudentScoreServlet")
public class ManagerStudentScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentSearchScoreDAO studentSearchScoreDAO = new StudentSearchScoreDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String studentId = request.getParameter("studentID");
        String studentName = request.getParameter("studentName");
        String academicYear = request.getParameter("academicYear");
        String semester = request.getParameter("semester");
        semester = academicYear + semester;
        String courseId = request.getParameter("courseID");
        String courseName = request.getParameter("courseName");

        List<StudentSearchScore> studentScoreList = studentSearchScoreDAO.getStudentScores(semester, courseId, courseName, studentId, studentName);

        if (studentScoreList.isEmpty()) {
            response.sendRedirect("manager_score_search.jsp");
        } else {
            request.setAttribute("studentScoreList", studentScoreList);
            request.getRequestDispatcher("manager_score_search.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
