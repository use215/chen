package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.*;
import cn.edu.lingnan.pojo.Property;

import java.util.List;

public class PropertyServiceMysqlImpl implements PropertyService {
    UserDao userDao = new UserDaoImpl();
    PropertyDao propertyDao = new PropertyDaoImpl();

    @Override
    public boolean deletePropertyByPid(String _pid) {
        return propertyDao.deletePropertyByPid(_pid);
    }

    @Override
    public Property findPropertyByPid(String _pid) {
        return propertyDao.findPropertyByPid(_pid);
    }

    @Override
    public int updateProperty(Property _property) {
        int flag = 0;
        if (propertyDao.findPropertyByPid(_property.getPid()).getPid() == null) {
            return 2;
        }
        flag = propertyDao.updateProperty(_property);

        return flag;
    }

    @Override
    public List<Property> findPropertyAll() {
        return  propertyDao.findPropertyAll();
    }


}
