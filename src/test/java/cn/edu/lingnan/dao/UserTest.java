package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.User;
import org.junit.Test;

public class UserTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void findUserByNameAndPasswordTest() throws ClassNotFoundException {
        System.out.println(userDao.findUserByNameAndPassword("admin","admin"));
    }

    @Test
    public void findUserAllTest(){
        for (User user : userDao.findUserAll()) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void findUserByIdTest() {
        System.out.println(userDao.findUserById("s01").toString());
    }

    @Test
    public void findUserNameTest() {
        for (User user : userDao.findUserByName("zh")) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void deleteUserByIdTest(){
        System.out.println(userDao.deleteUserById("s01"));
    }



}

