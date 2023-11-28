package com.alunoonline.api.controller;

import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher){
         Teacher teacherCreated = service.create(teacher);
         return ResponseEntity.status(201).body(teacherCreated);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> findAll(){

        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Teacher> findById(@PathVariable Long id){

        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){

        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody Teacher profAtualizado) throws ChangeSetPersister.NotFoundException {
        service.update(id, profAtualizado);
    }
}
