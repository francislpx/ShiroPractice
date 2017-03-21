package com.lpx.shiro.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

public class SysUser {
    private Long id;

    private Long organizationId;

    private String username;

    private String password;

    private String salt;

    private Boolean locked;

    private List<SysRole> roleList;

    private List<SysResource> resourceList;
    
    public List<SysResource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<SysResource> resourceList) {
        this.resourceList = resourceList;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }
    
    public Long[] getRoleId() {
        if(CollectionUtils.isEmpty(roleList)) {
            return new Long[0];
        }
        Long[] roleIds = new Long[roleList.size()];
        for(int i=0; i<roleList.size(); i++) {
            roleIds[i] = roleList.get(i).getId();
        }
        return roleIds;
    }
    
    public Set<String> getRoleSet() {
        if(CollectionUtils.isEmpty(roleList)) {
            return Collections.emptySet();
        }
        Set<String> roles = new HashSet<String>();
        for(int i=0; i<roleList.size(); i++) {
            roles.add(roleList.get(i).getRole());
        }
        return roles;
    }

    public Set<String> getPermissionSet() {
        if(CollectionUtils.isEmpty(resourceList)) {
            return Collections.emptySet();
        }
        Set<String> permissions = new HashSet<String>();
        for(int i=0; i<resourceList.size(); i++) {
            permissions.add(resourceList.get(i).getPermission());
        }
        return permissions;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}