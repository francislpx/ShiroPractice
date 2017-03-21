package com.lpx.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpx.shiro.dao.SysRoleDao;
import com.lpx.shiro.model.SysRole;
import com.lpx.shiro.service.SysRoleService;

/**
 * @ClassName SysRoleServiceImpl
 * @Description
 * @author 李平新
 * @date 2017年3月20日 上午9:48:07
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;
    
    @Override
    public void addRole(SysRole role) {
        //TODO 插入权限表
        sysRoleDao.insertSelective(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPermissionToRole(Long roleId, Long[] resourceIds) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SysRole> getRoleList(String roleName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateRole(SysRole role) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<SysRole> getRoleByUserName(String username) {
        return sysRoleDao.getRoleByUserName(username);
    }

}
