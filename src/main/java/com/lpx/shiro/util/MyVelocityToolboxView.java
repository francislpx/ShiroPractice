package com.lpx.shiro.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

/**
 * @ClassName MyVelocityToolboxView
 * @Description
 * @author 李平新
 * @date 2017年3月24日 上午11:57:50
 */
public class MyVelocityToolboxView extends VelocityLayoutView {
    @Override  
    protected Context createVelocityContext(Map model, HttpServletRequest request, HttpServletResponse response) {  
        ViewToolContext ctx;  
  
        ctx = new ViewToolContext(getVelocityEngine(), request, response, getServletContext());  
  
        ctx.putAll(model);  
  
        if (this.getToolboxConfigLocation() != null) {  
            ToolManager tm = new ToolManager();  
            tm.setVelocityEngine(getVelocityEngine());  
            tm.configure(getServletContext().getRealPath(getToolboxConfigLocation()));  
            if (tm.getToolboxFactory().hasTools(Scope.REQUEST)) {  
                ctx.addToolbox(tm.getToolboxFactory().createToolbox(Scope.REQUEST));  
            }  
            if (tm.getToolboxFactory().hasTools(Scope.APPLICATION)) {  
                ctx.addToolbox(tm.getToolboxFactory().createToolbox(Scope.APPLICATION));  
            }  
            if (tm.getToolboxFactory().hasTools(Scope.SESSION)) {  
                ctx.addToolbox(tm.getToolboxFactory().createToolbox(Scope.SESSION));  
            }  
        }  
        return ctx;  
    }  
}
