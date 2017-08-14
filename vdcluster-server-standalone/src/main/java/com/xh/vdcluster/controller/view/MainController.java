package com.xh.vdcluster.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bloom on 2017/8/12.
 */

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("main-page")
    public String getMainPage(){
        return "main";
    }


    @RequestMapping("/get-stream-list")
    public String getStreamListByUserId(@RequestParam(name="userId")String userId){



        return "stream";
    }

    @RequestMapping("/get-node-list")
    public String getNodeList(@RequestParam(name="userId")String userId){

        return "node";
    }

}
