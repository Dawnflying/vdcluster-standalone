package com.xh.vdcluster.controller.view;

import com.xh.vdcluster.common.*;
import com.xh.vdcluster.controller.BaseController;
import com.xh.vdcluster.repository.model.Servant;
import com.xh.vdcluster.repository.model.Stream;
import com.xh.vdcluster.service.StreamService;
import com.xh.vdcluster.service.TokenService;
import com.xh.vdcluster.service.VdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bloom on 2017/8/12.
 */

@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

    @Resource
    TokenService tokenService;

    @Resource
    VdService vdService;

    @Resource
    StreamService streamService;

    @RequestMapping("main-page")
    public String getMainPage() {
        return "main";
    }


    @RequestMapping("/get-stream-list")
    public String getStreamList(ModelMap modelMap) {

        String userId = (String)this.getSession().getAttribute(Constant.AUTH_USER_ID);
        List<Stream> streams = streamService.listStreamsByUserId(userId);
        modelMap.put("streamList",streams);

        List<Servant> servants = vdService.listAllServant(0,20,20);
        return "stream/stream";
    }

    @RequestMapping("/get-node-list")
    public String getNodeList() {

        return "node/node";
    }

    @RequestMapping("/get-add-stream-page")
    public String getAddStreamPage()
    {
        return "stream/add";
    }

    @RequestMapping("/add-stream")
    @ResponseBody
    public String addStream(@RequestParam(name = "rtspUrl") String rtspUrl, @RequestParam(name = "frameHeight") String frameHeight, @RequestParam(name = "frameWidth") String frameWidth,@RequestParam("typeList") String[] typeList) {

        String userId = (String)this.getSession().getAttribute(Constant.AUTH_USER_ID);

        List<DetectServiceConfiguration> configurationList = new ArrayList<>();

        List<DetectType> detectTypes = new ArrayList<>();
        detectTypes.add(new DetectType("smoke", 0.9));
        DetectServiceConfiguration configuration = new DetectServiceConfiguration();
        configuration.setDetectType(detectTypes);
        configuration.setStreamType(0);
        configuration.setDecodeMode(0);
        configuration.setServiceId(Md5Utils.MD5(rtspUrl));
        configuration.setFrameHeight(Integer.valueOf(frameHeight));
        configuration.setFrameWidth(Integer.valueOf(frameWidth));
        configuration.setStreamURL(rtspUrl);
        configurationList.add(configuration);

        VdResult result =  vdService.addServant(userId, configurationList);

        if(VdResultErrorCode.ISFAILED(result.getCode()))
            return "failed";
        else
            return "success";
    }
}
