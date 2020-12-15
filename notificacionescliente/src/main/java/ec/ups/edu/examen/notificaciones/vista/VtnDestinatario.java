package ec.ups.edu.examen.notificaciones.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.ups.edu.examen.notificaciones.modelo.Destinatario;
import ec.ups.edu.examen.notificaciones.negocio.GestionNotificacionONRemoto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;

public class VtnDestinatario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;

	private GestionNotificacionONRemoto on;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VtnDestinatario frame = new VtnDestinatario();
					frame.setVisible(true);
					frame.referenciarONDestinatario();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VtnDestinatario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(47, 58, 80, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo:");
		lblNewLabel_1.setBounds(47, 114, 80, 13);
		contentPane.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(166, 55, 142, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(166, 111, 142, 19);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar Destinatario");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarDestinatario();
			}
		});
		btnRegistrar.setBounds(93, 168, 165, 21);
		contentPane.add(btnRegistrar);
	}

	protected void registrarDestinatario() {
		Destinatario d = new Destinatario();
		d.setNombre(txtNombre.getText());
		d.setCorreo(txtCorreo.getText());
		
		try {
			on.registrarDestinatario(d);
			System.out.println("Registro Destinatario OK");
		} catch (Exception e) {
			System.out.println("Error al guardar"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	public void referenciarONDestinatario() throws Exception {
		try {  
	        final Hashtable<String, Comparable> jndiProperties =  
	                new Hashtable<String, Comparable>();  
	        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
	                "org.wildfly.naming.client.WildFlyInitialContextFactory");  
	        jndiProperties.put("jboss.naming.client.ejb.context", true);  
	          
	        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
	        jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejbremoto");  
	        jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb01");  
	          
	        final Context context = new InitialContext(jndiProperties);  
	          
	        final String lookupName = "ejb:/notificaciones/GestionNotificacionON!ec.ups.edu.examen.notificaciones.negocio.GestionNotificacionONRemoto";  
	          
	        this.on = (GestionNotificacionONRemoto) context.lookup(lookupName);  
	          
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	        throw ex;  
	    }  
	}

}
