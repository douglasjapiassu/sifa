package br.ufg.inf.es.sifa.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufg.inf.es.sifa.model.Servidor;
import br.ufg.inf.es.sifa.model.ValidModel;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public ModelAndView showMessage(@RequestParam(value = "name") String name) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("/teste")
	public ModelAndView teste() {
		ModelAndView mv = new ModelAndView("teste");
		return mv;
	}
	
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/adicionaTarefa")
	public String teste(@Valid ValidModel validModel, BindingResult result) {
		if (result.hasFieldErrors("descricao")) {
			return "teste";
		}
		
		return "teste";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginUsuario")
	public String loginUsuario(@Valid Servidor servidor, BindingResult result, Model model) {
		if (result.hasFieldErrors()) {
			return "login";
		}
		model.addAttribute(servidor);
		return "home";
	}
	
}