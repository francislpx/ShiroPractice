package com.lpx.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lpx.shiro.service.SysUserService;

/**
 * @ClassName SysUserController
 * @Description
 * @author 李平新
 * @date 2017年3月17日 上午9:46:17
 */
@Controller
@RequestMapping("/user")
public class SysUserController {
    
    @Autowired
    private SysUserService sysUserService;
    
    @RequiresPermissions("user:view")
    @RequestMapping(method = RequestMethod.GET)
    public String getUserList(ModelMap map) {
        map.put("userList", sysUserService.getUserListByName(null));
        return "user/list";
    }

}
