package cn.itcast.web.servlet;

import cn.itcast.service.UserService;
import cn.itcast.service.ipml.UserServiceIplm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectServlet")
public class delSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取id数组
        String[]  uuids = request.getParameterValues("uuid");
        //调用service删除
        UserService service=new UserServiceIplm();
        service.delSelectUser(uuids);
        //跳转到查询页面
        response.sendRedirect(request.getContextPath()+"/userListServlet");

    }
}
