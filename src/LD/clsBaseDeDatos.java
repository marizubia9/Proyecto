package LD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import LN.*;

import javax.swing.JOptionPane;

/** M�todos �tiles para base de datos.
 * Clase con m�todos est�ticos para gestionar una sola base de datos
 */
public class clsBaseDeDatos { // esta clase no se puede instanciar, ya que todas los metodos y atributos son est�ticos. 

	
	private static Connection connection = null; // gestionaba la conexion
	private static Statement statement = null; //gestionar las consultas sql 

	/** Inicializa una BD SQLITE y devuelve una conexi�n con ella. Debe llamarse a este 
	 * m�todo antes que ning�n otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @return	Conexi�n con la base de datos indicada. Si hay alg�n error, se devuelve null
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
			JOptionPane.showMessageDialog( null, "Error de conexi�n!! No se ha podido conectar con Doalzu.bd"  , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexi�n!! No se ha podido conectar con Doalzu.bd"  );
			return null;
			
		}
	}
	
	/** Cierra la conexi�n con la Base de Datos; cierra el archivo
	 */
	public static void close() { 
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Conexi�n con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() { 
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	
	
	/** Crea una tabla de las tiendas en la base de datos, si no exist�a ya.
	 * Debe haberse inicializado la conexi�n correctamente.
	 */
	public static void crearTablaTienda() {  // esto lo �nico que hace es crear la table
		if (statement==null) return;
		
		try {
					
			statement.executeUpdate("create table Tiendas " +
				"(correo string primary key, contrasenya string, nombre string" +
				", NIF string, direccion string, cod_postal string, provincia string, localidad string, cod_producto long)");
				
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}

	/** Crea una tabla de los usuario en la base de datos, si no exist�a ya.
	 * Debe haberse inicializado la conexi�n correctamente.
	 */
	public static void  crearTablaUsuarioBD() {  // esto lo �nico que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table Usuarios " +
				"(correo string primary key, contrasenya string, nombre string, apellidos string, direccion string" +
				", cod_postal string, provincia string, localidad string, fechanac string, NumPedido integer)");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	/** Crea una tabla de los productos de ropa en la base de datos, si no exist�a ya.
	 * Debe haberse inicializado la conexi�n correctamente.
	 */
	public static void crearTablaRopaBD() {  // esto lo �nico que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table Ropa " +
				"(codigo long, tienda string, nombre string, marca string, precio double, sexo boolean, tipo string, img string" +
				", descripcion string, stock_XS integer, stock_S integer, stock_M integer, stock_L integer, stock_XL integer, material string)");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	/** Crea una tabla de los productos de cosmetica en la base de datos, si no exist�a ya.
	 * Debe haberse inicializado la conexi�n correctamente.
	 */
	public static void crearTablaCosmeticaBD() {  // esto lo �nico que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table Cosmetica " +
				"(codigo long, tienda string, nombre string, marca string, descripcion string, precio double" +
				", sexo boolean, img string, tipo string, stock integer)");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	/** Crea una tabla de las compras en la base de datos, si no exist�a ya.
	 * Debe haberse inicializado la conexi�n correctamente.
	 */
	public static void crearTablaComprasBD() 
	{  // esto lo �nico que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table Compras " +
				"(NumPedido integer, comprador string, tienda string, cod_producto string" +
				", comentarios string, talla string, cantidad integer)");
		} catch (SQLException e) {
			System.out.println();
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	
	
	/**
	 * Es un m�todo mediante el cual vamos a poder comprobar si, por un lado existe ese usuario/tienda
	 * As�, si es un usuario el metodo nos devolver� 'u', si es tienda 't' y si no existe un '0'
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
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
		return '0';
	}
	
	/**
	 * Mediante este metodo se a�ade una nueva linea, en caso de no exista el usuario que se est� registrando, a la BD. 
	 * @param correo se ha de comprobar que no existe
	 * @param contrasenya
	 * @param nombre
	 * @param apellidos
	 * @param direccion
	 * @param cod_postal
	 * @param provincia
	 * @param localidad
	 * @param FechaNac
	 * @return true: si se ha a�adido y false: si ya existia y por tanto no se ha a�adido
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
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
		return ropa;
		
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
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
		return Cosmetica;
		
	}
	
	
	
}

