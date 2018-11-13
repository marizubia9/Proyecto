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
	Image Doalzu;
	JPanel pImagen;

	
	public clsMenuPrincipal ()
	{
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\DLZ.png"));
		setBackground(Color.WHITE);
		
		pPrincipal = new clsPanelFondo();
		getContentPane().add( pPrincipal, BorderLayout.NORTH );
		JPanel pSuperior = new JPanel();
		pPrincipal.add(pSuperior);
		
		JButton bSignIn =new JButton("Sign In");
		bSignIn.setBounds(699, 5, 65, 23);
		JTextField tCorreo= new JTextField();
		tCorreo.setBounds(517, 6, 86, 20);
		JTextField tPassword= new JTextField();
		pSuperior.setLayout(null);
		
		

		pSuperior.add(tCorreo);
		pSuperior.add(tPassword);
		pSuperior.add(bSignIn);
		
		tPassword.setBounds(608,6, 86, 20);
		tCorreo.setColumns(10);
		tPassword.setColumns(10);
		pSuperior.setBackground(Color.black);
		bSignIn.setBackground(Color.GRAY);
		pImagen = new JPanel();
		pSuperior.add(pImagen);
		pImagen.setBounds(769, 11, 10, 10);
		
		
		Doalzu = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\DOALZU.jpg");
		
		
	    }
	
		

	
	
	
		
	}
	

	

