package LP;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import LN.clsGestor;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;


public class clsRegistrarse_02 extends JFrame {


	
	private JPanel contentPane;
	private JLabel lblContacto;
	private JLabel lblNumero;
	private JLabel lblDoalzu;
	private JLabel lblEscribeTusDatos;
	private JTextField txtNombre=null;
	private JTextField txtApellidos;
	private JTextField txtEmail; 
	private JTextField txtLocalidad; 
	private JTextField txtCodigoPostal;
	private JPasswordField txtContrasenya;
	private JPasswordField txtRepetirContrasenya;
	private JTextField txtDireccion;
	private JRadioButton rdbtnEmpresa;
	private JLabel lblRegion;
	private JLabel lblSeleccionar;
	private JLabel lblFecNac;
	private JComboBox  ComboProvincias; 
	private JRadioButton rdbtUsuario;
	private JDateChooser dateChooser;
	private ButtonGroup GrupoUsuarioEmpresa;
	private Boolean radiobutton;
	private JButton btnRegistrar ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsRegistrarse_02 frame = new clsRegistrarse_02();
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
	public clsRegistrarse_02() {
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
//				txtContrasenya = new JPasswordField("Contrasenya");
//				txtContrasenya.setForeground(Color.LIGHT_GRAY);
//				txtContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 14));
//				txtContrasenya.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//				txtContrasenya.setBackground(Color.WHITE);
//				txtContrasenya.setEchoChar((char) 0);
//				txtContrasenya.setBounds(349, 142, 140, 23);
//				contentPane.add(txtContrasenya);
				
				//Escribir Contraseña
				txtContrasenya = new JPasswordField("Contrasenya");
				txtContrasenya.setEchoChar((char) 0);
				txtContrasenya.setForeground(Color.LIGHT_GRAY);
				txtContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtContrasenya.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtContrasenya.setBackground(Color.WHITE);
				txtContrasenya.setBounds(174, 192, 140, 23);
				contentPane.add(txtContrasenya);
				
				//Repetir Contraseña
				txtRepetirContrasenya = new JPasswordField("Repetir Contrasenya");
				txtRepetirContrasenya.setEchoChar((char) 0);
				txtRepetirContrasenya.setForeground(Color.LIGHT_GRAY);
				txtRepetirContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtRepetirContrasenya.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtRepetirContrasenya.setBackground(Color.WHITE);
				txtRepetirContrasenya.setBounds(349, 192, 140, 23);
				contentPane.add(txtRepetirContrasenya);
				
				//Escribir nombre
				txtNombre = new JTextField();
				txtNombre.setText("Nombre");
				txtNombre.setForeground(Color.LIGHT_GRAY);
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtNombre.setBackground(Color.WHITE);
				txtNombre.setBounds(174, 241, 140, 23);
				contentPane.add(txtNombre);
				
				lblRegion = new JLabel();
				lblRegion.setText("Región: España");
				lblRegion.setForeground(Color.BLACK);
				lblRegion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblRegion.setBackground(Color.WHITE);
				lblRegion.setBounds(174, 288, 140, 23);
				contentPane.add(lblRegion);
				
				txtDireccion = new JTextField();
				txtDireccion.setText("Direccion");
				txtDireccion.setForeground(Color.LIGHT_GRAY);
				txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtDireccion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtDireccion.setBackground(Color.WHITE);
				txtDireccion.setBounds(174, 334, 140, 23);
				contentPane.add(txtDireccion);
				
				txtCodigoPostal = new JTextField();
				txtCodigoPostal.setText("Codigo Postal");
				txtCodigoPostal.setForeground(Color.LIGHT_GRAY);
				txtCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCodigoPostal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtCodigoPostal.setBackground(Color.WHITE);
				txtCodigoPostal.setBounds(174, 378, 140, 23);
				contentPane.add(txtCodigoPostal);
				
				lblSeleccionar = new JLabel("Seleccionar:");
				lblSeleccionar.setBounds(349, 356, 84, 14);
				lblSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
				contentPane.add(lblSeleccionar);
				
				String pronvincias[]= {"\u00C1lava", "Albacete", "Alicante\u00A0", "Almer\u00EDa\u00A0", "Asturias\u00A0", "\u00C1vila", "Badajoz\u00A0", 
						"Barcelona", "Burgos", "C\u00E1ceres", "C\u00E1diz\u00A0", "Cantabria", "Castell\u00F3n\u00A0", 
						"Ciudad Real", "C\u00F3rdoba", "La Coru\u00F1a", "Cuenca\u00A0", "Gerona", "Granada", "Guadalajara", 
						"Guip\u00FAzcoa", "Huelva\u00A0", "Huesca", "Baleares", "Ja\u00E9n", "Le\u00F3n", "L\u00E9rida\u00A0", 
						"Lugo", "Madrid", "M\u00E1laga", "Murcia", "Navarra\u00A0", "Ourense", "Palencia", "Las Palmas", "Pontevedra", 
						"La Rioja", "Salamanca", "Segovia", "Sevilla", "Soria", "Tarragona"};
				
				ComboProvincias = new JComboBox(pronvincias);
				ComboProvincias.setMaximumRowCount(5);
				ComboProvincias.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				ComboProvincias.setBackground(Color.WHITE);
				ComboProvincias.setFont(new Font("Tahoma", Font.PLAIN, 14));
				ComboProvincias.setBounds(349, 381, 140, 23);
				contentPane.add(ComboProvincias);
				
				txtLocalidad = new JTextField();
				txtLocalidad.setText("Localidad");
				txtLocalidad.setForeground(Color.LIGHT_GRAY);
				txtLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtLocalidad.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtLocalidad.setBackground(Color.WHITE);
				txtLocalidad.setBounds(174, 430, 140, 23);
				contentPane.add(txtLocalidad);
				
				//Boton registrar
				btnRegistrar = new JButton("REGISTRAR");
				btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnRegistrar.setForeground(Color.WHITE);
				btnRegistrar.setBackground(Color.BLACK);
				btnRegistrar.setBounds(549, 496, 140, 30);
				contentPane.add(btnRegistrar);
				
				dateChooser = new JDateChooser();
				dateChooser.setBounds(174, 503, 140, 23);
				contentPane.add(dateChooser);
				
				//EscribirApellidos
				txtApellidos = new JTextField("Apellidos");
				txtApellidos.setForeground(Color.LIGHT_GRAY);
				txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtApellidos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtApellidos.setBackground(Color.WHITE);
				txtApellidos.setBounds(349, 241, 140, 23);
				contentPane.add(txtApellidos);
				
				
				
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
							boolean correo=validarEmailFuerte(txtEmail.getText());
							
							if( txtContrasenya.getText().equals(txtRepetirContrasenya.getText())&& correo)
							{
								SimpleDateFormat forma= new SimpleDateFormat("dd/mm/YYYY");
								String fecha= forma.format(dateChooser.getDate());
								;
										
								if (clsGestor.CrearUsuario(txtEmail.getText(), txtContrasenya.getText(), txtNombre.getText(), txtApellidos.getText(), 
														txtDireccion.getText(), txtCodigoPostal.getText(), (String) ComboProvincias.getSelectedItem() , 
														txtLocalidad.getText(),  dateChooser.getDate() , fecha ) )
								{
									clsMenuRopa a= new clsMenuRopa();
									setVisible(false);
								}
							}
							else 
							JOptionPane.showMessageDialog(null,"Correo o contraseña incorrectas");
							
							
							
						}
						else if (obj == btnRegistrar && radiobutton == false)
						{
							boolean correo=validarEmailFuerte(txtEmail.getText());
							if( txtContrasenya.getText().equals(txtRepetirContrasenya.getText())&& correo)
							{
								if (clsGestor.CrearTienda(txtEmail.getText(), txtContrasenya.getText(), txtNombre.getText(), txtApellidos.getText(), 
														txtDireccion.getText(), txtCodigoPostal.getText(), (String) ComboProvincias.getSelectedItem() , 
														txtLocalidad.getText() ) )
								{
									//Enviar correo de bienvenida
									clsEnviarEmail email=new clsEnviarEmail(txtEmail.getText());
									email.EnviarEmail();
									
									clsMenuTienda a= new clsMenuTienda();
									setVisible(false);
									
								}
								
							}	else
							{
								JOptionPane.showMessageDialog(null,"Correo o contraseña incorrectas");
							}
							
							
						}
						
					}
					
				
				};
			btnRegistrar.addActionListener(al);
			

				FocusListener fl= new FocusAdapter()
				{
					@Override
					public void focusGained(FocusEvent e) 
					{
						if(e.getSource()==txtEmail && (txtEmail.getText().equals("Email")) )
							{
								txtEmail.setText("");	
								txtEmail.setForeground(Color.BLACK);
							}
						
						if(e.getSource()==txtNombre && (txtNombre.getText().equals("Nombre")) )
						{
							txtNombre.setText("");	
							txtNombre.setForeground(Color.BLACK);
						}
						
						if(e.getSource()==txtContrasenya && (txtContrasenya.getText().equals("Contrasenya"))) 
							{
								txtContrasenya.setText("");
								txtContrasenya.setEchoChar('*');
								txtContrasenya.setForeground(Color.BLACK);
							}
							
						if(e.getSource()==txtDireccion && txtDireccion.getText().equals("Direccion")) 
							{
								txtDireccion.setText("");
								txtDireccion.setForeground(Color.BLACK);
							}
						
						if(e.getSource()==txtLocalidad && txtLocalidad.getText().equals("Localidad")) 
						{
							txtLocalidad.setText("");
							txtLocalidad.setForeground(Color.BLACK);
						}
						
						if(e.getSource()==txtCodigoPostal && txtCodigoPostal.getText().equals("Codigo Postal")) 
						{
							txtCodigoPostal.setText("");
							txtCodigoPostal.setForeground(Color.BLACK);
						}
						
						if(e.getSource()==txtRepetirContrasenya && txtRepetirContrasenya.getText().equals("Repetir Contrasenya")) 
							{
								txtRepetirContrasenya.setText("");
								txtRepetirContrasenya.setEchoChar('*');
								txtRepetirContrasenya.setForeground(Color.BLACK);
							}
					
							
					}
					@Override
					public void focusLost (FocusEvent e)
					{
						if(e.getSource()==txtEmail && txtEmail.getText().isEmpty()) 
							{
								txtEmail.setText("Email");
								txtEmail.setForeground(Color.LIGHT_GRAY);
							}
						
						if(e.getSource()==txtNombre && txtNombre.getText().isEmpty()) 
						{
							txtNombre.setText("Nombre");
							txtNombre.setForeground(Color.LIGHT_GRAY);
						}
						
						if(e.getSource()==txtContrasenya && txtContrasenya.getText().isEmpty()) 
							{
								txtContrasenya.setText("Contrasenya");
								txtContrasenya.setEchoChar((char) 0);
								txtContrasenya.setForeground(Color.LIGHT_GRAY);
							}
						if(e.getSource()==txtDireccion && txtDireccion.getText().isEmpty())
							{
								txtDireccion.setText("Direccion");
								txtDireccion.setForeground(Color.LIGHT_GRAY);
							}
						
						if(e.getSource()==txtLocalidad && txtLocalidad.getText().isEmpty())
						{
							txtLocalidad.setText("Localidad");
							txtLocalidad.setForeground(Color.LIGHT_GRAY);
						}
						
						if(e.getSource()==txtCodigoPostal && txtCodigoPostal.getText().isEmpty())
						{
							txtCodigoPostal.setText("Codigo Postal");
							txtCodigoPostal.setForeground(Color.LIGHT_GRAY);
						}
						
						
						
						
						if(e.getSource()==txtRepetirContrasenya && txtRepetirContrasenya.getText().isEmpty())  
							{
								txtRepetirContrasenya.setText("Repetir Contrasenya");
								txtRepetirContrasenya.setEchoChar((char) 0);
								txtRepetirContrasenya.setForeground(Color.LIGHT_GRAY);
							}

					}
					
					
				};
				
						
				txtEmail.addFocusListener(fl);
				txtNombre.addFocusListener(fl);
				txtDireccion.addFocusListener(fl);
				txtLocalidad.addFocusListener(fl);
				txtCodigoPostal.addFocusListener(fl);
				txtContrasenya.addFocusListener(fl);
				txtRepetirContrasenya.addFocusListener(fl);

				

				
			}
			
			//Metodo para actualizar panel Particular/Empresa
				public void CambioRadioButton()
				{
					if (radiobutton)
					{
						txtApellidos.setText("Apellidos");
						txtApellidos.setForeground(Color.LIGHT_GRAY);
						
						
						//fecha de nacimiento
						lblFecNac = new JLabel("Fecha de Nacimiento:");
						lblFecNac.setBounds(174, 478, 140, 14);
						lblFecNac.setFont(new Font("Tahoma", Font.PLAIN, 14));
						contentPane.add(lblFecNac);

						dateChooser.setVisible(true);
						contentPane.repaint();
						
						FocusListener fl= new FocusAdapter()
						{
							@Override
							public void focusGained(FocusEvent e) 
							{
							
								if(e.getSource()==txtApellidos && txtApellidos.getText().equals("Apellidos")&&radiobutton==true) 
									{
										txtApellidos.setText("");
										txtApellidos.setForeground(Color.BLACK);
										
									}

							
									
							}
							@Override
							public void focusLost (FocusEvent e)
							{
								
						
								if(e.getSource()==txtApellidos && txtApellidos.getText().isEmpty()&&radiobutton==true) 
									{
										txtApellidos.setText("Apellidos");
										txtApellidos.setForeground(Color.LIGHT_GRAY);
									}
								
							}
							
							
						};
						
							
						
						txtApellidos.addFocusListener(fl);
						
//						if(txtEmail.getText()==null && (!txtEmail.isFocusOwner())) txtEmail.setText("Email");
						
					
						
					}
					
					
					if (radiobutton==false)
					{
						//Borrar objetos de Particular
						contentPane.remove(lblFecNac);
						dateChooser.setVisible(false);
						txtApellidos.setForeground(Color.LIGHT_GRAY);
						txtApellidos.setText("NIF");
						
						
						
						FocusListener fl= new FocusAdapter()
						{
							@Override
							public void focusGained(FocusEvent e) 
							{
							
								if(e.getSource()==txtApellidos && txtApellidos.getText().equals("NIF")&& radiobutton==false) 
									{
										txtApellidos.setText("");
										txtApellidos.setForeground(Color.BLACK);
										
									}

							
									
							}
							@Override
							public void focusLost (FocusEvent e)
							{
								
						
								if(e.getSource()==txtApellidos && txtApellidos.getText().isEmpty() && radiobutton==false) 
									{
										txtApellidos.setText("NIF");
										txtApellidos.setForeground(Color.LIGHT_GRAY);
									}
								
							}
							
							
						};
						
							
						txtApellidos.addFocusListener(fl);
					
					
				}
					
				
			
		
		
	}
				/**
				 * Comprueba si es un correo, o no
				 * @param email
				 * @return true= si el correo es válido 
				 */
				public static boolean validarEmailFuerte(String email){
			        
			        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			 
			        Pattern pattern = Pattern.compile(regex);
			        Matcher matcher = pattern.matcher(email);
			        
			        return matcher.matches();
			    }
}
