package com.example.blogo.myblogo.account.dao;

import com.example.blogo.myblogo.account.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordDao extends JpaRepository<User,Integer> {
    @Query(value = "select * from t_user where name = ?1 and email = ?2 ", nativeQuery = true)
    User findByNameAndEmail(@Param("name") String name, @Param("email") String email);
}
