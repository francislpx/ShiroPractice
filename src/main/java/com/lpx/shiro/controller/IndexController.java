package com.lpx.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description
 * @author 李平新
 * @date 2017年3月21日 下午2:17:31
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
