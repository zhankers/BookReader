package com.ibook.api.user;

import com.ibook.api.user.dto.UserDTO;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-08-24 15:04
 */
public interface IUserService {

    UserDTO login(String loginReq);

    String register(String loginReq);
}
