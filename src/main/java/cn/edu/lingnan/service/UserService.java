package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.User;

import java.util.List;

public interface UserService {
    //这是一个登录方法，输入参数是：用户名和密码；输出参数是：boolean
    //如果登录成功，返回ture，否则返回false
    public User findUserByNameAndPassword(String _name, String _password);

    //这是一个查询所有学生的方法，输入的参数：无；输出参数是：学生对象集合List
    public List<User> findUserAll();

    //这是一个按id查询学生的方法,输入参数为id，输出参数为对应学生的记录
    public User findUserById(String _id);

    //这是一个按姓名查询学生的方法，采用模糊查询
    //输入参数是字符串（可能是一个不完整的姓名），输出对应学生的记录（学生对象）
    public List<User> findUserByName(String _name);

    //这是一个复杂业务逻辑的示例，功能为删除一条学生记录
    //输入参数：id(s01)，最终要删除的记录一共有4条记录
    public boolean deleteUserById(String _id);

    public int updateUserPassword(String _id,String _password);

    int insertUser(User _user);

    int updateUser(User user);
}
