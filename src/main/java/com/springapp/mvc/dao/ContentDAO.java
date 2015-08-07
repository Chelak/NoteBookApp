package com.springapp.mvc.dao;

import com.springapp.mvc.model.Content;

import java.util.List;

/**
 * Created by user on 7/21/2015.
 */
public interface ContentDAO
{
    public void insertRow(Content content);

    public List<Content> getList();

    public Content getRowById(int id);

    public void updateRow(Content content);

    public void deleteRow(int id);
}
