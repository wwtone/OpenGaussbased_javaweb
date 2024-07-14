package com.controller.stu;


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

@WebServlet("/stu_search_score")
public class StudentScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentSearchScoreDAO studentSearchScoreDAO = new StudentSearchScoreDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String studentId = (String) session.getAttribute("studentID");
        String academicYear = request.getParameter("academicYear");
        String semester = request.getParameter("semester");
        semester=academicYear+semester;
        String courseId = request.getParameter("courseID");
        String courseName = request.getParameter("courseName");

        List<StudentSearchScore> studentScoreList = studentSearchScoreDAO.getStudentScores(semester, courseId, courseName, studentId,null);
        for (int i = 0; i < studentScoreList.size(); i++) {
            StudentSearchScore score = studentScoreList.get(i);
            System.out.println("Semester: " + score.getSemester());
            System.out.println("Course ID: " + score.getCourseID());
            System.out.println("Course Name: " + score.getCourseName());
            System.out.println("Student ID: " + score.getStudentID());
            System.out.println("Student Name: " + score.getStudentName());
            System.out.println("Course Credits: " + score.getCourseCredits());
            System.out.println("ScoreDao: " + score.getScore());
        }

        if (studentScoreList.isEmpty()) {
            // 如果没有查询结果，重定向到初始页面
            response.sendRedirect("StudentScoreSearch.jsp");
        } else {
            // 如果有查询结果，将结果传递给JSP页面
            request.setAttribute("studentScoreList", studentScoreList);
            request.getRequestDispatcher("StudentScoreSearch.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
