package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoIplm implements UserDao {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());



    @Override
    public User findByUsernameAndPassword(String username, String password) {
        //jdbc操作数据库
        try {
            String sql="select * from user where username=? and password=?";
            //查询一个对象
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findUserServlet() {
        String sql="select * from user";
        //查询一个集合
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }

    @Override
    public void addUser(User user) {

        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delUser(int id) {
        String sql="delete from user where id = ?";
        template.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        String sql="select * from user where id= ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=? ";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
      }

    @Override
    public void delSelectUser(int uid) {

        String sql="delete from user where id=?";
        template.update(sql,uid);
    }
}
