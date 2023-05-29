package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.InformacionSerializada;
import logica.LogicaGlobal;

public class VentanaVentas extends JFrame {
	
	/**
	 * mi ventana Ventanas cuenta con la versionUID 7L
	 */
	private static final long serialVersionUID = 7L;
	
	private JPanel PaneLinicial;
	private String[] productos;
	private JButton botonRanking;
	private JButton botonCompras;
	private JButton clienteMayorCompraVuelo;
	private JButton totalRecaudadoCompraProductos;
	private JButton totalDineroRecaudadoTickets;
	private JButton cantMenores;
	private JButton MasVendidosTipoUbicacion;
	LogicaGlobal todaLogica;
	agregarClientes sec;
	InformacionSerializada infos;
	private JComboBox<String> NumeroComidaAlmuerzo;

	private JComboBox<String> NumeroComidaPostre;

	private JComboBox<String> NumeroComidaCafe;

	private JComboBox<String> NumeroComidaGaseosa;

	private JComboBox<String> NumeroComidaDesayuno;

	private JComboBox<String> NumeroComidaVino;
	
	private ArrayList<String[]> productosCliente;
	
	private ArrayList<ArrayList<String>> clientes;
	
	private String totalCompra;

	protected ArrayList<Integer> CantidadProductos;

