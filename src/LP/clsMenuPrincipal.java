package LP;

import LN.clsBaseDeDatos;
import LP.clsIniciarSesionEmpresa;
import LP.clsRegistrarse;
import LP.clsMenuRopa;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class clsMenuPrincipal extends JFrame
{
	
	clsPanelFondo pPrincipal;
	
	private JTextField txtCorreo;
	private JTextField txtPassword;
	private JButton bLogIn;

	private JPanel pLogo;

	
	public clsMenuPrincipal ()
	{
		
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		setBackground(Color.WHITE);
		clsBaseDeDatos.initBD();
		clsBaseDeDatos.crearTablaTienda();
		clsBaseDeDatos.crearTablaProductoBD();
		clsBaseDeDatos.crearTablaUsuarioBD();
		clsBaseDeDatos.crearTablaComprasBD();
		
		pPrincipal = new clsPanelFondo();
		getContentPane().add( pPrincipal, BorderLayout.CENTER);
		
		JPanel pSuperior = new JPanel();
		pPrincipal.add(pSuperior,BorderLayout.NORTH);
		
		bLogIn =new JButton("Log In");
		JButton bEmpresa =new JButton("Soy una Empresa");
		JButton bRegistrarse = new JButton ("Registrarse");
		txtCorreo= new JTextField("E-mail");
		txtPassword= new JTextField("Contraseña");
		
		pSuperior.add(txtCorreo);
		pSuperior.add(txtPassword);
		pSuperior.add(bLogIn);
		txtCorreo.setColumns(10);
		txtPassword.setColumns(10);
		bLogIn.setBackground(Color.GRAY);
		pPrincipal.add(bEmpresa);
		pPrincipal.add(bRegistrarse);
		
//		JDialog dialog = new JDialog();
//		dialog.add(pPrincipal);
//		dialog.pack();
//		bSignIn.requestFocusInWindow();
//		dialog.setVisible(true);
		ActionListener al= new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				if ( obj == bLogIn)
				{
					clsMenuRopa a= new clsMenuRopa();
			
					
				}
				else if (obj == bEmpresa)
				{
					clsIniciarSesionEmpresa a = new clsIniciarSesionEmpresa();
					a.setVisible(true);
				}
				
				else if (obj == bRegistrarse)
				{
					clsRegistrarse a = new clsRegistrarse ();
					a.setVisible(true);
				}
			}
			
		};
		
		bLogIn.addActionListener(al);
		bEmpresa.addActionListener(al);
		bRegistrarse.addActionListener(al);

		FocusListener f2= new FocusAdapter()
		{
		
			@Override
			public void focusLost (FocusEvent e)
			{
				if(e.getSource()==txtCorreo && txtCorreo.getText().isEmpty()) txtCorreo.setText("E-mail");
				if(e.getSource()==txtPassword && txtPassword.getText().isEmpty())  txtPassword.setText("Contraseña");
			
			}
			
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(e.getSource()==txtCorreo)  txtCorreo.setText("");
				if (e.getSource()==txtPassword) txtPassword.setText("");		
			}	
		};
				
		txtCorreo.addFocusListener(f2);
		txtPassword.addFocusListener(f2);
		
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
	

	

