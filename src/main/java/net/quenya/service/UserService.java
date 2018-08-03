package net.quenya.service;

import net.quenya.model.entity.User;

public interface UserService {
    User getUserByLoginName(String loginName);
}
