package LP;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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






import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class clsMenuPrincipal extends JFrame
{
	
	clsPanelFondo pPrincipal;
	
	JPanel pLogo;

	
	public clsMenuPrincipal ()
	{
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		setBackground(Color.WHITE);
		
		pPrincipal = new clsPanelFondo();
		getContentPane().add( pPrincipal, BorderLayout.CENTER);
		
		JPanel pSuperior = new JPanel();
		pPrincipal.add(pSuperior,BorderLayout.NORTH);
		
		JButton bSignIn =new JButton("Sign In");
		JButton bEmpresa =new JButton("Soy una Empresa");
		JTextField tCorreo= new JTextField();
		JTextField tPassword= new JTextField();
	
		pSuperior.add(tCorreo);
		pSuperior.add(tPassword);
		pSuperior.add(bSignIn);
		tCorreo.setColumns(10);
		tPassword.setColumns(10);
		bSignIn.setBackground(Color.GRAY);
		pPrincipal.add(bEmpresa);
		
//		pLogo= new JLabel();
//		pSuperior.add(pLogo);
		
//		Jlabel limagen= new Jlabel();
//		
//		try 
//		{
//			setIcon( new ImageIcon( "C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\DLZ.png"); // se utiliza para luego colgarlo en internet y no de error. 
//		} catch (Exception e) {
//			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
//			e.printStackTrace();
//		}
//		setBounds( 0, 0,124 ,24  );
//		
//		Image Doalzu;
//		Doalzu = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\DOALZU.jpg");
		
		
	    }
	
		

	
	
	
		
	}
	

	

