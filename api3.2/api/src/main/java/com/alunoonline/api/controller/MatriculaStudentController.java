package com.alunoonline.api.controller;

import com.alunoonline.api.dtos.PatchNotasRequest;
import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.service.MatriculaStudentService;
import com.alunoonline.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaStudentController {
    @Autowired
    MatriculaStudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody MatriculaAluno matriculaAluno){

        try {
            service.create(matriculaAluno);
            return ResponseEntity.status(HttpStatus.CREATED).body("Matrícula realizada com sucesso.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PatchMapping("/atualiza-notas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void pachNotas(
        @RequestBody PatchNotasRequest patchNotasRequest,
        @PathVariable Long id
    ) {
        service.patchNotas(id, patchNotasRequest);
    }

    @PatchMapping("/atualiza-status-para-trancado/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchStatusParaTrancado(@PathVariable Long id) {
        service.patchStatusParaTrancado(id);
    }
}
