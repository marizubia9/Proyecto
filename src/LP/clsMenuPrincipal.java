package LP;

import LN.clsGestor;
import LP.clsMenuRopa;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.io.IOException;

/**
 * Menu Principal
 * @author ALUMNO
 *
 */
public class clsMenuPrincipal extends JFrame
{
	
	clsPanelFondo pPrincipal;
	
	private JTextField txtCorreo;
	private JPasswordField txtPassword;
	private JButton bIniciarSesion;

	private JPanel pLogo;

	/**
	 * Frame de Menu Principal
	 * @throws IOException 
	 */
	public clsMenuPrincipal () throws IOException
	{
		
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		setBackground(Color.WHITE);
		clsGestor.creartablas ();

		
		pPrincipal = new clsPanelFondo();
		getContentPane().add( pPrincipal, BorderLayout.CENTER);
		
		GridBagLayout gbl_pPrincipal = new GridBagLayout();
		gbl_pPrincipal.columnWidths = new int[]{207, 86, 86, 95, 87, 0, 0};
		gbl_pPrincipal.rowHeights = new int[]{44, 0, 0, 0};
		gbl_pPrincipal.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pPrincipal.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pPrincipal.setLayout(gbl_pPrincipal);
		
		txtCorreo= new JTextField("E-mail");
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCorreo.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.gridx = 2;
		gbc_txtCorreo.gridy = 0;
		pPrincipal.add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(15);
		
		
		
		txtPassword= new JPasswordField("Contraseña");
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassword.setForeground(Color.LIGHT_GRAY);
		txtPassword.setEchoChar((char)0);
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.anchor = GridBagConstraints.WEST;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 1;
		pPrincipal.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(15);	
				
		bIniciarSesion =new JButton("Iniciar Sesion");
		bIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bIniciarSesion.setForeground(Color.WHITE);
		bIniciarSesion.setBackground(Color.BLACK);
		GridBagConstraints gbc_bIniciarSesion = new GridBagConstraints();
		gbc_bIniciarSesion.anchor = GridBagConstraints.SOUTHWEST;
		gbc_bIniciarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_bIniciarSesion.gridx = 3;
		gbc_bIniciarSesion.gridy = 1;
		pPrincipal.add(bIniciarSesion, gbc_bIniciarSesion);
	
		JButton bRegistrarse = new JButton ("Registrarse");
		bRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bRegistrarse.setForeground(Color.WHITE);
		bRegistrarse.setBackground(Color.BLACK);
		

		GridBagConstraints gbc_bRegistrarse = new GridBagConstraints();
		gbc_bRegistrarse.insets = new Insets(0, 0, 5, 0);
		gbc_bRegistrarse.anchor = GridBagConstraints.NORTHWEST;
		gbc_bRegistrarse.gridx = 5;
		gbc_bRegistrarse.gridy = 1;
		pPrincipal.add(bRegistrarse, gbc_bRegistrarse);
				

		ActionListener al= new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				if ( obj == bIniciarSesion && clsGestor.Existe(txtCorreo.getText(), txtPassword.getText())=='u')
				{
					clsMenuRopa a= new clsMenuRopa();
					setVisible(false);
					
				}
				
				if ( obj == bIniciarSesion && clsGestor.Existe(txtCorreo.getText(), txtPassword.getText())=='t')
				{
					clsMenuTienda a= new clsMenuTienda();
					setVisible(false);	
				}
				if ( obj == bIniciarSesion && clsGestor.Existe(txtCorreo.getText(), txtPassword.getText())=='0')
				{
					txtCorreo.setText("E-mail");
					txtPassword.setText("Contraseña");
					txtPassword.setEchoChar((char) 0);
					txtCorreo.setForeground(Color.LIGHT_GRAY);
					txtPassword.setForeground(Color.LIGHT_GRAY);
					JOptionPane.showMessageDialog(null,"Este usuario no existe, vuelva a introducir los datos");
					
				}
			
				else if (obj == bRegistrarse)
				{
					clsRegistrarse_02 a = new clsRegistrarse_02 ();
					a.setVisible(true);
					setVisible(false);
				}
			}
			
		};
		bIniciarSesion.addActionListener(al);
		bRegistrarse.addActionListener(al);

		FocusListener f2= new FocusAdapter()
		{
		
			@Override
			public void focusLost (FocusEvent e)
			{
				if(e.getSource()==txtCorreo && txtCorreo.getText().isEmpty()) 
					{
						txtCorreo.setText("E-mail");
						txtCorreo.setForeground(Color.LIGHT_GRAY);
					}
				if(e.getSource()==txtPassword && txtPassword.getText().isEmpty())  
					{
						txtPassword.setText("Contraseña");
						txtPassword.setEchoChar((char) 0);
						txtPassword.setForeground(Color.LIGHT_GRAY);
					}
			
			}
			
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(e.getSource()==txtCorreo && txtCorreo.getText().equals("E-mail"))  
					{
					txtCorreo.setText("");
					txtCorreo.setForeground(Color.BLACK);
					}
				if (e.getSource()==txtPassword && txtPassword.getText().equals("Contraseña"))
					{
					txtPassword.setText("");	
					txtPassword.setEchoChar('*');
					txtPassword.setForeground(Color.BLACK);
					}
			}	
		};
		txtCorreo.addFocusListener(f2);
		txtPassword.addFocusListener(f2);
		

		
		
	    }
	


	
	
	
		
	}