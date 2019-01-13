package LN;


import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import LD.clsBaseDeDatos;


public class clsGestor {
	
	private clsUsuario usuario;
	private static clsTienda tienda;
	private  ArrayList<clsRopa> Ropa;
	private  ArrayList<clsCosmetica> cosmeticos;
	
	private static ArrayList <clsProducto>listaAnyadidos = new ArrayList <clsProducto>();
	private static ArrayList <String>tallas = new ArrayList <String>();
	private static ArrayList <String>unidades = new ArrayList <String>();
	
	/**
	 * Este constructor se usará cuando el usuario que ha 
	 * inicie sesión o se registre un usuario
	 * @param correo
	 * @param e: nos indicará is es una tienda o un usuario
	 */
	public clsGestor(String correo, char e)
	{
	
		if(e=='u')
		{
			this.usuario=ObtenerUsuario(correo);
			Ropa=Ropa();
			cosmeticos=Cosmeticos();
		}
		
		if (e=='t')
		{
			this.tienda=ObtenerTienda(correo);
			Ropa=RopaTienda();
			cosmeticos=CosmeticosTienda();
		}
		
	}
	
	/**
	 * Este constructor se usará cuando se registren, ya que el arraylist 
	 * de los productos de la tienda estará vacio
	 * @param correo
	 * @param usuario_tienda
	 */
	public clsGestor(String correo)
	{
		Ropa= new <clsRopa>ArrayList();
		cosmeticos=new <clsRopa>ArrayList();
		this.tienda=ObtenerTienda(correo);
			
		
		
	}
	
	

	
	// Logger de la clase
		private static Logger logger = Logger.getLogger( clsGestor.class.getName() );
	
		public static void creartablas ()
		{
		
			clsBaseDeDatos.initBD();
			clsBaseDeDatos.crearTablaTienda();
			clsBaseDeDatos.crearTablaRopaBD();
			clsBaseDeDatos.crearTablaCosmeticaBD();
			clsBaseDeDatos.crearTablaUsuarioBD();
			clsBaseDeDatos.crearTablaComprasBD();
		}
		
