package cn.edu.lingnan.test;
import cn.edu.lingnan.dao.UserDao;
import cn.edu.lingnan.dao.UserDaoImpl;
import cn.edu.lingnan.pojo.User;

public class UserTest {
    public static void main(String[] args) throws ClassNotFoundException {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setId("4");
        user.setName("liu");
        user.setPassword("123");
        user.setPhone("1234");
        user.setRight(0);
        userDao.updateUser(user);
//        for (User user : userDao.findUserByName("zh")) {
//            System.out.println(user.toString());
//        }



//userDao.findUserAll().fori快捷得到for (int i = 0; i < userDao.findUserAll().size(); i++) {}

//        boolean flag = userDao.findUserByNameAndPassword("admin","admin");
//        System.out.println(flag);
    }
}











