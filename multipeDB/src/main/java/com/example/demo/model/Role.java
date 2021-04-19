package com.example.demo.model;

import com.example.demo.dto.RoleDTO;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role")
    @SequenceGenerator(name = "role",sequenceName = "Role_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @Column(name = "STATUS")
    private Long status;
    @Column(name = "USER_ID")
    private Long userID;

    public RoleDTO toModel()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(this.id);
        roleDTO.setRoleCode(this.roleCode);
        roleDTO.setRoleName(this.roleName);
        roleDTO.setStatus(this.status);
        roleDTO.setUserId(this.userID);
        return roleDTO;
    }

}
