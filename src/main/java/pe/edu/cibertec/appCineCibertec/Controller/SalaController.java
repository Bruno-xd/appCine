package pe.edu.cibertec.appCineCibertec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.appCineCibertec.Model.bd.response.ResultadoResponse;
import pe.edu.cibertec.appCineCibertec.Service.SalaService;

@Controller
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaservice;
	
	@GetMapping("/frmSala")
	public String frmMantSala(Model model) {
		model.addAttribute("listasalas", salaservice.listarSala());
		return "sala/frmsala";
	}
	
	@PostMapping("/registrarSala")
	@ResponseBody
	public ResultadoResponse registrarSala(@RequestBody SalaRequest salaRequest) {
		return null;
	}

}
