package LN;

public class clsCosmetica extends clsProducto
{
	private String zona;
	private String tipo; 
	private int stock;
	
	
	public clsCosmetica(double precio, String descripcion, String marca, String codigo, clsTienda tienda, int stock, String zona, String tipo)
	{
		super( precio,  descripcion,  marca,  codigo,  tienda);
		this.stock=stock;
		this.zona=zona;
		this.tipo=tipo;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
