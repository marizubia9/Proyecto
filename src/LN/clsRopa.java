package LN;

public class clsRopa extends clsProducto
{
	
	private String tipo;
	private String material; 
	
	public clsRopa(double precio, String descripcion, String marca, String codigo, clsTienda tienda, int stock,  String tipo, String material)
	{
		super( precio,  descripcion,  marca,  codigo,  tienda,  stock);
		this.material=material;
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
}
