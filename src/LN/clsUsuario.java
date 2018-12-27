package LN;

import java.sql.Date;

public class clsUsuario 
{
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String correo;
	private String contrasenya;
	private String direccion; 
	private Date FechaNac;
	private int NumPedido;
	
	public clsUsuario(String nombre, String apellido1, String apellido2, String correo, String contrasenya, Date FechaNac)
	{
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.correo=correo;
		this.contrasenya=contrasenya;
		this.FechaNac=FechaNac;
		this.NumPedido=0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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
}
