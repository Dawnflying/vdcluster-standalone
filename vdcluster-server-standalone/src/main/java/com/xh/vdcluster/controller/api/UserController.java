package com.xh.vdcluster.controller.api;

import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by bloom on 2017/7/16.
 */

@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/request-token",
            method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public VdResult request(@RequestParam String username, @RequestParam String code) {
        return userService.requestToken(username, code);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public VdResult register(@RequestParam String username, @RequestParam String password) {
        return userService.register(username, password);
    }
}
