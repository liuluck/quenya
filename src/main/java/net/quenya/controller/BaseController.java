package net.quenya.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

import java.io.IOException;


@Controller
@Slf4j
public class BaseController {
    public void writeJson(Object obj , HttpServletResponse response){
        String json = JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }
}