		/**
	 * se comprueba si existe el correo introducido para iniciar sesión.
	 * En función de lo que devuelva se sabrá si es una tienda, un usuario o si no existe
	 * @param correo
	 * @param contrasenya
	 * @return u: existe el usuario
	 * @return t: existe la tienda
	 * @return 0: no existen tales datos dados de alta en la bd
	 */
		public static char Existe (String correo, String contrasenya)
		{
			char existe= clsBaseDeDatos.existe(correo, contrasenya);
			return existe;
		}

	
		/**
		 * Mediante este metodo contacto con la BD, para crear un nuevo usuario y ahi mismo
		 * comprobar si existe ya uno dado de alta con el mismo @param correo
		 * @param correo: UNICO
		 * @param contrasenya
		 * @param nombre
		 * @param NIF
		 * @param direccion
		 * @param cod_postal
		 * @param provincia
		 * @param Localidad
		 * @return BOOLEAN : SI SE HA CREADO --> TRUE Y si no, FALSE. 
		 */
		public static boolean CrearUsuario (String correo, String contrasenya, String nombre, String apellidos, 
											String direccion, String cod_postal, String provincia, String Localidad, Date FechaNac, String Fec_Nac)
		{
			//Comprobar que no exista el email
			
			boolean nadie= clsBaseDeDatos.Nadie(correo);
		
			
			if( nadie)
			{
				boolean anyadido=clsBaseDeDatos.AnyadirUsuario( correo,  contrasenya,  nombre,  apellidos,  direccion,cod_postal, provincia, Localidad, Fec_Nac);
				if(anyadido)
				{
					clsUsuario nuevoUsuario = new clsUsuario( correo,  contrasenya,  nombre,  apellidos,  direccion,cod_postal, provincia, Localidad, FechaNac,0);
				}
				 
				return anyadido;
				
			}
			return false;
			
			
		}
		
		
		/**
		 * Despues de comprobar que existe ese usuario, vamos a hacer uso de este metodo
		 * para obtener el usuario exacto, ya que luego durante el programa tendremos que hacer
		 * uso, de más atributos de este
		 * @param correo. UNICO PARA CADA UNO
		 * @return el usuario
		 */
		public static clsUsuario ObtenerUsuario(String correo)
		{
			 clsUsuario usuario= clsBaseDeDatos.usuario(correo);
			 return usuario;
		}

		
		/**
		 * Mediante este metodo contacto con la BD, para crear una tienda y ahi mismo
		 * comprobar si existe ya uno dado de alta con el mismo @param correo
		 * @param correo: UNICO
		 * @param contrasenya
		 * @param nombre
		 * @param NIF
		 * @param direccion
		 * @param cod_postal
		 * @param provincia
		 * @param Localidad
		 * @return BOOLEAN : SI SE HA CREADO --> TRUE Y si no, FALSE. 
		 */
		public static boolean CrearTienda (String correo, String contrasenya, String nombre, String NIF, 
				String direccion, String cod_postal, String provincia, String Localidad)
			{
			//Comprobar que no exista el email
			
			
					
				if(clsBaseDeDatos.Nadie(correo))
					{
					boolean anyadido=clsBaseDeDatos.AnyadirTienda( correo,  contrasenya,  nombre,  NIF,  direccion,cod_postal, provincia, Localidad);
					if(anyadido)
					{
					clsTienda nuevaTienda = new clsTienda( correo,  contrasenya,  nombre,  NIF,  direccion,cod_postal, provincia, Localidad,0);
				
					}
					
					return anyadido;
					
					
					}
				return false;
			}
			
		
		
		
		/**
		 * Despues de comprobar que existe ese usuario, vamos a hacer uso de este metodo
		 * para obtener latienda  exacto, ya que luego durante el programa tendremos que hacer
		 * uso, de más atributos de este
		 * @param correo. UNICO PARA CADA UNO
		 * @return el usuario
		 */
		public static clsTienda ObtenerTienda(String correo)
		{
			 clsTienda tienda= clsBaseDeDatos.tienda(correo);
			 return tienda;
		}


		public static boolean CrearRopa (String nombre, String marca, double precio, String material,int XS, int S, 
				int M, int L,int XL , boolean sexo, String img, String tipo, String descripcion )
			{
			
				
				long codigo=tienda.getCod_producto()+1;
				String correo_tienda=tienda.getCorreo();
				int sexo_sql;
				if(sexo)sexo_sql=1;
				else sexo_sql=0;
				
			
				
				if(clsBaseDeDatos.AnyadirRopa(nombre, precio, descripcion, marca, codigo, correo_tienda, tipo, img, sexo_sql, XS, S, M, L, XL, material))
				{
					clsRopa ropa= new clsRopa(nombre, precio, descripcion, marca, codigo, correo_tienda, tipo, material, XS,S,M,L,XL,sexo,img);
					tienda.AgregarProducto(ropa);
					tienda.setCod_producto(codigo);
					clsBaseDeDatos.EditarCodigo(codigo, correo_tienda);
					return true;
					
				}
	
				
			return false;
			}
		
		public static boolean CrearCosmetico (String nombre, String marca, double precio, int stock
											, boolean sexo, String img, String tipo, String descripcion )
			{
			
				long codigo=tienda.getCod_producto()+1;
				String correo_tienda=tienda.getCorreo();
				int sexo_sql;
				if(sexo)sexo_sql=1;
				else sexo_sql=0;
				
				if(clsBaseDeDatos.AnyadirCosmetico(nombre, precio, descripcion, marca, codigo, correo_tienda, tipo, img, sexo_sql, stock))
				{
					clsCosmetica cosmetico= new clsCosmetica(nombre, precio, descripcion, marca, codigo, correo_tienda, stock,tipo, sexo,img);
			
					tienda.AgregarProducto(cosmetico);
					tienda.setCod_producto(codigo);
					clsBaseDeDatos.EditarCodigo(codigo, correo_tienda);
					return true;
					
				}
	
				
			return false;
			}
			
