package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.JRadioButton;

public class clsRegistrarse extends JFrame {

	private JPanel contentPane;
	private JLabel lblContacto;
	private JLabel lblNumero;
	private JLabel lblDoalzu;
	private JLabel lblEscribeTusDatos;
	private JTextField txtNombre=null;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextField txtEmail; 
	private JTextField txtContrasenya;
	private JTextField txtRepetirContrasenya;
	private JTextField txtDireccion;
	private JRadioButton rdbtnEmpresa;
	JRadioButton rdbtUsuario;
	JDateChooser dateChooser;
	ButtonGroup GrupoUsuarioEmpresa;
	Boolean radiobutton;
	JLabel lblFechaNac;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsRegistrarse frame = new clsRegistrarse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public clsRegistrarse() {
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		setBackground(Color.WHITE);
		
	
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Contacto
		lblContacto = new JLabel();
		lblContacto.setText("Contacto:");
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblContacto.setBorder(null);
		lblContacto.setBackground(Color.WHITE);
		lblContacto.setBounds(586, 0, 208, 36);
		contentPane.add(lblContacto);
		
		lblNumero = new JLabel();
		lblNumero.setForeground(Color.GRAY);
		lblNumero.setText("943227684");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 8));
		lblNumero.setBorder(null);
		lblNumero.setBackground(Color.WHITE);
		lblNumero.setBounds(637, 8, 69, 23);
		contentPane.add(lblNumero);
		
		//DOALZU
		lblDoalzu = new JLabel();
		lblDoalzu.setBackground(Color.WHITE);
		lblDoalzu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDoalzu.setForeground(Color.BLACK);
		lblDoalzu.setText("D O A L Z U");
		lblDoalzu.setBounds(24, 11, 110, 36);
		lblDoalzu.setBorder(null);
		contentPane.add(lblDoalzu);
		
		//Escribir tus datos personales
		lblEscribeTusDatos = new JLabel();
		lblEscribeTusDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEscribeTusDatos.setBackground(Color.WHITE);
		lblEscribeTusDatos.setText("Escribe tus datos personales");
		lblEscribeTusDatos.setBounds(225, 65, 208, 36);
		lblEscribeTusDatos.setBorder(null);
		contentPane.add(lblEscribeTusDatos);		



		
		
		//Escribir email
		txtEmail = new JTextField("Email");
		txtEmail.setForeground(Color.LIGHT_GRAY);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(174, 142, 140, 23);
		txtEmail.setBorder( new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(txtEmail);	

		//Escribir Contraseña
		txtContrasenya = new JTextField("Contrasenya");
		txtContrasenya.setForeground(Color.LIGHT_GRAY);
		txtContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContrasenya.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtContrasenya.setBackground(Color.WHITE);
		txtContrasenya.setBounds(349, 142, 140, 23);
		contentPane.add(txtContrasenya);
		
		//Repetir Contraseña
		txtRepetirContrasenya = new JTextField("Repetir Contrasenya");
		txtRepetirContrasenya.setForeground(Color.LIGHT_GRAY);
		txtRepetirContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRepetirContrasenya.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRepetirContrasenya.setBackground(Color.WHITE);
		txtRepetirContrasenya.setBounds(174, 192, 140, 23);
		contentPane.add(txtRepetirContrasenya);
		
		//Escribir localidad
		txtDireccion = new JTextField("Direcci\u00F3n");
		txtDireccion.setForeground(Color.LIGHT_GRAY);
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDireccion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setBounds(349, 192, 140, 23);
		contentPane.add(txtDireccion);
		
	
		
		//Boton registrar
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.BLACK);
	    btnRegistrar.setBounds(467, 347, 110, 30);
		contentPane.add(btnRegistrar);
		
		//RadioButton
		rdbtUsuario = new JRadioButton("Usuario");
		rdbtUsuario.setSelected(true);
		rdbtUsuario.setBackground(Color.WHITE);
		rdbtUsuario.setBounds(237, 99, 110, 23);
		contentPane.add(rdbtUsuario);
		
		
		rdbtnEmpresa = new JRadioButton("Empresa");
		rdbtnEmpresa.setBackground(Color.WHITE);
		rdbtnEmpresa.setBounds(349, 99, 110, 23);
		contentPane.add(rdbtnEmpresa);
		
		//Crear grupo radio button
		GrupoUsuarioEmpresa=new ButtonGroup();
		GrupoUsuarioEmpresa.add(rdbtUsuario);	
		GrupoUsuarioEmpresa.add(rdbtnEmpresa);

		radiobutton=true;
		CambioRadioButton();
		
		rdbtUsuario.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) 
 {	
	        	radiobutton=true;
	        	CambioRadioButton();
	    	
	        }
	    });
		
		rdbtnEmpresa.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	radiobutton=false;
	        	CambioRadioButton();
	        }
	    	
	    }
		
				);
		ActionListener al= new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				if ( obj == btnRegistrar && radiobutton == true)
				{
					

				
//					if(clsGestor.CrearUsuario(txtNombre.getText(), txtApellido1.getText(),  txtApellido2.getText(), txtEmail.getText(), txtContrasenya, FechaNac))
//					{
//						setVisible(false);
//						clsMenuRopa a= new clsMenuRopa();
//					}
					
					
					
				}
				else if (obj == btnRegistrar && radiobutton == false)
				{
					
					clsPrincipalEmpresa a= new clsPrincipalEmpresa();
					a.setVisible(true);
					setVisible(false);
				}
				
			}
			
		
		};
		btnRegistrar.addActionListener(al);	
		

		FocusListener fl= new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(e.getSource()==txtEmail)  txtEmail.setText("");	
				if(e.getSource()==txtContrasenya)  txtContrasenya.setText("");
				if(e.getSource()==txtDireccion)  txtDireccion.setText("");
				if(e.getSource()==txtRepetirContrasenya)  txtRepetirContrasenya.setText("");
			
					
			}
			@Override
			public void focusLost (FocusEvent e)
			{
				if(e.getSource()==txtEmail && txtEmail.getText().isEmpty()) txtEmail.setText("Email");
				if(e.getSource()==txtContrasenya && txtContrasenya.getText().isEmpty())  txtContrasenya.setText("Contraseña");
				if(e.getSource()==txtDireccion && txtDireccion.getText().isEmpty())  txtDireccion.setText("Localidad");
				if(e.getSource()==txtRepetirContrasenya && txtRepetirContrasenya.getText().isEmpty())  txtRepetirContrasenya.setText("Contraseña");

			}
			
			
		};
		
				
		txtEmail.addFocusListener(fl);
		txtContrasenya.addFocusListener(fl);
		txtDireccion.addFocusListener(fl);
		txtRepetirContrasenya.addFocusListener(fl);

		
