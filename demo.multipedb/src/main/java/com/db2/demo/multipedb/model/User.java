package com.db2.demo.multipedb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    private Long id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASS_WORD")
    private String password;
}
