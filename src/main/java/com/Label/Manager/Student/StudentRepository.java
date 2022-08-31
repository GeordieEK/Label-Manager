package com.Label.Manager.Student;

import org.springframework.data.repository.CrudRepository;
// CrudRepository includes standard CRUD operations in Spring JPA
public interface StudentRepository extends CrudRepository<Student, Long> {

}
