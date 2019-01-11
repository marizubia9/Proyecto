package LN;


import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import LD.clsBaseDeDatos;


public class clsGestor {

	
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
			
			boolean anyadido=clsBaseDeDatos.AnyadirUsuario( correo,  contrasenya,  nombre,  apellidos,  direccion,cod_postal, provincia, Localidad, Fec_Nac);
			if(anyadido)
			{
				clsUsuario nuevoUsuario = new clsUsuario( correo,  contrasenya,  nombre,  apellidos,  direccion,cod_postal, provincia, Localidad, FechaNac,0);
			}
			 
			return anyadido;
			
			
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
			
			boolean anyadido=clsBaseDeDatos.AnyadirTienda( correo,  contrasenya,  nombre,  NIF,  direccion,cod_postal, provincia, Localidad);
			if(anyadido)
			{
			clsTienda nuevaTienda = new clsTienda( correo,  contrasenya,  nombre,  NIF,  direccion,cod_postal, provincia, Localidad,0);
			DevolverTienda(nuevaTienda);
			}
			
			return anyadido;
			
			
			}
		
		public static clsTienda DevolverTienda (clsTienda tienda)
		{
			return tienda;
		}
		
		/**
		 * Despues de comprobar que existe ese usuario, vamos a hacer uso de este metodo
		 * para obtener el usuario exacto, ya que luego durante el programa tendremos que hacer
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
				int M, int L,int XL , boolean sexo, String img, String tipo, String descripcion, clsTienda tienda )
			{
			
				long codigo=tienda.getCod_producto()+1;
				String correo_tienda=tienda.getCorreo();
			
				
				if(clsBaseDeDatos.AnyadirRopa(nombre, precio, descripcion, marca, codigo, correo_tienda, tipo, img, sexo, XS, S, M, L, XL, material))
				{
					clsRopa ropa= new clsRopa(nombre, precio, descripcion, marca, codigo, correo_tienda, tipo, material, XS,S,M,L,XL,sexo,img);
					tienda.AgregarProducto(ropa);
					tienda.setCod_producto(codigo);
					clsBaseDeDatos.EditarCodigo(codigo, correo_tienda);
					return true;
					
				}
	
				
			return false;
			
			
			
			
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
		public static  ArrayList<clsRopa> chaqueta_H ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> chaqueta_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
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
		public static  ArrayList<clsRopa> Abrigo_H ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> Abrigo_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
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
		public static  ArrayList<clsRopa> camisa_H ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> camisa_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
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
		 * COnseguimos el arraylist de los pantalones de hombre
		 * filtrandolo mediante el tipo de ropa
		 * @return arraylist de tipo clsRopa (solo los pantalones)
		 */
		public static  ArrayList<clsRopa> pantalon_H ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> pantalon_H = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
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
		public static  ArrayList<clsRopa> falda_M ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> falda_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
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
		public static  ArrayList<clsRopa> chaqueta_M ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> chaqueta_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
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
		public static  ArrayList<clsRopa> Abrigo_M ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> abrigo_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
				 {
					 if (!(a.isSexo()))
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
		public static  ArrayList<clsRopa> vestido_M ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> vestido_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
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
		public static  ArrayList<clsRopa> camisa_M ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> camisa_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
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
		public static  ArrayList<clsRopa> pantalon_M ()
			{
				 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
				 ropa= Ropa();
				ArrayList<clsRopa> pantalon_M = new ArrayList<clsRopa>();
				
				 for( clsRopa a: ropa)
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
		public static  ArrayList<clsCosmetica> Piel_M ()
			{
				 ArrayList<clsCosmetica> cosmeticos = new ArrayList<clsCosmetica>();
				 cosmeticos= Cosmeticos();
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
		public static  ArrayList<clsCosmetica> Perfume_M ()
			{
				 ArrayList<clsCosmetica> cosmeticos = new ArrayList<clsCosmetica>();
				 cosmeticos= Cosmeticos();
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
		public static  ArrayList<clsCosmetica> Maquillaje_M ()
			{
				 ArrayList<clsCosmetica> cosmeticos = new ArrayList<clsCosmetica>();
				 cosmeticos= Cosmeticos();
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
		public static  ArrayList<clsCosmetica> Maquillaje_H ()
			{
				 ArrayList<clsCosmetica> cosmeticos = new ArrayList<clsCosmetica>();
				 cosmeticos= Cosmeticos();
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
		public static  ArrayList<clsCosmetica> Piel_H ()
			{
				 ArrayList<clsCosmetica> cosmeticos = new ArrayList<clsCosmetica>();
				 cosmeticos= Cosmeticos();
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
		public static  ArrayList<clsCosmetica> Perfume_H ()
			{
				 ArrayList<clsCosmetica> cosmeticos = new ArrayList<clsCosmetica>();
				 cosmeticos= Cosmeticos();
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
	
	 

		 	
		
		
		
		
}

