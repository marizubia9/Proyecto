package LP;



import javax.swing.JButton;
import javax.swing.JDesktopPane;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\DLZ.png"));
		setBackground(Color.WHITE);
		
		pPrincipal = new clsPanelFondo();
		getContentPane().add( pPrincipal, BorderLayout.CENTER);
		
		JPanel pSuperior = new JPanel();
		pPrincipal.add(pSuperior,BorderLayout.NORTH);
		
		JButton bSignIn =new JButton("Sign In");
		JTextField tCorreo= new JTextField();
		JTextField tPassword= new JTextField();
	
		pSuperior.add(tCorreo);
		pSuperior.add(tPassword);
		pSuperior.add(bSignIn);
		tCorreo.setColumns(10);
		tPassword.setColumns(10);
		bSignIn.setBackground(Color.GRAY);
		
//		pLogo= new JLabel();
//		pSuperior.add(pLogo);
		
		
		Image Doalzu;
		Doalzu = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\DOALZU.jpg");
		
//		bSignIn.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent e)
//			{
//				clsMenuRopa clsMenuRopa=new clsMenuRopa();
//				contentPane.setVisible(false);
//				contentPane.add(clsMenuRopa);
//				clsMenuRopa.setVisible(true);
//				clsMenuRopa.toFront();
//				contentPane.setVisible(true);
//			}
//		});
		
		
	    }
	
		

	
	
	
		
	}
	

	

