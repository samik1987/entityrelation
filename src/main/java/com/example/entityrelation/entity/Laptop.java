package com.example.entityrelation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Laptop {

    @Id
    private int id;
    private String model;

      //@OneToOne
      @OneToOne(mappedBy = "laptop")
//    @JoinColumn(name = "student_id")
      @JsonIgnore
      private Student student;

    public Laptop(int id, String model
            , Student student
    ) {
        this.id = id;
        this.model = model;
        this.student = student;
    }

    public Laptop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
