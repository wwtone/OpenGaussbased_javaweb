package com.controller.manager;

import com.Beans.Teacher;
import com.Dao.TeacherDao;
import com.DaoImpl.TeacherDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchTeacherServlet")
public class SearchTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String teacherID = request.getParameter("teacherID");
        String teacherName = request.getParameter("teacherName");

        TeacherDao teacherDao = new TeacherDaoImpl();
        List<Teacher> teacherList = teacherDao.getTeacher(teacherID, teacherName);

        request.setAttribute("teacherList", teacherList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manager_teacher_manage.jsp");
        dispatcher.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request,response);
    }
}
