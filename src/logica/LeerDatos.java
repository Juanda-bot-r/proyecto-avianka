package logica;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LeerDatos {
public static String LeerString(String message) {
	String s=JOptionPane.showInputDialog(message);
	return s;
}
public static double leerDouble (String message) {
	double w= Double.parseDouble(JOptionPane.showInputDialog(message));
	return w;
}
public static int leerEntero (String message) {
	int z= Integer.parseInt(JOptionPane.showInputDialog(message));
	return z;
}
public static int[] leerArregloEnteros (String message, int tamanio) {
	
	int[] arreglo= new int [tamanio];
	for(int i =0; i<arreglo.length;i++) {
		int w= Integer.parseInt(JOptionPane.showInputDialog(message));
		arreglo[i]=w;
	}
	return arreglo;
}
public static double [] leerArregloDouble (String message, int tamanio) {
	double [] arregloDouble=new double [tamanio];
	for(int j=0; j<arregloDouble.length;j++) {
		double x= Double.parseDouble(JOptionPane.showInputDialog(message));
		arregloDouble[j]=x;
	}
	return arregloDouble;
}
public static char[] leerArreglochars (String message, int tamanio) {
	char [] arregloChars= new char[tamanio];
	for (int i=0; i<arregloChars.length;i++) {
		char x=DestringaChart(JOptionPane.showInputDialog(message));
		arregloChars[i]=x;
	}
	return arregloChars;
}
private static char DestringaChart(String showInputDialog) {
	char chart1= ' ';
	chart1=showInputDialog.charAt(0);
	return chart1;
}
public static String leerString(String message) {
	String mensage=JOptionPane.showInputDialog(message);
	return mensage;
}
public static ArrayList<String> leerArraylist(String message, int tamanio){
	ArrayList<String> datos=new ArrayList<>();
	for(int i=0;i<tamanio;i++) {
		datos.add(JOptionPane.showInputDialog(message));
	}
	return datos;
}
}
