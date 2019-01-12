package LN;

public class clsRopa extends clsProducto
{
	
	private String tipo;
	private String material; 
	private int stock_XS;
	private int stock_S;
	private int stock_M;
	private int stock_L;
	private int stock_XL;
	
	public clsRopa(String nombre, double precio, String descripcion, String marca, long codigo,
			String tienda,  String tipo, String material,int stock_XS, int stock_S, 
			int stock_M, int stock_L,int stock_XL , boolean sexo, String img)
	{
		super( nombre, precio,  descripcion,  marca,  codigo,  tienda, sexo, img);
		this.material=material;
		this.tipo=tipo;
		this.stock_XS=stock_XS;
		this.stock_S=stock_S;
		this.stock_M=stock_M;
		this.stock_L=stock_L;
		this.stock_XL=stock_XL;
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
	public int getStock_XS() {
		return stock_XS;
	}

	public void setStock_XS(int stock_XS) {
		this.stock_XS = stock_XS;
	}

	public int getStock_S() {
		return stock_S;
	}

	public void setStock_S(int stock_S) {
		this.stock_S = stock_S;
	}

	public int getStock_M() {
		return stock_M;
	}

	public void setStock_M(int stock_M) {
		this.stock_M = stock_M;
	}

	public int getStock_L() {
		return stock_L;
	}

	public void setStock_L(int stock_L) {
		this.stock_L = stock_L;
	}

	public int getStock_XL() {
		return stock_XL;
	}

	public void setStock_XL(int stock_XL) {
		this.stock_XL = stock_XL;
	}

	@Override
	public String toString() {
		return "clsRopa [tipo=" + tipo + ", material=" + material
				+ ", stock_XS=" + stock_XS + ", stock_S=" + stock_S
				+ ", stock_M=" + stock_M + ", stock_L=" + stock_L
				+ ", stock_XL=" + stock_XL + "]";
	}
	
	
	
	
}
