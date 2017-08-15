package com.xh.vdcluster.controller.view;

import com.xh.vdcluster.common.Constant;
import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.controller.BaseController;
import com.xh.vdcluster.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by bloom on 2017/8/12.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Resource
    UserService userService;

    @RequestMapping("/do-login")
    public String login(HttpRequest request, String username, String code) {

        if(!userService.authenicate(username, code))
            return "error";



        this.getSession().setAttribute(Constant.AUTH_USER, username);

        return "main/main-page";
    }

}
