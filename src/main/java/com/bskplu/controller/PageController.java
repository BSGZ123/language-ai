package com.bskplu.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 使用页面跳转
 * Created by 尘心 on 2020/9/25 0025.
 */
@Api(tags = "页面跳转")
@Controller
public class PageController {

    @RequestMapping(value = {"/","/index"},method = {RequestMethod.GET})
    public String toIndex() {
        return "index";
    }
}
