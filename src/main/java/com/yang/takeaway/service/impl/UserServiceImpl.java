package com.yang.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yang.takeaway.entity.User;
import com.yang.takeaway.mapper.UserMapper;
import com.yang.takeaway.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
