package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Property;

import java.util.List;

public interface PropertyService {
    public boolean deletePropertyByPid(String _pid);

    public Property findPropertyByPid(String _pid);
    //新增一条职位记录:0代表失败；1代表成功；2代表没有对应的职位；
    public int updateProperty(Property _property);

    List<Property> findPropertyAll();
}
