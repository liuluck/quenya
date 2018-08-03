package net.quenya.model.dao;

import lombok.extern.slf4j.Slf4j;
import net.quenya.model.entity.User;
import net.quenya.model.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserDao {
    private final UserMapper userMapper;

    public UserDao(UserMapper userMapper){

        this.userMapper = userMapper;
    }

    public User getUserByLoginName(String loginName){
        log.debug("loginName:{}",loginName);
        if(!loginName.isEmpty()){
            return  userMapper.findByLoginName(loginName);
        }
        log.debug("loginName is empty");
        return null;
    }

}
