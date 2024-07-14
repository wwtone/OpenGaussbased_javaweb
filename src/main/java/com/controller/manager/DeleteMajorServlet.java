package com.controller.manager;

import com.Dao.DaoException;
import com.Dao.MajorDao;
import com.DaoImpl.MajorDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteMajorServlet")
public class DeleteMajorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String majorID = request.getParameter("majorID");

        MajorDao majorDao = new MajorDaoImpl();
        try {
            majorDao.deleteMajor(majorID);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("manager_major_manage.jsp");
    }
}
