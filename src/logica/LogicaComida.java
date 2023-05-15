package logica;

import java.util.ArrayList;
import java.util.Arrays;

public class LogicaComida {
	
	//X varialbe
	//total poducto alimenticio x cliente
	
	public static int productoxcliente(String[] productos,int pos) {
		int valor=(logicaProductos.partidora(productos, pos).length)/2;

		return valor;
	}
	
	
	//cliente mayor comprador clientes para total de todos los clients
	/*cliente mayor comprador tiene como parametros el arrayslist de clientes y la posicion
	 * en donde esta ubicado el string de comida,devuelve el valor mayor de compra
	 */
	public static String clientemayorcomprador(ArrayList<String[]> clientes,int pos) {
		int cont=0;
		String nombre="";
		String cent="";
		for(int i=0;i<clientes.size();i++) {
			String[] cliente=logicaProductos.devolvercadena(clientes,i);
			int valor=totalalimentos(cliente,pos);
			System.out.println(valor);
			if(valor>cont) {
				cont=valor;
				nombre=cliente[1];
			}
		}cent+=nombre;
		return cent;
		
	}
	
	
/**
 * total de alimentos por cliente
 * @param  recibe parametros el string del cliente y 
 * @param la posicion
 * en donde esta el string de comida
 * @return retorna el total de alimentos
 */
	public static int totalalimentos(String[] n,int pos){
		int cant=0;
		String[] valor=logicaProductos.partidora(n, pos);
		for(int i=0;i<valor.length;i++){
		if(logicaProductos.imPar(i)==true) {
			cant+=Integer.parseInt(valor[i]);
		}}
		return cant;
	}
	
	
/*sus parametros son la lista de completa de los clientes y la posicion del string de alimentos
 * y retorna un arreglo con el total de producto comprado por todos los clientes
 */
	public static int[] cantproductovendido(ArrayList<String[]> clientes,int pos) {
		String[] ranking= {"palomitas","gaseosa"};
		int[] vacia=new int[ranking.length];
		for(int i=0;i<clientes.size();i++) {
			String[] clie=clientes.get(i);
			ArrayList <Integer> cliente=logicaProductos.cantalimento(clie,pos);
			vacia=logicaProductos.sumarcadenasn(vacia, cliente);
			System.out.println(Arrays.toString(vacia));
		}
		return vacia;
	}
	
/*recibe el arraylist de clientes el arreglo de producto mas comprado y la poscision de la comida
 * va a mostrar los clientes que compraron el producto mas vendido
 * //listado de clientes por ubicacion de producto mas vendido
 */
	public static ArrayList<String> clienxprodvendido(ArrayList<String[]>clientes,String[]productomascomprado,int pos) {
		ArrayList<String>valor=new ArrayList<String>();
		String producto=productomascomprado[0];
		for(int i=0;i<clientes.size();i++) {
			String[] cliente = clientes.get(i);
			String[] cent=logicaProductos.compraxcliente(cliente,5);
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
 * @param ranking la cantidad de alimentos vendidos y su total incluidos los valores 0
 * @return lista de alimentos sin los valores de ceros, es decir, el total de alimentos vendidos
 */
	public static ArrayList<String> alimvendidos(String[]ranking) {
		ArrayList<String>valor=new ArrayList<String>();
		for(int i=0;i<ranking.length;i++) {
			if(logicaProductos.imPar(i)==false && Integer.parseInt(ranking[i-1])!=0) {
				valor.add(ranking[i-1]);
				valor.add(ranking[i]);
			}
		}
		return valor;
		

	}
/*se ingresa el arraylist de clientes y las pos de la comida y regresa el aarraylist de la comida
 * con su cant de producto vendido en total
 */
	public static ArrayList<String> ranking(ArrayList<String[]> clientes,int pos){
		ArrayList<String>valor=new ArrayList<String>();
		return valor;
		//regresa cadena con los numeros pares la cant y numeros impares el producto
}

//producto mas vendido y clientes que lo compraron 
}
