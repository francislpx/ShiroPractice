package com.lpx.shiro.dao;

import org.springframework.stereotype.Repository;

import com.lpx.shiro.model.SysUserRole;

@Repository
public interface SysUserRoleDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
    
    int deleteByUserId(Long userId);
    
}