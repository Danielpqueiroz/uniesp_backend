package com.alunoonline.api.service;

import com.alunoonline.api.dtos.PatchNotasRequest;
import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.repository.MatriculaStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatriculaStudentService {
    @Autowired
    MatriculaStudentRepository repository;

    public void create(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus("MATRICULADO");
        repository.save(matriculaAluno);

    }

    public void patchNotas(Long id, PatchNotasRequest patchNotasRequest) {
        Optional<MatriculaAluno> matriculaAluno = repository.findById(id);
        //fazer validação se a matricula existe
        MatriculaAluno matriculaUpdated = matriculaAluno.get();

        matriculaUpdated.setNota1(patchNotasRequest.getNota1());
        matriculaUpdated.setNota2(patchNotasRequest.getNota2());

        // quero a regra de calcular a media fora daqui
        Double media = (matriculaUpdated.getNota1() + matriculaUpdated.getNota2()) / 2;

        // quero que o valor da media pra ser aprovado, esteja em constate
        Double mediaParaAprovacao = 7.0;
        // quero que verifique o valor do status em um metodo por fora
        if (media >= mediaParaAprovacao) {
            matriculaUpdated.setStatus("APROVADO");
        }else {
            matriculaUpdated.setStatus("REPROVADO");
        }

        repository.save(matriculaUpdated);
    }
/*
    private  Boolean validateNotas(){
        if() {
            matriculaUpdated.setStatus("APROVADO");
        }else {
            matriculaUpdated.setStatus("REPROVADO");
        }
        repository.save(matriculaUpdated);
    }*/

    public void patchStatusParaTrancado(Long matriculaAlunoId) {
        Optional<MatriculaAluno> matriculaAluno = repository.findById(matriculaAlunoId);

        // fazer uma validação para só deixar mudar para trancado só quando tiver as duas notas nulas
        // tabem fazer a validação para verificar se a matricula existe antes de fazer esse get abaixo

        MatriculaAluno matriculaUpdated = matriculaAluno.get();

        matriculaUpdated.setStatus("TRANCADO");// no lugar de string recomendo enum

        repository.save(matriculaUpdated);
    }
}
