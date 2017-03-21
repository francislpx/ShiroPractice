package com.lpx.shiro.dao;

import org.springframework.stereotype.Repository;

import com.lpx.shiro.model.SysOrganization;

@Repository
public interface SysOrganizationDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    SysOrganization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);
}