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

@WebServlet("/findUserServletQ")
public class findUserServletQ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取id
        String id = request.getParameter("id");
        //根据id查询用户信息
        UserService service=new UserServiceIplm();
        User user = service.findUserById(id);
        //将user对象存到request域中
        request.setAttribute("user",user);
        //转发页面
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
