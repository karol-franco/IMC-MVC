package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Coordinador miCoordinador;
	private JButton btnRegistrar;
	private JButton btnConsultarPersona;
	private JButton btnConsultarLista;


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		iniciarComponentes();
		

	}


	private void iniciarComponentes() {
		JLabel lblSistemaGestionUsuarios = new JLabel("SISTEMA GESTION USUARIOS");
		lblSistemaGestionUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaGestionUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSistemaGestionUsuarios.setBounds(33, 6, 388, 30);
		contentPane.add(lblSistemaGestionUsuarios);
		
		JTextArea txtrEstaAplicacinPermite = new JTextArea();
		txtrEstaAplicacinPermite.setText("La funcionalidad de esta aplicacion es calcular el indice de masa corporal de una persona, porfavor"
				+ "ingrese una opcion");
		txtrEstaAplicacinPermite.setColumns(5);
		txtrEstaAplicacinPermite.setBounds(21, 48, 410, 127);
		contentPane.add(txtrEstaAplicacinPermite);
		
		btnRegistrar = new JButton("Registrar Persona");
		btnRegistrar.setBounds(16, 192, 415, 29);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		btnConsultarPersona = new JButton("Consultar Persona");
		btnConsultarPersona.setBounds(16, 219, 415, 29);
		btnConsultarPersona.addActionListener(this);
		contentPane.add(btnConsultarPersona);
		
		btnConsultarLista = new JButton("Consultar Lista de Personas");
		btnConsultarLista.addActionListener(this);
		btnConsultarLista.setBounds(16, 248, 415, 29);
		contentPane.add(btnConsultarLista);
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRegistrar) {
			miCoordinador.mostrarVentanaRegistro();
		}else if (e.getSource()==btnConsultarPersona) {
			miCoordinador.mostrarVentanaConsultaIndividual();
		}else if (e.getSource()==btnConsultarLista) {
			miCoordinador.mostrarVentanaConsultarLista();
		}
	}

}
