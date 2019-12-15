package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    User findByUsernameAndPassword(String username, String password);


    List<User> findUserServlet();


    void addUser(User user);

    void delUser(int id);

    User findUserById(int id);

    void updateUser(User user);


    void delSelectUser(int uid);
}
