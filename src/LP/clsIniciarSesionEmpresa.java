package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class clsIniciarSesionEmpresa extends JFrame
{
clsPanelFondo pPrincipal;
	
	private JTextField txtCorreo;
	private JTextField txtPassword;
	private JButton bLogIn;
	
	JPanel pLogo;

	
	public clsIniciarSesionEmpresa ()
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
		
		bLogIn =new JButton("Log In");
		txtCorreo= new JTextField();
		txtPassword= new JTextField();
		
		pSuperior.add(txtCorreo);
		pSuperior.add(txtPassword);
		pSuperior.add(bLogIn);
		txtCorreo.setColumns(10);
		txtPassword.setColumns(10);
		bLogIn.setBackground(Color.GRAY);

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

					clsPrincipalEmpresa a= new clsPrincipalEmpresa();
					a.setVisible(true);

			}
			
		};
		
		bLogIn.addActionListener(al);

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
	}
}
