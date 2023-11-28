package com.alunoonline.api.controller;

import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Disciplina> create(@RequestBody Disciplina disciplina){
        Disciplina disciplinaCreated = service.create(disciplina);

        return ResponseEntity.status(201).body(disciplinaCreated);
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> findAll(){

        return service.findAll();
    }
    @GetMapping("/teacher/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> findByTeacherId(@PathVariable Long teacherId){
        return service.findByTeacherId(teacherId);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){

        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Disciplina discAtualizada){
        service.update(id, discAtualizada);
    }


}
