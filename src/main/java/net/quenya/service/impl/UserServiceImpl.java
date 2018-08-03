package net.quenya.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.quenya.model.dao.UserDao;
import net.quenya.model.entity.User;
import net.quenya.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserDao userDao;
    @Override
    public User getUserByLoginName(String loginName) {
        log.debug("loginName{}",loginName);
        if(loginName.isEmpty()){
            log.debug("loginName is empty{}");
            return null;
        }
        return userDao.getUserByLoginName(loginName);
    }
}
