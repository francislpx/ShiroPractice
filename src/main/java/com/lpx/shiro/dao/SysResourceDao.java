package com.lpx.shiro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lpx.shiro.model.SysResource;

@Repository
public interface SysResourceDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);
    
    List<SysResource> getResourceByRoleId(Long roleId);

    List<SysResource> getResourceByUserId(Long id);
}