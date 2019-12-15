package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import cn.itcast.service.ipml.UserServiceIplm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //调用service查询
        UserService service=new UserServiceIplm();
        List<User> users = service.findUsers();
        //存入request中
        //System.out.println(users);
        request.setAttribute("users",users);
        System.out.println("查询用户列表方法执行一次");
       //跳转页面
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
