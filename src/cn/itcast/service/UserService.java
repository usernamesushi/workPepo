package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface  UserService {

    //用户登录
    User login(User user);

    //用户查询（不带分页）
    List<User> findUsers();

    //添加用户
    void addUser(User user);

    //根据id删除用户
    void delUser(String id);

    //根据id查询用户
    User findUserById(String id);

    //修改用户信息
    void updateUser(User user);

    //批量删除
    void delSelectUser(String[] uuids);
}
