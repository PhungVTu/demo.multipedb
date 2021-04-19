package com.example.demo.repos;

import com.example.demo.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RoleRepo extends CrudRepository<Role,Integer> {

    public List<Role> getRoleByUserID(@Param("USER_ID") Long userId);

}
