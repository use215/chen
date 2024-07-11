package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Property;

import java.util.List;

public interface PropertyDao {
    public boolean deletePropertyByPid(String _pid);

    public Property findPropertyByPid(String _pid);

    public int updateProperty(Property _property);

    public List<Property> findPropertyAll();

}
