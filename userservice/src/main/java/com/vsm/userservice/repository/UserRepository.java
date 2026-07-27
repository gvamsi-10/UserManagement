package com.vsm.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsm.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
