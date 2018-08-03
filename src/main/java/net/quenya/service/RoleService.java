package net.quenya.service;

import net.quenya.model.entity.User;

public interface RoleService {
    User getUserByLoginName(String loginName);
}
