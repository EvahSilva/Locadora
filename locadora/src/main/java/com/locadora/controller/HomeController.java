package com.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.locadora.model.Cliente;
import com.locadora.reposity.CrudCliente;
@Controller
public class HomeController {
	@Autowired
	private CrudCliente crud;
	
	
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView= new ModelAndView("index");
		modelAndView.addObject("CrudCliente", crud.findAll());
		modelAndView.addObject(new Cliente());
		return modelAndView;
		
	}
	
	@PostMapping("/salvar")
	public String salvar(Cliente cliente) {		
		System.out.println("Cliente:" + cliente.getNome() +  "Filme:" + cliente.getTitulo());
		crud.save(cliente);
		return "/index";
		
	}
	@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
		     crud.deleteById(id);
		     return "redirect:/";
	}
	
	
		 
	}
	
	


