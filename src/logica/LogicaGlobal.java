package logica;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;


public class LogicaGlobal {
private LeerDatos llenarDatos;
	public static String devolerNombre(ArrayList<String> nombres, int posicion) {
		String nombre="";
		for(int i=0;i<nombres.size();i++) {
			if(i==posicion) {
				nombre=nombres.get(i);
			}
		}
		return nombre;
	}

	public String TipoSilla(JButton matriz2[][], JButton matriz[][]){
		String TipoSilla = "";
		if(matriz!=null && matriz2!=null) {
			if(VerificarPuestosOcupado(matriz2)) {
				TipoSilla=TipoSilla+";preferencial;";
			}
				if(VerificarPuestosOcupado(matriz)) {
					for(int i=0;i<matriz.length;i++) {
						for(int j=0;j<matriz[i].length;j++) {
							if( matriz[i][j]!=null) {
								if(matriz[i][j].getBackground().equals(Color.red)) {
									TipoSilla=TipoSilla+";normal";
									TipoSilla=TipoSilla+devolverTipoPuesto(i, j, matriz );
								}
							}
						}
					}
				}
		}			
		return TipoSilla;
	}
	private String devolverTipoPuesto (int i, int j, JButton[][] matriz) {
		String tipoPuesto="";
		int nuevoIndex=i-1;
		if(nuevoIndex!=-1) {
			if(matriz[nuevoIndex][j].getBackground().equals(Color.cyan)){
				tipoPuesto=",ventana";
			}
			if(matriz[nuevoIndex][j].getBackground().equals(Color.green)){
				tipoPuesto=",centro";
			}
			if(matriz[nuevoIndex][j].getBackground().equals(Color.orange)){
				tipoPuesto=",pasillo";
			}	
		}
		else {
			if(matriz[1][j].getBackground().equals(Color.cyan)) {
				tipoPuesto=",ventana";
			}
			if(matriz[1][j].getBackground().equals(Color.green)) {
				tipoPuesto=",centro";
			}
			if(matriz[1][j].getBackground().equals(Color.orange)) {
				tipoPuesto=",pasillo";
			}
		}
				return tipoPuesto;
			}
		


	public boolean VerificarPuestosOcupado(JButton[][] matrizBotones) {
		boolean centinela=false;
		for(int i=0;i<matrizBotones.length;i++) {
			for(int j=0;j<matrizBotones[i].length;j++) {
				if(!(matrizBotones[i][j]== null)) {
					if(matrizBotones[i][j].getBackground().equals(Color.red)) {
						centinela=true;
						}	
				}
				}
			}	
		
		return centinela;
	}

	public static  String[] agregarData(String id, String nombre, String direccion, String fechaNacimiento, String contactosEmergencia) {
		String[] arregloCliente = {id, nombre,direccion, fechaNacimiento, contactosEmergencia};
		return arregloCliente;
	}
	
	//funcion para partir arreglos
	public  String[] partidora(String[] n,int pos) {
		String[] valor=n[pos].split("-");
		return valor;
	
	}
	public  String[] partidorasigno(String[] n,int pos) {
		String[] valor=n[pos].split("-");
		return valor;
		}

