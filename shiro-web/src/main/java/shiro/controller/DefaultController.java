package shiro.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import shiro.service.UserService;

/**
 * Created by sunjx on 2018/3/1.
 */
@Controller
public class DefaultController {

    @Autowired
    private UserService userService;

    @RequestMapping("user/list")
    @RequiresRoles("admin")
    public ModelAndView userListPage(ModelAndView mv){
        mv.setViewName("user/list");
        mv.getModel().put("list", userService.listAll());
        return mv;
    }
}
