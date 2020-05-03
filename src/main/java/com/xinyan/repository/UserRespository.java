package com.xinyan.repository;

import com.xinyan.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xinyan.xie
 * @description
 * @date 2020/5/3
 */
public interface UserRespository extends JpaRepository<User,String> {
}
