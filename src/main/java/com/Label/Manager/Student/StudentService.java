package com.Label.Manager.Student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

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
        return studentList;
    }

    public Student getStudent(long id) {
        return studentList.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void updateStudent(long id, Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            if (s.getId().equals(id)) {
                studentList.set(i, student);
                return;
            }
        }
    }

    public void deleteStudent(long id) {
        studentList.removeIf(s -> s.getId().equals(id));
    }
}
