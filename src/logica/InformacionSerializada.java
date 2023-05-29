package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class InformacionSerializada implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> identificaciones;
	private ArrayList<String> nombres;
	private ArrayList<String> telefonos;
	private ArrayList<String> contactosEmergencia;
	private ArrayList<String> direcciones; 
	private ArrayList<String> fechasNacimiento;
	private ArrayList<String[]> producto;
	private ArrayList<ArrayList<String>> clientes;
	
	public final String ruta() {
		String RUTA="src/logica/informacion.data";
		return RUTA;
	}
	public InformacionSerializada() {
		identificaciones = new ArrayList<String>();
		nombres = new ArrayList<String>();
		telefonos = new ArrayList<String>();
		contactosEmergencia= new ArrayList<String>();
		fechasNacimiento= new ArrayList<String>();
		direcciones= new ArrayList<String>();
		// en el boton en el actionlistener
		//guardaR(ruta());
		leerInformacion(ruta());
	}

	public boolean agregarCliente(String nombre, String identificacion,String telefono, String contactoEmergencia, String direccion, String fechaNacimiento ) {
		boolean sePudoAgregar = true;
		if (determinarClienteExiste(identificacion)) {
			sePudoAgregar = false;
		} else {
			nombres.add(nombre);
			identificaciones.add(identificacion);
			telefonos.add(telefono);
			contactosEmergencia.add(contactoEmergencia);
			direcciones.add(direccion);
			fechasNacimiento.add(fechaNacimiento);
			
		}
		guardaR(ruta());
		return sePudoAgregar;
	}

	public boolean agregarProducto(String[] productos, String identificacion ) {
		boolean centinela= true;
		if(determinarClienteExiste(identificacion)) {
			producto.add(productos);
		}
		guardaR(ruta());
		return centinela;
	}
	
	public boolean EliminarProducto(String identificacion) {
		boolean centinela = true;
		if(determinarClienteExiste(identificacion)) {
			int index= identificaciones.lastIndexOf(identificacion);
			producto.remove(index);
		}
		else {
			centinela=false;
		}
		guardaR(ruta());
		return centinela;
	}
	public boolean eliminarCliente(String identificacion) {
		boolean centinela = true;
		if (determinarClienteExiste(identificacion)) {
			int indice = identificaciones.indexOf(identificacion);
			identificaciones.remove(indice);
			nombres.remove(indice);
			telefonos.remove(indice);
			contactosEmergencia.remove(indice);
			direcciones.remove(indice);
			fechasNacimiento.remove(indice);
			producto.remove(indice);
			
		} else {
			centinela = false;
		}
		guardaR(ruta());
		return centinela;
	}

	public boolean determinarClienteExiste(String identificacion) {
		boolean centinela = false;
		for (int i = 0; i < identificaciones.size(); i++) {
			String cadaIdentificacion = identificaciones.get(i);
			if (identificacion.equals(cadaIdentificacion)) {
				centinela = true;
			}
		}
		return centinela;
	}

	public static ArrayList<String> leerArchivoTexto(String ruta) throws IOException {
		File miArchivo = new File(ruta);
		FileReader miFileReader = new FileReader(miArchivo);
		BufferedReader miBufferReader = new BufferedReader(miFileReader);
		String linea;
		ArrayList<String> misLineas = new ArrayList<>();
		while ((linea = miBufferReader.readLine()) != null) {
			misLineas.add(linea);
		}
		
		miBufferReader.close();
		miFileReader.close();
		return misLineas;
	}

	public static void escribirArchivo(String nombre, ArrayList<String> miTexto, boolean adicionar) throws IOException {
		File miArchivo = new File(nombre);
		FileWriter miFileWriter = new FileWriter(miArchivo, adicionar);
		BufferedWriter miBufferWriter = new BufferedWriter(miFileWriter);
		for (String linea : miTexto) {
			miBufferWriter.write(linea + "\n");
		}
		miBufferWriter.close();
		miFileWriter.close();
	}

	/**
	 * Permite serializar un archivo
	 * 
	 * @param data          El objeto del mundo a serializar
	 * @param nombreArchivo Es la ruta del archivo
	 * @throws IOException      Se produce cuando hay un error de entrada salida
	 * @throws RuntimeException En caso de error en tiempo de ejecución
	 */
	public void serialize(String nombreArchivo) throws Exception {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		fos = new FileOutputStream(nombreArchivo);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		
		System.out.println(this.nombres.toString());
		oos.close();
		fos.close();
	}

	/**
	 * Permite deserializar un archivo
	 * 
	 * @param nombreArchivo Es el nombre del archivo
	 * @return 
	 * @return El dato serializado
	 * @throws Exception
	 * @throws IOException
	 * @throws RuntimeException
	 */
	// limitar a las personas en el ingreso de datos;
	public  void deserialize(String nombreArchivo) throws Exception {
		clientes = new ArrayList<ArrayList<String>>();
		FileInputStream fis = new FileInputStream(nombreArchivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		InformacionSerializada data = (InformacionSerializada) ois.readObject();
		identificaciones= data.identificaciones;
		nombres = data.nombres;
		telefonos = data.telefonos;
		contactosEmergencia= data.contactosEmergencia;
		fechasNacimiento= data.fechasNacimiento;
		direcciones= data.direcciones;
		producto= data.producto;
		clientes.add(identificaciones);
		clientes.add(nombres);
		clientes.add(direcciones);
		clientes.add(fechasNacimiento);
		clientes.add(contactosEmergencia);
		clientes.add(telefonos);
		ois.close();
		fis.close();
		
	}
	public void guardaR(String nombreArchivo) {
		try {
			serialize(nombreArchivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void leerInformacion(String nombreArchivo) {
		try {
			deserialize(nombreArchivo);
		} catch (Exception e) {
			
			try {
				serialize(nombreArchivo);
			} catch (Exception e1) {
				
			}
		}
	}
	public ArrayList<ArrayList<String>> devolverArrays() {
		return clientes;
	}

}
