package com.example.blogo.myblogo.account.dao;

import com.example.blogo.myblogo.account.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends JpaRepository<User,Integer> {
}
