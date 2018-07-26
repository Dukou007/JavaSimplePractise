package com.huaqin.mapper;

import com.huaqin.domain1.QueryVo;
import com.huaqin.domain1.User;

import java.util.List;

public interface UserMapper {

    public List<User> findByUserName(User user);

    public List<User> findByQueryVo(QueryVo vo);




}
