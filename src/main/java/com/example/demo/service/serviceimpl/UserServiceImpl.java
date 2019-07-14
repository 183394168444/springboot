package com.example.demo.service.serviceimpl;

import com.example.demo.mappers.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: 李林威
 * Date: 2019/7/3
 * Time: 14:57
 * To change this template use File / Settings / File Templates.
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> selectUserByName() {
        return userMapper.selectUserByName();
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }
}
