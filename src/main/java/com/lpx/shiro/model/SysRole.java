package com.lpx.shiro.model;

import java.util.List;

public class SysRole {
    private Long id;

    private String role;

    private String description;

    private Boolean available;

    private List<SysResource> resourceList;
    
    public List<SysResource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<SysResource> resourceList) {
        this.resourceList = resourceList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}