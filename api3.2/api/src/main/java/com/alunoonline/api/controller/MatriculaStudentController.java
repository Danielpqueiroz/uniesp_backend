package com.alunoonline.api.controller;

import com.alunoonline.api.dtos.PatchNotasRequest;
import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.service.MatriculaStudentService;
import com.alunoonline.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaStudentController {
    @Autowired
    MatriculaStudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MatriculaAluno matriculaAluno){
        service.create(matriculaAluno);
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