			/**
			 * Llama al metodo de la BD para recoger el arraylist de todos los productos de ropa
			 * de la tienda.
			 * @return arraylist de clsRopa
			 */
			public static ArrayList<clsRopa>RopaTienda ()
			{
				 ArrayList<clsRopa> ropatienda = new ArrayList<clsRopa>();
				 ropatienda= clsBaseDeDatos.RopaTienda(tienda.getCorreo());
				 
				 return ropatienda;
			}
			
			/**
			 * Llama al metodo de la BD para recoger el arraylist de todos los productos de ropa
			 * de la tienda.
			 * @return arraylist de clsRopa
			 */
			public static ArrayList<clsCosmetica>CosmeticosTienda ()
			{
				 ArrayList<clsCosmetica> CosmeticosTienda = new ArrayList<clsCosmetica>();
				 CosmeticosTienda= clsBaseDeDatos.CosmeticaTienda(tienda.getCorreo());
				 
				 return CosmeticosTienda;
			}
			
		
		
		/**
		 * Llama al metodo de la BD para recoger el arraylist de todos los productos de ropa.
		 * @return arraylist de clsRopa
		 */
		public static  ArrayList<clsRopa> Ropa ()
		{
			 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
			 ropa= clsBaseDeDatos.Ropa();
			 
			 return ropa;
		}

		
		/**
		 * Llama al metodo de la BD para recoger el arraylist de clsCosmetica.
		 * @return arraylist de clsCosmetica
		 */
		public static  ArrayList<clsCosmetica> Cosmeticos ()
		{
			 ArrayList<clsCosmetica> Cosmeticos = new ArrayList<clsCosmetica>();
			 Cosmeticos= clsBaseDeDatos.Cosmetica();
			 return Cosmeticos;
		}
		

		
		/**
		 * COnseguimos el arraylist de los chaquetas de hombre
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo las chaqueta)
		 */
		public  ArrayList<clsRopa> chaqueta_H ()
			{
				
				ArrayList<clsRopa> chaqueta_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("chaqueta"))
						 {
							 chaqueta_H.add(a);
						 }
					 }
				 }
				 
				 
				 return chaqueta_H;
			}
		
		/**
		 * COnseguimos el arraylist de los abrigos de hombre
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo los abrigos)
		 */
		public  ArrayList<clsRopa> Abrigo_H ()
			{
				 
				ArrayList<clsRopa> Abrigo_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("abrigo"))
						 {
							 Abrigo_H.add(a);
						 }
					 }
				 }
				 
				 
				 return Abrigo_H;
			}
		

		/**
		 * COnseguimos el arraylist de las camisas de hombre
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo las camisas)
		 */
		public  ArrayList<clsRopa> camisa_H ()
			{
				 
				ArrayList<clsRopa> camisa_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("camisa"))
						 {
							 camisa_H.add(a);
						 }
					 }
				 }
				 
				 
				 return camisa_H;
			}
		
		/**
		 * COnseguimos el arraylist de las camisas de hombre
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo las camisas)
		 */
		public  ArrayList<clsRopa> camiseta_H ()
			{
				 
				ArrayList<clsRopa> camiseta_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("camiseta"))
						 {
							 camiseta_H.add(a);
						 }
					 }
				 }
				 
				 
				 return camiseta_H;
			}
		/**
		 * COnseguimos el arraylist de las camisetas de mujer
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo las camisas)
		 */
		public  ArrayList<clsRopa> camiseta_M ()
			{
				 
				ArrayList<clsRopa> camiseta_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if ((a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("camiseta"))
						 {
							 camiseta_H.add(a);
						 }
					 }
				 }
				 
				 
				 return camiseta_H;
			}
		

		/**
		 * COnseguimos el arraylist de los pantalones de hombre
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo los pantalones)
		 */
		public   ArrayList<clsRopa> pantalon_H ()
			{
				
				ArrayList<clsRopa> pantalon_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("pantalon"))
						 {
							 pantalon_H.add(a);
						 }
					 }
				 }
				 
				 
				 return pantalon_H;
			}
		

		
		/**
		 * COnseguimos el arraylist de las faldas
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo las faldas)
		 */
		public   ArrayList<clsRopa> falda_M ()
			{
				 
				ArrayList<clsRopa> falda_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("falda"))
						 {
							 falda_M.add(a);
						 }
					 }
				 }
				 
				 
				 return falda_M;
			}
		

		
		/**
		 * COnseguimos el arraylist de los chaquetas de mujer
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo las chaqueta)
		 */
		public   ArrayList<clsRopa> chaqueta_M ()
			{
				 
				ArrayList<clsRopa> chaqueta_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("chaqueta"))
						 {
							 chaqueta_M.add(a);
						 }
					 }
				 }
				 
				 
				 return chaqueta_M;
			}
		
		/**
		 * COnseguimos el arraylist de las abrigos de mujer
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo los abrigos)
		 */
		public   ArrayList<clsRopa> Abrigo_M ()
			{
				
				ArrayList<clsRopa> abrigo_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (a.isSexo())
					 {
						 if(a.getTipo().toLowerCase().equals("abrigo"))
						 {
							 abrigo_M.add(a);
						 }
					 }
				 }
				 
				 
				 return abrigo_M;
			}
		
		/**
		 * COnseguimos el arraylist de los vestidos o monos
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo los vestidos)
		 */
		public   ArrayList<clsRopa> vestido_M ()
			{
				 
				ArrayList<clsRopa> vestido_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("vestido"))
						 {
							 vestido_M.add(a);
						 }
					 }
				 }
				 
				 
				 return vestido_M;
			}

		/**
		 * COnseguimos el arraylist de las camisas o blusas de mujer
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo las camisas)
		 */
		public   ArrayList<clsRopa> camisa_M ()
			{
				
				ArrayList<clsRopa> camisa_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("camisa"))
						 {
							 camisa_M.add(a);
						 }
					 }
				 }
				 
				 
				 return camisa_M;
			}
		

		/**
		 * COnseguimos el arraylist de los pantalones de mujer
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo los pantalones)
		 */
		public   ArrayList<clsRopa> pantalon_M ()
			{
				 
				ArrayList<clsRopa> pantalon_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: Ropa)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("pantalon"))
						 {
							 pantalon_M.add(a);
						 }
					 }
				 }
				 
				 
				 return pantalon_M;
			}


		/**
		 * COnseguimos el arraylist de los productos de cuidado de piel para la mujer
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsCosmetica
		 */
		public   ArrayList<clsCosmetica> Piel_M ()
			{
			
				ArrayList<clsCosmetica> Piel_M = new ArrayList<clsCosmetica>();
	
				 for( clsCosmetica a: cosmeticos)
				 {
					 if (a.isSexo())
					 {	
						 if(a.getTipo().toLowerCase().equals("piel"))
						 {
							 Piel_M.add(a);
						 }
					 }
				 }
				 
				 
				 return Piel_M;
			}


		/**
		 * COnseguimos el arraylist de los perfume de mujer
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsCosmetica
		 */
		public   ArrayList<clsCosmetica> Perfume_M ()
			{
				 
				ArrayList<clsCosmetica> Perfume_M = new ArrayList<clsCosmetica>();
				
				 for( clsCosmetica a: cosmeticos)
				 {
					 if (a.isSexo())
					 {
						 if(a.getTipo().toLowerCase().equals("perfume"))
						 {
							 Perfume_M.add(a);
						 }
					 }
				 }
				 
				 
				 return Perfume_M;
			}
		
		/**
		 * COnseguimos el arraylist de los productos de maquillaje de mujer
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsCosmetica
		 */
		public   ArrayList<clsCosmetica> Maquillaje_M ()
			{
				 
				ArrayList<clsCosmetica> Maquillaje_M = new ArrayList<clsCosmetica>();
				
				
				 for( clsCosmetica a: cosmeticos)
				 {
					 
					 if (a.isSexo())
					 {
						 if(a.getTipo().toLowerCase().equals("maquillaje"))
						 {
							 Maquillaje_M.add(a);
							
						 }
					 }
				 }
				 
				
				 return Maquillaje_M;
				
				 
			}
		
		/**
		 * COnseguimos el arraylist de los productos de maquillaje de hombre
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsCosmetica
		 */
		public ArrayList<clsCosmetica> Maquillaje_H ()
			{
				 
				ArrayList<clsCosmetica> Maquillaje_H = new ArrayList<clsCosmetica>();
				
				 for( clsCosmetica a: cosmeticos)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("maquillaje"))
						 {
							 Maquillaje_H.add(a);
						 }
					 }
				 }
				 
				 
				 return Maquillaje_H;
			}
		
		/**
		 * COnseguimos el arraylist de los productos de cuidado de la piel de hombre
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsCosmetica
		 */
		public   ArrayList<clsCosmetica> Piel_H ()
			{
				 
				ArrayList<clsCosmetica> Piel_H = new ArrayList<clsCosmetica>();
				
				 for( clsCosmetica a: cosmeticos)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("piel"))
						 {
							 Piel_H.add(a);
						 }
					 }
				 }
				 
				 
				 return Piel_H;
			}
		
		/**
		 * COnseguimos el arraylist de los perfumes de hombre
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsCosmetica
		 */
		public   ArrayList<clsCosmetica> Perfume_H ()
			{
				
				ArrayList<clsCosmetica> Perfume_H = new ArrayList<clsCosmetica>();
				
				 for( clsCosmetica a: cosmeticos)
				 {
					 if (!(a.isSexo()))
					 {
						 if(a.getTipo().toLowerCase().equals("perfume"))
						 {
							 Perfume_H.add(a);
						 }
					 }
				 }
				 
				 
				 return Perfume_H;
			}
		
		/**
		 * Conseguimos ArrayList de productos de los productos que el usuario ha ido añadiendo al carrito, que esta creado en esta clase, 
		 * para poder mantenerlo mientras que el usuario mantenga iniciada la sesion. Se añade el producto que se le manda como parametro 
		 * desde la clase VerProducto1 cuando se pulsa el boton añadir al carrito. 
		 * @param anyadido
		 * @return ArrayList de tipo clsProducto
		 */
		public static  ArrayList<clsProducto>ListaAnyadidos (clsProducto anyadido)
		{
			listaAnyadidos.add(anyadido);
			return listaAnyadidos;
		}
		
		/**
		 * Conseguimos ArrayList de tallas de los productos que el usuario ha ido añadiendo al carrito, que esta creado en esta clase, 
		 * para poder mantenerlo mientras que el usuario mantenga iniciada la sesion. Se añade la talla del producto que se le manda como parametro 
		 * desde la clase VerProducto1 cuando se pulsa el boton añadir al carrito. 
		 * @param talla
		 * @return ArrayList de tipo String
		 */
		public static ArrayList <String> Tallas (String talla)
		{
			tallas.add(talla);
			return tallas;
		}
		
		/**
		 * Conseguimos ArrayList de unidades de los productos que el usuario ha ido añadiendo al carrito, que esta creado en esta clase, 
		 * para poder mantenerlo mientras que el usuario mantenga iniciada la sesion. Se añade la talla del producto que se le manda como parametro 
		 * desde la clase VerProducto1 cuando se pulsa el boton añadir al carrito. 
		 * @param unidad
		 * @return ArrayList de tipo String
		 */
		public static ArrayList <String> Unidades (String unidad)
		{
			unidades.add(unidad);
			return unidades;
		}
			
}

