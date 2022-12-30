package com.Crud.gerenciadorFuncionarios.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Crud.gerenciadorFuncionarios.model.Funcionario;
import com.Crud.gerenciadorFuncionarios.model.Funcionario.FuncionarioSetor;
import com.Crud.gerenciadorFuncionarios.repository.FuncionarioRepository;

@Controller
public class HomeController {

    private FuncionarioRepository funcionarioRepository;

    HomeController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        model.addAttribute("funcionarios", funcionarios);
        return "home";
    }

    @GetMapping
    public String setor(@RequestParam String setor, Model model) {
        FuncionarioSetor funcionarioSetor = FuncionarioSetor.valueOf(setor.toUpperCase());
        List<Funcionario> funcionarios = funcionarioRepository.findBySetor(funcionarioSetor);

        model.addAttribute("funcionarios", funcionarios);
        return "home";
    }
}
