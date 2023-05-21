package pe.edu.cibertec.appCineCibertec.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.appCineCibertec.Model.bd.Estado;
import pe.edu.cibertec.appCineCibertec.Model.bd.Sala;
import pe.edu.cibertec.appCineCibertec.Model.bd.request.SalaRequest;
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
		String mensaje="Sala registrada correctamente";
		Boolean respuesta=true;
		try {
			//se puede aplicar el patron builder en estos objetos
			Sala objSala = new Sala();
			if(salaRequest.getIdsala() > 0) {
				objSala.setIdsala(salaRequest.getIdsala());
			}
			objSala.setDescsala(salaRequest.getDescsala());
			objSala.setAsientos(salaRequest.getAsientos());
			Estado objEstado = new Estado();
			objEstado.setIdestado(salaRequest.getIdestado());
			objSala.setEstado(objEstado);
		} catch (Exception e) {
			mensaje="Sala no registrada";
			respuesta=false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarSala")
	@ResponseBody
	public ResultadoResponse eliminarSala(@RequestBody SalaRequest salaRequest) {
		String mensaje = "Sala eliminada correctamente";
		Boolean respuesta = true;
		try {
			salaservice.eliminarSala(salaRequest.getIdsala());
		} catch (Exception e) {
			mensaje = "Sala no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("listarSalas")
	@ResponseBody
	public List<Sala> listarSalas(){
		return salaservice.listarSala();
	}

}
