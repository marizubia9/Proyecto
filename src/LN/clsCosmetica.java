package LN;

public class clsCosmetica extends clsProducto
{
	private String zona;
	private String tipo; 
	
	public clsCosmetica(double precio, String descripcion, String marca, String codigo, clsTienda tienda, int stock, String zona, String tipo)
	{
		super( precio,  descripcion,  marca,  codigo,  tienda,  stock);
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
	
	
}
