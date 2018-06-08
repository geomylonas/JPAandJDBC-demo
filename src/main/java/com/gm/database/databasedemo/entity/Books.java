package com.gm.database.databasedemo.entity;

import javax.persistence.*;

@Entity

public class Books {
    @Id
    @GeneratedValue
    private int book_id;
    private String name;
    private int person_id;


    public Books() {
    }

    public Books(int book_id, String name, int person_id) {
        this.book_id = book_id;
        this.name = name;
        this.person_id = person_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", person_id=" + person_id +
                '}';
    }
}
