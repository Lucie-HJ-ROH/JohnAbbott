package com.example.project.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Book")
public class Book {
    private long id;
    private String title;

    public Book() {
        this.id = id;
        this.title = title;
    }

    public Book(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}' + "\n";
    }
}
