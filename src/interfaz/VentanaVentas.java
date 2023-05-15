package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.LogicaComida;
import logica.LogicaCompraboletos;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class VentanaVentas extends JFrame {
	
	/**
	 * mi ventana Ventanas cuenta con la versionUID 7L
	 */
	private static final long serialVersionUID = 7L;
	
	private JPanel PaneLinicial;
	private JButton botonRanking;
	private JButton botonCompras;
	private JButton clienteMayorCompraVuelo;
	private JButton totalRecaudadoCompraProductos;
	private JButton totalDineroRecaudado;
	private JButton cantMenores;
	private JButton MasVendidosTipoUbicacion;
	private LogicaCompraboletos logCompras;
	private LogicaComida logComida;

	private JComboBox NumeroComidaAlmuerzo;

	private JComboBox NumeroComidaPostre;

	private JComboBox NumeroComidaCafe;

	private JComboBox NumeroComidaGaseosa;

	private JComboBox NumeroComidaDesayuno;

	private JComboBox NumeroComidaVino;
	
	private String totalCompra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVentas frame = new VentanaVentas(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param informacion 
	 */
	public VentanaVentas(agregarClientes informacion) {
		logCompras= new LogicaCompraboletos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280, 720);
		PaneLinicial = new JPanel();
		PaneLinicial.setToolTipText("");
		PaneLinicial.setBackground(new Color(128, 255, 255));
		PaneLinicial.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PaneLinicial);
		botonCompras = new JButton("Comprar ");
		botonCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		PaneLinicial.setLayout(new BorderLayout(0, 0));
		PaneLinicial.add(botonCompras, BorderLayout.SOUTH);
		
		botonRanking= new JButton( " Ranking productos");
		botonRanking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		clienteMayorCompraVuelo= new JButton(" cliente con mas compras ");
		clienteMayorCompraVuelo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		totalRecaudadoCompraProductos= new JButton("total recaudado por productos ");
		totalRecaudadoCompraProductos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		totalDineroRecaudado= new JButton("total dinero recaudado");
		totalDineroRecaudado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cantMenores= new JButton(" la cantidad de menores de edad");
		cantMenores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		MasVendidosTipoUbicacion= new JButton("productos mas vendidos por ubicacion");
		MasVendidosTipoUbicacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		CrearPaneles();
	}
	public void CrearPaneles() {
		JPanel ContenedorComida= new JPanel();
		ContenedorComida.setLayout(new GridLayout(1,6,5,5));
		
		JPanel  Almuerzos= new JPanel();
		
		JPanel desayunos= new JPanel();
		JPanel gaseosa= new JPanel();
		JPanel café= new JPanel();
		JPanel postre= new JPanel();
		JPanel vino= new JPanel();
		ImageIcon imgAlmuerzo =new ImageIcon("src/imagenes/Bandeja.jpg");
		ImageIcon imgenCAfe= new ImageIcon("src/imagenes/CAfe.jpg");
		ImageIcon imgenGaseosa =new ImageIcon("src/imagenes/R.jpg");
		ImageIcon imgenDEsayuno= new ImageIcon("src/imagenes/pizza.jpg");
		ImageIcon imgenPostre =new ImageIcon("src/imagenes/Postres.jpg");
		ImageIcon imgenVIno= new ImageIcon("src/imagenes/Vino.jpg");
		JLabel contenerdorImageDesayuno= new JLabel(imgenDEsayuno);
		
		contenerdorImageDesayuno.setBackground(new Color(192, 192, 192));
		JLabel ContenerdorTipoComidaAlmu= new JLabel(" Almuerzo: " + " Bandeja Paisa");
		ContenerdorTipoComidaAlmu.setOpaque(true);
		ContenerdorTipoComidaAlmu.setBackground(Color.green);
		JLabel ContenerdorTipoComidaDes = new JLabel(" Desayunos: "+" Pizza ");
		ContenerdorTipoComidaDes.setOpaque(true);
		ContenerdorTipoComidaDes.setBackground(Color.green);
		JLabel ContenerdorTipoComidaCafe = new JLabel(" Bebida: "+" Cafe ");
		ContenerdorTipoComidaCafe.setOpaque(true);
		ContenerdorTipoComidaCafe.setBackground(Color.green);
		JLabel ContenerdorTipoComidapostre = new JLabel("Postre: "+"Pastel de frambuesa ");
		ContenerdorTipoComidapostre.setOpaque(true);
		ContenerdorTipoComidapostre.setBackground(Color.green);
		JLabel ContenerdorTipoComidagaseosa = new JLabel(" Bebida: "+" Gaseosa ");
		ContenerdorTipoComidagaseosa.setOpaque(true);
		ContenerdorTipoComidagaseosa.setBackground(Color.green);
		JLabel ContenerdorTipoComidavino = new JLabel(" Bebida: "+" Vino ");
		ContenerdorTipoComidavino.setOpaque(true);
		ContenerdorTipoComidavino.setBackground(Color.green);                                                    
		JLabel contenerdorImageAlmuerzos= new JLabel(imgAlmuerzo);
		
		JLabel contenerdorImagegaseosa= new JLabel(imgenGaseosa);
		
		JLabel contenerdorImagecafé= new JLabel(imgenCAfe);
		                                          
		JLabel contenerdorImagepostre= new JLabel(imgenPostre);
		                                       
		JLabel contenerdorImagevino= new JLabel(imgenVIno);
		                                          
		
		ContenedorComida.add(Almuerzos);
		Almuerzos.setLayout(new GridLayout(3, 1, 0, 0));
		
		NumeroComidaAlmuerzo = new JComboBox();
		NumeroComidaAlmuerzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalCompra="";
				String seleccion="";
				String actual=NumeroComidaAlmuerzo.getSelectedItem().toString();
				for(int i=0;i<actual.length();i++) {
					if(Character.isDigit(actual.charAt(i))) {
						seleccion+=actual.charAt(i);
						totalCompra=seleccion+","+totalCompra;
					}
				}
			}
		});
		NumeroComidaAlmuerzo.addItem("cantidad: 0 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 1 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 2 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 3 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 4 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 5 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 6 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 7 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 8 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 9 und");
		NumeroComidaAlmuerzo.addItem("cantidad: 10 und");
		Almuerzos.add(ContenerdorTipoComidaAlmu);
		Almuerzos.add(contenerdorImageAlmuerzos);
		Almuerzos.add(NumeroComidaAlmuerzo);
		ContenedorComida.add(desayunos);
		
		desayunos.setLayout(new GridLayout(3, 1, 0, 0));
		
		 NumeroComidaDesayuno = new JComboBox();
		 NumeroComidaDesayuno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccion="";
				String actual=NumeroComidaDesayuno.getSelectedItem().toString();
				for(int i=0;i<actual.length();i++) {
					if(Character.isDigit(actual.charAt(i))) {
						seleccion+=actual.charAt(i);
						totalCompra=seleccion+","+totalCompra;
					}
			}
			}});
		NumeroComidaDesayuno.addItem("cantidad: 0 und ");
		NumeroComidaDesayuno.addItem("cantidad: 1 und ");
		NumeroComidaDesayuno.addItem("cantidad: 2 und ");
		NumeroComidaDesayuno.addItem("cantidad: 3 und ");
		NumeroComidaDesayuno.addItem("cantidad: 4 und ");
		NumeroComidaDesayuno.addItem("cantidad: 5 und ");
		NumeroComidaDesayuno.addItem("cantidad: 6 und ");
		NumeroComidaDesayuno.addItem("cantidad: 7 und ");
		NumeroComidaDesayuno.addItem("cantidad: 8 und ");
		NumeroComidaDesayuno.addItem("cantidad: 9 und ");
		NumeroComidaDesayuno.addItem("cantidad: 10 und ");
		desayunos.add(ContenerdorTipoComidaDes);
		desayunos.add(contenerdorImageDesayuno);
		desayunos.add(NumeroComidaDesayuno);
		
		ContenedorComida.add(gaseosa);
		gaseosa.setLayout(new GridLayout(3, 1, 0, 0));
		
		 NumeroComidaGaseosa = new JComboBox();
		 NumeroComidaGaseosa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccion="";
				String actual=NumeroComidaGaseosa.getSelectedItem().toString();
				for(int i=0;i<actual.length();i++) {
					if(Character.isDigit(actual.charAt(i))) {
						seleccion+=actual.charAt(i);
						totalCompra=seleccion+","+totalCompra;
					}
			}
			}
				
			}
		);
		NumeroComidaGaseosa.addItem("cantidad: 0 und");
		NumeroComidaGaseosa.addItem("cantidad: 1 und");		
		NumeroComidaGaseosa.addItem("cantidad: 2 und");
		NumeroComidaGaseosa.addItem("cantidad: 3 und");
		NumeroComidaGaseosa.addItem("Cantidad: 4 und");
		NumeroComidaGaseosa.addItem("Cantidad: 5 und");
		NumeroComidaGaseosa.addItem("Cantidad: 6 und");
		NumeroComidaGaseosa.addItem("Cantidad: 7 und");
		NumeroComidaGaseosa.addItem("Cantidad: 8 und");
		NumeroComidaGaseosa.addItem("Cantidad: 9 und");
		NumeroComidaGaseosa.addItem("Cantidad: 10 und");
		gaseosa.add(ContenerdorTipoComidagaseosa);
		gaseosa.add(contenerdorImagegaseosa);
		gaseosa.add(NumeroComidaGaseosa);
		
		ContenedorComida.add(café);
		café.setLayout(new GridLayout(3, 1, 0, 0));
	
		 NumeroComidaCafe = new JComboBox();
		 NumeroComidaCafe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccion="";
				String actual=NumeroComidaCafe.getSelectedItem().toString();
				for(int i=0;i<actual.length();i++) {
					if(Character.isDigit(actual.charAt(i))) {
						seleccion+=actual.charAt(i);
						if(actual.indexOf("CafeGratis")!=-1) {
							seleccion+="g";
						}
						totalCompra=seleccion+","+totalCompra;
					}
			}
			}
		});
		NumeroComidaCafe.addItem("CafeGratis: 0und ");
		NumeroComidaCafe.addItem("cantidad: 0 und ");
		NumeroComidaCafe.addItem("cantidad: 1 und  ");
		NumeroComidaCafe.addItem("cantidad: 2 und  ");
		NumeroComidaCafe.addItem("cantidad: 3 und ");
		NumeroComidaCafe.addItem("cantidad: 4 und ");
		NumeroComidaCafe.addItem("cantidad: 5 und ");
		NumeroComidaCafe.addItem("cantidad: 6 und ");
		NumeroComidaCafe.addItem("cantidad: 7 und ");
		NumeroComidaCafe.addItem("cantidad: 8 und ");
		NumeroComidaCafe.addItem("cantidad: 9 und ");
		NumeroComidaCafe.addItem("cantidad: 10 und ");
		
		café.add(ContenerdorTipoComidaCafe);
		café.add(contenerdorImagecafé);
		café.add(NumeroComidaCafe);
		
		ContenedorComida.add(postre);
		postre.setLayout(new GridLayout(3, 1, 0, 0));
		
		 NumeroComidaPostre = new JComboBox();
		 NumeroComidaPostre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccion="";
				String actual=NumeroComidaPostre.getSelectedItem().toString();
				for(int i=0;i<actual.length();i++) {
					if(Character.isDigit(actual.charAt(i))) {
						seleccion+=actual.charAt(i);
						totalCompra=seleccion+","+totalCompra;
					}
			}
			}
		});
		NumeroComidaPostre.addItem("cantidad: 0 und ");
		NumeroComidaPostre.addItem("cantidad: 1 und ");
		NumeroComidaPostre.addItem("cantidad: 2 und ");
		NumeroComidaPostre.addItem("cantidad: 3 und ");
		NumeroComidaPostre.addItem("cantidad: 4 und ");
		NumeroComidaPostre.addItem("cantidad: 5 und ");
		NumeroComidaPostre.addItem("cantidad: 6 und ");
		NumeroComidaPostre.addItem("cantidad: 7 und ");
		NumeroComidaPostre.addItem("cantidad: 8 und ");
		NumeroComidaPostre.addItem("cantidad: 9 und ");
		NumeroComidaPostre.addItem("cantidad: 10 und ");
		
		
		postre.add(ContenerdorTipoComidapostre);
		postre.add(contenerdorImagepostre);
		postre.add(NumeroComidaPostre);
		
		ContenedorComida.add(vino);
		vino.setLayout(new GridLayout(3, 1, 0, 0));
		
		 NumeroComidaVino = new JComboBox();
		 NumeroComidaVino.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccion="";
				String actual=NumeroComidaVino.getSelectedItem().toString();
				for(int i=0;i<actual.length();i++) {
					if(Character.isDigit(actual.charAt(i))) {
						seleccion+=actual.charAt(i);
						totalCompra=seleccion+","+totalCompra;
						System.out.println(totalCompra);
						}
			}
			}
		});
		NumeroComidaVino.addItem("cantidad: 0 und ");
		NumeroComidaVino.addItem("cantidad: 1 und ");
		NumeroComidaVino.addItem("cantidad: 2 und ");
		NumeroComidaVino.addItem("cantidad: 3 und ");
		NumeroComidaVino.addItem("cantidad: 4 und ");
		NumeroComidaVino.addItem("cantidad: 5 und ");
		NumeroComidaVino.addItem("cantidad: 6 und ");
		NumeroComidaVino.addItem("cantidad: 7 und ");
		NumeroComidaVino.addItem("cantidad: 8 und ");
		NumeroComidaVino.addItem("cantidad: 9 und ");
		NumeroComidaVino.addItem("cantidad: 10 und ");
		
		vino.add(ContenerdorTipoComidavino);
		vino.add(contenerdorImagevino);
		vino.add(NumeroComidaVino);
		vino.setMaximumSize( new Dimension(20,20));
		JPanel panelBotonesExtra = new JPanel();
		PaneLinicial.add(panelBotonesExtra, BorderLayout.EAST);
		PaneLinicial.add(ContenedorComida, BorderLayout.CENTER);
		

		panelBotonesExtra.setLayout(new GridLayout(7, 1, 20, 4));
		JButton botonVolver= new JButton(" boton para volver ");
		botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaVentas frame = new VentanaVentas(null);
				frame.setVisible(false);
				
			}
		});
		PaneLinicial.setBackground(Color.green);
		botonRanking= new JButton();
		botonRanking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logComida.ranking();
				
			}
		});
		panelBotonesExtra.add(botonRanking);
		panelBotonesExtra.add(clienteMayorCompraVuelo);
		panelBotonesExtra.add(totalRecaudadoCompraProductos);
		panelBotonesExtra.add(totalDineroRecaudado);
		panelBotonesExtra.add(cantMenores);
		panelBotonesExtra.add(MasVendidosTipoUbicacion);
		panelBotonesExtra.add(botonVolver);
	}
	
}