	public  boolean imPar(int n){
		boolean valor=true;
		if((n & 1)==0){
			
		}
		else{
			valor=false;}
		return valor;
	}
	public  ArrayList<String[]> devolvercadena(ArrayList<ArrayList<String[]>> clientes,int pos){
		ArrayList<String[]> valor=clientes.get(pos);
		return valor;
	}
	public  int sumacant(String[] products,int pos) {
		int valor=0;
		for(int i=0;i<products.length;i++){
			if(imPar(i)==true) {
				valor+=Integer.parseInt(products[i]);
			}}
		return valor;
	}
	public  int sumacant2(String[] products,int pos) {
		int valor=0;
			if(imPar(pos)==true) {
				valor+=Integer.parseInt(products[pos]);
			}
		return valor;
	}
	public  String[] productos(ArrayList<String[]>arrayLProductos,int pos) {
		String[] compraxcliente=new String[4];
		for(int i=0;i<arrayLProductos.size();i++){
			compraxcliente=partidora(arrayLProductos.get(i), pos);}
			return compraxcliente;
	}
	public  ArrayList<Integer> cantidaddecomida(ArrayList<String[]> clientes,int pos) {
		String[] arregloCliente = clientes.get(0);
		String[] arregloComidas = arregloCliente[arregloCliente.length-1].split("-");
		ArrayList<Integer> valor=new ArrayList <Integer>();
		for(int i=0;i<arregloComidas.length;i++) {
			if(imPar(i)) {
				valor.add(Integer.parseInt(arregloComidas[i]));
			}
		}
		return valor;
		
	}
	public  ArrayList<Integer> cantalimento(String[]productos,int pos){
		ArrayList<Integer> valor= new ArrayList<Integer>();
		String[] cliente=compraxcliente(productos,pos);
		for(int i=0;i<cliente.length;i++) {
			if(imPar(i)) {
				valor.add(Integer.parseInt(cliente[i]));
			}
		}
		return valor;
	}
	public  String[] compraxcliente(String[] product,int pos) {
		String[] cent=partidora(product,pos);
		return cent;
		
	}
	public  int[] sumarcadenasn(int[] vacia, ArrayList<Integer>llenar) {
		int[] valor=new int[vacia.length];
		for(int i=0;i<vacia.length;i++) {
			valor[i]=vacia[i]+llenar.get(i);
		}
		return valor;
	}
	public  ArrayList<String> intercalar(String[] COmida,String[] ranking){
		ArrayList <String> valor=new ArrayList<String>();
		for(int i=0;i<(COmida.length+ranking.length);i++){
			if(imPar(i)) {
				valor.add(COmida[i]);
			}else {
				valor.add(ranking[i]);
			}
		}
		return valor;
	}
	public  int[] ordenar(int[] aOrdenar) {
		int[] arregloOrdenado=aOrdenar.clone();
		int[] arregloPos=new int[aOrdenar.length];
		for(int i=0;i<aOrdenar.length;i++) {
			arregloPos[i]=i;}
		for(int i=0;i<arregloOrdenado.length-1;i++) {
			for(int j=i+1;j<arregloOrdenado.length;j++) {
				if(arregloOrdenado[i]>arregloOrdenado[j]) {
					int numAux=arregloOrdenado[i];
					arregloOrdenado[i]=arregloOrdenado[j];
					arregloOrdenado[j]=numAux;
					int numPosAux=arregloPos[j];
					arregloPos[j]=arregloPos[i];
					arregloPos[i]=numPosAux;
					
				}
			}
		}int[] arregloP=new int[aOrdenar.length];
		for(int i=0;i<arregloP.length;i++) {
			arregloP[arregloPos[i]]=i;
		}
		return arregloP;}
		
	//X varialbe
	//total poducto alimenticio x cliente
	
	public  int productoxcliente(String[] productos,int pos) {
		int valor=(partidora(productos, pos).length)/2;

		return valor;
	}
	
	
	//cliente mayor comprador clientes para total de todos los clients
	/*cliente mayor comprador tiene como parametros el arrayslist de clientes y la posicion
	 * en donde esta ubicado el string de comida,devuelve el valor mayor de compra
	 */
	public  String clientemayorcomprador(ArrayList<ArrayList> clientes,int pos) {
		int cont=0;
		String nombre="";
		String cent="";

		return cent;
		
	}
	
	
private ArrayList<String> recorreArreglo(ArrayList<ArrayList<String>> clientes, int pos) {
	ArrayList<String> nombreCliente= new ArrayList<String>();
	return nombreCliente;
}
private ArrayList<String[]> devolvercadena2(ArrayList<ArrayList<String[]>> Produtos, int i) {
	ArrayList<String[]> valu= new ArrayList<String[]>(); 
		return valu;
	}

/**
 * total de alimentos por cliente
 * @param  recibe parametros el string del cliente y 
 * @param la posicion
 * en donde esta el string de comida
 * @return retorna el total de alimentos
 */
	public  int totalalimentos(ArrayList<String[]> n,int pos){
		int cant=0;
		String[] valor= n.get(pos);
		for(int i=0;i<valor.length;i++){
		if(imPar(i)==true) {
			cant+=Integer.parseInt(valor[i]);
		}}
		return cant;
	}
	
	
/*sus parametros son la lista de completa de los clientes y la posicion del string de alimentos
 * y retorna un arreglo con el total de producto comprado por todos los clientes
 */
	public  int[] cantproductovendido(ArrayList<String[]> clientes,int pos) {
		String[] ranking= {"palomitas","gaseosa"};
		int[] vacia=new int[ranking.length];
		for(int i=0;i<clientes.size();i++) {
			String[] clie=clientes.get(i);
			ArrayList <Integer> cliente=cantalimento(clie,pos);
			vacia=sumarcadenasn(vacia, cliente);
		}
		return vacia;
	}
	
/*recibe el arraylist de clientes el arreglo de producto mas comprado y la poscision de la comida
 * va a mostrar los clientes que compraron el producto mas vendido
 * //listado de clientes por ubicacion de producto mas vendido
 */
	public ArrayList<String> clienxprodvendido(ArrayList<String[]>clientes,String[]productomascomprado,int pos) {
		ArrayList<String>valor=new ArrayList<String>();
		String producto=productomascomprado[0];
		for(int i=0;i<clientes.size();i++) {
			String[] cliente = clientes.get(i);
			String[] cent=compraxcliente(cliente,5);
			for(int j=0;j<cent.length;j++){
			if(cent[j].equals(producto)) {
				int y=j;
				valor.add(cliente[y-1]);
			}}
		}
		return valor;
	} 
/**
 * 
 * @param productosCliente la cantidad de alimentos vendidos y su total incluidos los valores 0
 * @return lista de alimentos sin los valores de ceros, es decir, el total de alimentos vendidos
 */
	public String alimvendidos(ArrayList<String[]> productosCliente) {
		String valor="";
		
		
		return valor;
	}
/*se ingresa el arraylist de clientes y las pos de la comida y regresa el aarraylist de la comida
 * con su cant de producto vendido en total
 */
	public String ranking(ArrayList<String[]> ProductosCliente,int pos){
		String nuevo="";
		
		return nuevo;
		//regresa cadena con los numeros pares la cant y numeros impares el producto
}

