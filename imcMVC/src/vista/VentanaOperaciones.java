package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.Coordinador;
import modelo.Procesos;

import java.awt.Font;

public class VentanaOperaciones extends JDialog  implements ActionListener{
	private JButton btnCalcular;
	private JTextArea datosArea;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JLabel lblNumero1;
	private JLabel lblNumero2;
	private JLabel lblTitulo;
	Procesos misProcesos=new Procesos();


    public VentanaOperaciones(VentanaRegistro ventanaOperaciones, boolean modal) {
    	/**Al llamar al constructor super(), le enviamos el
    	  * JFrame Padre y la propiedad booleana que determina
    	  * que es hija*/
    	super(ventanaOperaciones, modal);
    	  
        setTitle("Ventana de Consulta");
        setSize(471, 272);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(345, 79, 100, 30);
        getContentPane().add(btnCalcular);
        btnCalcular.addActionListener(this);

        datosArea = new JTextArea();
        datosArea.setBounds(50, 120, 395, 60);
        datosArea.setEditable(false);
        getContentPane().add(datosArea);
        
        txtNum1 = new JTextField();
        txtNum1.setBounds(50, 80, 86, 26);
        getContentPane().add(txtNum1);
        txtNum1.setColumns(10);
        
        txtNum2 = new JTextField();
        txtNum2.setColumns(10);
        txtNum2.setBounds(152, 80, 86, 26);
        getContentPane().add(txtNum2);


        // Agrupar los botones en un ButtonGroup
        ButtonGroup grupoOperaciones = new ButtonGroup();
        
        lblNumero1 = new JLabel("Peso");
        lblNumero1.setBounds(50, 62, 86, 16);
        getContentPane().add(lblNumero1);
        
        lblNumero2 = new JLabel("Talla");
        lblNumero2.setBounds(152, 62, 86, 16);
        getContentPane().add(lblNumero2);
        
        lblTitulo = new JLabel("OPERACIONES MATEMATICAS");
        lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(6, 6, 388, 30);
        getContentPane().add(lblTitulo);

	}

	
	private void verificaCampo(boolean validarNumero, JTextField campo) {
		
		if (validarNumero==true) {
			campo.setBackground(Color.white);
		}else {
			campo.setBackground(Color.red);
		}
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnCalcular == e.getSource()) {
			int peso = Integer.parseInt(txtNum1.getText());
			int talla = Integer.parseInt(txtNum2.getText());

			String resultado = misProcesos.calcularImc(peso, talla);
			datosArea.setText("imc: " + resultado);
		}
	}

}
