package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.*;
import cn.edu.lingnan.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceMysqlImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    PropertyDao propertyDao = new PropertyDaoImpl();


    public UserServiceMysqlImpl() {
        super();
    }

    @Override
    public User findUserByNameAndPassword(String _name, String _password) {
        return userDao.findUserByNameAndPassword(_name,_password);
    }

    @Override
    public List<User> findUserAll() {
        return userDao.findUserAll();
    }

    @Override
    public User findUserById(String _id) {
        return userDao.findUserById(_id);
    }

    @Override
    public List<User> findUserByName(String _name) {
        return findUserByName(_name);
    }

    @Override
    public boolean deleteUserById(String _id) {
        boolean flag = false;
        List<String> list = null;
        List<String> ids = new ArrayList<>();

        userDao.deleteUserById(_id);
        for (String id : ids) {
            propertyDao.deletePropertyByPid(id);
        }
        flag = true;
        return flag;
    }

    @Override
    public int updateUserPassword(String _id, String _password) {
        int flag = 0;
        if(userDao.findUserById(_id)==null){
            return 2;
        }
        flag = userDao.updateUserPassword(_id,_password);
        return flag;
    }

    @Override
    public int insertUser(User _user) {
        int flag=0;
        flag= userDao.insertUser(_user);
        return flag;
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

}




