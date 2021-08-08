package com.hb.core.service;

import com.hb.core.po.User;

public interface UserService {
    public User findUser(String usercode,String password);
}
