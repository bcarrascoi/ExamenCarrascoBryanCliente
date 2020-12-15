package ec.ups.edu.examen.notificaciones.negocio;

import java.util.List;

import ec.ups.edu.examen.notificaciones.modelo.Destinatario;
import ec.ups.edu.examen.notificaciones.modelo.Notificacion;

public interface GestionNotificacionONRemoto {

	public boolean registrarEnvio(Notificacion notificacion) throws Exception;
	public List<Notificacion> getNotificacions() throws Exception;
	public boolean registrarDestinatario(Destinatario destinatario) throws Exception;
}
