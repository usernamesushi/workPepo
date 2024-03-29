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

@WebServlet("/userPageServlet")
public class UserPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        //2.调用service查询
        UserService service = new UserServiceIplm();
        PageBean pb = service.findUserByPage(currentPage, rows);
        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        System.out.println(pb);
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
