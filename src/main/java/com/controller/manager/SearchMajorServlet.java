package com.controller.manager;

import com.Beans.Major;
import com.Dao.MajorDao;
import com.DaoImpl.MajorDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchMajorServlet")
public class SearchMajorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String majorID = request.getParameter("majorID");
        String majorName = request.getParameter("majorName");
        System.out.println(majorID);
        System.out.println(majorName);
        MajorDao majorDao = new MajorDaoImpl();
        List<Major> majorList = majorDao.getMajor(majorID, majorName);
        System.out.println(majorList.size());
        request.setAttribute("majorList", majorList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manager_major_manage.jsp");
        dispatcher.forward(request, response);
    }
}
