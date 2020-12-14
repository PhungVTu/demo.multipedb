package com.db2.demo.multipedb.repository;

import com.db2.demo.multipedb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,Integer> {
}
