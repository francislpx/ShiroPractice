package com.lpx.shiro.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpx.shiro.model.SysUser;
import com.lpx.shiro.service.SysUserService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

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

    @RequiresPermissions("user:view")
    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户名获取用户对象", httpMethod = "GET", response = String.class, notes = "根据用户名获取用户对象")
    public String getUserByName(@ApiParam(required = true, name = "name", value = "用户名") @PathVariable String name) {
        List<SysUser> userList = sysUserService.getUserListByName(name);
        
        /** 
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。 
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。 
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。 
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。 
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。 
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。 
         */  
        ObjectMapper mapper = new ObjectMapper();  
        String list = "";
        try {
            list = mapper.writeValueAsString(userList);
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        return list;
    }

}
