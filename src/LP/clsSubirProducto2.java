package LP;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import LN.clsGestor;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class clsSubirProducto2 extends JFrame {


	
	private JPanel contentPane;
	private JLabel lblDoalzu;
	private JLabel lblEscogerDatos;
	private JTextField txtNombre=null;
	private JTextField txtMarca;
	private JTextField txtCodigoPostal;
	private JTextField txtEmail;
	private JTextField txtContrasenya;
	private JTextField txtRepetirContrasenya;
	private JTextField txtDescripcion;
	private JTextField txtLocalidad;
	private JRadioButton rdbtCosmetico;
	private JLabel lblFecNac;
	private JComboBox  ComboCategoria; 
	private JRadioButton rdbtRopa;
	private ButtonGroup GrupoRopaCosmetico;
	private ButtonGroup GrupoMujerHombre;
	private Boolean radiobutton;
	private JLabel label;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private JButton btnSubirImagen;
	private JLabel lblCantidad;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtM;
	private JTextField txtL;
	private JTextField txtXl;
	private JButton btnSubirProducto;
	private JLabel labelFoto;
	private GridBagConstraints gbc_label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsSubirProducto2 frame = new clsSubirProducto2();
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
	public clsSubirProducto2() {
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
				GridBagLayout gbl_contentPane = new GridBagLayout();
				gbl_contentPane.columnWidths = new int[]{110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 173, 140, 60, 245, 0};
				gbl_contentPane.rowHeights = new int[]{47, 0, 57, 23, 23, 23, 0, 23, 0, 0, 0, 0, 0, 0, 0, 36, 26, 23, 43, 30, 0};
				gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				contentPane.setLayout(gbl_contentPane);
												
												
													//DOALZU
													lblDoalzu = new JLabel();
													lblDoalzu.setBackground(Color.WHITE);
													lblDoalzu.setFont(new Font("Times New Roman", Font.BOLD, 18));
													lblDoalzu.setForeground(Color.BLACK);
													lblDoalzu.setText("D O A L Z U");
													lblDoalzu.setBorder(null);
													GridBagConstraints gbc_lblDoalzu = new GridBagConstraints();
													gbc_lblDoalzu.gridwidth = 5;
													gbc_lblDoalzu.fill = GridBagConstraints.BOTH;
													gbc_lblDoalzu.insets = new Insets(0, 0, 5, 5);
													gbc_lblDoalzu.gridx = 1;
													gbc_lblDoalzu.gridy = 1;
													contentPane.add(lblDoalzu, gbc_lblDoalzu);
													
													//Escoger datos
													lblEscogerDatos = new JLabel();
													lblEscogerDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
													lblEscogerDatos.setBackground(Color.WHITE);
													lblEscogerDatos.setText("Escoja el tipo de producto");
													lblEscogerDatos.setBorder(null);
													GridBagConstraints gbc_lblEscribeTusDatos = new GridBagConstraints();
													gbc_lblEscribeTusDatos.anchor = GridBagConstraints.WEST;
													gbc_lblEscribeTusDatos.gridwidth = 7;
													gbc_lblEscribeTusDatos.insets = new Insets(0, 0, 5, 5);
													gbc_lblEscribeTusDatos.gridx = 2;
													gbc_lblEscribeTusDatos.gridy = 2;
													contentPane.add(lblEscogerDatos, gbc_lblEscribeTusDatos);		
												
												
												
												//RadioButton
												rdbtRopa = new JRadioButton("Ropa");
												rdbtRopa.setSelected(true);
												rdbtRopa.setBackground(Color.WHITE);
												GridBagConstraints gbc_rdbtUsuario = new GridBagConstraints();
												gbc_rdbtUsuario.gridwidth = 5;
												gbc_rdbtUsuario.anchor = GridBagConstraints.SOUTHEAST;
												gbc_rdbtUsuario.insets = new Insets(0, 0, 5, 5);
												gbc_rdbtUsuario.gridx = 3;
												gbc_rdbtUsuario.gridy = 3;
												contentPane.add(rdbtRopa, gbc_rdbtUsuario);
//												GrupoRopaCosmetico.add(rdbtRopa);	
														
												rdbtCosmetico = new JRadioButton("Cosmetico");
												rdbtCosmetico.setBackground(Color.WHITE);
												GridBagConstraints gbc_rdbtnEmpresa = new GridBagConstraints();
												gbc_rdbtnEmpresa.anchor = GridBagConstraints.SOUTH;
												gbc_rdbtnEmpresa.fill = GridBagConstraints.HORIZONTAL;
												gbc_rdbtnEmpresa.insets = new Insets(0, 0, 5, 5);
												gbc_rdbtnEmpresa.gridx = 9;
												gbc_rdbtnEmpresa.gridy = 3;
												contentPane.add(rdbtCosmetico, gbc_rdbtnEmpresa);
//												GrupoRopaCosmetico.add(rdbtCosmetico);
								
								label = new JLabel();
								label.setText("Escriba los datos del producto");
								label.setFont(new Font("Tahoma", Font.BOLD, 14));
								label.setBorder(null);
								label.setBackground(Color.WHITE);
								GridBagConstraints gbc_label = new GridBagConstraints();
								gbc_label.anchor = GridBagConstraints.WEST;
								gbc_label.gridwidth = 7;
								gbc_label.insets = new Insets(0, 0, 5, 5);
								gbc_label.gridx = 2;
								gbc_label.gridy = 5;
								contentPane.add(label, gbc_label);
								
								rdbtnMujer = new JRadioButton("Mujer");
								rdbtnMujer.setSelected(true);
								GridBagConstraints gbc_rdbtnMujer = new GridBagConstraints();
								gbc_rdbtnMujer.insets = new Insets(0, 0, 5, 5);
								gbc_rdbtnMujer.gridx = 9;
								gbc_rdbtnMujer.gridy = 6;
								contentPane.add(rdbtnMujer, gbc_rdbtnMujer);
//								GrupoMujerHombre.add(rdbtnMujer);
								
								rdbtnHombre = new JRadioButton("Hombre");
								GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
								gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 5);
								gbc_rdbtnHombre.gridx = 13;
								gbc_rdbtnHombre.gridy = 6;
								contentPane.add(rdbtnHombre, gbc_rdbtnHombre);
//								GrupoMujerHombre.add(rdbtnHombre);
				
				//Escribir nombre
				txtNombre = new JTextField();
				txtNombre.setText("Nombre (No mas de 40 caracteres)");
				txtNombre.setForeground(Color.LIGHT_GRAY);
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtNombre.setBackground(Color.WHITE);
				GridBagConstraints gbc_txtNombre = new GridBagConstraints();
				gbc_txtNombre.anchor = GridBagConstraints.NORTH;
				gbc_txtNombre.gridwidth = 8;
				gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
				gbc_txtNombre.gridx = 2;
				gbc_txtNombre.gridy = 8;
				contentPane.add(txtNombre, gbc_txtNombre);
				
				txtDescripcion = new JTextField();
				txtDescripcion.setText("Descripcion");
				txtDescripcion.setForeground(Color.LIGHT_GRAY);
				txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtDescripcion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtDescripcion.setBackground(Color.WHITE);
				GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
				gbc_txtDireccion.gridheight = 2;
				gbc_txtDireccion.gridwidth = 7;
				gbc_txtDireccion.anchor = GridBagConstraints.NORTH;
				gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
				gbc_txtDireccion.gridx = 2;
				gbc_txtDireccion.gridy = 9;
				contentPane.add(txtDescripcion, gbc_txtDireccion);
				
				ComboCategoria = new JComboBox();
				ComboCategoria.setMaximumRowCount(5);
				ComboCategoria.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				ComboCategoria.setBackground(Color.WHITE);
				ComboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_ComboProvincias = new GridBagConstraints();
				gbc_ComboProvincias.gridwidth = 3;
				gbc_ComboProvincias.anchor = GridBagConstraints.SOUTH;
				gbc_ComboProvincias.fill = GridBagConstraints.HORIZONTAL;
				gbc_ComboProvincias.insets = new Insets(0, 0, 5, 5);
				gbc_ComboProvincias.gridx = 13;
				gbc_ComboProvincias.gridy = 9;
				contentPane.add(ComboCategoria, gbc_ComboProvincias);
				
				lblCantidad = new JLabel("Cantidad");
				GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
				gbc_lblCantidad.anchor = GridBagConstraints.WEST;
				gbc_lblCantidad.gridwidth = 3;
				gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
				gbc_lblCantidad.gridx = 13;
				gbc_lblCantidad.gridy = 10;
				contentPane.add(lblCantidad, gbc_lblCantidad);
				
				//EscribirApellidos
				txtMarca = new JTextField("Marca");
				txtMarca.setForeground(Color.LIGHT_GRAY);
				txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtMarca.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtMarca.setBackground(Color.WHITE);
				GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
				gbc_txtApellidos.gridwidth = 5;
				gbc_txtApellidos.fill = GridBagConstraints.BOTH;
				gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
				gbc_txtApellidos.gridx = 2;
				gbc_txtApellidos.gridy = 11;
				contentPane.add(txtMarca, gbc_txtApellidos);
				
				textField = new JTextField("XS");
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.gridheight = 2;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 13;
				gbc_textField.gridy = 11;
				contentPane.add(textField, gbc_textField);
				textField.setColumns(10);
				
				txtCodigoPostal = new JTextField();
				txtCodigoPostal.setText("Precio");
				txtCodigoPostal.setForeground(Color.LIGHT_GRAY);
				txtCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCodigoPostal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtCodigoPostal.setBackground(Color.WHITE);
				GridBagConstraints gbc_txtCodigoPostal = new GridBagConstraints();
				gbc_txtCodigoPostal.gridwidth = 2;
				gbc_txtCodigoPostal.anchor = GridBagConstraints.NORTH;
				gbc_txtCodigoPostal.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCodigoPostal.insets = new Insets(0, 0, 5, 5);
				gbc_txtCodigoPostal.gridx = 2;
				gbc_txtCodigoPostal.gridy = 12;
				contentPane.add(txtCodigoPostal, gbc_txtCodigoPostal);
				
				textField_1 = new JTextField("S");
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.gridwidth = 2;
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 12;
				gbc_textField_1.gridy = 13;
				contentPane.add(textField_1, gbc_textField_1);
				textField_1.setColumns(10);
				
				btnSubirImagen = new JButton("Subir imagen");
				GridBagConstraints gbc_btnSubirImagen = new GridBagConstraints();
				gbc_btnSubirImagen.insets = new Insets(0, 0, 5, 5);
				gbc_btnSubirImagen.gridx = 2;
				gbc_btnSubirImagen.gridy = 14;
				contentPane.add(btnSubirImagen, gbc_btnSubirImagen);
				
				labelFoto = new JLabel("FOTO");
				Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
				labelFoto.setBorder(border);
				gbc_label_1 = new GridBagConstraints();
				gbc_label_1.weighty = 10.0;
				gbc_label_1.weightx = 10.0;
				gbc_label_1.ipady = 99;
				gbc_label_1.ipadx = 99;
				gbc_label_1.gridheight = 6;
				gbc_label_1.gridwidth = 8;
				gbc_label_1.insets = new Insets(5, 5, 5, 5);
				gbc_label_1.gridx = 4;
				gbc_label_1.gridy = 14;
				contentPane.add(labelFoto, gbc_label_1);
				
				txtM = new JTextField();
				txtM.setText("M");
				GridBagConstraints gbc_txtM = new GridBagConstraints();
				gbc_txtM.insets = new Insets(0, 0, 5, 5);
				gbc_txtM.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtM.gridx = 13;
				gbc_txtM.gridy = 14;
				contentPane.add(txtM, gbc_txtM);
				txtM.setColumns(10);
				
				txtL = new JTextField();
				txtL.setText("L");
				GridBagConstraints gbc_txtL = new GridBagConstraints();
				gbc_txtL.insets = new Insets(0, 0, 5, 5);
				gbc_txtL.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtL.gridx = 13;
				gbc_txtL.gridy = 15;
				contentPane.add(txtL, gbc_txtL);
				txtL.setColumns(10);
				
				txtXl = new JTextField();
				txtXl.setText("XL");
				GridBagConstraints gbc_txtXl = new GridBagConstraints();
				gbc_txtXl.insets = new Insets(0, 0, 5, 5);
				gbc_txtXl.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtXl.gridx = 13;
				gbc_txtXl.gridy = 16;
				contentPane.add(txtXl, gbc_txtXl);
				txtXl.setColumns(10);
				
				btnSubirProducto = new JButton("SUBIR PRODUCTO");
				GridBagConstraints gbc_btnSubirProducto = new GridBagConstraints();
				gbc_btnSubirProducto.anchor = GridBagConstraints.WEST;
				gbc_btnSubirProducto.insets = new Insets(0, 0, 5, 0);
				gbc_btnSubirProducto.gridx = 16;
				gbc_btnSubirProducto.gridy = 17;
				btnSubirImagen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						File dirActual = new File( System.getProperty("user.dir") );
						File fichero = null;
						JFileChooser chooser = new JFileChooser( dirActual );
						
						FileNameExtensionFilter filtro = new FileNameExtensionFilter ("JPG", "jpg", "png", "PNG");
						chooser.setFileFilter(filtro);
						int returnVal = chooser.showOpenDialog( null );
						
						if (JFileChooser.APPROVE_OPTION == returnVal)
						{
							fichero = chooser.getSelectedFile();
							
							try
							{
								ImageIcon icon = new ImageIcon (fichero.toString());
								
								Icon icono = new ImageIcon (icon.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
							
								labelFoto.setText(null);
								
								labelFoto.setIcon(icono);
								
								contentPane.remove(labelFoto);
								
								contentPane.add(labelFoto, gbc_label_1);
							}
							catch (Exception ex)
							{
								JOptionPane.showMessageDialog(null, "Error abriendo la imagen" + ex);
							}
						}

					}
				});
				contentPane.add(btnSubirProducto, gbc_btnSubirProducto);
								
				//Crear grupo radio button
				GrupoRopaCosmetico=new ButtonGroup();
				GrupoMujerHombre = new ButtonGroup();

				radiobutton=true;
				CambioRadioButton();
				
			

				rdbtRopa.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) 
	 {	
		        	radiobutton=true;
		        	CambioRadioButton();
		    	
		        }
		    });
			
				rdbtCosmetico.addActionListener(new ActionListener() {
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
					if ( obj == btnSubirProducto && radiobutton == true)
						
					{
//						boolean correo=validarEmailFuerte(txtEmail.getText());
//						
//						if( txtContrasenya.getText().equals(txtRepetirContrasenya.getText())&& correo)
//						{
//							SimpleDateFormat forma= new SimpleDateFormat("dd/mm/YYYY");
//							
//						}
//						else System.out.println("correo o contra incorrectas");
//	 
						
						
						
					}
//					else if (obj == btnSubirProducto && radiobutton == false)
//					{
//						boolean correo=validarEmailFuerte(txtEmail.getText());
//						if( txtContrasenya.getText().equals(txtRepetirContrasenya.getText())&& correo)
//						{
//							if (clsGestor.CrearTienda(txtEmail.getText(), txtContrasenya.getText(), txtNombre.getText(), txtMarca.getText(), 
//									txtDescripcion.getText(), txtCodigoPostal.getText(), (String) ComboCategoria.getSelectedItem() , 
//													txtLocalidad.getText() ) )
//							{
//								//Enviar correo de bienvenida
//								clsEnviarEmail email=new clsEnviarEmail(txtEmail.getText());
//								email.EnviarEmail();
//								
//								clsPrincipalEmpresa a= new clsPrincipalEmpresa();
//								a.setVisible(true);
//								setVisible(false);
//								
//							}
//							
//						}		
//						
//						
//					}
//					
				}
				
			
			};
		

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
							((JPasswordField) txtContrasenya).setEchoChar('*');
							txtContrasenya.setForeground(Color.BLACK);
						}
						
					if(e.getSource()==txtDescripcion && txtDescripcion.getText().equals("Direccion")) 
						{
						txtDescripcion.setText("");
						txtDescripcion.setForeground(Color.BLACK);
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
							((JPasswordField) txtRepetirContrasenya).setEchoChar('*');
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
							((JPasswordField) txtContrasenya).setEchoChar((char) 0);
							txtContrasenya.setForeground(Color.LIGHT_GRAY);
						}
					if(e.getSource()==txtDescripcion && txtDescripcion.getText().isEmpty())
						{
							txtDescripcion.setText("Direccion");
							txtDescripcion.setForeground(Color.LIGHT_GRAY);
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
							((JPasswordField) txtRepetirContrasenya).setEchoChar((char) 0);
							txtRepetirContrasenya.setForeground(Color.LIGHT_GRAY);
						}

				}
				
				
			};
			
					
