package com.servlets;

import com.Dao.StudentDao;
import com.DaoImpl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String studentID = request.getParameter("studentID");

        try {
            studentDao.deleteStudent(studentID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("manager_stu_manage.jsp");
    }
}
