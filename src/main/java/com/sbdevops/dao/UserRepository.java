package com.sbdevops.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbdevops.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
