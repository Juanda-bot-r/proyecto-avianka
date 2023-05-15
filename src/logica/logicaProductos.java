package logica;

import java.util.ArrayList;

public class logicaProductos {
	//funcion para partir arreglos
	public static String[] partidora(String[] n,int pos) {
		String[] valor=n[pos].split("-");
		return valor;
	
	}
	public static String[] partidorasigno(String[] n,int pos) {
		String[] valor=n[pos].split("-");
		return valor;
		}

	public static boolean imPar(int n){
		boolean valor=true;
		if((n & 1)==0){
			
		}
		else{
			valor=false;}
		return valor;
	}
	public static String[] devolvercadena(ArrayList<String[]> n,int pos){
		String[] valor=n.get(pos);
		return valor;
	}
	public static int sumacant(String[] n,int pos) {
		int valor=0;
		for(int i=0;i<n.length;i++){
			if(imPar(i)==true) {
				valor+=Integer.parseInt(n[i]);
			}}
		return valor;
	}
	public static int sumacant2(String[] n,int pos) {
		int valor=0;
			if(imPar(pos)==true) {
				valor+=Integer.parseInt(n[pos]);
				System.out.println(valor);
			}
		return valor;
	}
	public static String[] productos(ArrayList<String[]>n,int pos) {
		String[] compraxcliente=new String[4];
		for(int i=0;i<n.size();i++){
			compraxcliente=partidora(n.get(i), pos);}
			return compraxcliente;
	}
	public static ArrayList<Integer> cantidaddecomida(ArrayList<String[]> clientes,int pos) {
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
	public static ArrayList<Integer> cantalimento(String[]n,int pos){
		ArrayList<Integer> valor= new ArrayList<Integer>();
		String[] cliente=compraxcliente(n,pos);
		for(int i=0;i<cliente.length;i++) {
			if(imPar(i)) {
				valor.add(Integer.parseInt(cliente[i]));
			}
		}
		return valor;
	}
	public static String[] compraxcliente(String[] n,int pos) {
		String[] cent=partidora(n,pos);
		return cent;
		
	}
	public static int[] sumarcadenasn(int[] vacia,ArrayList<Integer>llenar) {
		int[] valor=new int[vacia.length];
		for(int i=0;i<vacia.length;i++) {
			valor[i]=vacia[i]+llenar.get(i);
		}
		return valor;
	}
	public static ArrayList<String> intercalar(String[] COmida,String[] ranking){
		ArrayList <String> valor=new ArrayList<String>();
		for(int i=0;i<(COmida.length+ranking.length);i++){
			if(imPar(i)) {
				valor.add(COmida[i]);
			}else {
				valor.add(ranking[i]);
			}
			System.out.println(valor);
		}
		return valor;
	}
	public static int[] ordenar(int[] n) {
		int[] arregloOrdenado=n.clone();
		int[] arregloPos=new int[n.length];
		for(int i=0;i<n.length;i++) {
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
		}int[] arregloP=new int[n.length];
		for(int i=0;i<arregloP.length;i++) {
			arregloP[arregloPos[i]]=i;
		}
		return arregloP;}
		
	}

