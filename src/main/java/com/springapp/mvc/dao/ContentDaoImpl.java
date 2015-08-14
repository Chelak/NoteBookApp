package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Content;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by user on 7/21/2015.
 */
public class ContentDaoImpl implements ContentDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insertRow(Content content) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(content);
        transaction.commit();
        session.close();

    }

    @Override
    public List<Content> getList() {
        Session session = sessionFactory.openSession();
        List<Content> contentList = session.createQuery("from Content").list();
        session.close();
        return contentList;
    }

    @Override
    public Content getRowById(int id) {
        Session session = sessionFactory.openSession();
        Content content = (Content) session.load(Content.class, id);
        return content;
    }

    @Override
    public void updateRow(Content content, int id )
    {
        Content contentToUpdate = getRowById(id);

        if (contentToUpdate != null)
        {
            contentToUpdate.setTitle(content.getTitle());
            contentToUpdate.setContent(content.getContent());
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(contentToUpdate);
            tx.commit();
            session.close();

        }


    }

    @Override
    public void deleteRow(int id) {

        Content contentToDelete = getRowById(id);

        if (contentToDelete != null)
        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(contentToDelete);
            tx.commit();
            session.close();
        }

    }
}
