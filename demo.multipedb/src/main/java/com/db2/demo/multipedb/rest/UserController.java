package com.db2.demo.multipedb.rest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class UserController {

    @GetMapping("/abc")
    public String test()
    {
        return"abc test";
    }

}
