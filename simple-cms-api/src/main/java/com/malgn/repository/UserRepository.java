package com.malgn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malgn.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
