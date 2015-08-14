package com.springapp.mvc.services;

import com.springapp.mvc.dao.ContentDAO;
import com.springapp.mvc.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by user on 7/21/2015.
 */
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentDAO contentDAO ;

    @Override
    public void insertRow(Content content) {
        contentDAO.insertRow(content);
    }

    @Override
    public List<Content> getList() {
        return contentDAO.getList();
    }

    @Override
    public Content getRowById(int id) {
        return contentDAO.getRowById(id);
    }

    @Override
    public void updateRow(Content content) {
        contentDAO.updateRow(content);
    }

    @Override
    public void deleteRow(int id) {
        contentDAO.deleteRow(id);
    }
}
