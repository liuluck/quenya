package net.quenya.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@Slf4j
@RequestMapping(value = "login")
public class LoginController extends BaseController{

    @RequestMapping(value = "sign")
    public void login(@RequestAttribute String a){
        System.out.println("hello==============");

    }
}
