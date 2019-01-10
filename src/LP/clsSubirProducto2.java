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

import LN.clsConstantes.enTipoCosmeticoHombre;
import LN.clsConstantes.enTipoCosmeticoMujer;
import LN.clsConstantes.enTipoRopaHombre;
import LN.clsConstantes.enTipoRopaMujer;
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
	private JTextField txtPrecio;
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
	private Boolean radiobutton1;
	private JLabel label;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private JButton btnSubirImagen;
	private JLabel lblCantidad;
	private JTextField txtXS;
	private JTextField txtS;
	private JTextField txtM;
	private JTextField txtL;
	private JTextField txtXl;
	private JButton btnSubirProducto;
	private JLabel labelFoto;
	private GridBagConstraints gbc_label_1;
	GridBagConstraints gbc_ComboCategoria;
	

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
				gbl_contentPane.rowHeights = new int[]{47, 0, 57, 23, 23, 23, 0, 23, 0, 0, 0, 0, 0, 0, 0, 36, 26, 23, 43, 8, 0};
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
					GridBagConstraints gbc_lblEscogerDatos = new GridBagConstraints();
					gbc_lblEscogerDatos.anchor = GridBagConstraints.WEST;
					gbc_lblEscogerDatos.gridwidth = 7;
					gbc_lblEscogerDatos.insets = new Insets(0, 0, 5, 5);
					gbc_lblEscogerDatos.gridx = 2;
					gbc_lblEscogerDatos.gridy = 2;
					contentPane.add(lblEscogerDatos, gbc_lblEscogerDatos);		
				
				
				
				//RadioButton
				rdbtRopa = new JRadioButton("Ropa");
				rdbtRopa.setSelected(true);
				rdbtRopa.setBackground(Color.WHITE);
				GridBagConstraints gbc_rdbtRopa = new GridBagConstraints();
				gbc_rdbtRopa.gridwidth = 5;
				gbc_rdbtRopa.anchor = GridBagConstraints.SOUTHEAST;
				gbc_rdbtRopa.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtRopa.gridx = 3;
				gbc_rdbtRopa.gridy = 3;
				contentPane.add(rdbtRopa, gbc_rdbtRopa);
					
						
				rdbtCosmetico = new JRadioButton("Cosmetico");
				rdbtCosmetico.setBackground(Color.WHITE);
				GridBagConstraints gbc_rdbtCosmetico = new GridBagConstraints();
				gbc_rdbtCosmetico.anchor = GridBagConstraints.SOUTH;
				gbc_rdbtCosmetico.fill = GridBagConstraints.HORIZONTAL;
				gbc_rdbtCosmetico.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtCosmetico.gridx = 9;
				gbc_rdbtCosmetico.gridy = 3;
				contentPane.add(rdbtCosmetico, gbc_rdbtCosmetico);
				
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
				rdbtnMujer.setBackground(Color.WHITE);
				rdbtnMujer.setSelected(true);
				GridBagConstraints gbc_rdbtnMujer = new GridBagConstraints();
				gbc_rdbtnMujer.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnMujer.gridx = 9;
				gbc_rdbtnMujer.gridy = 6;
				contentPane.add(rdbtnMujer, gbc_rdbtnMujer);
				
				rdbtnHombre = new JRadioButton("Hombre");
				rdbtnHombre.setBackground(Color.WHITE);
				GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
				gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHombre.gridx = 13;
				gbc_rdbtnHombre.gridy = 6;
				contentPane.add(rdbtnHombre, gbc_rdbtnHombre);
				
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
				GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
				gbc_txtDescripcion.gridheight = 2;
				gbc_txtDescripcion.gridwidth = 7;
				gbc_txtDescripcion.anchor = GridBagConstraints.NORTH;
				gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
				gbc_txtDescripcion.gridx = 2;
				gbc_txtDescripcion.gridy = 9;
				contentPane.add(txtDescripcion, gbc_txtDescripcion);
				
				ComboCategoria = new JComboBox();
				ComboCategoria.setMaximumRowCount(5);
				ComboCategoria.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				ComboCategoria.setBackground(Color.WHITE);
				ComboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
				gbc_ComboCategoria = new GridBagConstraints();
				gbc_ComboCategoria.gridwidth = 3;
				gbc_ComboCategoria.anchor = GridBagConstraints.SOUTH;
				gbc_ComboCategoria.fill = GridBagConstraints.HORIZONTAL;
				gbc_ComboCategoria.insets = new Insets(0, 0, 5, 5);
				gbc_ComboCategoria.gridx = 13;
				gbc_ComboCategoria.gridy = 9;
				for (enTipoRopaMujer a: enTipoRopaMujer.values())
				{
					ComboCategoria.addItem(a.toString());
				}
				contentPane.add(ComboCategoria, gbc_ComboCategoria);
				
				lblCantidad = new JLabel("Cantidad");
				GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
				gbc_lblCantidad.anchor = GridBagConstraints.WEST;
				gbc_lblCantidad.gridwidth = 3;
				gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
				gbc_lblCantidad.gridx = 13;
				gbc_lblCantidad.gridy = 10;
				contentPane.add(lblCantidad, gbc_lblCantidad);
				
				txtMarca = new JTextField("Marca");
				txtMarca.setForeground(Color.LIGHT_GRAY);
				txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtMarca.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtMarca.setBackground(Color.WHITE);
				GridBagConstraints gbc_txtMarca = new GridBagConstraints();
				gbc_txtMarca.gridwidth = 5;
				gbc_txtMarca.fill = GridBagConstraints.BOTH;
				gbc_txtMarca.insets = new Insets(0, 0, 5, 5);
				gbc_txtMarca.gridx = 2;
				gbc_txtMarca.gridy = 11;
				contentPane.add(txtMarca, gbc_txtMarca);
				
				txtXS = new JTextField("XS");
				txtXS.setForeground(Color.LIGHT_GRAY);
				txtXS.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtXS.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtXS.setBackground(Color.WHITE);
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.gridheight = 2;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 13;
				gbc_textField.gridy = 11;
				contentPane.add(txtXS, gbc_textField);
				txtXS.setColumns(10);
				
				txtPrecio = new JTextField();
				txtPrecio.setText("Precio");
				txtPrecio.setForeground(Color.LIGHT_GRAY);
				txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtPrecio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtPrecio.setBackground(Color.WHITE);
				GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
				gbc_txtPrecio.gridwidth = 2;
				gbc_txtPrecio.anchor = GridBagConstraints.NORTH;
				gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
				gbc_txtPrecio.gridx = 2;
				gbc_txtPrecio.gridy = 12;
				contentPane.add(txtPrecio, gbc_txtPrecio);
				
				txtS = new JTextField("S");
				txtS.setForeground(Color.LIGHT_GRAY);
				txtS.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtS.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtS.setBackground(Color.WHITE);
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 13;
				gbc_textField_1.gridy = 13;
				contentPane.add(txtS, gbc_textField_1);
				txtS.setColumns(10);
				
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
				gbc_label_1.fill = GridBagConstraints.BOTH;
				gbc_label_1.weighty = 10.0;
				gbc_label_1.weightx = 10.0;
				gbc_label_1.ipady = 99;
				gbc_label_1.ipadx = 99;
				gbc_label_1.gridheight = 6;
				gbc_label_1.gridwidth = 8;
				gbc_label_1.insets = new Insets(5, 5, 23, 10);
				gbc_label_1.gridx = 4;
				gbc_label_1.gridy = 14;
				contentPane.add(labelFoto, gbc_label_1);
				
				txtM = new JTextField();
				txtM.setText("M");
				txtM.setForeground(Color.LIGHT_GRAY);
				txtM.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtM.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtM.setBackground(Color.WHITE);
				GridBagConstraints gbc_txtM = new GridBagConstraints();
				gbc_txtM.insets = new Insets(0, 0, 5, 5);
				gbc_txtM.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtM.gridx = 13;
				gbc_txtM.gridy = 14;
				contentPane.add(txtM, gbc_txtM);
				txtM.setColumns(10);
				
				txtL = new JTextField();
				txtL.setText("L");
				txtL.setForeground(Color.LIGHT_GRAY);
				txtL.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtL.setBackground(Color.WHITE);
				GridBagConstraints gbc_txtL = new GridBagConstraints();
				gbc_txtL.insets = new Insets(0, 0, 5, 5);
				gbc_txtL.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtL.gridx = 13;
				gbc_txtL.gridy = 15;
				contentPane.add(txtL, gbc_txtL);
				txtL.setColumns(10);
				
				txtXl = new JTextField();
				txtXl.setText("XL");
				txtXl.setForeground(Color.LIGHT_GRAY);
				txtXl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtXl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				txtXl.setBackground(Color.WHITE);
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
				
				btnSubirProducto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						ComprobarPrecio();
					}
					});
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
				GrupoRopaCosmetico.add(rdbtRopa);
				GrupoRopaCosmetico.add(rdbtCosmetico);
				
				GrupoMujerHombre = new ButtonGroup();
				GrupoMujerHombre.add(rdbtnMujer);
				GrupoMujerHombre.add(rdbtnHombre);
				
			FocusListener fl= new FocusAdapter()
			{
				@Override
				public void focusGained(FocusEvent e) 
				{

					if(e.getSource()==txtNombre && (txtNombre.getText().equals("Nombre (No mas de 40 caracteres)")) )
					{
						txtNombre.setText("");	
						txtNombre.setForeground(Color.BLACK);
					}
					
					if(e.getSource()==txtMarca && (txtMarca.getText().equals("Marca"))) 
					{
						txtMarca.setText("");
						txtMarca.setForeground(Color.BLACK);
					}
						
					if(e.getSource()==txtDescripcion && txtDescripcion.getText().equals("Descripcion")) 
					{
						txtDescripcion.setText("");
						txtDescripcion.setForeground(Color.BLACK);
					}
					
					if(e.getSource()==txtPrecio && txtPrecio.getText().equals("Precio")) 
					{
						txtDescripcion.setText("");
						txtDescripcion.setForeground(Color.BLACK);
					}
					
					if(e.getSource()==txtXS && txtXS.getText().equals("XS")) 
					{
						txtXS.setText("");
						txtXS.setForeground(Color.BLACK);
					}
					
					if(e.getSource()==txtS && txtS.getText().equals("S")) 
					{
						txtS.setText("");
						txtS.setForeground(Color.BLACK);
					}
					
					if(e.getSource()==txtM && txtM.getText().equals("M")) 
					{
						txtM.setText("");
						txtM.setForeground(Color.BLACK);
					}
					
					if(e.getSource()==txtL && txtL.getText().equals("L")) 
					{
						txtL.setText("");
						txtL.setForeground(Color.BLACK);
					}
					
					if(e.getSource()==txtXl && txtXl.getText().equals("XL")) 
					{
						txtXl.setText("");
						txtXl.setForeground(Color.BLACK);
					}		
				}
				@Override
				public void focusLost (FocusEvent e)
				{
					if(e.getSource()==txtNombre && txtNombre.getText().isEmpty()) 
						{
							txtNombre.setText("Nombre (No mas de 40 caracteres)");
							txtNombre.setForeground(Color.LIGHT_GRAY);
						}
					
					if(e.getSource()==txtMarca && txtMarca.getText().isEmpty()) 
					{
						txtMarca.setText("Marca");
						txtMarca.setForeground(Color.LIGHT_GRAY);
					}
					
					if(e.getSource()==txtPrecio && txtPrecio.getText().isEmpty()) 
					{
						txtPrecio.setText("Precio");
						txtPrecio.setForeground(Color.LIGHT_GRAY);
					}
					
					if(e.getSource()==txtDescripcion && txtDescripcion.getText().isEmpty()) 
					{
						txtDescripcion.setText("Descripcion");
						txtDescripcion.setForeground(Color.LIGHT_GRAY);
					}
					
					if(e.getSource()==txtXS && txtXS.getText().isEmpty())
					{
						txtXS.setText("XS");
						txtXS.setForeground(Color.LIGHT_GRAY);
					}
					
					if(e.getSource()==txtS && txtS.getText().isEmpty())
					{
						txtS.setText("S");
						txtS.setForeground(Color.LIGHT_GRAY);
					}
					
					if(e.getSource()==txtM && txtM.getText().isEmpty())
					{
						txtM.setText("M");
						txtM.setForeground(Color.LIGHT_GRAY);
					}
					
					if(e.getSource()==txtL && txtL.getText().isEmpty())
					{
						txtL.setText("L");
						txtL.setForeground(Color.LIGHT_GRAY);
					}
					
					if(e.getSource()==txtXl && txtXl.getText().isEmpty())
					{
						txtL.setText("XL");
						txtL.setForeground(Color.LIGHT_GRAY);
					}
				}	
			};
			
			txtNombre.addFocusListener(fl);
			txtDescripcion.addFocusListener(fl);
			txtMarca.addFocusListener(fl);
			txtPrecio.addFocusListener(fl);
			txtXS.addFocusListener(fl);
			txtS.addFocusListener(fl);
			txtM.addFocusListener(fl);
			txtL.addFocusListener(fl);
			txtXl.addFocusListener(fl);
			
			radiobutton=true;
			radiobutton1=true;

			rdbtRopa.addActionListener(new ActionListener() 
			{
		        @Override
		        public void actionPerformed(ActionEvent e) 
		        {	
		        	
		        	CambioRadioButton();
		        }
		        
		    });
			
			rdbtCosmetico.addActionListener(new ActionListener() 
			{
		        @Override
		        public void actionPerformed(ActionEvent e) 
		        {
		        	CambioRadioButton();
		        }
		    	
		    }	
			
					);
			

			rdbtnMujer.addActionListener(new ActionListener() 
			{
		        @Override
		        public void actionPerformed(ActionEvent e) 
		        {	
		        	
		        	CambioRadioButton();
		        }
		        
		    });
			
			rdbtnHombre.addActionListener(new ActionListener() 
			{
		        @Override
		        public void actionPerformed(ActionEvent e) 
		        {
		        	CambioRadioButton();
		        }
		    	
		    }	
			
					);		
			
		}
	
	private  void CambioRadioButton()
	{
		
		if(rdbtRopa.isSelected() && rdbtnMujer.isSelected())
		{
			ComboCategoria.removeAllItems();
			this.CargarComboRopaMujer();
			
		}
		
		if(rdbtRopa.isSelected() && rdbtnHombre.isSelected())
		{
			ComboCategoria.removeAllItems();
			this.CargarComboRopaHombre();
		}
		
		if(rdbtCosmetico.isSelected() && rdbtnHombre.isSelected())
		{
			ComboCategoria.removeAllItems();
			this.CargarComboCosmeticoHombre();
		}
		
		if(rdbtCosmetico.isSelected() && rdbtnMujer.isSelected())
		{
			ComboCategoria.removeAllItems();
			this.CargarComboCosmeticoMujer();
			
		}
		
	}
	
	private void CargarComboRopaMujer()
	{
		
		for (enTipoRopaMujer a: enTipoRopaMujer.values())
			{
				ComboCategoria.addItem(a.toString());
				ComboCategoria.repaint();
				contentPane.add(ComboCategoria, gbc_ComboCategoria);
			}
	}
	
	private void CargarComboCosmeticoMujer()
	{
			for (enTipoCosmeticoMujer a: enTipoCosmeticoMujer.values())
			{
				ComboCategoria.addItem(a.toString());
				ComboCategoria.repaint();
				contentPane.add(ComboCategoria, gbc_ComboCategoria);
			}
	}
	
	private void CargarComboRopaHombre()
	{
		
		for (enTipoRopaHombre a: enTipoRopaHombre.values())
			{
				ComboCategoria.addItem(a.toString());
				ComboCategoria.repaint();
				contentPane.add(ComboCategoria, gbc_ComboCategoria);
			}
	}
	
	private void CargarComboCosmeticoHombre()
	{
			for (enTipoCosmeticoHombre a: enTipoCosmeticoHombre.values())
			{
				ComboCategoria.addItem(a.toString());
				ComboCategoria.repaint();
				contentPane.add(ComboCategoria, gbc_ComboCategoria);
			}
	}
	
	public void ComprobarPrecio()
	{
		String cadena = txtPrecio.getText();
		int numero;

        if (isNumeric(cadena) == true) 
        {
            numero = Integer.parseInt(cadena);
            System.out.println("Numero: " + numero);
        } else 
        {
        	JOptionPane.showMessageDialog(null, "El precio solo puede contener numeros");
        }
	}
	
	public static boolean isNumeric(String cadena) 
	{
        boolean resultado;

        try 
        {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) 
        {
            resultado = false;
        }

        return resultado;
    }
		
}
