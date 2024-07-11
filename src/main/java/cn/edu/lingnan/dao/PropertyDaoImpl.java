package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Property;
import cn.edu.lingnan.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDaoImpl implements PropertyDao {
    public boolean deletePropertyByPid(String _pid){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep= null;
        try {
            conn = DBUtil.getInstance().getConnection();
            prep = conn.prepareStatement("delete from race where pid=?");
            prep.setString(1,_pid);
            prep.executeUpdate();
            flag=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.getInstance().close(prep,conn);
        }
        return flag;
    }
    @Override
    public Property findPropertyByPid(String _pid) {
        Property property = new Property();
        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            stat = connection.createStatement();
            rs= stat.executeQuery("select * from property where pid='"+_pid+"'");
            if (rs.next()){
                property.setPid(rs.getString("pid"));
                property.setAddress(rs.getString("rname"));
                property.setPrice(rs.getInt("rflag"));
                property.setArea(rs.getInt("rflag"));
                property.setType(rs.getString("rname"));

            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            DBUtil.getInstance().close(rs,stat,connection);
        }
        return property;
    }
    @Override
    public int updateProperty(Property _property) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            prep = conn.prepareStatement("UPDATE race SET rname = ?, rflag = ? WHERE pid = ?");
            prep.setString(3, _property.getPid());
            prep.setString(1, _property.getAddress());
            prep.setInt(2, _property.getPrice());
            flag = prep.executeUpdate();
            if (flag == 1){
                System.out.println("修改成功");
            }
            else System.out.println("修改失败");

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.getInstance().close(prep,conn);
        }
        return flag;
    }

    @Override
    public List<Property> findPropertyAll() {
        List<Property> list = new ArrayList<>();
        Statement stat=null;
        Connection conn =null;
        ResultSet rs =null;
        try {
            conn= DBUtil.getInstance().getConnection();
            stat =conn.createStatement();
            rs=stat.executeQuery("select *from property ");
            while(rs.next()) {
                Property property = new Property();
                property.setPid(rs.getString("pid"));
                property.setAddress(rs.getString("address"));
                property.setPrice(rs.getInt("price"));
                property.setArea(rs.getInt("area"));
                property.setType(rs.getString("type"));
                list.add(property);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.getInstance().close(rs,stat,conn);
        }

        return list;
    }

}
