package com.alunoonline.api.service;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    @Autowired
    StudentRepository repository;
    public Student create(Student student) {
        return repository.save(student);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

    public Optional<Student>  findById(Long id){
        return  repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Long id, Student alunoAtualizado) {
        Optional<Student> alunoExistente = repository.findById(id);

        if (alunoExistente.isPresent()) {

            Student alunoParaAtualizar = alunoExistente.get();
            alunoParaAtualizar.setNome(alunoAtualizado.getNome());
            alunoParaAtualizar.setEmail(alunoAtualizado.getEmail());
            alunoParaAtualizar.setCurso(alunoAtualizado.getCurso());


            repository.save(alunoParaAtualizar);
        } else {
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado com o ID: " + id);

        }
    }
}
