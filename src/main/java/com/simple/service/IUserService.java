package com.simple.service;

import com.simple.common.ServerResponse;
import com.simple.pojo.User;

public interface IUserService {

    ServerResponse<User> login(String username, String password);
}
