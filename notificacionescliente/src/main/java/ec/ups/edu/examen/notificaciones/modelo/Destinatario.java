package ec.ups.edu.examen.notificaciones.modelo;

import java.io.Serializable;


public class Destinatario implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	private String correo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
