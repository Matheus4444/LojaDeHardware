package br.edu.iff.bsi.LojaDeHardware.controllerRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api")
public class ControllerView {
	
	@GetMapping
	@ResponseBody
	public String initial() {
		return "Bem vindo a sua API";
	}

	@PostMapping("/new")
	@ResponseBody
	public String page(@PathVariable("id") int id) {
        return "Olá Mundo ---> " + id;
    }
}