//		if(txtEmail.getText()==null && (!txtEmail.isFocusOwner())) txtEmail.setText("Email");
		
	}
	
	//Metodo para actualizar panel Particular/Empresa
		public void CambioRadioButton()
		{
			if (radiobutton==true)
			{
				
				//EscribirApellido1
				txtApellido1 = new JTextField("1\u00BA Apellido");
				txtApellido1.setForeground(Color.LIGHT_GRAY);
				txtApellido1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtApellido1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtApellido1.setBackground(Color.WHITE);
				txtApellido1.setBounds(349, 241, 140, 23);
				contentPane.add(txtApellido1);
				
				//EscribirApellido2
				txtApellido2 = new JTextField("2\u00BA Apellido");
				txtApellido2.setForeground(Color.LIGHT_GRAY);
				txtApellido2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtApellido2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtApellido2.setBackground(Color.WHITE);
				txtApellido2.setBounds(349, 292, 140, 23);
				contentPane.add(txtApellido2);
		    	
			
				//Escribir nombre
				txtNombre = new JTextField();
				txtNombre.setText("Nombre");
				txtNombre.setForeground(Color.LIGHT_GRAY);
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtNombre.setBackground(Color.WHITE);
				txtNombre.setBounds(174, 241, 140, 23);
				contentPane.add(txtNombre);
				
				//FechaDeNacimiento
				dateChooser = new JDateChooser();
				dateChooser.setBounds(174, 308, 95, 20);
				contentPane.add(dateChooser);
				
				lblFechaNac = new JLabel("Fecha de nacimiento:");
				lblFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblFechaNac.setBounds(174, 285, 140, 14);
				contentPane.add(lblFechaNac);
				contentPane.repaint();
				
				FocusListener fl= new FocusAdapter()
				{
					@Override
					public void focusGained(FocusEvent e) 
					{
						
						if(e.getSource()==txtNombre)  txtNombre.setText("");					
						if(e.getSource()==txtApellido1)  txtApellido1.setText("");
						if(e.getSource()==txtApellido2)  txtApellido2.setText("");
					
							
					}
					@Override
					public void focusLost (FocusEvent e)
					{
						
						if(e.getSource()==txtNombre && txtNombre.getText().isEmpty())  txtNombre.setText("Nombre");
						if(e.getSource()==txtApellido1 && txtApellido1.getText().isEmpty())  txtApellido1.setText("Apellido1");
						if(e.getSource()==txtApellido2 && txtApellido2.getText().isEmpty())  txtApellido2.setText("Apellido2");
					}
					
					
				};
				
					
				txtNombre.addFocusListener(fl);
				txtApellido1.addFocusListener(fl);
				txtApellido2.addFocusListener(fl);
				
//				if(txtEmail.getText()==null && (!txtEmail.isFocusOwner())) txtEmail.setText("Email");
				
			
				
			}
			
			
			if (radiobutton==false)
			{
				//Borrar objetos de Particular
				contentPane.remove(txtApellido1);
				contentPane.remove(txtApellido2);
				contentPane.remove(lblFechaNac);
				contentPane.remove(dateChooser);
				contentPane.remove(txtNombre);
				
		      
				contentPane.repaint();
			
			
		}
		}
}

