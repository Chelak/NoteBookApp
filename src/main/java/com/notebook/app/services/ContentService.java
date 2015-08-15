package com.notebook.app.services;

import com.notebook.app.domain.Content;

import java.util.List;

/**
 * Created by user on 7/21/2015.
 */
public interface ContentService
{
    public void insertRow(Content content);

    public List<Content> getList();

    public Content getRowById(int id);

    public void updateRow(Content content, int id);

    public void deleteRow(int id);
}
