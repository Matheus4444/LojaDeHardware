package br.edu.iff.bsi.LojaDeHardware.controller.apirest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/api")
public class MainRestController {
	
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

	@GetMapping("/teste/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") String id) {
		if (id.equals("123")) {
			return ResponseEntity.ok().header("Content-Type", "text/html").body("success");
		}

		return ResponseEntity.notFound().header("Content-Type", "text/html").build();
	}

	@PostMapping("new/users")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, String>  registerUser(@RequestBody Map<String, String> userMap){
		try{
			if (userMap.get("UserName") != null || userMap.get("Password") != null) {
				System.out.println("UserName: " + userMap.get("userName"));
				System.out.println("Password: " + userMap.get("Password"));
				return userMap;
			}
			throw new NullPointerException();
		}catch(Exception e){
			String errorMessage = "Erro: Nome de usuário ou senha não digitados";
			Map<String,String> errorMap = new HashMap<>();
			errorMap.put("error", errorMessage);
			return errorMap;
		}
	}
}
