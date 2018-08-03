package net.quenya.model.mapper;

import net.quenya.model.entity.Role;
import net.quenya.model.entity.User;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface RoleMapper {
    @Select("SELECT * from role")
    Role findAllRole();

    Role findById(int id);

}
