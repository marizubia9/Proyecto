package LP;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class clsPanelFondo extends JPanel
{
	Image fotofondo;
	
	public clsPanelFondo()
	{
		fotofondo= Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\zara.png");
	}
	public void paint(Graphics g) {
        g.drawImage(fotofondo, 0, 0, getWidth(), getHeight(), this);
 
       setOpaque(false);
        super.paint(g);
    }
}
