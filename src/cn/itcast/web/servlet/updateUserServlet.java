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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取表单数据map
        Map<String, String[]> map = request.getParameterMap();
        //封装User对象
       User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service`
        UserService service=new UserServiceIplm();
        service.updateUser(user);
        //跳转页面
        response.sendRedirect(request.getContextPath()+"/userListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
