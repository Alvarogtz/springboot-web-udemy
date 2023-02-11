package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({ "/index", "/", "/home", "" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario user = new Usuario("Alvarogtz", "apellido", null);
		model.addAttribute("usuario", user);
		model.addAttribute("titulo", textoPerfil.concat(user.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		//model.addAttribute("titulo", "Listar usuarios");
		model.addAttribute("titulo", textoListar);
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> rellenarUsuarios(Model model) {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Alvarogtz", "apellido", null),
				new Usuario("Pattry", "apellido", "prueba@hotmail.es"),
				new Usuario("Pablo", "apellido", "email@gmail.com"));
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("titulo", "Listar usuarios");
		return usuarios;
	}

}
