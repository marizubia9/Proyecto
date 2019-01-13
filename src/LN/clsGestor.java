package LN;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Logger;

import LD.clsBaseDeDatos;


public class clsGestor {
	
	private static clsUsuario usuario;
	private static clsTienda tienda;
	private static  ArrayList<clsRopa> Ropa;
	private static  ArrayList<clsCosmetica> cosmeticos;
	private static boolean cumple;
	private static ArrayList <clsProducto>listaAnyadidos = new ArrayList <clsProducto>();
	



	private static ArrayList <String>tallas = new ArrayList <String>();
	private static ArrayList <Integer>unidades = new ArrayList <Integer>();
	
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
			cumple=cumpleaños();
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
					Ropa.add(ropa);
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
					cosmeticos.add(cosmetico);
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
		public static void ListaAnyadidos (clsProducto anyadido)
		{
			listaAnyadidos.add(anyadido);
		}
		
		/**
		 * Conseguimos ArrayList de tallas de los productos que el usuario ha ido añadiendo al carrito, que esta creado en esta clase, 
		 * para poder mantenerlo mientras que el usuario mantenga iniciada la sesion. Se añade la talla del producto que se le manda como parametro 
		 * desde la clase VerProducto1 cuando se pulsa el boton añadir al carrito. 
		 * @param talla
		 * @return ArrayList de tipo String
		 */
		public static void Tallas (String talla)
		{
			tallas.add(talla);
		}
		
		/**
		 * Conseguimos ArrayList de unidades de los productos que el usuario ha ido añadiendo al carrito, que esta creado en esta clase, 
		 * para poder mantenerlo mientras que el usuario mantenga iniciada la sesion. Se añade la talla del producto que se le manda como parametro 
		 * desde la clase VerProducto1 cuando se pulsa el boton añadir al carrito. 
		 * @param unidad
		 * @return ArrayList de tipo String
		 */
		public static void Unidades (int unidad)
		{
			unidades.add(unidad);
		}
		
		/**
		 *  Mediante este metodo por un lado, actualizamos nuestra BD, y además
		 * también actualizamos el arraylist que tenemos en gestor
		 * @param nombre
		 * @param marca
		 * @param material
		 * @param descripcion
		 * @param precio
		 * @param XS
		 * @param S
		 * @param M
		 * @param L
		 * @param XL
		 * @param tienda
		 * @param cod_producto
		 */
		public static void EditarRopa(String nombre, String marca, String material, String descripcion, double precio,
				int XS, int S, int M, int L, int XL, String img, String tienda, long cod_producto)
		{
			clsBaseDeDatos.EditarRopa(tienda, cod_producto, nombre, marca, material, descripcion, XS, S, M, L, XL, precio, img);
			
			for(clsRopa a: Ropa)
			{
				if(a.getCodigo()==cod_producto && a.getTienda().equals(tienda))
				{
					a.setNombre(nombre);
					a.setMarca(marca);
					a.setMaterial(material);
					a.setImg(img);
					a.setDescripcion(descripcion);
					a.setPrecio(precio);
					a.setStock_L(L);
					a.setStock_M(M);
					a.setStock_S(S);
					a.setStock_XL(XL);
					a.setStock_XS(XS);
				}
			}
		}
		
		/**
		 * Mediante este metodo por un lado, actualizamos nuestra BD, y además
		 * también actualizamos el arraylist que tenemos en gestor
		 * @param nombre
		 * @param marca
		 * @param descripcion
		 * @param precio
		 * @param stock
		 * @param tienda
		 * @param cod_producto
		 */
		public static void EditarCosmetico(String nombre, String marca,  String descripcion, double precio,
				int stock, String img, String tienda, long cod_producto)
		{
			clsBaseDeDatos.EditarCosmetica(tienda, cod_producto, nombre, marca,  descripcion, stock, precio ,img);
			
			for(clsCosmetica a: cosmeticos)
			{
				if(a.getCodigo()==cod_producto && a.getTienda().equals(tienda))
				{
					a.setNombre(nombre);
					a.setMarca(marca);
					a.setImg(img);
					a.setDescripcion(descripcion);
					a.setPrecio(precio);
					a.setStock(stock);
					
					
				}
			}
		}
		
