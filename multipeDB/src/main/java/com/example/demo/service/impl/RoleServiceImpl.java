package com.example.demo.service.impl;

import com.example.demo.dto.RoleDTO;
import com.example.demo.model.Role;
import com.example.demo.repos.RoleRepo;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepository;

    public List<RoleDTO> getListRole(Long userId){

        List<RoleDTO> result = new ArrayList<>();
        List<Role> list = roleRepository.getRoleByUserID(userId);
        for(Role item:list)
        {
            result.add(item.toModel());
        }
        return result;
    }
}
