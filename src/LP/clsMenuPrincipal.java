package LP;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import com.sun.javafx.text.GlyphLayout;


public class clsMenuPrincipal extends JFrame
{
	
	clsPanelFondo pPrincipal;
	
	public clsMenuPrincipal ()
	{
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\Icono.png"));
		setBackground(Color.WHITE);
		
		pPrincipal = new clsPanelFondo();
		JPanel pSuperior = new JPanel();
		pSuperior.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add( pPrincipal, BorderLayout.CENTER );
		getContentPane().add( pSuperior, BorderLayout.NORTH );
		
		JButton bSignIn =new JButton("Sign In");
		JTextField tCorreo= new JTextField();
		JTextField tPassword= new JTextField();
		pSuperior.add(tCorreo);
		pSuperior.add(tPassword);
		pSuperior.add(bSignIn);
		
		tPassword.setBounds(tCorreo.getX(),(tCorreo.getX()+tCorreo.getWidth()+2), tCorreo.getWidth(), tCorreo.getHeight());
		tCorreo.setColumns(10);
		tPassword.setColumns(10);
		pSuperior.setBackground(Color.black);
		bSignIn.setBackground(Color.GRAY);
		
		

	
	
	
		
	}
	

	
}
