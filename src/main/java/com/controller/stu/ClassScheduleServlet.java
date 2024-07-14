package com.controller.stu;
import com.Beans.ClassSchedule;
import com.Dao.ClassScheduleDAO;
import com.DaoImpl.ClassScheduleDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClassScheduleServlet")
public class ClassScheduleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String academicYear = request.getParameter("academicYear");
        String semester = request.getParameter("semester");
        String classId = request.getParameter("classId");
        String className = request.getParameter("className");
        System.out.println(className);
        // 调用DAO方法获取查询结果
        ClassScheduleDAO classScheduleDAO = new ClassScheduleDAOImpl();
        List<ClassSchedule> classScheduleList = classScheduleDAO.getClassSchedule(academicYear, semester, classId, className);

        // 将查询结果设置为请求属性
        request.setAttribute("classScheduleList", classScheduleList);

        // 转发请求到JSP页面
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClassSchedule.jsp");
        dispatcher.forward(request, response);
    }
}
