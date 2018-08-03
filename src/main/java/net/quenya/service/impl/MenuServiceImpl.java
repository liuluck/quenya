package net.quenya.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.quenya.model.dao.UserDao;
import net.quenya.model.entity.Menu;
import net.quenya.model.entity.User;
import net.quenya.service.MenuService;
import net.quenya.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    UserDao userDao;
    @Override
    public List<Menu> getMenuByIds(String ids) {

        return null;
    }
}
