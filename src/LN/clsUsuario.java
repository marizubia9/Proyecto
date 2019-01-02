package LN;

import java.sql.Date;

public class clsUsuario 
{
	private String nombre;
	private String apellidos;
	private String direccion;
	private String correo;
	private int cod_postal;
	private String contrasenya;
	private String localidad; 
	private String provincia; 
	private Date FechaNac;
	private int NumPedido;
	
	public clsUsuario( String correo, String contrasenya,  String nombre, String apellidos, String direccion, int cod_postal, String provincia, String localidad, Date FechaNac)
	{
		this.nombre=nombre;
		this.cod_postal=cod_postal;
		this.apellidos=apellidos;
		this.direccion=direccion;
		this.correo=correo;
		this.localidad=localidad;
		this.provincia=provincia;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Date getFechaNac() {
		return FechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		FechaNac = fechaNac;
	}

	public int getNumPedido() {
		return NumPedido;
	}

	public void setNumPedido(int numPedido) {
		NumPedido = numPedido;
	}

}