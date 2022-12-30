package com.Crud.gerenciadorFuncionarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Crud.gerenciadorFuncionarios.model.Funcionario;
import com.Crud.gerenciadorFuncionarios.repository.FuncionarioRepository;

import jakarta.validation.Valid;

@Controller
public class FuncionarioController {

    FuncionarioRepository funcionarioRepository;

    FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/form")
    public String funcionariosForm(Funcionario funcionario) {
        return "addFuncionariosForm";
    }

    @PostMapping("/add")
    public String novo(@Valid Funcionario funcionario, BindingResult result) {
        if (result.hasFieldErrors()) {
            return "redirect:/form";
        }
        funcionarioRepository.save(funcionario);
        return "redirect:/home";
    }

    // Acessa o formulario de edição
    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable(name = "id") int id) {

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("funcionario", funcionario);
        return "atualizaForm";
    }

    // Atualiza funcionario
    @PostMapping("update/{id}")
    public String alterarProduto(@Valid Funcionario funcionario, BindingResult result, @PathVariable int id) {

        if (result.hasErrors()) {
            return "redirect:/form";
        }

        funcionarioRepository.save(funcionario);
        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(name = "id") int id, Model model) {

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        funcionarioRepository.delete(funcionario);
        return "redirect:/home";
    }
}