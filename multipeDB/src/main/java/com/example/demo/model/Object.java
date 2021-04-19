package com.example.demo.model;

import com.example.demo.dto.ObjectDTO;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Object")
public class Object implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "object")
    @SequenceGenerator(name = "object",sequenceName = "OBJECT_SEQ",allocationSize = 1)
    private Long id;
    @Column(name = "OBJECT_CODE")
    private String objectCode;
    @Column(name = "OBJECT_NAME")
    private String objectName;
    @Column(name = "STATUS")
    private Long status;
    @Column(name = "ID_ROLE")
    private Long idRole;

    public ObjectDTO toModel()
    {
        ObjectDTO objectDTO = new ObjectDTO();
        objectDTO.setId(this.id);
        objectDTO.setStatus(this.status);
        objectDTO.setIdRole(this.idRole);
        objectDTO.setObjectCode(this.objectCode);
        objectDTO.setObjectName(this.objectName);
        return objectDTO;
    }

}
