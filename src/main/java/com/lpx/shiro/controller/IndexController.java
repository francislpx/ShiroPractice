package com.lpx.shiro.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lpx.shiro.Constants;
import com.lpx.shiro.model.SysResource;
import com.lpx.shiro.model.SysUser;
import com.lpx.shiro.service.SysResourceService;

/**
 * @ClassName IndexController
 * @Description
 * @author 李平新
 * @date 2017年3月21日 下午2:17:31
 */
@Controller
public class IndexController {

    @Autowired
    private SysResourceService sysResourceService;
    
    @RequestMapping("/")
    public String index(HttpServletRequest req, Model model) {
        SysUser user = (SysUser) req.getAttribute(Constants.CURRENT_USER);
        user.setResourceList(sysResourceService.getResourceListByUserId(user.getId()));
        Set<String> permissions = user.getPermissionSet();
        List<SysResource> menus = sysResourceService.getMenuByPermission(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }
    
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
