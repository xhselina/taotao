package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:JeffreyJi@yeah.net">Jeffrey</a>
 * @version 1.0
 * @date ${date} ${time}
 */
@Controller
@RequestMapping
public class PageController {
    @RequestMapping("/")
    public String showIndex(){
        return  "index";
    }
    @RequestMapping("/{page}")
    public String showPage(@PathVariable  String page){
        return  page;
    }
}
