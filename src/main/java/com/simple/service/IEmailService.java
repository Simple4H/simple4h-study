package com.simple.service;

import com.simple.common.ServerResponse;

public interface IEmailService {

    ServerResponse sendEmail(String email);

    ServerResponse checkEmailToken(String token,String email);
}
