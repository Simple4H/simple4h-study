package com.simple4h.demo.service;

import com.simple4h.common.response.ServerResponse;
import com.simple4h.demo.domain.User;

/**
 * author Create By Simple4H
 * date 2020-09-25 10:14
 */
public interface IUserService {

    ServerResponse<User> getUserInfo(Integer userId);
}
