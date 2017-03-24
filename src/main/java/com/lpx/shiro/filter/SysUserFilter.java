package com.lpx.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.lpx.shiro.Constants;
import com.lpx.shiro.service.SysUserService;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private SysUserService sysUserService;

    /* 
     * 在进入controller前，取到登录用户的信息，放在request中
     */
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        
        String username = (String) SecurityUtils.getSubject().getPrincipal();
//        request.setAttribute(Constants.CURRENT_USER, sysUserService.getUserWithRoleByUserName(username));
        request.setAttribute(Constants.CURRENT_USER, sysUserService.getUserByUserName(username));
        return true;
    }
}
