package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logica.InformacionSerializada;
import logica.LogicaCompraboletos;

public class agregarClientes extends JFrame {

	/***/
	private static final long serialVersionUID = 3L;

	private ArrayList<String[]> clientesPreferenciales;
	private ArrayList<String[]> clientesNormales;
	private JPanel panelTodo;
	private JLabel labelId;
	private JLabel nombre;
	private JLabel contactoEmergencia;
	private JButton jbuttonAceptar;
	private JTextField ingresoID;
	private JTextField ingresoNombre;
	private JTextField ingresoContactoEmergencia;
	private JTextField ingresefechaNacimiento;
	private JPanel panelInferior;
	private JPanel panelCentro;
	private JPanel panelMedio;
	private JPanel panelSuperior;
	private JPanel panelCentrado;
	private JLabel telefonoUser;
	private JLabel direccion;
	private JLabel fechaNacimiento;
	private JTextField ingreseTelefono;
	private JTextField ingresoDireccion ;
	private JPanel panelSubInferior2;
	private InformacionSerializada info;

	private JPanel panelSubInferior;
	CompraBoletos principal;
	
	
	public agregarClientes(CompraBoletos ppal) {
		principal=ppal;
		info= new InformacionSerializada();
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearPanelTodo();
		crearPanelesTexfield();
		crearTexfield();
	}

	

	public String[] agregarData() {
		new ArrayList<String>();	
		String [] dato=LogicaCompraboletos.agregarData(ingresoID.getText(), ingresoNombre.getText(),ingresoContactoEmergencia.getText(),ingresefechaNacimiento.getText(),ingresoDireccion.getText());
		return dato;
	}

	public void crearPanelesTexfield() {
		
		panelSuperior = new JPanel();
		JPanel JpanelBotones = new JPanel();
		JButton botonEliminar = new JButton(" Eliminar ");
		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				info.leerInformacion("ruta.dat");
				info.eliminarCliente(ingresoID.getText());
			}
			
		});
		panelSuperior.setLayout(new BorderLayout());
		panelMedio = new JPanel();
		panelMedio.setLayout(new BorderLayout());
		panelCentro = new JPanel();
		panelCentro.setLayout(new BorderLayout());
		panelInferior = new JPanel();
		panelInferior.setLayout(new BorderLayout());
		panelSubInferior= new JPanel();
		panelSubInferior.setLayout(new BorderLayout());
		panelSubInferior2= new JPanel();
		panelSubInferior2.setLayout(new BorderLayout());
		jbuttonAceptar = new JButton(" registrar ");
		agregarClientes informacion= this;
		jbuttonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ingresefechaNacimiento.getText().isEmpty() || ingresoNombre.getText().isEmpty() || ingresoContactoEmergencia.getText().isEmpty() || ingresoID.getText().isEmpty() || ingreseTelefono.getText().isEmpty() || ingresoDireccion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "recuerde rellenar todos los espacios");
				}
				else {
					agregarData();
					VentanaVentas ventanaVentas= new VentanaVentas(informacion);
					ventanaVentas.setVisible(true);
					info.leerInformacion("ruta.dat");
					info.agregarCliente(ingresefechaNacimiento.getText(),ingresoNombre.getText(),ingresoContactoEmergencia.getText(),ingresoID.getText(),ingreseTelefono.getText(),ingresoDireccion.getText());
					ingresefechaNacimiento.setText("");
					ingresoNombre.setText("");
					ingresoContactoEmergencia.setText("");
					ingresoID.setText("");
					ingreseTelefono.setText("");
					ingresoDireccion.setText("");
				}
			}
		});
		panelCentrado.add(panelSuperior);
		panelCentrado.add(panelMedio);
		panelCentrado.add(panelCentro);
		panelCentrado.add(panelInferior);
		panelCentrado.add(panelSubInferior);
		panelCentrado.add(panelSubInferior2);
		JpanelBotones.add(jbuttonAceptar, BorderLayout.WEST);
		JpanelBotones.add(botonEliminar, BorderLayout.EAST);
		panelTodo.add(JpanelBotones, BorderLayout.SOUTH);

	}

	public void crearTexfield() {
		labelId = new JLabel(" Ingrese el ID:	");
		nombre = new JLabel(" Ingresoe el Nombre: ");
		contactoEmergencia = new JLabel(" Ingrese el Contacto de Emergencia: ");
		telefonoUser= new JLabel(" ingrese el telefono del usuario ");
		direccion= new JLabel(" ingrese la direccion  del usuario ");
		fechaNacimiento= new JLabel(" ingrese la fecha de nacimiento del usuario ");
		ingreseTelefono= new JTextField();
		ingreseTelefono.setPreferredSize(new Dimension(500,200));
		ingresoDireccion= new JTextField();
		ingresoDireccion.setPreferredSize(new Dimension(500,50));
		ingresoID = new JTextField();
		ingresoID.setPreferredSize(new Dimension(500, 50));
		ingresoNombre = new JTextField();
		ingresoNombre.setPreferredSize(new Dimension(500, 50));
		ingresoContactoEmergencia = new JTextField();
		ingresoContactoEmergencia.setPreferredSize(new Dimension(500, 50));
		ingresefechaNacimiento = new JTextField();
		ingresefechaNacimiento.setPreferredSize(new Dimension(500, 50));
		panelSuperior.add(ingresoID, BorderLayout.EAST);
		panelSuperior.add(labelId, BorderLayout.CENTER);
		panelSuperior.setBackground(Color.cyan);
		panelMedio.add(ingresoNombre, BorderLayout.EAST);
		panelMedio.add(nombre, BorderLayout.CENTER);
		panelMedio.setBackground(Color.cyan);
		panelCentro.add(ingresoContactoEmergencia, BorderLayout.EAST);
		panelCentro.add(contactoEmergencia, BorderLayout.CENTER);
		panelCentro.setBackground(Color.cyan);
		panelInferior.add(ingresefechaNacimiento, BorderLayout.EAST);
		panelInferior.add(fechaNacimiento, BorderLayout.CENTER);
		panelInferior.setBackground(Color.cyan);
		panelSubInferior.add(ingreseTelefono, BorderLayout.EAST);
		panelSubInferior.add(telefonoUser, BorderLayout.CENTER);
		panelSubInferior.setBackground(Color.cyan);
		panelSubInferior2.add(ingresoDireccion, BorderLayout.EAST);
		panelSubInferior2.add(direccion, BorderLayout.CENTER);
		panelSubInferior2.setBackground(Color.cyan);;
	}

	public void crearPanelTodo() {
		panelTodo = new JPanel();
		panelCentrado = new JPanel();
		panelTodo.setLayout(new BorderLayout());
		panelCentrado.setLayout(new GridLayout(6, 1, 10, 10));
		panelCentrado.setBackground(Color.cyan);
		setContentPane(panelTodo);
		panelTodo.add(panelCentrado, BorderLayout.CENTER);
	}

}
