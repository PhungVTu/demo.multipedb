package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    public enum the_week {MONDAY("Thu hai"),
                            TUESDAY("Thu ba"),
                            WEDNESDAY("Thu tư"),
                            THURSDAY("Thu nam"),
                            FRIDAY("Thu sau"),
                            SATURDAY("Thu bay"),
                            SUNDAY("Chu nhat");
        the_week(String name){
            this.name = name;
        }
    private String name;
        public String getName(){
            return this.name;
        }
    };
    private transient String name;
    private String userName;
    private String password;
    private List<ObjectDTO> listObject;
    private List<RoleDTO> listRole;


    public void show(int ...a){
        UserDTO userDTO = new UserDTO();

    }

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User toModel()
    {
        User user = new User();
        user.setId(this.id);
        user.setUserName(this.userName);
        user.setPassWord(this.password);
        return user;
    }
}
