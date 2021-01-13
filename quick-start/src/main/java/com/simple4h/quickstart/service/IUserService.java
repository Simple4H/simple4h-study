package com.simple4h.quickstart.service;

import com.simple4h.quickstart.domain.User;

/**
 * user接口类
 *
 * @author Simple4H
 */
public interface IUserService {

    User getUserById(Integer userId);
}
