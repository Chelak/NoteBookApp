package com.notebook.app.dao;

import com.notebook.app.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by user on 8/14/2015.
 */
public class UserDaoImpl implements UserDAO {



    @Autowired
    SessionFactory sessionFactory;

        @Override
    public void insertRow(User user)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();

    }


    @Override
    public List<User> getList()
    {
        Session session = sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();
        return userList;


    }

    @Override
    public User getRowById(int id)
    {
        Session session = sessionFactory.openSession();
        return (User) session.load(User.class, id);
    }

    @Override
    public void updateRow(User user, int id)
    {
            User userToUpdate = getRowById(id);
        if (userToUpdate !=null)
        {
            userToUpdate.setName(user.getName());
            userToUpdate.setPassword(user.getPassword());
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(userToUpdate);
            tx.commit();
            session.close();
        }
    }

    @Override
    public void deleteRow(int id)
    {
      User userToDelete = getRowById(id);
        if (userToDelete !=null)
        {

            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(userToDelete);
            tx.commit();
            session.close();

        }
    }
}
