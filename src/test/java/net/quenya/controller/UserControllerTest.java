package net.quenya.controller;

import lombok.extern.slf4j.Slf4j;
import net.quenya.BaseTest;
import net.quenya.model.dao.UserDao;
import net.quenya.model.entity.User;
import net.quenya.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 */
@Slf4j
//@Ignore
public class UserControllerTest extends BaseTest {


    @Autowired
    private UserService userService;

    private User user;

//    @Ignore
    @Before
    public void before() {
        log.info("before");
    }

    @Ignore
    @Test
    public void testfind() {
        User admin = userService.getUserByLoginName("admin");
        System.out.println(admin.id);
        log.debug("admin id:{}",admin.id);
        log.info("admin id:{}",admin.id);
    }
    @Ignore
    @After
    public void after() {
        log.info("after");

    }

}
