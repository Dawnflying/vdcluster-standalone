package com.xh.vdcluster.controller.view;

import com.xh.vdcluster.common.Constant;
import com.xh.vdcluster.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.ldap.BasicControl;

/**
 * Created by bloom on 2017/8/12.
 */

@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

    @RequestMapping("main-page")
    public String getMainPage(){
        return "main";
    }


    @RequestMapping("/get-stream-list")
    public String getStreamList(){



        return "stream";
    }

    @RequestMapping("/get-node-list")
    public String getNodeList(){

        return "node";
    }

    @RequestMapping("/add-stream")
    public String addStream(@RequestParam(name="rtspUrl")String rtspUrl){

        return "add";
    }
}
