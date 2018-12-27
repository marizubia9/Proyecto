package LN;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

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
				", NIF string, direccion string)");
				
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
				"(correo string primary key, nombre string, ape1 string, ape2 string" +
				", contrasenya string, fechanac string, NumPedido integer)");
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
				"(codigo string, tienda string, descripcion string, precio double" +
				", nombre string, stock_S integer, stock_M integer, stock_L integer, stock_XL integer)");
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
				"(codigo string, tienda string, descripcion string, precio double" +
				", nombre string, stock integer)");
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
				"(NumPedido integer, comprador string, tienda string, cod_producto string" +
				", comentarios string, talla string, cantidad integer)");
		} catch (SQLException e) {
			System.out.println();
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	/**
	 * 
	 * @param correo
	 * @return devuelve true si se añade un nuevo usuario
	 */
	public static boolean AnyadirUsuario(String nombre, String apellido1, String apellido2, String correo, String contrasenya,String FechaNac)
	{
		
		boolean NuevoUsuario=true;
		boolean NuevaTienda=true;
		
		if (statement==null) return false;
	
		try {
			 ResultSet rs = statement.executeQuery("select * from Usuarios");
			 while(rs.next())
			 {
				 if((rs.getString("correo")).equals(correo))  NuevoUsuario=false; 
					 
			 }
			 
			 rs = statement.executeQuery("select * from Tiendas");
			 while(rs.next())
			 {
				 if((rs.getString("correo")).equals(correo)) NuevaTienda=false;
			 }
			 
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
		
		if(NuevoUsuario && NuevaTienda )
			{
			System.out.println("AÑADIRRRRR");
				try {
					statement.executeUpdate("insert into Usuarios values('"+correo+"', '"+nombre+"', '"+apellido1+"', '"+apellido2+"', '"+contrasenya+"', '"+FechaNac+"', 0)");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
	
		else {
			System.out.println("EXISTE!!");
			return false;
		}
		
		
	}
}

