package LP;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.clsBaseDeDatos;
import LN.clsGestor;
import LN.clsRopa;

/**
 * En este test comprobaremos que el producto se añade bien al añadir carrito. 
 * @author ALUMNO
 *
 */
public class testAñadirAlCarrito {

	clsGestor gestor;
	clsRopa producto;
	
	@Before
	public void setUp() throws Exception
	{
		clsBaseDeDatos.initBD();
		producto=new clsRopa("abrigo",1.1,"abrigo de invierno","nike",22,"lua","abrigo","tela",10,2,3,4,5,true,"imagen");
		gestor=new clsGestor("mi@gmail.com");
		
		
	}
	@After
	public void tearDown() {
		

	}
	@Test
	public void test() 
	{
		gestor.ListaAnyadidos(producto);
		assertEquals(producto.getNombre(),gestor.getListaAnyadidos().get(0).getNombre());
		

}

}
