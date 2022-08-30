package com.Label.Manager.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//Tells Spring this is a REST controller
@RestController
// @RequestMapping signifies the type of request and its url path, it is used at class level
@RequestMapping(path = "api/v1")
public class StudentController {

    // @Autowired annotation marks this as something that needs dependency injection
    // This means when your method runs, there's an instance of the dependent object available
    @Autowired
    private StudentService studentService;

    // @GetMapping is @RequestMapping combined with .GET and is used at method level
    @GetMapping(path = "/student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/student/{id}")
    // @PathVariable tells spring to pull the variable from the url path portion in {}
    // They will automatically match if the variable in the path and code are the same, or it can be passed as a parameter to @PathVariable
    public Student getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }

    // @RequestBody allows for the .json payload of the request body to be converted to a student instance
    @PostMapping(path = "/student")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
}
