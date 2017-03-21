package com.lpx.shiro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lpx.shiro.model.SysUser;

@Repository
public interface SysUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> getUserList(String username);

    SysUser selectByUserName(String username);
}