	private CompraBoletos Principal;

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVentas frame = new VentanaVentas(null, null);
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
	public VentanaVentas(agregarClientes informacion,CompraBoletos ppal) {
		todaLogica= new LogicaGlobal();
		sec= informacion;
		Principal=ppal;
		infos= new InformacionSerializada();
		clientes= new ArrayList<ArrayList<String>>();
		clientes=infos.devolverArrays();
		CantidadProductos= new ArrayList<Integer>();
		totalCompra= new String();
		productosCliente= new ArrayList<String[]>();
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
				
				String actual=NumeroComidaAlmuerzo.getSelectedItem().toString();
				String actual1=NumeroComidaDesayuno.getSelectedItem().toString();
				String actual2=NumeroComidaGaseosa.getSelectedItem().toString();
				String actual3=NumeroComidaCafe.getSelectedItem().toString();
				String actual4=NumeroComidaPostre.getSelectedItem().toString();
				String actual5=NumeroComidaVino.getSelectedItem().toString();
				String seleccion=todaLogica.nuevaSeleccion(actual);
				String seleccion2=todaLogica.nuevaSeleccion(actual1);
				String seleccion3=todaLogica.nuevaSeleccion(actual2);
				String seleccion4=todaLogica.nuevaSeleccion(actual3);
				String seleccion5=todaLogica.nuevaSeleccion(actual4);
				String seleccion6=todaLogica.nuevaSeleccion(actual5);
				if(seleccion!=null && seleccion2 !=null && seleccion3 !=null && seleccion4!=null  && seleccion5!=null && seleccion6!=null ) {
					totalCompra=seleccion+","+seleccion2+","+seleccion3+","+seleccion4+","+seleccion5+","+seleccion6;
					productos=todaLogica.arregloProductos(totalCompra);
					productosCliente.add(productos);
					JOptionPane.showMessageDialog(null, "la compra Actual es: "+totalCompra);
				}

			}
		});
		PaneLinicial.setLayout(new BorderLayout(0, 0));
		PaneLinicial.add(botonCompras, BorderLayout.SOUTH);
		botonRanking= new JButton( " Ranking productos ");
		botonRanking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int pos= todaLogica.recorrerArreglo(productosCliente);
				String products=todaLogica.ranking(productosCliente,pos);
				JOptionPane.showMessageDialog(null, "los productos por ranking son: "+ products);
			}
		});
		clienteMayorCompraVuelo= new JButton(" cliente con mas compras ");
		clienteMayorCompraVuelo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cliente=todaLogica.clienteMascompras(productosCliente, clientes);
				JOptionPane.showMessageDialog(null, "el cliente con mas compras es: "+cliente);
			}
		});
		
		totalRecaudadoCompraProductos= new JButton("total recaudado por productos ");
		totalRecaudadoCompraProductos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CantidadProductos=todaLogica.CantidadComida(productosCliente);
				String totalRecaudado=todaLogica.recaudadoProd(CantidadProductos);
				//JOptionPane.showMessageDialog(null, "el total recudado en productos es:"+totalRecaudado);
			}
		});
		totalDineroRecaudadoTickets= new JButton("total dinero recaudado");
		totalDineroRecaudadoTickets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int total=todaLogica.Totaldinero(productosCliente);
				JOptionPane.showMessageDialog(null, "total Recaudado es: "+total);
			}
		});
		cantMenores= new JButton(" la cantidad de menores de edad");
		cantMenores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cantidadMenores=sec.devolverCanTmenores();
				JOptionPane.showMessageDialog(null, "la cantidad de menores: "+cantidadMenores);
			}
		});
		MasVendidosTipoUbicacion= new JButton("productos mas vendidos por ubicacion");
		MasVendidosTipoUbicacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				todaLogica.MasVendidosTipoPuesto(CantidadProductos);	
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
		
		NumeroComidaAlmuerzo = new JComboBox<String>();
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
		
		 NumeroComidaDesayuno = new JComboBox<String>();

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
		
		 NumeroComidaGaseosa = new JComboBox<String>();

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
	
		 NumeroComidaCafe = new JComboBox<String>();
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
		
		 NumeroComidaPostre = new JComboBox<String>();
		 
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
		
		 NumeroComidaVino = new JComboBox<String>();
		 
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
		

		panelBotonesExtra.setLayout(new GridLayout(11, 1, 20, 4));
		JButton botonVolver= new JButton(" Regresar ");
		botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sec.setVisible(true);
			}
		});
		PaneLinicial.setBackground(Color.green);
		panelBotonesExtra.add(botonRanking);
		panelBotonesExtra.add(clienteMayorCompraVuelo);
		panelBotonesExtra.add(totalRecaudadoCompraProductos);
		panelBotonesExtra.add(totalDineroRecaudadoTickets);
		panelBotonesExtra.add(cantMenores);
		panelBotonesExtra.add(MasVendidosTipoUbicacion);
		
		JButton sillasLibresyOcupadas = new JButton(" numero de sillas Libres y ocupadas");
		sillasLibresyOcupadas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String devolver=Principal.enviarNumeroSillas();
				JOptionPane.showMessageDialog(null, "el numero de Sillas Libres y ocupadas es: "+devolver);
			}
		});
		panelBotonesExtra.add(sillasLibresyOcupadas);
		
			
		JButton ProductoYmonto = new JButton("Productos por monto");
		ProductoYmonto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ProductosPormnt=todaLogica.alimvendidos(productosCliente);
				JOptionPane.showMessageDialog(null, "los productos con su monto separados por comas: "+ProductosPormnt);
			}
		});
		panelBotonesExtra.add(ProductoYmonto);
		
		JButton clienteMasGasto = new JButton("el cliente mas gasto en vuelo");
		clienteMasGasto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cliente=todaLogica.ClienteMasGasto(productosCliente, clientes);
				 JOptionPane.showMessageDialog(null, "el cliente que mas gasto en el vuelo es: "+cliente);
			}
		});
		panelBotonesExtra.add(clienteMasGasto);
		
		JButton mayorCantCompras = new JButton("La mayor Cantidad de compras");
		mayorCantCompras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cliente = todaLogica.clienteMayorcomprador(productosCliente, clientes);
				JOptionPane.showMessageDialog(null, "cliente con la mayor cantidad de compras: "+cliente);
			}
		});
		panelBotonesExtra.add(mayorCantCompras);
		panelBotonesExtra.add(botonVolver);
		productosCliente.add(todaLogica.arregloProductos(totalCompra));
		// leerArchivo
	}
	
}
