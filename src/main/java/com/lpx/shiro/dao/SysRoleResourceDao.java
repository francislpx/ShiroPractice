package com.lpx.shiro.dao;

import org.springframework.stereotype.Repository;

import com.lpx.shiro.model.SysRoleResource;

@Repository
public interface SysRoleResourceDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    SysRoleResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleResource record);

    int updateByPrimaryKey(SysRoleResource record);
}