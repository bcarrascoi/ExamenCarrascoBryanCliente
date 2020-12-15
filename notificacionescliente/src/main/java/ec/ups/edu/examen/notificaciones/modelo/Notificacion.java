package ec.ups.edu.examen.notificaciones.modelo;

import java.io.Serializable;
public class Notificacion implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String fecha;
	private String asunto;
	private String detalle;
	private String tipoenvio;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getTipoenvio() {
		return tipoenvio;
	}

	public void setTipoenvio(String tipoenvio) {
		this.tipoenvio = tipoenvio;
	}

}
