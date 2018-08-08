package com.example.blogo.myblogo.account.dao;

import com.example.blogo.myblogo.account.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends CrudRepository<User, Integer> {

    @Query(value = "select * from t_user where name = ?1 and password = ?2 ", nativeQuery = true)
    User findAllByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Query(value = "select * from t_user where name = ?1 ", nativeQuery = true)
    User findAllByName(String name);
}
