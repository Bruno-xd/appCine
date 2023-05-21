package pe.edu.cibertec.appCineCibertec.Model.bd.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
	private Boolean respuesta;
	private Boolean mensaje;
}
