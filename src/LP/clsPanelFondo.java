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

import javax.swing.JPanel;

public class clsPanelFondo extends JPanel
{
	// hemen sortu berko genuke array bat, ta for batekin que vaya recorriendo el array, y así, irán cambiando las imagens.
	Image fotofondo;
	ArrayList <File>fotos; 
	   
	
	public clsPanelFondo()
	{
		fotofondo= Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\zara.png");
		fotos= new ArrayList<File>();
		String carpeta = "C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img";
		MeterImagenes(carpeta);
	
	}
	public void paint(Graphics g) {
        g.drawImage(fotofondo, 0, 0, getWidth(), getHeight(), this);
 
       setOpaque(false);
        super.paint(g);
    }
	public void MeterImagenes (String carpeta)
	{
		String filtro1 =".*.jpg";
		String filtro2= ".*.png";	
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		File fInic = new File(carpeta); 
		if (fInic.isDirectory())
		{
			for( File f : fInic.listFiles() ) 
			{
				
				if ( pfiltro1.matcher(f.getName()).matches()  || pfiltro2.matcher(f.getName()).matches()){
					try {
						byte[] fileContent = Files.readAllBytes(f.toPath());
						} catch (IOException e) {
						
						e.printStackTrace();
					}
					fotos.add( f );
					
				}
			}
		}
		
	}
}
