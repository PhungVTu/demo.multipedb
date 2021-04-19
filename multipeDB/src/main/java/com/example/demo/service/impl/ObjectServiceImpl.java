package com.example.demo.service.impl;

import com.example.demo.dto.ObjectDTO;
import com.example.demo.model.Object;
import com.example.demo.repos.ObjectRepo;
import com.example.demo.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {
    @Autowired
    private ObjectRepo objectRepository;

    public List<ObjectDTO> getListObject(Long idRole){

        List<ObjectDTO> result = new ArrayList<>();
        List<Object> list = objectRepository.getObjectsByIdRole(idRole);
        for(Object item:list)
        {
            result.add(item.toModel());
        }
        return result;
    }
}
