package LN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
					
			statement.executeUpdate("create table tienda " +
				"(correo string, contrasenya string, nombre string" +
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
			statement.executeUpdate("create table usuarios " +
				"(correo string, nombre string, ape1 string, ape2 string" +
				", contrasenya string, fechanac string, NumPedido");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	/** Crea una tabla de los productos en la base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaProductoBD() {  // esto lo único que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table producto " +
				"(codigo string, tienda string, descripcion string, precio double" +
				", nombre string, stock_S integer, stock_M integer, stock_L integer, stock_XL integer)");
		} catch (SQLException e) {
			System.out.println("ya esta creado");
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	/** Crea una tabla de los productos en la base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaComprasBD() {  // esto lo único que hace es crear la table
		if (statement==null) return;
		try {
			statement.executeUpdate("create table compras " +
				"(codigo string, tienda string, comprador string" +
				", comentarios string, talla integer, cantidad integer, NumPedido integer)");
		} catch (SQLException e) {
			System.out.println("ya esta creado");
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
}

