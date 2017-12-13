package com.lanou3g.ssm.controller;

import com.lanou3g.ssm.exception.DefaultException;
import org.springframework.stereotype.Controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(String username) {

        if (StringUtils.isEmpty(username)) {
            throw new DefaultException("空指针异常");
        }

        return "home";
    }

}