	public String nuevaSeleccion(String actual) {
		String seleccion="";
		for(int i=0;i<actual.length();i++) {
			if(Character.isDigit(actual.charAt(i))) {
				seleccion+=actual.charAt(i);
				if(actual.indexOf("CafeGratis")!=-1) {
					seleccion+="g";
				}
			}
		}
	
		return seleccion;
	}

	public String TipoSilla(boolean matriz1, boolean matriz2, JButton[][] matrizBotones, JButton[][] matrizBotones2) {
			String tipos= "";
			if(matrizBotones!=null && matrizBotones2!=null) {
				if(matriz1 || matriz2) {
					tipos=TipoSilla(matrizBotones2, matrizBotones)+";"+tipos;
				}	
			}
			return tipos;
		}

	public String devolverSillas(boolean matriz1, boolean matriz2, JButton[][] matrizBotones, JButton[][]matrizBotones2) {
		String cantSillas="";
		int cantSillasOcupadas=0;
		int cantSillasLibres=0;
		if(matriz1 || matriz2) {
			for(int i=0;i<matrizBotones.length;i++) {
				for(int j=0;j<matrizBotones[0].length;j++) {
					if(matrizBotones[i][j]!=null) {
						if(matrizBotones[i][j].getBackground().equals(Color.red)) {
							cantSillasOcupadas++;	
						}
						else {
							cantSillasLibres++;
						}
					}
				}
			}
		}
		for(int i=0;i<matrizBotones2.length;i++) {
			for(int j=0;j<matrizBotones2[0].length;j++) {
				if(matrizBotones2[i][j]!=null) {
					if(matrizBotones2[i][j].getBackground().equals(Color.red)) {
						cantSillasOcupadas++;	
					}
					else {
						cantSillasLibres++;
					}
				}
			}
		}
		cantSillas+=cantSillasLibres+","+cantSillasOcupadas;
		return cantSillas;
	}
	
