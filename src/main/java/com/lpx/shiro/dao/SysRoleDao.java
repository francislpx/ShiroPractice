package com.lpx.shiro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lpx.shiro.model.SysRole;

@Repository
public interface SysRoleDao {
    
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    List<SysRole> getRoleByUserId(Long userId);
    
    List<SysRole> getRoleByUserName(String username);
}