package LN;

public class clsProducto 
{
	private double precio;
	private String descripcion;
	private String marca;
	private String codigo;
	private clsTienda tienda;
	
	
	
	public  clsProducto (double precio, String descripcion, String marca, String codigo, clsTienda tienda )
	{
		this.precio=precio;
		this.descripcion=descripcion;
		this.marca=marca;
		this.codigo=codigo;
		this.tienda=tienda;
	
		
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public clsTienda getTienda() {
		return tienda;
	}
	public void setTienda(clsTienda tienda) {
		this.tienda = tienda;
	}


	
}
