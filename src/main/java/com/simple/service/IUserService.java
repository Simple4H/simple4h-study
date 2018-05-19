package com.simple.service;

import com.simple.common.ServerResponse;

public interface IUserService {

    ServerResponse login(String username, String password);
}
