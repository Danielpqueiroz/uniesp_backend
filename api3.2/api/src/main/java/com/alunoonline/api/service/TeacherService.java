package com.alunoonline.api.service;

import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class TeacherService {

    @Autowired
    TeacherRepository repository;

    public Teacher create (Teacher teacher){
        return repository.save(teacher);
    }

    public List<Teacher> findAll() {
        return  repository.findAll();
    }
    public Optional<Teacher> findById(Long id) {
        return repository.findById(id);
    }

    public  void delete(Long id) {repository.deleteById(id);}

    public void update(Long id, Teacher profAtualizado) {
        Optional<Teacher> alunoExistente = repository.findById(id);

        if (alunoExistente.isPresent()) {// Atualiza as informações do aluno existente com os novos dados
            Teacher alunoParaAtualizar = alunoExistente.get();
            alunoParaAtualizar.setNome(profAtualizado.getNome());
            alunoParaAtualizar.setEmail(profAtualizado.getEmail());

            repository.save(alunoParaAtualizar);  // Salva o aluno atualizado no banco de dados

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado com o ID: " + id);

        }
    }


}
