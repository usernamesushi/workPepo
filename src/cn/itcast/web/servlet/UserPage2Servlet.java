package cn.itcast.web.servlet;

import cn.itcast.domain.PageBean;
import cn.itcast.service.UserService;
import cn.itcast.service.ipml.UserServiceIplm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserPage2Servlet")

public class UserPage2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        UserService service=new UserServiceIplm();
        PageBean pb = service.findUserByPage(currentPage, rows);
        request.setAttribute("pb",pb);
        System.out.println(pb);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
