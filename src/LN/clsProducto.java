package LN;

public class clsProducto implements Comparable<clsProducto>
{


	private double precio;
	private String descripcion;
	private String nombre;
	private String marca;
	private long codigo;
	private String tienda;
	private boolean sexo;
	private String img;
	
	
	
	public  clsProducto (String nombre, double precio, String descripcion, String marca, long codigo, String tienda, boolean sexo, String img )
	{
		this.precio=precio;
		this.descripcion=descripcion;
		this.marca=marca;
		this.codigo=codigo;
		this.tienda=tienda;
		this.sexo=sexo;
		this.img=img;
		this.nombre=nombre;
	
		
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

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "clsProducto [precio=" + precio + ", descripcion=" + descripcion
				+ ", nombre=" + nombre + ", marca=" + marca + ", codigo="
				+ codigo + ", tienda=" + tienda + ", sexo=" + sexo + ", img="
				+ img + "]";
	}

	@Override
	public int compareTo(clsProducto prd1)
	{
	
		return	this.getNombre().compareTo(prd1.getNombre());
		
		 
	}

	
}
