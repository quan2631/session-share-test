package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: QUAN
 * @date: Created in 2019/12/9 15:31
 * @description:
 * @modified By:
 */
@RestController
public class SessionController {

    @RequestMapping(value = "/setSession")
    public Object setSession(@RequestParam(required=false) String value, HttpSession session) {
        session.setAttribute("value", value);
        int maxInactiveInterval = session.getMaxInactiveInterval();
        System.out.println("setSession maxInactiveInterval: " + maxInactiveInterval);
        return session.getId();
    }

    @RequestMapping(value = "/getSession")
    public Object getSession(HttpSession session) {
        Object value = session.getAttribute("value");
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", session.getId());
        map.put("value", value);
        int maxInactiveInterval = session.getMaxInactiveInterval();
        System.out.println("getSession maxInactiveInterval: " + maxInactiveInterval);
        return map;
    }

}
