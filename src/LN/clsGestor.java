package LN;


import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;


public class clsGestor {
	private ArrayList < clsUsuario> ListaUsuarios;
	private ArrayList < clsTienda> ListaTiendas;
	// Logger de la clase
		private static Logger logger = Logger.getLogger( clsGestor.class.getName() );
	
	
	public clsGestor()
	{
		ListaUsuarios=ListaUsuarios();
		ListaTiendas=ListaTiendas();
	}
	
	
	// Programar este metodo para acceder a la BD y coger toda la lista de usuarios
	public ArrayList <clsUsuario> ListaUsuarios()
	{
		 ListaUsuarios=new ArrayList<clsUsuario>();
		return ListaUsuarios;
	}
	
	// Programar este metodo para acceder a la BD y coger toda la lista de tiendas
		public ArrayList<clsTienda> ListaTiendas()
		{
			ListaTiendas=new ArrayList<clsTienda>();

			return ListaTiendas;
		}
		
		public static boolean CrearUsuario (String correo, String contrasenya, String nombre, String apellidos, 
											String direccion, String cod_postal, String provincia, String Localidad, Date FechaNac, String Fec_Nac)
		{
			//Comprobar que no exista el email
			
			boolean anyadido=clsBaseDeDatos.AnyadirUsuario( correo,  contrasenya,  nombre,  apellidos,  direccion,cod_postal, provincia, Localidad, Fec_Nac);
			if(anyadido)
			{
				clsUsuario nuevoUsuario = new clsUsuario( correo,  contrasenya,  nombre,  apellidos,  direccion,cod_postal, provincia, Localidad, FechaNac);
			}
			 
			return anyadido;
			
			
		}
		
		public static char Existe (String correo, String contrasenya)
		{
			char existe= clsBaseDeDatos.existe(correo, contrasenya);
			return existe;
		}
		
		public static boolean CrearTienda (String correo, String contrasenya, String nombre, String NIF, 
				String direccion, String cod_postal, String provincia, String Localidad)
			{
			//Comprobar que no exista el email
			
			boolean anyadido=clsBaseDeDatos.AnyadirTienda( correo,  contrasenya,  nombre,  NIF,  direccion,cod_postal, provincia, Localidad);
			if(anyadido)
			{
			clsTienda nuevaTienda = new clsTienda( correo,  contrasenya,  nombre,  NIF,  direccion,cod_postal, provincia, Localidad);
			}
			
			return anyadido;
			
			
			}
//		public boolean CrearTienda (String nombre, String NIF, String correo, String contrasenya, String direccion)
//		{
//			//Comprobar que no exista el NIF
//			boolean existe=false;
//			for (clsTienda a :ListaTiendas)
//			{
//				if(NIF==a.getNIF()) existe= true;
//			}
//			if (!existe)
//			{
//				clsTienda nuevaTienda= new clsTienda(  nombre, NIF,  correo,  contrasenya,direccion);
//				return true;
//			}
//			return false;
//			
//		}
		
		public boolean CrearProducto (Enum enumerador, double precio, String descripcion, String marca, String codigo, clsTienda tienda, int stock)
		{
			//Comprobar que no exista el hashcode
			boolean existe=false;
			if(existe)
			{
				return false;
			}
			else
			{
//				clsProducto producto= new clsProducto(precio, descripcion, marca, codigo, tienda, stock)
//				switch (enumerador)
//				{
//				case
//				}
			}
			
		
			return false;
			
		}
		
		
		
}

