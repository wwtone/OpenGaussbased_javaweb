package com.servlets;

import com.Beans.Student;
import com.Dao.StudentDao;
import com.DaoImpl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchStudentServlet")
public class SearchStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String studentID = request.getParameter("studentID");
        String studentName = request.getParameter("studentName");

        List<Student> students = null;
        try {
            students = studentDao.getStudentsByNameAndID(studentName, studentID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("studentList", students);
        request.getRequestDispatcher("manager_stu_manage.jsp").forward(request, response);
    }
}
