package com.example.demo.dto;

import com.example.demo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Long id;
    private String roleCode;
    private String roleName;
    private Long status;
    private Long userId;

    public Role toModel(){
        Role role = new Role();
        role.setId(this.id);
        role.setRoleCode(this.roleCode);
        role.setRoleName(this.roleName);
        role.setStatus(this.status);
        role.setUserID(this.userId);
        return role;
    }
}
