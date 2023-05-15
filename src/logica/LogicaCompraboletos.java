package logica;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

public class LogicaCompraboletos {
	public static String devolerNombre(ArrayList<String> nombres, int posicion) {
		String nombre="";
		for(int i=0;i<nombres.size();i++) {
			if(i==posicion) {
				nombre=nombres.get(i);
			}
		}
		return nombre;
	}

	public String TipoSilla(int numero, JButton matriz[][]){
		String TipoSilla="";
		if(numero==1 && matriz!=null ) {
			TipoSilla="preferencial";
		}
		else {
			TipoSilla="normal";
		}
		if(TipoSilla.equals("normal")) {
			for(int i=0;i<matriz.length;i++) {
				for(int j=0;j<matriz[i].length;j++) {
					if( matriz[i][j]!=null && matriz[i][j].getBackground().equals(Color.cyan)) {
						TipoSilla=TipoSilla+" "+"ventana";
					}
					else {
						if(matriz[i][j]!=null && matriz[i][j].getBackground().equals(Color.green)) {
							TipoSilla= TipoSilla+" "+"centro";
						}
						else {
							TipoSilla= TipoSilla+" "+" Pasillo";
						}
					}
				}
			}	
		}
		
		return TipoSilla;
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

	public static String[] agregarData(String id, String nombre, String direccion, String fechaNacimiento, String contactosEmergencia) {
		String[] arregloCliente = {id, nombre,direccion, fechaNacimiento, contactosEmergencia, "", "", ""};
		return arregloCliente;
	}
	
		
}
