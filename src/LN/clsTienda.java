package LN;

import java.util.ArrayList;

public class clsTienda 
{
	private String nombre; 
	private String correo;


	private String contrasenya;
	private String direccion;
	private String Cod_postal;
	private String Localidad;
	private String Provincia;
	private String NIF;
	private ArrayList <clsProducto> productos;
	private long cod_producto;
	
	public clsTienda (String correo, String contrasenya, String nombre, String NIF, String direccion, String Cod_postal,String provincia, String Localidad, long cod_producto )
	{
		this.nombre=nombre;
		this.Cod_postal=Cod_postal;
		this.Localidad=Localidad;
		this.NIF=NIF;
		this.Provincia=provincia;
		this.correo=correo;
		this.contrasenya=contrasenya;
		this.direccion=direccion; 
		this.productos= new ArrayList <clsProducto>();
		this.cod_producto=cod_producto;
		
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getCod_postal() {
		return Cod_postal;
	}

	public void setCod_postal(String cod_postal) {
		Cod_postal = cod_postal;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public ArrayList<clsProducto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<clsProducto> productos) {
		this.productos = productos;
	}
	
	public void AgregarProducto(clsProducto producto)
	{
		this.productos.add(producto);
	}
	
	public long getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(long cod_producto)
	{
		this.cod_producto = cod_producto;
	}

}