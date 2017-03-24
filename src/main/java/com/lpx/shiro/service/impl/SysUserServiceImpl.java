package com.lpx.shiro.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpx.shiro.dao.SysResourceDao;
import com.lpx.shiro.dao.SysRoleDao;
import com.lpx.shiro.dao.SysUserDao;
import com.lpx.shiro.dao.SysUserRoleDao;
import com.lpx.shiro.model.SysResource;
import com.lpx.shiro.model.SysRole;
import com.lpx.shiro.model.SysUser;
import com.lpx.shiro.model.SysUserRole;
import com.lpx.shiro.service.PasswordHelper;
import com.lpx.shiro.service.SysUserService;

/**
 * @ClassName SysUserServiceImpl
 * @Description
 * @author 李平新
 * @date 2017年3月20日 上午9:48:22
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysResourceDao sysResourceDao;
    @Autowired
    private PasswordHelper passwordHelper;
    
    @Override
    public void addUser(SysUser user) {
        //插入用户表
        passwordHelper.encryptPassword(user);
        sysUserDao.insertSelective(user);
        
        //插入 用户-角色 关系表
        List<SysRole> roleList = user.getRoleList();
        if(CollectionUtils.isNotEmpty(roleList)) {
            SysUserRole record = new SysUserRole();
            for(int i=0; i<roleList.size(); i++) {
                record.setUserId(user.getId());
                record.setRoleId(roleList.get(i).getId());
                sysUserRoleDao.insert(record);
            }
        }
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        SysUser user = sysUserDao.selectByPrimaryKey(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        sysUserDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<SysUser> getUserListByName(String username) {
        return sysUserDao.getUserListByName(username);
    }

    @Override
    public void updateUser(SysUser user) {
        //更新用户表
        sysUserDao.updateByPrimaryKeySelective(user);
        //删除原有关联关系
        sysUserRoleDao.deleteByUserId(user.getId());
        //插入 用户-角色 关系表
        List<SysRole> roleList = user.getRoleList();
        if(CollectionUtils.isNotEmpty(roleList)) {
            SysUserRole record = new SysUserRole();
            for(int i=0; i<roleList.size(); i++) {
                record.setUserId(user.getId());
                record.setRoleId(roleList.get(i).getId());
                sysUserRoleDao.insert(record);
            }
        }
    }

    @Override
    public Set<String> getRoleListByUserName(String username) {
        List<SysRole> roleList = sysRoleDao.getRoleByUserName(username);
        Set<String> roles = new HashSet<String>();
        for(int i=0; i<roleList.size(); i++) {
            roles.add(roleList.get(i).getRole());
        }
        return roles;
    }

    @Override
    public SysUser getUserWithRoleByUserName(String username) {
        SysUser user = sysUserDao.selectByUserName(username);
        if(user != null) {
            List<SysRole> roleList = sysRoleDao.getRoleByUserName(username);
            user.setRoleList(roleList);
            if(CollectionUtils.isNotEmpty(roleList)) {
                List<SysResource> resourceList = sysResourceDao.getResourceByUserId(user.getId());
                user.setResourceList(resourceList);
            }
        }
        return user;
    }

    @Override
    public SysUser getUserByUserName(String username) {
        return sysUserDao.selectByUserName(username);
    }

}
