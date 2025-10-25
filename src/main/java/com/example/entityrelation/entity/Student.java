package com.example.entityrelation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private String standard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id")
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
