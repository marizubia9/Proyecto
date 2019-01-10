package LP;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LN.clsUsuario;
import LN.clsBaseDeDatos;
import ud.prog3.pr01.ListaDeReproduccion;

/**
 * Clase para comprobaciones Junit
 * @author ALUMNO
 *
 */
publiArrayList<E>lsTest {
	
	ArrayList<clsUsuario> usuarios;
	clsUsuario usuario1;
	clsUsuario usuario2;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		clsBaseDeDatos.initBD();
		clsBaseDeDatos.clsGestor.AnyadirUsuario("doalzu@gmail.com", "mariamaidereider", "doalzu", "DLZ", "Donostia", "207502", "Gipzukoa", "Zumaia", "19/04/98");
		usuarios.add(usuario1);
		
	}

	@After
	public void tearDown() {
		
	}
	
	@Test
	public void test() {
		
		
		
	}

}
