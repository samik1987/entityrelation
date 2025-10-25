package com.example.entityrelation.repository;

import com.example.entityrelation.entity.Laptop;
import com.example.entityrelation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface EntityRepository  extends JpaRepository<Student,Integer> {

    @Query("SELECT s.laptop FROM Student s WHERE s.laptop.id = :laptopId")
    Laptop findLaptopByLaptopId(@Param("laptopId") Integer laptopId);
//
//    @Query("SELECT s.laptop FROM Student s WHERE s.id = :studentId")
//    Laptop findLaptopByStudentId(@Param("studentId") Integer studentId);
}

