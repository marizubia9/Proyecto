package LN;

import java.sql.Date;
import java.util.ArrayList;
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
		
		public boolean CrearUsuario (String nombre, String apellido1, String apellido2, String correo, String contrasenya,Date FechaNac)
		{
			//Comprobar que no exista el email
			boolean existe=false;
			for (clsUsuario a :ListaUsuarios)
			{
				if(correo==a.getCorreo()) existe= true;
			}
			if (!existe)
			{
				clsUsuario NuevoUsuario= new clsUsuario(  nombre,  apellido1,  apellido2,  correo,  contrasenya,FechaNac);
				return true;
			}
			return false;
			
		}
		
		public boolean CrearTienda (String nombre, String NIF, String correo, String contrasenya, String direccion)
		{
			//Comprobar que no exista el NIF
			boolean existe=false;
			for (clsTienda a :ListaTiendas)
			{
				if(NIF==a.getNIF()) existe= true;
			}
			if (!existe)
			{
				clsTienda nuevaTienda= new clsTienda(  nombre, NIF,  correo,  contrasenya,direccion);
				return true;
			}
			return false;
			
		}
		
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

