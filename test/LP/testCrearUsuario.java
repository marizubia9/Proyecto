package LP;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.clsBaseDeDatos;

/**
 * En este test comprobaremos si el usuario se añade bien. 
 * @author ALUMNO
 *
 */
public class testCrearUsuario {
	@Before
	public void setUp() throws Exception
	{
		clsBaseDeDatos.initBD();
		clsBaseDeDatos.crearTablaUsuarioBD();
		
	}
	@After
	public void tearDown() {
		clsBaseDeDatos.EliminarUsuario("ma@a.com");
		clsBaseDeDatos.close();
		
	}
	@Test
	public void test() 
	{
		clsBaseDeDatos.AnyadirUsuario("ma@gmail.com", "gmail", "maria", "artabe", "basadi", "20757", "gipuzkoa", "getaria", "02/29/22");
		char aux=clsBaseDeDatos.existe("ma@gmail.com","gmail");
		assertEquals(aux, 'u');
	}


}
