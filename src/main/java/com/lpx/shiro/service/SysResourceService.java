package com.lpx.shiro.service;

import java.util.List;

import com.lpx.shiro.model.SysResource;

/**
 * @ClassName SysResourceService
 * @Description
 * @author 李平新
 * @date 2017年3月17日 下午2:58:13
 */
public interface SysResourceService {

    public void addResource(SysResource resource);
    public void deleteResource(Long resourceId);
    public List<SysResource> getResourceList();
}
