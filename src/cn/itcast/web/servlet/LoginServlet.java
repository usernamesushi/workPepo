package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.ipml.UserServiceIplm;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


//@WebServlet(value="/loginServlet")
@WebServlet(urlPatterns = {"/loginServlet"})

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        //校验验证码
        String verifycode = request.getParameter("verifycode");//用户填写的验证码
        HttpSession session = request.getSession();
        //页面生成的验证码
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            //给出提示信息
            request.setAttribute("log_msg", "验证码错误!");
            //跳转到页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        //验证码正确
        //封装User对象
        User user = new User();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //判断用户登录
        UserService service=new UserServiceIplm();
        User loginUser = service.login(user);
        if(loginUser!=null){
            //登录成功
            //将USER对象存入session中，跳转页面
            session.setAttribute("users",loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //登录失败
            request.setAttribute("log_msg", "用户名或者密码错误!");
            //跳转到页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
