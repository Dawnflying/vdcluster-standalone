package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.authenication.Token;
import com.xh.vdcluster.authenication.TokenManager;
import com.xh.vdcluster.common.DateUtils;
import com.xh.vdcluster.common.Md5Utils;
import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.common.VdResultErrorCode;
import com.xh.vdcluster.repository.mapper.UserMapper;
import com.xh.vdcluster.repository.model.User;
import com.xh.vdcluster.service.TokenService;
import com.xh.vdcluster.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by bloom on 2017/7/24.
 */
@Component
public class UserServiceImpl implements UserService {

    @Resource
    TokenService tokenService;

    @Resource
    UserMapper userMapper;

    @Override
    public VdResult register(String name, String password) {

        try {
            User user = new User();
            user.setUsername(name);
            user.setPassword(password);
            user.setCreatetime(DateUtils.getNow());
            user.setModifiedtime(DateUtils.getNow());
            user.setUserid(Md5Utils.MD5(name));
            userMapper.insert(user);
            return new VdResult("success to register", VdResultErrorCode.REGISTER_SUCCESS, user, "");
        } catch (Exception e) {
            return new VdResult("failed to register", VdResultErrorCode.REGISTER_FAILED, null, "");
        }
    }

    /**
     * 请求识别服务,如果验证通过则自动重新生成token,用户通过token来获取服务。
     *
     * @param name 用户名
     * @param code 加密后密码
     * @return
     */
    @Override
    public boolean authenicate(String name, String code) {
        try {
            User user = userMapper.getUserByUsername(name);

            if (code.equals(Md5Utils.MD5(user.getPassword())))
                return true;

            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public VdResult requestToken(String username, String code) {
        if (this.authenicate(username, code)) {

            User user = userMapper.getUserByUsername(username);

            Token token = TokenManager.getToken();

            tokenService.addToken(user.getUserid(), token);

            return new VdResult("success to request token", VdResultErrorCode.AUTH_SUCCESS, token, user.getUserid());

        } else {

            return new VdResult("fail to request token", VdResultErrorCode.AUTH_FAILED, null, "");
        }
    }
}
