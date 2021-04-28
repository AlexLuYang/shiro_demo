package com.alex.shirodemo.service;

import com.alex.shirodemo.pojo.User;

public interface UserService {

    User getUserById(Integer id);

    User getUserByName(String name);
}
