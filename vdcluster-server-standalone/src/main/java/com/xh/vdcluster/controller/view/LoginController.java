package com.xh.vdcluster.controller.view;

import com.xh.vdcluster.common.Constant;
import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.common.VdResultErrorCode;
import com.xh.vdcluster.controller.BaseController;
import com.xh.vdcluster.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by bloom on 2017/8/12.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Resource
    UserService userService;

    @RequestMapping("/do-login")
    public String login(@RequestParam("username") String username, @RequestParam("code")String code) {

        VdResult result = userService.requestToken(username,code);

        if(VdResultErrorCode.ISFAILED(result.getCode()))
            return "error";

        this.getSession().setAttribute(Constant.AUTH_USER_ID, result.getRequestId());
        this.getSession().setAttribute(Constant.AUTH_USER, username);

        return "main";
    }

}
