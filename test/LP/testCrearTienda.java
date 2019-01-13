package LP;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.clsBaseDeDatos;
/**
 * En este test comprobaremos si la tienda se añade bien. 
 * @author ALUMNO
 *
 */
public class testCrearTienda {

	@Before
	public void setUp() throws Exception
	{
		clsBaseDeDatos.initBD();
		clsBaseDeDatos.crearTablaTienda();
		
	}
	@After
	public void tearDown() {
		clsBaseDeDatos.EliminarTienda("ma@gmail.com");
		clsBaseDeDatos.close();
	}
	@Test
	public void test() 
	{
		clsBaseDeDatos.AnyadirTienda("ma@gmail.com", "a", "a", "a", "s", "j", "gipuzkoa", "zumaia");
		char aux=clsBaseDeDatos.existe("ma@gmail.com","a");
		assertEquals(aux, 't');
	}


}
