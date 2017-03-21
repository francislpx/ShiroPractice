package com.lpx.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpx.shiro.dao.SysResourceDao;
import com.lpx.shiro.model.SysResource;
import com.lpx.shiro.service.SysResourceService;

/**
 * @ClassName SysResourceServiceImpl
 * @Description
 * @author 李平新
 * @date 2017年3月17日 下午3:01:17
 */
@Service
public class SysResourceServiceImpl implements SysResourceService{

    @Autowired
    private SysResourceDao sysResourceDao;
    
    @Override
    public void addResource(SysResource resource) {
        sysResourceDao.insertSelective(resource);
    }

    @Override
    public void deleteResource(Long resourceId) {
        
    }

    @Override
    public List<SysResource> getResourceList() {
        // TODO Auto-generated method stub
        return null;
    }

}
