package com.notebook.app.services;

import com.notebook.app.dao.UserDAO;
import com.notebook.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by user on 8/14/2015.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;


    @Override
    public void insertRow(User user) {
        userDAO.insertRow(user);
    }

    @Override
    public List<User> getList() {
        return userDAO.getList();
    }

    @Override
    public User getRowById(int id) {
        return userDAO.getRowById(id);
    }

    @Override
    public void updateRow(User user, int id)
    {
        userDAO.updateRow(user,id);
    }

    @Override
    public void deleteRow(int id)
    {
        userDAO.deleteRow(id);
    }
}
