package LN;

public class clsProducto 
{
	private double precio;
	private String descripcion;
	private String marca;
	private long codigo;
	private clsTienda tienda;
	private boolean sexo;
	
	
	
	public  clsProducto (double precio, String descripcion, String marca, long codigo, clsTienda tienda, boolean sexo )
	{
		this.precio=precio;
		this.descripcion=descripcion;
		this.marca=marca;
		this.codigo=codigo;
		this.tienda=tienda;
		this.sexo=sexo;
	
		
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

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public clsTienda getTienda() {
		return tienda;
	}
	public void setTienda(clsTienda tienda) {
		this.tienda = tienda;
	}


	
}
