package cn.edu.lingnan.service;

import org.junit.Test;

public class UserServiceTest {
    UserService service = new UserServiceMysqlImpl();
    @Test
    public void updateUserPasswordTest(){
        String id = "s02";
        String newPassword = "12345";
        System.out.println(service.updateUserPassword(id, newPassword));
    }
}
