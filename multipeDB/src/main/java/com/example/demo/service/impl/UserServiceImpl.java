package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repos.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    public User getUserByUserName(String userName){
        return userRepository.getUsersByUserName(userName);
    }
    public List<User> getListUsers(String password){
        return  userRepository.getUsersByPassWord(password);
    }
}
