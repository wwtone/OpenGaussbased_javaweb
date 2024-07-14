package com.controller.stu;

import com.Beans.BasicInfo;
import com.Dao.BasicInfoDao;
import com.DaoImpl.BasicInfoImpl;
import com.Dao.DaoException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/BasicInfoServlet")
public class BasicInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BasicInfoDao basicInfoDao;

    @Override
    public void init() throws ServletException {
        super.init();
        basicInfoDao = new BasicInfoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentID = (String) session.getAttribute("studentID");
        System.out.println(studentID);
        if (studentID != null && !studentID.isEmpty()) {
            try {
                BasicInfo basicInfo = basicInfoDao.getBasicInfo(studentID);
                request.setAttribute("basicInfo", basicInfo);
                request.getRequestDispatcher("/showBasicInfo.jsp").forward(request, response);
            } catch (DaoException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database access error");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid student ID");
        }
    }
}
