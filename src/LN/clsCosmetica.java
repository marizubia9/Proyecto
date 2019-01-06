package LN;

public class clsCosmetica extends clsProducto
{
	private String tipo; 
	private int stock;
	
	
	public clsCosmetica(double precio, String descripcion, String marca, long codigo, clsTienda tienda, int stock, String zona, String tipo, boolean sexo)
	{
		super( precio,  descripcion,  marca,  codigo,  tienda, sexo);
		this.stock=stock;
		this.tipo=tipo;
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
