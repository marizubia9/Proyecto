package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import LN.*;

import javax.swing.JOptionPane;

/** Métodos útiles para base de datos.
 * Clase con métodos estáticos para gestionar una sola base de datos
 */
public class clsBaseDeDatos { // esta clase no se puede instanciar, ya que todas los metodos y atributos son estáticos. 

	
	private static Connection connection = null; // gestionaba la conexion
	private static Statement statement = null; //gestionar las consultas sql 

	/** Inicializa una BD SQLITE y devuelve una conexión con ella. Debe llamarse a este 
	 * método antes que ningún otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */
	public static Connection initBD()
	{
		try {
		
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:Doalzu.bd" );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg --> siempre se pone, pero normalmente no se suele usar. 
		
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexión!! No se ha podido conectar con Doalzu.bd"  , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexión!! No se ha podido conectar con Doalzu.bd"  );
			return null;
			
		}
	}
	
	/** Cierra la conexión con la Base de Datos; cierra el archivo
	 */
	public static void close() { 
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Conexión con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() { 
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	
	
	/** Crea una tabla de las tiendas en la base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaTienda() {  // esto lo único que hace es crear la table
		if (statement==null) return;
		
		try {
					
			statement.executeUpdate("create table Tiendas " +
				"(correo string primary key, contrasenya string, nombre string" +
				", NIF string, direccion string, cod_postal string, provincia string, localidad string, cod_producto long)");
				
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}

	/** Crea una tabla de los usuario en la base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void  crearTablaUsuarioBD() {  // esto lo único que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table Usuarios " +
				"(correo string primary key, contrasenya string, nombre string, apellidos string, direccion string" +
				", cod_postal string, provincia string, localidad string, fechanac string, NumPedido integer)");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	/** Crea una tabla de los productos de ropa en la base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaRopaBD() {  // esto lo único que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table Ropa " +
				"(codigo long, tienda string, nombre string, marca string, precio double, sexo boolean, tipo string, img string" +
				", descripcion string, stock_XS integer, stock_S integer, stock_M integer, stock_L integer, stock_XL integer, material string)");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	/** Crea una tabla de los productos de cosmetica en la base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaCosmeticaBD() {  // esto lo único que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table Cosmetica " +
				"(codigo long, tienda string, nombre string, marca string, descripcion string, precio double" +
				", sexo boolean, img string, tipo string, stock integer)");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	/** Crea una tabla de las compras en la base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaComprasBD() 
	{  // esto lo único que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table Compras " +
				"(comprador string, num_pedido int, tienda string, cod_producto long" +
				",  talla string, cantidad integer, fecha string)");
		} catch (SQLException e) {
			System.out.println();
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	
	
	/**
	 * Es un método mediante el cual vamos a poder comprobar si, por un lado existe ese usuario/tienda
	 * Así, si es un usuario el metodo nos devolverá 'u', si es tienda 't' y si no existe un '0'
	 * @param correo
	 * @param contrasenya
	 * @return --> 'u': usuario / 't': tienda /'0': no existe 
	 */
	public static char existe(String correo, String contrasenya)
	{
		if (statement==null) return '0';
		
		try {
			 ResultSet rs = statement.executeQuery("select * from Usuarios");
			 while(rs.next())
			 {
				 if((rs.getString("correo")).equals(correo) &&(rs.getString("contrasenya")).equals(contrasenya))  return'u'; 
				
			 }
			 
			 rs = statement.executeQuery("select * from Tiendas");
			 while(rs.next())
			 {
				 if((rs.getString("correo")).equals(correo) &&(rs.getString("contrasenya")).equals(contrasenya))  return't'; 
				 
			 }
			 
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
		return '0';
	}
	
	/**
	 * Mediante este metodo conseguimos el usuario que tenga el @param correo
	 * @return el usuario 
	 */
	public static clsUsuario usuario(String correo)
	{
		clsUsuario usuario = null;
		 try 
		 {
			ResultSet rs = statement.executeQuery("select * from Usuarios where correo='"+correo+"'");
				  
				  String contrasenya= rs.getString("contrasenya");
				  String nombre =rs.getString("nombre");
				  String apellidos= rs.getString("apellidos");
				  String direccion= rs.getString("direccion");
				  String cod_postal= rs.getString("cod_postal");
				  String provincia= rs.getString("provincia");
				  String localidad= rs.getString("localidad");
				  String fechanac= rs.getString("fechanac");
				  int NumPedido=rs.getInt("NumPedido");
				  
				  SimpleDateFormat forma= new SimpleDateFormat("dd-MM-yyyy");
				  Date fecha;
			try {
					 fecha=forma.parse(fechanac);
				} 
			catch (ParseException e) 
				{
					
					fecha=null;
				}
			
			 usuario=new clsUsuario(correo, contrasenya, nombre, apellidos, direccion, cod_postal, provincia, localidad, fecha, NumPedido);
		 } 
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return usuario;

	}
	
	public static boolean Nadie(String correo)
	{
		try {
			ResultSet rs = statement.executeQuery("select * from Tiendas");
			 while(rs.next())
			 {
				 if((rs.getString("correo")).equals(correo) )
					 {
			
					 	return false; 
					 }
				 
			 }
			 
			 rs = statement.executeQuery("select * from Usuarios");
			 while(rs.next())
			 {
				 if((rs.getString("correo")).equals(correo) )
					 {
					 
					 	return false; 
					 }
				 
			 }
				 
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Mediante este metodo conseguimos la tienda especifica que tenga el @param correo
	 * @return la tienda especifica. 
	 */
	public static clsTienda tienda(String correo)
	{
		clsTienda tienda = null;
		 try 
		 {
			ResultSet rs = statement.executeQuery("select * from Tiendas where correo='"+correo+"'");
				  
				  String contrasenya= rs.getString("contrasenya");
				  String nombre =rs.getString("nombre");
				  String NIF= rs.getString("NIF");
				  String direccion= rs.getString("direccion");
				  String cod_postal= rs.getString("cod_postal");
				  String provincia= rs.getString("provincia");
				  String localidad= rs.getString("localidad");
				  long cod_producto= rs.getLong("cod_producto");
				 
				  
			
			
			 tienda=new clsTienda(correo, contrasenya, nombre, NIF, direccion, cod_postal, provincia, localidad, cod_producto);
		 } 
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return tienda;

	}
	
	
	/**
	 * Mediante este metodo se añade una nueva linea, en caso de no exista el usuario que se está registrando, a la BD. 
	 * @param correo se ha de comprobar que no existe
	 * @param contrasenya
	 * @param nombre
	 * @param apellidos
	 * @param direccion
	 * @param cod_postal
	 * @param provincia
	 * @param localidad
	 * @param FechaNac
	 * @return true: si se ha añadido y false: si ya existia y por tanto no se ha añadido
	 */
	public static boolean AnyadirUsuario(String correo, String contrasenya,String nombre, String apellidos, String direccion, 
										String cod_postal, String provincia , String localidad, String FechaNac)
	{
		char existe= existe(correo, contrasenya);
		
		if(existe=='0' )
			{
				try {
					statement.executeUpdate("insert into Usuarios values('"+correo+"', '"+contrasenya+"', '"+nombre+"', '"+apellidos+"', '"+direccion+"', '"+cod_postal+
																		"', '"+provincia+"', '"+localidad+"', '"+FechaNac+"', 0)");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
	
		else {

			return false;
		}
		
		
	}
	
	/**
	 * Lo primero que hace, es comprobar si existe el correo que se le ha pasado.
	 * Para ello hace uso del metodo 'existe' y en caso de que no exista, crea una tienda nueva
	 * haciendo uso de los parametros siguientes
	 * @param correo: es el identificador de cada tienda/UNICO/
	 * @param contrasenya
	 * @param nombre
	 * @param NIF
	 * @param direccion
	 * @param cod_postal
	 * @param provincia
	 * @param localidad
	 * @return TRUE: si se ha creado /FALSE: si no se ha creado. 
	 */
	public static boolean AnyadirTienda(String correo, String contrasenya,String nombre, String NIF, String direccion, 
										String cod_postal, String provincia , String localidad)
				{
					char existe= existe(correo, contrasenya);				
					if(existe=='0' )
					{
						try 
						{
							statement.executeUpdate("insert into Tiendas values('"+correo+"', '"+contrasenya+"', '"+nombre+"', '"+NIF+"', '"+direccion+"', '"+cod_postal+
															"', '"+provincia+"', '"+localidad+"', 0)");
						}
						catch (SQLException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
				
				else return false;

				}
	
		

	/**
	 * Añadir un nuevo producto.
	 * @param nombre
	 * @param precio
	 * @param descripcion
	 * @param marca
	 * @param codigo
	 * @param tienda
	 * @param tipo
	 * @param img
	 * @param sexo
	 * @param XS
	 * @param S
	 * @param M
	 * @param L
	 * @param XL
	 * @param material
	 * @return true si se ha añadido correctamente. 
	 */
	public static boolean AnyadirRopa(String nombre, double precio, String descripcion, String marca, long codigo, 
										String tienda, String tipo , String img, int sexo,  int XS, int S, int M, int L, int XL, String material)
				{
					
						try 
						{
							statement.executeUpdate("insert into Ropa values("+codigo+", '"+tienda+"', '"+nombre+"', '"+marca+"', "+precio+", "+sexo+
															", '"+tipo+"', '"+img+"', '"+descripcion+"', "+XS+", "+S+", "+M+", "+L+", "+XL+", '"+material+"')");
						}
						catch (SQLException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					

				}
	
/**
 * añadir un nuevo cosmetico
 * @param nombre
 * @param precio
 * @param descripcion
 * @param marca
 * @param codigo
 * @param tienda
 * @param tipo
 * @param img
 * @param sexo
 * @param stock
 * @return
 */
	public static boolean AnyadirCosmetico(String nombre, double precio, String descripcion, String marca, long codigo, 
										String tienda, String tipo , String img, int sexo,  int stock)
				{
					
						try 
						{
							statement.executeUpdate("insert into Cosmetica values("+codigo+", '"+tienda+"', '"+nombre+"', '"+marca+"', '"+descripcion+"', "+precio+", "+sexo+
															", '"+img+"', '"+tipo+"', '"+stock+"')");
						}
						catch (SQLException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					

				}
	
	/**
	 * Mediante este metodo, se edita el codigo_producto de la tienda
	 * @param codigo
	 */
	public static void EditarCodigo(long codigo, String correo)
	{
		try 
		{
			ResultSet rs = statement.executeQuery("update Tiendas set cod_producto="+codigo+" where correo='"+correo+"'");
		} 
		catch (SQLException e) 
		{
//			 TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	
	/**
	 * Mediante este metodo leemos todos los productos de ropa que tenemos en la base de datos,
	 * y se lo pasamos a clsMenuRopa, para que este pueda visualizar todos los datos de cada producto.
	 * @return ArrayList de tipo ropa. 
	 */
	public static ArrayList<clsRopa> Ropa ()
	{
		if (statement==null) return null;
		 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
		
		try {
			 ResultSet rs = statement.executeQuery("select * from Ropa");
			 while(rs.next())
			 {
				  long codigo= rs.getLong("codigo");
				  String tienda= rs.getString("tienda");
				  String nombre =rs.getString("nombre");
				  String marca= rs.getString("marca");
				  double Precio = rs.getDouble("precio") ;
				  Boolean sexo =rs.getBoolean("sexo");
				  String tipo =rs.getString("tipo");
				  String img = rs.getString("img");
				  String descripcion = rs.getString("descripcion");
				  int stock_XS = rs.getInt("stock_XS");
				  int stock_S= rs.getInt("stock_S");
				  int stock_M = rs.getInt("stock_M");
				  int stock_L= rs.getInt("stock_L");
				  int stock_XL= rs.getInt("stock_XL");
				  String material= rs.getString("material");
				  
				  clsRopa prenda = new clsRopa(nombre,Precio, descripcion, marca, codigo, tienda, tipo, material, stock_XS, stock_S,stock_M,stock_L,stock_XL,sexo, img );
				  ropa.add(prenda);

				 
			 }
			 
			
			 
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
		return ropa;
		
	}
	
	/**
	 * Mediante este metodo leemos todos los productos de ropa que tenemos en la base de datos,
	 * y obtenemos unicamente aquellos productos que pertenezcan a la tienda
	 * @return ArrayList de tipo ropa. 
	 */
	public static ArrayList<clsRopa> RopaTienda (String correo)
	{
		if (statement==null) return null;
		 ArrayList<clsRopa> ropa = new ArrayList<clsRopa>();
		
		try {
			 ResultSet rs = statement.executeQuery("select * from Ropa where tienda='"+correo+"'");
			 while(rs.next())
			 {
				  long codigo= rs.getLong("codigo");
				  String tienda= rs.getString("tienda");
				  String nombre =rs.getString("nombre");
				  String marca= rs.getString("marca");
				  double Precio = rs.getDouble("precio") ;
				  Boolean sexo =rs.getBoolean("sexo");
				  String tipo =rs.getString("tipo");
				  String img = rs.getString("img");
				  String descripcion = rs.getString("descripcion");
				  int stock_XS = rs.getInt("stock_XS");
				  int stock_S= rs.getInt("stock_S");
				  int stock_M = rs.getInt("stock_M");
				  int stock_L= rs.getInt("stock_L");
				  int stock_XL= rs.getInt("stock_XL");
				  String material= rs.getString("material");
				  
				  clsRopa prenda = new clsRopa(nombre,Precio, descripcion, marca, codigo, tienda, tipo, material, stock_XS, stock_S,stock_M,stock_L,stock_XL,sexo, img );
				  ropa.add(prenda);

				 
			 }
			 
			
			 
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
		return ropa;
		
	}
	
	
	/**
	 * Mediante este metodo leemos todos los productos de cosmetica que tenemos en la base de datos,
	 * y obtenemos unicamente aquellos productos que pertenezcan a la tienda
	 * @return ArrayList de tipo clsCosmetica. 
	 */
	public static ArrayList<clsCosmetica> CosmeticaTienda (String correo)
	{if (statement==null) return null;
	 ArrayList<clsCosmetica> Cosmetica = new ArrayList<clsCosmetica>();
		
	try {
		 ResultSet rs = statement.executeQuery("select * from Cosmetica where tienda='"+correo+"'");
		 while(rs.next())
		 {
			  long codigo= rs.getLong("codigo");
			  String tienda= rs.getString("tienda");
			  String nombre =rs.getString("nombre");
			  String marca= rs.getString("marca");
			  double Precio = rs.getDouble("precio") ;
			  Boolean sexo =rs.getBoolean("sexo");
			  String tipo =rs.getString("tipo");
			  String img = rs.getString("img");
			  String descripcion = rs.getString("descripcion");
			  int stock = rs.getInt("stock");
			 
	
			  clsCosmetica cosmetico = new clsCosmetica(nombre,Precio, descripcion, marca, codigo, tienda,  stock, tipo, sexo, img );
			  Cosmetica.add(cosmetico);	 
		 }
			 
			
			 
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
		return Cosmetica;
		
	}
	
	/**
	 * Mediante este metodo leemos todos los cosmeticos que tenemos en la BD,
	 * y se lo pasamos a clsMenuRopa, para que este pueda visualizar todos los datos de cada producto.
	 * @return ArrayList de tipo Cosmetica. 
	 */
	public static ArrayList<clsCosmetica> Cosmetica ()
	{
		if (statement==null) return null;
		 ArrayList<clsCosmetica> Cosmetica = new ArrayList<clsCosmetica>();
		
		try {
			 ResultSet rs = statement.executeQuery("select * from Cosmetica");
			 while(rs.next())
			 {
				  long codigo= rs.getLong("codigo");
				  String tienda= rs.getString("tienda");
				  String nombre =rs.getString("nombre");
				  String marca= rs.getString("marca");
				  double Precio = rs.getDouble("precio") ;
				  Boolean sexo =rs.getBoolean("sexo");
				  String tipo =rs.getString("tipo");
				  String img = rs.getString("img");
				  String descripcion = rs.getString("descripcion");
				  int stock = rs.getInt("stock");
				 
		
				  clsCosmetica cosmetico = new clsCosmetica(nombre,Precio, descripcion, marca, codigo, tienda,  stock, tipo, sexo, img );
				  Cosmetica.add(cosmetico);	 
			 }
			 
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
		return Cosmetica;
		
	}
	
	/**
	 * Mediante este metodo, editamos los productos que la tienda deseee
	 * así, mantenemos la BD actualizada
	 * @param correo
	 * @param cod_producto
	 * @param nombre
	 * @param marca
	 * @param material
	 * @param descripcion
	 * @param XS
	 * @param S
	 * @param M
	 * @param L
	 * @param XL
	 * @param precio
	 */
	public static void EditarRopa(String correo, long cod_producto, String nombre, String marca, String material, String descripcion, int XS,
									int S, int M, int L, int XL, double precio,String img)
		{
		 try
		 {
			 statement.executeUpdate("update Ropa set nombre='"+nombre+"', marca='"+marca+"', material='"+material
											+"', descripcion='"+descripcion+"', precio="+precio+", img='"+img+"', stock_XS="+XS+", stock_S="+S
											+", stock_M="+M+", stock_L="+L+", stock_XL="+XL+" where tienda='"+correo+"' and codigo="+cod_producto);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public static void EditarCosmetica(String correo, long cod_producto, String nombre, String marca, String descripcion, int stock, double precio, String img )
					{
					try
					{
					statement.executeUpdate("update Cosmetica set nombre='"+nombre+"', marca='"+marca+"', img='"+img+"', "+
										"descripcion='"+descripcion+"', precio="+precio+", stock="+stock+" where tienda='"+correo+"' and codigo="+cod_producto);
					
					
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					
					}
						
	/**
	 * Nos devuelve el nombre de la tienda del correo que se le envia
	 * @param correo
	 * @return
	 */
	public static String NombreTIenda(String correo)
	{
		String Nombre=null;
		 try 
		 {
			ResultSet rs = statement.executeQuery("select * from Tiendas where correo='"+correo+"'");
			Nombre=rs.getString("nombre");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return Nombre;
	}
	
	public static void AnyadirCompra(String usuario, int num_pedido, String tienda, long cod_producto, String talla, int cantidad, String fecha)
	{
		try {
			statement.executeUpdate("insert into Compras values('"+usuario+"', "+num_pedido+", '"+tienda+"', "+cod_producto+", '"+talla+"', "+cantidad+", '"+fecha+
																"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void EditarNumPedido(String correo, int num_pedido)
	{
		try 
		{
			statement.executeUpdate("update Usuarios set NumPedido="+num_pedido+" where correo='"+correo+"'");
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void EditarStock(String correo, long cod_producto, int stock, String talla)
	{
		try 
		{
			if(talla.toLowerCase().equals("xs"))
			{
				statement.executeUpdate("update Ropa set stock_XS="+stock+" where tienda='"+correo+"' and codigo="+cod_producto);
			}
			if(talla.toLowerCase().equals("s"))
			{
				statement.executeUpdate("update Ropa set stock_S="+stock+" where tienda='"+correo+"' and codigo="+cod_producto);
			}
			if(talla.toLowerCase().equals("m"))
			{
				statement.executeUpdate("update Ropa set stock_M="+stock+" where tienda='"+correo+"' and codigo="+cod_producto);
			}
			if(talla.toLowerCase().equals("l"))
			{
				statement.executeUpdate("update Ropa set stock_L="+stock+" where tienda='"+correo+"' and codigo="+cod_producto);
			}
			if(talla.toLowerCase().equals("xl"))
			{
				statement.executeUpdate("update Ropa set stock_XL="+stock+" where tienda='"+correo+"' and codigo="+cod_producto);
			}
			if(talla.toLowerCase().equals("stock"))
			{
				statement.executeUpdate("update Cosmetica set stock="+stock+" where tienda='"+correo+"' and codigo="+cod_producto);
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int ConocerStock(String correo, long cod_producto,  String talla)
	{
		int stock=0;
		try 
		{
			if(talla.toLowerCase().equals("xs"))
			{
				ResultSet rs =statement.executeQuery("select stock_XS from Ropa where tienda='"+correo+"' and codigo="+cod_producto);
				stock=rs.getInt("stock_XS");
				return stock;
			}
			if(talla.toLowerCase().equals("s"))
			{
				ResultSet rs =statement.executeQuery("select stock_S from Ropa where tienda='"+correo+"' and codigo="+cod_producto);
				stock=rs.getInt("stock_S");
				return stock;
			}
			if(talla.toLowerCase().equals("m"))
			{
				ResultSet rs =statement.executeQuery("select stock_M from Ropa where tienda='"+correo+"' and codigo="+cod_producto);
				stock=rs.getInt("stock_M");
				return stock;
			}
			if(talla.toLowerCase().equals("l"))
			{
				ResultSet rs =statement.executeQuery("select stock_L from Ropa where tienda='"+correo+"' and codigo="+cod_producto);
				stock=rs.getInt("stock_L");
				return stock;
			}
			if(talla.toLowerCase().equals("xl"))
			{
				ResultSet rs =statement.executeQuery("select stock_XL from Ropa where tienda='"+correo+"' and codigo="+cod_producto);
				stock=rs.getInt("stock_XL");
				return stock;
			}
			if(talla.toLowerCase().equals("stock"))
			{
				ResultSet rs =statement.executeQuery("select stock from Cosmetica where tienda='"+correo+"' and codigo="+cod_producto);
				stock=rs.getInt("stock");
				return stock;
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return stock;	
	}
	
	
}

