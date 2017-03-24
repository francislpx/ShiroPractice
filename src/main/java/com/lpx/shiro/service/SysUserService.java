package com.lpx.shiro.service;

import java.util.List;
import java.util.Set;

import com.lpx.shiro.model.SysUser;

/**
 * @ClassName SysUserService
 * @Description
 * @author 李平新
 * @date 2017年3月17日 下午2:57:39
 */
public interface SysUserService {

    public void addUser(SysUser user);
    public void changePassword(Long userId, String newPassword);
    public void updateUser(SysUser user);
    public List<SysUser> getUserListByName(String username);
    public Set<String> getRoleListByUserName(String username);
    
    //根据用户名查询用户，同时查询角色和权限
    public SysUser getUserWithRoleByUserName(String username);
    //根据用户名查询用户，不查角色和权限
    public SysUser getUserByUserName(String username);
}
