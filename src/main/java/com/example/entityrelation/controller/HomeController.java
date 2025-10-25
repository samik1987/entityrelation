package com.example.entityrelation.controller;

import com.example.entityrelation.entity.Laptop;
import com.example.entityrelation.entity.Student;
import com.example.entityrelation.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private EntityRepository _repository;

    @PostMapping("/addstudent")
    public void addStudent(@RequestBody Student inputStd) throws Exception {
        try {



            //inputStd.setLaptop(inputStd.getLaptop());

            inputStd.getLaptop().setStudent(inputStd);

            this._repository.save(inputStd);
        }
        catch (Exception ex)
        {
            throw new Exception("Adding Student Failed due to "+ex.getMessage());
        }

    }

    @GetMapping("/getstudent/{_id}")
    public Student getStudentById(@PathVariable int _id)
    {

       return this._repository.findById(_id).orElse(new Student());
    }

    @GetMapping("/getlaptop/{_id}")
    public Object getLaptopById(@PathVariable int _id)
    {

        return this._repository.findLaptopByLaptopId(_id);
    }

//    @GetMapping("/getlaptopbystudent/{_id}")
//    public Laptop getLaptopByStudentId(@PathVariable int _id)
//    {
//
//        return this._repository.findLaptopByStudentId(_id);
//    }
}
