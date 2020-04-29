package com.ebook.service.user;


import com.alibaba.dubbo.config.annotation.Service;
import com.ebook.api.user.IUserService;
import com.ebook.api.user.dto.UserDTO;
import com.ibook.component.mongo.repositories.UserRepository;
import com.ibook.component.mongo.repositories.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Description:
 * @author: yaunde
 * @Date: 2019-08-24 14:55
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO login(String loginReq) {
        return new UserDTO("XIAOYU", (short) 10, "jiangxi");
    }

    @Override
    public String register(String loginReq) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAddress("jiangxi");
        userEntity.setAge(10);
        userEntity.setUsername("mifuzi");
        UserEntity insert = userRepository.insert(userEntity);
        return userEntity.getId();
    }


}