	public String[][] OcupadorUser(JButton matriz[][], String ID){
		String[][] puestosOcupados= new String[matriz.length][matriz[0].length];
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz.length;j++) {
				if(matriz[i][j].getBackground().equals(Color.red)) {
					puestosOcupados[i][j]=ID;
				}
			}
		}
		return puestosOcupados;
	}
	//producto mas vendido y clientes que lo compraron 

	public String[] arregloProductos(String totalCompra) {
		String sinCOmas="";
		llenarDatos = new LeerDatos();
		for(int i=0;i<totalCompra.length();i++) {
			if(totalCompra.charAt(i)!=',') {
				sinCOmas+=totalCompra.charAt(i);
			}
		}
		String [] arregloProductos= new String[sinCOmas.length()];
		arregloProductos=llenarDatos.llenarArreglo(sinCOmas);
		return arregloProductos;
	}

	public boolean esMenor(String text) {
		boolean centinela=false;
		LocalDate fechanacimiento= LocalDate.parse(text);
		if(LocalDate.now().getYear()-fechanacimiento.getYear()<18){
			centinela=true;
	}
		if(LocalDate.now().getYear()-fechanacimiento.getYear()==18) {
			if(fechanacimiento.getMonth().compareTo(LocalDate.now().getMonth())<0) {
				centinela=true;
		}	
	}
		return centinela;
	}
	public int recorrerArreglo(ArrayList<String[]> productosCliente) {
		int pos=0;
		for(int i=0;i<productosCliente.size();i++) {
			pos=i;
		}
		return pos;
	}

	public int Totaldinero( ArrayList<String[]> productoCliente ) {
		int totalDinero=0;
		for(int i=0;i<productoCliente.size();i++) {
			String [] productos= productoCliente.get(i);
			for(int j=0;j<productos.length;j++) {
					if(j==0) {
						String producto=productos[j];
						int unidad6=Integer.parseInt(producto);
						totalDinero=((unidad6*12000)+totalDinero);
					}
					if(j==1) {
						String producto=productos[j];
						int unidad5=Integer.parseInt(producto);
						totalDinero=(unidad5*10000)+totalDinero;
					}
					if(j==2) {
						String producto=productos[j];
						int unidad4=Integer.parseInt(producto);
						totalDinero=(unidad4*4000)+totalDinero;
					}
					if(j==3) {
						String producto=productos[j];
						if(producto.indexOf('g')!=-1) {
							totalDinero=0+totalDinero;
						}
						else {
							int unidad3=Integer.parseInt(producto);
							totalDinero=(unidad3*36000)+totalDinero;	
						}
						
						
					}
					if(j==4) {
						String producto=productos[j];
						if(producto.indexOf('g')!=-1) {
							totalDinero=0+totalDinero;
						}
						else {
							int unidad2=Integer.parseInt(producto);
							totalDinero=(unidad2*4500)+totalDinero;	
						}
					}
					if(j==5) {
						String producto=productos[j];
						if(producto.indexOf('g')!=-1) {
							
						}
						else {
							int unidad=Integer.parseInt(producto);
							totalDinero=(unidad*50000)+totalDinero;
						}
						
					}
		}
		}
		return totalDinero;
	}

	public String recaudadoProd(ArrayList<Integer> CantidadTotal) {
		String recaudado="";
		for(int i=0;i<CantidadTotal.size();i++) {
			if(i==0) {
				int total=CantidadTotal.get(i)*12000;
				recaudado+=total;
			}
			if(i==1) {
				int total1=CantidadTotal.get(i)*10000;
				recaudado+=total1;
			}
			if(i==2) {
				int total2=CantidadTotal.get(i)*4000;
				recaudado+=total2;
			}
			if(i==3) {
				int total3=CantidadTotal.get(i)*4500;
				recaudado+=total3;
			}
			if(i==4) {
				int total4=CantidadTotal.get(i)*36000;
				recaudado+=total4;
			}
			if(i==5) {
				int total5=CantidadTotal.get(i)*50000;
				recaudado+=total5;
			}
		}
		return recaudado;
	}


	public String clienteMayorcomprador(ArrayList<String[]> productosCliente, ArrayList<ArrayList<String>> clientes) {
		String cliente="";
		
		
		return cliente;
	}

	public String ClienteMasGasto(ArrayList<String[]> productosCliente, ArrayList<ArrayList<String>> clientes) {
		String cliente="";
		
		return cliente;
	}

	public String clienteMascompras(ArrayList<String[]> productosCliente, ArrayList<ArrayList<String>> clientes) {
		String cliente="";
		
		return cliente;
	}

	public ArrayList<Integer> CantidadComida(ArrayList<String[]> productosCliente) {
		ArrayList<Integer> cantComi= new ArrayList<Integer>();
		for(int i=0;i<productosCliente.size();i++) {
			String [] temporal= productosCliente.get(i);
			for(int j=0;j<temporal.length;j++) {
				if(temporal[j].indexOf("g")!=-1) {
					cantComi.add(0);
				}
				else {
					int numeroTemp=Integer.parseInt(temporal[j]);
					cantComi.add(numeroTemp);	
				}
			}
		}
		return cantComi; 
	}

	
	public ArrayList<Integer> MasVendidosTipoPuesto(ArrayList<Integer> cantidadProductos) {
		ArrayList<Integer> totalOrdenado= new ArrayList<Integer>();
		for(int i=0;i<totalOrdenado.size();i++) {
			for(int j=0;j<totalOrdenado.size()-1;j++) {
				int elementoActu=totalOrdenado.get(j);
				int elmentoSig=totalOrdenado.get(j+1);
				if(elementoActu>elmentoSig) {
					totalOrdenado.add(0,elmentoSig);
					totalOrdenado.add(1,elementoActu);
				}
			}
		}
		System.out.println(totalOrdenado.toString());
		return totalOrdenado;
	}
}


