package com.example.entityrelation.controller;

import com.example.entityrelation.entity.Book;
import com.example.entityrelation.entity.Laptop;
import com.example.entityrelation.entity.Student;
import com.example.entityrelation.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private EntityRepository _repository;

    @PostMapping("/addstudent")
    public void addStudent(@RequestBody Student inputStd) throws Exception {
        try {


            // Student reference or FK in Laptop table
            Laptop inputLaptop = inputStd.getLaptop();
            inputLaptop.setStudent(inputStd);

            // OR
            //inputStd.getLaptop().setStudent(inputStd);

            // Laptop reference or FK in Student table
            //inputStd.setLaptop(inputStd.getLaptop());


            List<Book> bookList = inputStd.getBookList();
            for(Book bk : bookList)
            {
                bk.setStdnt_id(inputStd);
            }


            Student resp=    this._repository.save(inputStd);
            System.out.println("END");
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
