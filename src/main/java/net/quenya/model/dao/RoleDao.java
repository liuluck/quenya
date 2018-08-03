package net.quenya.model.dao;

import lombok.extern.slf4j.Slf4j;
import net.quenya.model.entity.Role;
import net.quenya.model.entity.User;
import net.quenya.model.mapper.RoleMapper;
import net.quenya.model.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class RoleDao {
    private final RoleMapper roleMapper;

    public RoleDao(RoleMapper roleMapper){

        this.roleMapper = roleMapper;
    }

    public Role getUserByLoginName(int id){
        log.debug("role id:{}",id);
        if(id != 0){
            return  roleMapper.findById(id);
        }
        log.debug("role id is 0");
        return null;
    }

}
