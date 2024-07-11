package cn.edu.lingnan.dao;
import cn.edu.lingnan.pojo.User;
import cn.edu.lingnan.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserByNameAndPassword(String _name, String _password) {
        User user = new User();
        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getInstance().getConnection();
                    //getConnection很浪费资源
                    //在try里面关吗？
                    //try里面定义的所有变量，都是局部变量，把定义移到外层
            stat = connection.createStatement();
            rs= stat.executeQuery
                    ("select * from user where name='"+_name+"' and password = '"+_password+"'");
            while (rs.next()){
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRight(rs.getInt("right"));

            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            DBUtil.getInstance().close(rs,stat,connection);
            return user;
        }
    }

    @Override
    public List<User> findUserAll(){
        ArrayList<User> List = new ArrayList<>();
        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            stat = connection.createStatement();
            rs= stat.executeQuery("select * from user");
            while (rs.next()){
                User user =new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRight(rs.getInt("right"));
                List.add(user);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            DBUtil.getInstance().close(rs,stat,connection);
        }
        return List;
    }
    //先进后出：栈
    @Override
    public User findUserById(String _id){
        User user = new User();
        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            stat = connection.createStatement();
            rs= stat.executeQuery("select * from user where id='"+_id+"'");
            while (rs.next()){
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRight(rs.getInt("right"));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            DBUtil.getInstance().close(rs,stat,connection);
        }
        return user;
    }

    @Override
    public List<User> findUserByName(String _name){
        List<User> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            prep = connection.prepareStatement("select * from user where name like ?");
            prep.setString(1,"%"+_name+"%");
            rs= prep.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRight(rs.getInt("right"));
                list.add(user);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            DBUtil.getInstance().close(rs,prep,connection);
        }
        return list;
    }

    @Override
    public boolean deleteUserById(String _id) {
        boolean flag=false;
        Connection conn = null;
        PreparedStatement prep1= null;
        PreparedStatement prep2= null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            prep1=conn.prepareStatement("select * from job where id=?");
            prep1.setString(1,_id);
            rs1 =prep1.executeQuery();
            HashSet<String> pids= new HashSet<>();
            while(rs1.next()){
                String tempRid = rs1.getString("pid");
                prep2 = conn.prepareStatement("select count(*) as num from job where pid=?");
                prep2.setString(1,tempRid);
                rs2=prep2.executeQuery();
                rs2.next();
                if (Integer.parseInt(rs2.getString("num"))==1){
                    //tempCid是需要删除的课程号，记录下来即可
                    pids.add(tempRid);
                }
            }

            //分数表必须先删除
            prep1 =conn.prepareStatement("delete from job where id=?");
            prep1.setString(1,_id);
            prep1.executeUpdate();
            //学生表和课程表随后删除，二者没有先后关系
            prep1 = conn.prepareStatement("delete from user where id=?");
            prep1.setString(1,_id);
            prep1.executeUpdate();
            for (String pid : pids) {
                prep1 = conn.prepareStatement("delete from race where pid=?");
                prep1.setString(1,pid);
                prep1.executeUpdate();
            }
            flag=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.getInstance().close(prep1,conn);
        }
        return flag;
    }

    @Override
    public int updateUserPassword(String _id, String _password) {

        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            prep = conn.prepareStatement("UPDATE user SET password = ? WHERE id = ?");
            prep.setString(1, _password);
            prep.setString(2, _id);
            flag = prep.executeUpdate();
            if (flag == 1){
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.getInstance().close(prep, conn);
        }
        return flag;
    }

    @Override
    public int insertUser(User _user) {
        int flag=0;
        PreparedStatement prep=null;
        Connection conn =null;
        try {
            conn= DBUtil.getInstance().getConnection();
            prep =conn.prepareStatement("insert into user values (?,?,?,?,?)");
            prep.setString(1, _user.getId());
            prep.setString(2, _user.getName());
            prep.setString(3, _user.getPassword());
            prep.setString(4, _user.getPhone());
            prep.setInt(5, _user.getRight());
            prep.executeUpdate();
            flag=1;
        } catch (SQLException e) {
            try {
                conn.rollback();
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }finally {
            DBUtil.getInstance().close(prep,conn);
        }
        return flag;
    }

    @Override
    public int updateUser(User user) {
        int flag=0;
        PreparedStatement prep=null;
        Connection conn =null;
        try {
            conn= DBUtil.getInstance().getConnection();
            prep =conn.prepareStatement
                    ("update user set name=?,password=?,phone=?,right=? where id=?");
            //System.out.println("[Debug 085]" + user.toString());
            prep.setString(1, user.getName());
            prep.setString(2, user.getPassword());
            prep.setString(3, user.getPhone());
            prep.setInt(4, user.getRight());
            prep.setString(5, user.getId());
            System.out.println("[Debug 090]" + prep);
            prep.executeUpdate();
            System.out.println("[Debug 091]" + prep);
            System.out.println("[Debug 091]");
            flag=1;
        } catch (SQLException e) {
//            try {
//                conn.rollback();
//            }catch (SQLException ex){
//                throw new RuntimeException(ex);
//            }
        }finally {
            DBUtil.getInstance().close(prep,conn);
        }
        return flag;
    }
}



//ctrl+alt+v 补全语句
