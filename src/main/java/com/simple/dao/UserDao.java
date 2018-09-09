package com.simple.dao;

import com.simple.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Create By S I M P L E On 2018/09/09 14:31:16
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
