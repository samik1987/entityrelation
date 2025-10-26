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
    private int lap_id;
    private String model;

      @OneToOne
      //@OneToOne(mappedBy = "laptop")
      @JoinColumn(name = "std_id")
      @JsonIgnore
      private Student studentCol;

    public Laptop(int id, String model
            , Student student
    ) {
        this.lap_id = id;
        this.model = model;
        this.studentCol = student;
    }

    public Laptop() {
    }

    public int getId() {
        return lap_id;
    }

    public void setId(int id) {
        this.lap_id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Student getStudent() {
        return studentCol;
    }

    public void setStudent(Student student) {
        this.studentCol = student;
    }
}
