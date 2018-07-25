package com.vebinar.service;

import com.vebinar.dao.UserDao;
import com.vebinar.entity.User;
import com.vebinar.mapper.UserMapper;
import com.vebinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserServiceImpl implements UserService {



    @Autowired
    public UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }
}
