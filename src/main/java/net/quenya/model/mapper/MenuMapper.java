package net.quenya.model.mapper;

import net.quenya.model.entity.Menu;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface MenuMapper {
    @Select("SELECT * from menu")
    Menu findAllMenu();

    Menu findById(int id);

}
