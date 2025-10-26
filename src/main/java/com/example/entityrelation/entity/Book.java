package com.example.entityrelation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    public int getBook_id() {
        return book_id;
    }

    public Book() {
    }

    public Book(int book_id, String book_name) {
        this.book_id = book_id;
        this.book_name = book_name;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Book(int book_id, String book_name, Student stdnt_id) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.stdnt_id = stdnt_id;
    }

    public Student getStdnt_id() {
        return stdnt_id;
    }

    public void setStdnt_id(Student stdnt_id) {
        this.stdnt_id = stdnt_id;
    }

    @Id
    private int book_id;
    private String book_name;

    @ManyToOne
    @JoinColumn(name = "std_id")
    private Student stdnt_id;

}
