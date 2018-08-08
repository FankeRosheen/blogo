package com.example.blogo.myblogo.account.dao;

import com.example.blogo.myblogo.account.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgDao extends JpaRepository<User, Integer> {
    @Query(value = "select * from t_user where name = ?1 ", nativeQuery = true)
    User findAllByName(@Param("name") String userName);
}
