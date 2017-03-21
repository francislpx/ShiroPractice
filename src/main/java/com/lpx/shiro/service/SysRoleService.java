package com.lpx.shiro.service;

import java.util.List;

import com.lpx.shiro.model.SysRole;

/**
 * @ClassName SysRoleService
 * @Description
 * @author 李平新
 * @date 2017年3月17日 下午2:57:55
 */
public interface SysRoleService {

    public void addRole(SysRole role);
    public void deleteRole(Long roleId);
    public void updateRole(SysRole role);
    public void setPermissionToRole(Long roleId, Long[] resourceIds);
    public List<SysRole> getRoleList(String roleName);
    public List<SysRole> getRoleByUserName(String username);
}
