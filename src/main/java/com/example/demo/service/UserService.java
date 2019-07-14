package com.example.demo.service;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService{
    public List<User> selectUserByName();

    int deleteById(@Param("id") int id);

    int add(User user);
}
