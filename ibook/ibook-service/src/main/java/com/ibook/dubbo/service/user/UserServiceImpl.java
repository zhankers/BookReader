package com.ibook.dubbo.service.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.ibook.api.user.IUserService;
import com.ibook.api.user.dto.UserDTO;

/**
 * @Description:
 * @author: yaunde
 * @Date: 2019-08-24 14:55
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements IUserService {

    @Override
    public UserDTO login(String loginReq) {
        return new UserDTO("XIAOYU", (short) 10, "jiangxi");
    }
}
