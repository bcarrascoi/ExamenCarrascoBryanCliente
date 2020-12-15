package ec.ups.edu.examen.notificaciones.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.ups.edu.examen.notificaciones.modelo.Notificacion;
import ec.ups.edu.examen.notificaciones.negocio.GestionNotificacionONRemoto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.DefaultComboBoxModel;

public class VtnNotificacion extends JFrame {

	private JPanel contentPane;
	private JTextField txtFecha;
	private JTextField txtAsunto;
	private JTextField txtDetalle;

	private GestionNotificacionONRemoto on;
	private JTextField txtEnvio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VtnNotificacion frame = new VtnNotificacion();
					frame.setVisible(true);
					frame.referenciarONNotificacion();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VtnNotificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha: ");
		lblNewLabel.setBounds(70, 37, 63, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Asunto:");
		lblNewLabel_1.setBounds(70, 73, 63, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Detalle");
		lblNewLabel_2.setBounds(70, 111, 63, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TipoEnvio");
		lblNewLabel_3.setBounds(70, 154, 86, 13);
		contentPane.add(lblNewLabel_3);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(169, 34, 144, 19);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtAsunto = new JTextField();
		txtAsunto.setBounds(169, 70, 144, 19);
		contentPane.add(txtAsunto);
		txtAsunto.setColumns(10);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(169, 108, 144, 19);
		contentPane.add(txtDetalle);
		txtDetalle.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarEnvio();
			}
		});
		btnNewButton.setBounds(162, 214, 128, 21);
		contentPane.add(btnNewButton);
		
		txtEnvio = new JTextField();
		txtEnvio.setBounds(167, 151, 146, 19);
		contentPane.add(txtEnvio);
		txtEnvio.setColumns(10);
	}

	protected void registrarEnvio() {
		Notificacion n = new Notificacion();
		n.setFecha(txtFecha.getText());
		n.setDetalle(txtDetalle.getText());
		n.setAsunto(txtAsunto.getText());
		n.setTipoenvio(txtEnvio.getText());
		
		try {
			on.registrarEnvio(n);
			System.out.println("Registro OK");
		} catch (Exception e) {
			System.out.println("Error al guardar"+e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	public void referenciarONNotificacion() throws Exception {
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
