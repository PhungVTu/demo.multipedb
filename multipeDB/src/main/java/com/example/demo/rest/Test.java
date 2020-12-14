package com.example.demo.rest;


import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Test {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/test")
    public String get()
    {
        String userName ="tupv";
        String password ="8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
        User user = userServiceImpl.getListUser(userName);
        List<User> getList = userServiceImpl.getListUsers(password);
        for (User item: getList) {
            System.out.println(item.getUserName()+ " "+ item.getPassWord());
        }
        System.out.println(user.getUserName());
        return "abc afsafsdfs" +" " + user.toString();
    }
}
