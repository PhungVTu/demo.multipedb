package com.example.demo.repos;

import com.example.demo.model.User;
import com.example.demo.repos.common.HibernateRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

    public User getUsersByUserName(@Param("userName") String userName);
    public List<User> getUsersByPassWord(@Param("password") String password);

}
