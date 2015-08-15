package com.notebook.app.domain;

import javax.persistence.*;

/**
 * Created by user on 7/21/2015.
 */
@Entity
@Table(name="Content")
public class Content
{
    @Id
    @GeneratedValue
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
