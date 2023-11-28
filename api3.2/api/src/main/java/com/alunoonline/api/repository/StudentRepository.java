package com.alunoonline.api.repository;

import com.alunoonline.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Query("UPDATE ALUNO a SET a.nome = :nome, a.email = :email, a.curso =curso WHERE a.id = :id")
    void update(@Param("id") Long id, @Param("nome") String nome, @Param("email") String email, @Param("curso") String curso);

}