//			txtEmail.addFocusListener(fl);
//			txtNombre.addFocusListener(fl);
//			txtDireccion.addFocusListener(fl);
//			txtLocalidad.addFocusListener(fl);
//			txtCodigoPostal.addFocusListener(fl);
//			txtContrasenya.addFocusListener(fl);
//			txtRepetirContrasenya.addFocusListener(fl);

			

			
		}
		
		//Metodo para actualizar panel Particular/Empresa
			public void CambioRadioButton()
			{
				if (radiobutton)
				{
					txtMarca.setText("Apellidos");
					txtMarca.setForeground(Color.LIGHT_GRAY);
					
					FocusListener fl= new FocusAdapter()
					{
						@Override
						public void focusGained(FocusEvent e) 
						{
						
							if(e.getSource()==txtMarca && txtMarca.getText().equals("Apellidos")&&radiobutton==true) 
								{
								txtMarca.setText("");
								txtMarca.setForeground(Color.BLACK);
									
								}

						
								
						}
						@Override
						public void focusLost (FocusEvent e)
						{
							
					
							if(e.getSource()==txtMarca && txtMarca.getText().isEmpty()&&radiobutton==true) 
								{
								txtMarca.setText("Apellidos");
								txtMarca.setForeground(Color.LIGHT_GRAY);
								}
							
						}
						
						
					};
					
						
					
					txtMarca.addFocusListener(fl);
					
//					if(txtEmail.getText()==null && (!txtEmail.isFocusOwner())) txtEmail.setText("Email");
					
				
					
				}
				
				
				if (radiobutton==false)
				{
					//Borrar objetos de Particular
					contentPane.remove(lblFecNac);
					txtMarca.setForeground(Color.LIGHT_GRAY);
					txtMarca.setText("NIF");
					
					
					
					FocusListener fl= new FocusAdapter()
					{
						@Override
						public void focusGained(FocusEvent e) 
						{
						
							if(e.getSource()==txtMarca && txtMarca.getText().equals("NIF")&& radiobutton==false) 
								{
								txtMarca.setText("");
									txtMarca.setForeground(Color.BLACK);
									
								}

						
								
						}
						@Override
						public void focusLost (FocusEvent e)
						{
							
					
							if(e.getSource()==txtMarca && txtMarca.getText().isEmpty() && radiobutton==false) 
								{
								txtMarca.setText("NIF");
								txtMarca.setForeground(Color.LIGHT_GRAY);
								}
							
						}
						
						
					};
					
						
					txtMarca.addFocusListener(fl);
				
				
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
