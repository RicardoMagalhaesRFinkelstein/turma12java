package com.example.demo.Seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Tema;
import com.example.demo.repository.TemaRepository;

@Controller
public class ControllerGeral {//cérebro, ela que define os links e o que cada link faz
	
	@Autowired//coloca o repositório dentro do controller. ABSOLUTAMENTE NECESSÁRIO
	private TemaRepository repository;
	
	//localhost:0808 <- direciona p a index
	@GetMapping(value= "/")
	public String login() {
		return "index";
	}	
	@GetMapping(value="/cadastrarTema")
	public String form(){
		return "formTema";
	}	
	
	@PostMapping(value="/cadastrarTema")
	public String form(Tema tema){			
		repository.save(tema);
		return "redirect:/cadastrarTema";
	}


}
