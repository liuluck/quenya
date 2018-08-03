package net.quenya.service;

import net.quenya.model.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuByIds(String ids);
}
