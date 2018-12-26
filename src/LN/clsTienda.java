package LN;

import java.util.ArrayList;

public class clsTienda 
{
	private String nombre; 
	private String NIF;
	private String correo;
	private String contrasenya;
	private String direccion;
	private ArrayList <clsProducto> productos;
	
	public clsTienda (String nombre, String NIF, String correo, String contrasenya, String direccion)
	{
		this.nombre=nombre;
		this.NIF=NIF;
		this.correo=correo;
		this.contrasenya=contrasenya;
		this.direccion=direccion; // cuando se le pida al usuario hay que pedir las cosas por separadoo y luego crear un string conjunto
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<clsProducto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<clsProducto> productos) {
		this.productos = productos;
	}
}
