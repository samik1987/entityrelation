package com.example.entityrelation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private String standard;

    public Student(int id, String name, String standard, List<Book> bookList, Laptop laptop) {
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.bookList = bookList;
        this.laptop = laptop;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "stdnt_id")
    private List<Book> bookList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "studentCol")
    //@JoinColumn(name = "laptop_id" , referencedColumnName = "lap_id")
    //@OneToOne(cascade = CascadeType.ALL)
    //@OneToOne
    //@JoinColumn(name = "laptop_id")
    private Laptop laptop;

    public Student(int id, String name, String standard
            , Laptop laptop
    ) {
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.laptop = laptop;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
