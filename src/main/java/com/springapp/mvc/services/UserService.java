package com.springapp.mvc.services;

import com.springapp.mvc.domain.User;

import java.util.List;

/**
 * Created by user on 8/14/2015.
 */
public interface UserService
{
    public void insertRow(User user);

    public List<User> getList();

    public User getRowById(int id);

    public void updateRow(User user, int id);

    public void deleteRow(int id);
}
