package com.springapp.mvc.dao;

import com.springapp.mvc.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by user on 8/14/2015.
 */
public class UserDaoImpl implements UserDAO {



    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }



    @Override
    public void insertRow(User user)
    {
        sessionFactory.getCurrentSession().save(user);
    }


    @Override
    public List<User> getList()
    {
        return  sessionFactory.getCurrentSession().createCriteria("from User").list();
    }

    @Override
    public User getRowById(int id)
    {
        return (User) sessionFactory.getCurrentSession().load(User.class, id);
    }

    @Override
    public void updateRow(User user, int id)
    {
            User userToUpdate = getRowById(id);
        if (userToUpdate !=null)
        {
            userToUpdate.setName(user.getName());
            userToUpdate.setPassword(user.getPassword());
            sessionFactory.getCurrentSession().update(userToUpdate);
        }
    }

    @Override
    public void deleteRow(int id)
    {
      User userToDelete = getRowById(id);
        if (userToDelete !=null)
        {
            sessionFactory.getCurrentSession().delete(userToDelete);
        }
    }
}
