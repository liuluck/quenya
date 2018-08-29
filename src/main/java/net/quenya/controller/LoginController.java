package net.quenya.controller;

import lombok.extern.slf4j.Slf4j;
import net.quenya.model.entity.User;
import net.quenya.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping(value = "login")
public class LoginController extends BaseController{

    @Resource
    UserService userService;

    @RequestMapping(value = "sign")
    public String login(String username){
        log.info("hello=============={}",username);
        System.out.println("hello=============={}"+username);
        final User admin = userService.getUserByLoginName("admin");
        log.info("admin.mobile: {}",admin.mobile);
        return "";
    }
}
