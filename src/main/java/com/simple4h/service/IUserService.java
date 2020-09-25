package com.simple4h.service;

import com.simple4h.common.ServerResponse;
import com.simple4h.domain.User;

/**
 * author Create By Simple4H
 * date 2020-09-25 10:14
 */
public interface IUserService {

    ServerResponse<User> getUserInfo(Integer userId);
}
