package com.example.demo.repos;

import com.example.demo.model.Object;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ObjectRepo extends CrudRepository<Object,Integer> {

    public List<Object> getObjectsByIdRole(@Param("id_role") Long idRole);
}
