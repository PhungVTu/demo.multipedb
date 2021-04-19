package com.example.demo.dto;

import com.example.demo.model.Object;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDTO {
    private Long id;
    private String objectCode;
    private String objectName;
    private Long status;
    private Long idRole;
    public Object toModel()
    {
        Object object = new Object();
        object.setId(this.id);
        object.setObjectCode(this.objectCode);
        object.setObjectName(this.objectName);
        object.setStatus(this.status);
        object.setIdRole(this.idRole);
        return object;
    }
}
