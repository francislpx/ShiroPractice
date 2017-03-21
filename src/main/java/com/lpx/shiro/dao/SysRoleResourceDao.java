package com.lpx.shiro.dao;

import com.lpx.shiro.model.SysRoleResource;

public interface SysRoleResourceDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    SysRoleResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleResource record);

    int updateByPrimaryKey(SysRoleResource record);
}