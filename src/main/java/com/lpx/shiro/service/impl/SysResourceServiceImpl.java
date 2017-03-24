package com.lpx.shiro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        sysResourceDao.deleteByPrimaryKey(resourceId);
    }

    @Override
    public List<SysResource> getAllResource() {
        return sysResourceDao.getAllResource();
    }

    @Override
    public List<SysResource> getResourceListByUserId(Long userId) {
        return sysResourceDao.getResourceByUserId(userId);
    }

    @Override
    public List<SysResource> getMenuByPermission(Set<String> permissions) {
        List<SysResource> allResources = getAllResource();
        List<SysResource> menus = new ArrayList<SysResource>();
        for(SysResource resource : allResources) {
            if(resource.isRootNode()) {
                continue;
            }
            
            if(resource.getType() != SysResource.ResourceType.menu) {
                continue;
            }
            
            if(!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, SysResource resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }

}
