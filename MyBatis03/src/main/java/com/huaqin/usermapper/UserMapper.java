package com.huaqin.usermapper;

import com.huaqin.domain1.User;

import java.util.List;

public interface UserMapper {

    public List<User> findByUserName(User user);

    public List<User> findByQueryVo(User user);




}
