package LN;

import java.util.ArrayList;

public class clsTienda 
{
	private String nombre; 
	private String CIF;
	private String correo;
	private String contrase�a;
	private String direccion;
	private ArrayList <clsProducto> productos;
	
	public clsTienda (String nombre, String CIF, String correo, String contrase�a)
	{
		this.nombre=nombre;
		this.CIF=CIF;
		this.correo=correo;
		this.contrase�a=contrase�a;
		
	}
}
