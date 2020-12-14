package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String userName;
    private String password;

    public User toModel()
    {
        User user = new User();
        user.setId(this.id);
        user.setUserName(this.userName);
        user.setPassWord(this.password);
        return user;
    }

}
