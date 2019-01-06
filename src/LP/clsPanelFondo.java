package LP;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JPanel;





public class clsPanelFondo extends JPanel
{
	// hemen sortu berko genuke array bat, ta for batekin que vaya recorriendo el array, y así, irán cambiando las imagens.
	private ArrayList <Image>fotos;   
	 int index;
	private HiloIndex hiloindex;
	
	public clsPanelFondo()
	{
//		fotofondo= Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\zara.png")
		fotos= new ArrayList<Image>();
	
		 String path= clsPanelFondo.class.getResource("/img").getPath();
		MeterImagenes(path);
		hiloindex=new HiloIndex();
		hiloindex.start();
		index=0;
	
		
		
	
	}
	public void paint(Graphics g) {
		
		g.drawImage(fotos.get(index), 0, 0, getWidth(), getHeight(), this);
         
       setOpaque(false);
        super.paint(g);
    }
	public void MeterImagenes (String path)
	{
		
		String filtro1 ="fondo.*.jpg";
		String filtro2= "fondo.*.png";	
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		
		File fInic = new File(path); 
		
		if (fInic.isDirectory())
		{
			for( File f : fInic.listFiles() ) 
			{
				
				if ( pfiltro1.matcher(f.getName()).matches()  || pfiltro2.matcher(f.getName()).matches())
				{
					Image imagen = null;
				
						try {
							 imagen = ImageIO.read(f);
							} 
						catch (IOException e) 
							{
							// TODO Auto-generated catch block
							e.printStackTrace();
							}

					fotos.add( imagen );
					
				}
			}
		}
		
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
	
	
}

