package cn.edu.lingnan.util;

import java.sql.*;

//功能：返回一个数据库连接；关闭数据库连接
public class DBUtil {
    private static DBUtil dbUtil;
    public DBUtil(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }


    public static DBUtil getInstance(){
        if(dbUtil==null){
            dbUtil=new DBUtil();
        }
        return new DBUtil();
    }

    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/house","chen","123456");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return conn;
    }

    public  void close(ResultSet rs,Statement stat,Connection conn){
        try {
            if (rs!= null)
                rs.close();
            if(stat!=null)
                stat.close();
            if(conn!=null)
                conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //查询
    public  void close(ResultSet rs,PreparedStatement prep,Connection conn){
        try {
            if (rs!= null)
                rs.close();
            if(prep!=null)
                prep.close();
            if(conn!=null)
                conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //新增或删除没有结果集
    public  void close(Statement stat,Connection conn){
        try {
            if(stat!=null)
                stat.close();
            if(conn!=null)
                conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
