package com.sj.boot.system.user.controller;

import com.sj.boot.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/master")
    public String master(){
        userService.master();
        return "master";
    }


    @RequestMapping("/slave")
    public String slave(){
        userService.slave();
        return "slave";
    }
}
