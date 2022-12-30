package com.Crud.gerenciadorFuncionarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Crud.gerenciadorFuncionarios.model.Funcionario;
import com.Crud.gerenciadorFuncionarios.model.Funcionario.FuncionarioSetor;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    List<Funcionario> findBySetor(FuncionarioSetor funcionarioSetor);
}