package com.example.demo.repos.common;


import com.example.demo.dto.UserDTO;

@FunctionalInterface
public interface TestFunctional {
//     void doSomeThing();
     // co cac phuong thuc cua Object
//     int hashCode();
//     String toString();
//     boolean equals(Object object);
//     default void someThing1(){};
//     static void someThing12(){};
     UserDTO sayHello(String userName);
}
