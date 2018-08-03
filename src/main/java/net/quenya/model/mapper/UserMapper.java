package net.quenya.model.mapper;

import net.quenya.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface UserMapper {
    @Select("SELECT * from user")
    User findAllUser();

    User findByLoginName(String loginName);

}
