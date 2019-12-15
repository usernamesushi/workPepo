package cn.itcast.service.ipml;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoIplm;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;

public class UserServiceIplm implements UserService {

    private UserDao dao=new UserDaoIplm();

    @Override
    public User login(User user) {
        return dao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> findUsers() {
        return dao.findUserServlet();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void delUser(String id) {
        dao.delUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelectUser(String[] uuids) {
        for (String s:uuids
             ) {
            dao.delSelectUser(Integer.parseInt(s));
        }


    }


}
