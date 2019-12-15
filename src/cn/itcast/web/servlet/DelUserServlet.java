package cn.itcast.web.servlet;

import cn.itcast.service.UserService;

import cn.itcast.service.ipml.UserServiceIplm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取id
        String id = request.getParameter("id");
        //调用service查询
        System.out.println(id);
        UserService service=new UserServiceIplm();
        service.delUser(id);
        //跳转页面
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
