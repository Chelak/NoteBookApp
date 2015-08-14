package com.springapp.mvc.dao;

import com.springapp.mvc.domain.User;


import java.util.List;

/**
 * Created by user on 8/14/2015.
 */
public interface UserDAO
{


    public void insertRow(User user);

    public List<User> getList();

    public User getRowById(int id);

    public void updateRow(User user, int id);

    public void deleteRow(int id);
}
