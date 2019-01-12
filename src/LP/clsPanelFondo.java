package LP;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JPanel;




/**
 * Clase para mostrar fotos en Menu Principal mediante un hilo
 * @author ALUMNO
 *
 */
public class clsPanelFondo extends JPanel
{
	// hemen sortu berko genuke array bat, ta for batekin que vaya recorriendo el array, y así, irán cambiando las imagens.
	private ArrayList <Image>fotos;   
	 int index;
	private HiloIndex hiloindex;
	
	/**
	 * 
	 * @throws IOException
	 */
	public clsPanelFondo() 
	{
		
		fotos= new ArrayList<Image>();
	
		 String path= clsPanelFondo.class.getResource("/img").getPath();
		 dameFicheros(path,"fondo.*.jpg","fondo.*.png",fotos,true);
		hiloindex=new HiloIndex();
		hiloindex.start();
		index=0;
	
		
		
	
	}
	public void paint(Graphics g) {
		
		g.drawImage(fotos.get(index), 0, 0, getWidth(), getHeight(), this);
         
       setOpaque(false);
        super.paint(g);
    }
	
	
	public class HiloIndex extends Thread
	{
		boolean seguir=true; 
		public void run()
		{
			index=0;
			
			
			while (seguir)
			{
				
				if (index<fotos.size()-1) 	index+=1;
				if (index==fotos.size()-1) index=0;
				repaint();
								
			try 
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
				
			}
		}	
		}
	}
	/**
	 * Se le pasa una máscara de nombre de ficheros en formato regex de java
	 * y busca, recursivamente o no, todos los ficheros que cumplen dicha máscara.
	 * 
	 * @author Chuidiang
	 */
	
	    /**
	     * Busca todos los ficheros que cumplen la máscara que se le pasa y los
	     * mete en la listaFicheros que se le pasa.
	     * 
	     * @param pathInicial Path inicial de búsqueda. Debe ser un directorio que
	     * exista y con permisos de lectura.
	     * @param mascara Una máscara válida para la clase Pattern de java.
	     * @param listaFicheros Una lista de ficheros a la que se añadirán los File
	     * que cumplan la máscara. No puede ser null. El método no la vacía.
	     * @param busquedaRecursiva Si la búsqueda debe ser recursiva en todos los
	     * subdirectorios por debajo del pathInicial.
	     * @throws IOException 
	     */
	    public static void dameFicheros(String pathInicial, String mascara,String mascara1,
	            ArrayList<Image> fotos, boolean busquedaRecursiva) 
	    {	
	    	Image imagen = null;
	        File directorioInicial = new File(pathInicial);
	        if (directorioInicial.isDirectory())
	        {
	            File[] ficheros = directorioInicial.listFiles();
	            for (int i = 0; i < ficheros.length; i++)
	            {
	                if (ficheros[i].isDirectory() && busquedaRecursiva )
	                {
	                    try {
							imagen = ImageIO.read(ficheros[i]);
						} catch (IOException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
						}
		                    dameFicheros(ficheros[i].getAbsolutePath(), mascara,mascara1,
		                            fotos, busquedaRecursiva);

	                }

	                else if (Pattern.matches(mascara, ficheros[i].getName())||Pattern.matches(mascara1, ficheros[i].getName()))
	                {
	                	try {
							imagen = ImageIO.read(ficheros[i]);
						} catch (IOException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
						}
	                    fotos.add(imagen);	
	                }

	            }
	        }
	    }


	
	
	
}

