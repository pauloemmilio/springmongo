package com.paulo.springmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.springmongo.model.Funcionario;
import com.paulo.springmongo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> obterTodos() {
		return funcionarioService.obterTodos();
	}
	
	@GetMapping("/{codigo}")
	public Funcionario obterPorCodigo(@PathVariable String codigo) {
		return this.funcionarioService.obterPorCodigo(codigo);
	}
	
	@PostMapping
	public Funcionario criar (@RequestBody Funcionario funcionario) {
		return this.funcionarioService.criar(funcionario);
	}
	
	@GetMapping("/range")
	public List<Funcionario> obterFuncionariosPorRangeDeIdade (@RequestParam Integer de, @RequestParam Integer ate){
		return this.funcionarioService.obterFuncionariosPorRangeDeIdade(de, ate);
	}
	
	@GetMapping("/por-nome")
	public List<Funcionario> obterFuncionariosPorNome (@RequestParam String nome){
		return this.funcionarioService.findByNome(nome);
	}
}
