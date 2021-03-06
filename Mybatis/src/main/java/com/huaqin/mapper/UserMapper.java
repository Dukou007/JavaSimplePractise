package com.huaqin.mapper;

import com.huaqin.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();

    public User findById(Integer userId);

    public void insert(User user);

    public void update(User user);

    public void delete(Integer userId);

    public List<User> findByName(String username);

    public Integer findByCount();
}
