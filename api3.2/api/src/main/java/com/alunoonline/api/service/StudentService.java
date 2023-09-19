package com.alunoonline.api.service;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    @Autowired
    StudentRepository repository;
    public Student create(Student student) {
        return repository.save(student);
    }

}
