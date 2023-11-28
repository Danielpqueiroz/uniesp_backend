package com.alunoonline.api.service;

import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public Disciplina create(Disciplina disciplina) {
        return  repository.save(disciplina);
    }

    public List<Disciplina> findAll(){

        return repository.findAll();
    }

    public List<Disciplina> findByTeacherId(Long teacherId) {
        return repository.findByTeacherId(teacherId);
    }

    public void delete (Long id){

        repository.deleteById(id);
    }

    public void update(Long id, Disciplina discAtualizada){

        Optional<Disciplina> discExistente = repository.findById(id);

        if(discExistente.isPresent()){
            Disciplina discAtual = discExistente.get();
            discAtual.setNome(discAtualizada.getNome());
            discAtual.setTeacher(discAtualizada.getTeacher());

            repository.save(discAtual);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado com o id: " + id);
        }
    }

    public List<Disciplina> findByProfessorId(Long teacherId){

        return repository.findByTeacherId(teacherId);
    }

}
