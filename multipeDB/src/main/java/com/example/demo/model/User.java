package com.example.demo.model;

import com.example.demo.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user")
    @SequenceGenerator(name = "user",sequenceName = "USER_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASS_WORD")
    private String passWord;


    public UserDTO toModel()
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(this.id);
        userDTO.setUserName(this.userName);
        userDTO.setPassword(this.passWord);
        return userDTO;
    }

}
