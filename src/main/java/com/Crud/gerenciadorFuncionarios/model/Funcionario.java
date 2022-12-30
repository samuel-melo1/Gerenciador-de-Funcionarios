package com.Crud.gerenciadorFuncionarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private String cargo;
    private Float salario;

    @Enumerated(EnumType.STRING)
    private FuncionarioSetor setor;

    public void setSetor(FuncionarioSetor setor) {
        this.setor = setor;
    }

    public enum FuncionarioSetor {
        TECNOLOGIA("tecnologia"), RH("rh"), DIRETORIA("diretoria");

        private String value;

        private FuncionarioSetor(String value) {
            this.value = value;
        }

        public String getSetor() {
            return value;
        }
    }

}