package com.Label.Manager.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    // @Autowired means that when Spring creates an instance of StudentService,
    // it's going to inject an instance of StudentRepository, ready to use in methods.
    @Autowired
    private StudentRepository studentRepository;

    private ArrayList<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(
                    1L,
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    21
            ),
            new Student(
                    2L,
                    "Geordie",
                    "geordie.jamal@gmail.com",
                    LocalDate.of(2003, Month.SEPTEMBER, 5),
                    21
            )
    ));

    public List<Student> getAllStudents() {
        //findAll() will connect to the DB, run a query, get all student rows,
        // convert each of them to student instances and return them
        List<Student> students = new ArrayList<>();
        // ::add is a method reference which is like a lambda expression (more info on lambda basics at javabrains.io)
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Optional<Student> getStudent(Long id) {
        // return studentList.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        return studentRepository.findById(id);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Long id, Student student) {
//        for (int i = 0; i < studentList.size(); i++) {
//            Student s = studentList.get(i);
//            if (s.getId().equals(id)) {
//                studentList.set(i, student);
//                return;
//            }
//        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        // studentList.removeIf(s -> s.getId().equals(id));
        studentRepository.deleteById(id);
    }
}