		public static String NombreTienda(String correo)
		{
			
			return clsBaseDeDatos.NombreTIenda(correo);
		}
		
		
	/**
	 * Mediante este metodo, lo que hacemos es por un lado añadir a la BD, la compra realizada, 
	 * cambiar el número del pedido que tiene el usuario.
	 * y cambia el stock de cada producto cambiado.
	 */
		public static void AnyadirCompra()
		{
			Date a= new Date();
			String fecha=null;
			try{
				SimpleDateFormat forma= new SimpleDateFormat("dd/mm/YYYY hh:mm:ss");
				 fecha= forma.format(a);
				}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			for( int i=0; i<unidades.size();i++)
			{
				clsBaseDeDatos.AnyadirCompra(usuario.getCorreo(), usuario.getNumPedido(), listaAnyadidos.get(i).getTienda(),
						listaAnyadidos.get(i).getCodigo(), tallas.get(i), unidades.get(i), fecha);
				 
				usuario.setNumPedido(usuario.getNumPedido()+1);
				clsBaseDeDatos.EditarNumPedido(usuario.getCorreo(),usuario.getNumPedido()+1);
				
				if(listaAnyadidos.get(i) instanceof clsRopa)
				{
					if(tallas.get(i).toLowerCase().equals("xs"))
							{
							
							clsRopa ropa=(clsRopa)listaAnyadidos.get(i);
							int cantidad= ropa.getStock_XS()-unidades.get(i);
							clsBaseDeDatos.EditarStock(listaAnyadidos.get(i).getTienda(), listaAnyadidos.get(i).getCodigo(), cantidad, "xs");
						
							}
					if(tallas.get(i).toLowerCase().equals("s"))
							{
						clsRopa ropa=(clsRopa)listaAnyadidos.get(i);
						int cantidad= ropa.getStock_S()-unidades.get(i);
						clsBaseDeDatos.EditarStock(listaAnyadidos.get(i).getTienda(), listaAnyadidos.get(i).getCodigo(), cantidad, "s");
							}
					if(tallas.get(i).toLowerCase().equals("m"))
							{
						clsRopa ropa=(clsRopa)listaAnyadidos.get(i);
						int cantidad= ropa.getStock_M()-unidades.get(i);
						clsBaseDeDatos.EditarStock(listaAnyadidos.get(i).getTienda(), listaAnyadidos.get(i).getCodigo(), cantidad, "m");
							}
					if(tallas.get(i).toLowerCase().equals("l"))
							{
						clsRopa ropa=(clsRopa)listaAnyadidos.get(i);
						int cantidad= ropa.getStock_L()-unidades.get(i);
						clsBaseDeDatos.EditarStock(listaAnyadidos.get(i).getTienda(), listaAnyadidos.get(i).getCodigo(), cantidad, "l");
							}
					if(tallas.get(i).toLowerCase().equals("xl"))
							{
						clsRopa ropa=(clsRopa)listaAnyadidos.get(i);
						int cantidad= ropa.getStock_XL()-unidades.get(i);
						clsBaseDeDatos.EditarStock(listaAnyadidos.get(i).getTienda(), listaAnyadidos.get(i).getCodigo(), cantidad, "xl");
							}
				}
				if(listaAnyadidos.get(i) instanceof clsCosmetica)
				{
					clsCosmetica cosmetica=(clsCosmetica)listaAnyadidos.get(i);
					int cantidad= cosmetica.getStock()-unidades.get(i);
					clsBaseDeDatos.EditarStock(listaAnyadidos.get(i).getTienda(), listaAnyadidos.get(i).getCodigo(), cantidad, "stock");
				}
				
				
			}
			
		
		}
		
		public static boolean cumpleaños()
		{
			
			Date a= new Date();
			Date fecha_nac= usuario.getFechaNac();
			
			
			
			String hoy=null;
			String nacimiento=null;
			try{
				SimpleDateFormat forma= new SimpleDateFormat("dd/MM");
				 hoy= forma.format(a);
				 nacimiento=forma.format(fecha_nac);

				 if (hoy.equals(nacimiento)) return true;
				}
			catch(Exception ex)
			{
				ex.printStackTrace();
				
			}
	
			return false;
		}
		
		public static void VaciarArrays()
		{
			listaAnyadidos.clear();
			tallas.clear();
			unidades.clear();
			
		}
		public static ArrayList<clsProducto> OrdenarNombre(ArrayList<clsProducto> productos)
		{
			 Collections.sort(productos);
			 return productos;
		}
		
		public static ArrayList<clsProducto> OrdenarPrecio(ArrayList<clsProducto> productos)
		{
			 Collections.sort(productos, new OrdenarPrecios());
			 return productos;
		}
		

		public static ArrayList<clsProducto> getListaAnyadidos() 
		{
			return listaAnyadidos;
		}

		public static void setListaAnyadidos(ArrayList<clsProducto> listaAnyadidos) 
		{
			clsGestor.listaAnyadidos = listaAnyadidos;
		}

		public static ArrayList<String> getTallas() {
			return tallas;
		}

		public static void setTallas(ArrayList<String> tallas) {
			clsGestor.tallas = tallas;
		}

		public static ArrayList<Integer> getUnidades() {
			return unidades;
		}

		public static void setUnidades(ArrayList<Integer> unidades) {
			clsGestor.unidades = unidades;
		}

}

