package com.gm.database.databasedemo.entity;

public class PersonBooks {

    private String person_name;
    private String book_name;

    public PersonBooks() {
    }

    public PersonBooks(int personbooks_id, String person_name, String book_name) {
        this.person_name = person_name;
        this.book_name = book_name;
    }




    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    @Override
    public String toString() {
        return "\nPersonBooks{" +
                ", person_name='" + person_name + '\'' +
                ", book_name='" + book_name + '\'' +
                '}';
    }
}