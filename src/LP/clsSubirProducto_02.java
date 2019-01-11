package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.JRadioButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

import LN.clsGestor;
import LN.clsTienda;

public class clsSubirProducto_02 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_foto;
	private	JLabel lblXl;
	private JLabel lblXs;
	private JLabel lblS;
	private JLabel lblM;
	private JLabel lblL;
	private ButtonGroup GrupoTextilCosmetico;
	private	JRadioButton rdbtnTextil;
	private JRadioButton rdbtnCosmetico;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JTextField txt_XS;
	private JTextField txt_S;
	private JTextField txt_M;
	private JTextField txt_XL;
	private JPanel pnl_Aceptar;
	private JPanel panel_principal;
	private JPanel panel;
	private JButton btnSubirfoto;
	private JButton btnAceptar;
	private JPanel panel_central;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private ButtonGroup GrupoSexo;
	private JComboBox<String> comboBoxTipo;
	private JTextArea txtArea_descripcion;
	private JButton btnCancelar;
	private String Tipos[];
	private JTextField txt_L;
	private JLabel lblMaterial;
	private boolean fotoSubida;
	private JTextField txt_Material;
	private static File fichero_origen;
	private static File fichero_destino;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					clsSubirProducto_02 frame = new clsSubirProducto_02();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public clsSubirProducto_02(clsTienda tienda) {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		setLocationRelativeTo(null);
		
		JPanel panel_doalzu = new JPanel();
		panel_doalzu.setBackground(Color.BLACK);
		getContentPane().add(panel_doalzu, BorderLayout.NORTH);
		
		JLabel lbl_doalzu = new JLabel("D O A L Z U");
		lbl_doalzu.setForeground(Color.WHITE);
		lbl_doalzu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_doalzu.add(lbl_doalzu);
		
		pnl_Aceptar = new JPanel();
		pnl_Aceptar.setBackground(Color.WHITE);
		FlowLayout fl_pnl_Aceptar = (FlowLayout) pnl_Aceptar.getLayout();
		fl_pnl_Aceptar.setVgap(20);
		fl_pnl_Aceptar.setHgap(30);
		fl_pnl_Aceptar.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(pnl_Aceptar, BorderLayout.SOUTH);
		
		btnAceptar=new JButton("Aceptar");
		pnl_Aceptar.add(btnAceptar);
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(Color.BLACK);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setForeground(Color.WHITE);
		pnl_Aceptar.add(btnCancelar);
		
		panel_principal = new JPanel();
		panel_principal.setBackground(Color.WHITE);
		getContentPane().add(panel_principal, BorderLayout.CENTER);
		panel_principal.setLayout(new BorderLayout(0, 0));
		ImageIcon icono_subir = new ImageIcon(Toolkit.getDefaultToolkit().getImage(clsSubirProducto_02.class.getResource("/img/upload.png")));
		
		JPanel panel_tipo = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_tipo.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(30);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_tipo.setBackground(Color.WHITE);
		panel_principal.add(panel_tipo, BorderLayout.NORTH);
		
		JLabel lbl_TipoProducto = new JLabel("Escoja el tipo de producto que desee subir:");
		lbl_TipoProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_tipo.add(lbl_TipoProducto);
		
		rdbtnTextil = new JRadioButton("Textil");
		rdbtnTextil.setBackground(Color.WHITE);
		rdbtnTextil.setSelected(true);
		rdbtnTextil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_tipo.add(rdbtnTextil);
		
		rdbtnCosmetico = new JRadioButton("Cosmetico");
		rdbtnCosmetico.setBackground(Color.WHITE);
		rdbtnCosmetico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_tipo.add(rdbtnCosmetico);
		
		GrupoTextilCosmetico=new ButtonGroup();
		GrupoTextilCosmetico.add(rdbtnTextil);
		GrupoTextilCosmetico.add(rdbtnCosmetico);
		
		panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_principal.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_foto = new JPanel();
		panel_foto.setBackground(Color.WHITE);
		panel_central.add(panel_foto,BorderLayout.SOUTH );
		GridBagLayout gbl_panel_foto = new GridBagLayout();
		gbl_panel_foto.columnWidths = new int[]{70, 107, 70, 0, 0, 28, 0};
		gbl_panel_foto.rowHeights = new int[]{97, 0};
		gbl_panel_foto.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_foto.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_foto.setLayout(gbl_panel_foto);
		
		btnSubirfoto = new JButton();
		GridBagConstraints gbc_btnSubirfoto = new GridBagConstraints();
		gbc_btnSubirfoto.anchor = GridBagConstraints.WEST;
		gbc_btnSubirfoto.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubirfoto.gridx = 1;
		gbc_btnSubirfoto.gridy = 0;
		panel_foto.add(btnSubirfoto, gbc_btnSubirfoto);
		btnSubirfoto.setText("Subir foto ");
		btnSubirfoto.setIcon(icono_subir);
		
		
		lbl_foto = new JLabel("FOTO");
		lbl_foto.setBackground(Color.WHITE);
		GridBagConstraints gbc_lbl_foto = new GridBagConstraints();
		gbc_lbl_foto.fill = GridBagConstraints.BOTH;
		gbc_lbl_foto.gridwidth = 3;
		gbc_lbl_foto.gridx = 3;
		gbc_lbl_foto.gridy = 0;
		panel_foto.add(lbl_foto, gbc_lbl_foto);
		
		fotoSubida=false;

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel_central.add(panel,BorderLayout.CENTER );
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{93, 174, 138, 111, 177, 0};
		gbl_panel.rowHeights = new int[] {46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("Introduzca los datos del producto:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBackground(Color.WHITE);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.WEST;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.fill = GridBagConstraints.VERTICAL;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 3;
		gbc_lblSexo.gridy = 1;
		panel.add(lblSexo, gbc_lblSexo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarca.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 1;
		gbc_lblMarca.gridy = 2;
		panel.add(lblMarca, gbc_lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		GridBagConstraints gbc_txtMarca = new GridBagConstraints();
		gbc_txtMarca.anchor = GridBagConstraints.WEST;
		gbc_txtMarca.insets = new Insets(0, 0, 5, 5);
		gbc_txtMarca.gridx = 2;
		gbc_txtMarca.gridy = 2;
		panel.add(txtMarca, gbc_txtMarca);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBackground(Color.WHITE);
		rdbtnMujer.setSelected(true);
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_rdbtnMujer = new GridBagConstraints();
		gbc_rdbtnMujer.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnMujer.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnMujer.gridx = 4;
		gbc_rdbtnMujer.gridy = 1;
		panel.add(rdbtnMujer, gbc_rdbtnMujer);
		
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBackground(Color.WHITE);
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
		gbc_rdbtnHombre.fill = GridBagConstraints.BOTH;
		gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnHombre.gridx = 4;
		gbc_rdbtnHombre.gridy = 2;
		panel.add(rdbtnHombre, gbc_rdbtnHombre);
		
		GrupoSexo=new ButtonGroup();
		GrupoSexo.add(rdbtnMujer);
		GrupoSexo.add(rdbtnHombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 3;
		panel.add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField("€");
		txtPrecio.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.anchor = GridBagConstraints.WEST;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.gridx = 2;
		gbc_txtPrecio.gridy = 3;
		panel.add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(4);
		
		JLabel lblTipoDeProducto = new JLabel("Tipo de Producto");
		lblTipoDeProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTipoDeProducto = new GridBagConstraints();
		gbc_lblTipoDeProducto.fill = GridBagConstraints.BOTH;
		gbc_lblTipoDeProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeProducto.gridx = 3;
		gbc_lblTipoDeProducto.gridy = 3;
		panel.add(lblTipoDeProducto, gbc_lblTipoDeProducto);
		
		lblMaterial = new JLabel("Material:");
		lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblMaterial = new GridBagConstraints();
		gbc_lblMaterial.anchor = GridBagConstraints.EAST;
		gbc_lblMaterial.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterial.gridx = 1;
		gbc_lblMaterial.gridy = 4;
		panel.add(lblMaterial, gbc_lblMaterial);
		
		txt_Material = new JTextField("");
		txt_Material.setForeground(Color.black);
		txt_Material.setColumns(4);
		GridBagConstraints gbc_txt_Material = new GridBagConstraints();
		gbc_txt_Material.anchor = GridBagConstraints.WEST;
		gbc_txt_Material.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Material.gridx = 2;
		gbc_txt_Material.gridy = 4;
		panel.add(txt_Material, gbc_txt_Material);
		
		
		
		JLabel lblCantidadDiponible = new JLabel("Cantidad Diponible:");
		lblCantidadDiponible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCantidadDiponible = new GridBagConstraints();
		gbc_lblCantidadDiponible.fill = GridBagConstraints.VERTICAL;
		gbc_lblCantidadDiponible.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidadDiponible.gridx = 1;
		gbc_lblCantidadDiponible.gridy = 5;
		panel.add(lblCantidadDiponible, gbc_lblCantidadDiponible);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setBackground(Color.WHITE);
		 panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descripcion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		 gbc_panel_1.fill = GridBagConstraints.BOTH;
		 gbc_panel_1.gridheight = 6;
		 gbc_panel_1.gridx = 4;
		 gbc_panel_1.gridy = 5;
		 panel.add(panel_1, gbc_panel_1);
		 GridBagLayout gbl_panel_1 = new GridBagLayout();
		 gbl_panel_1.columnWidths = new int[]{177, 0, 0};
		 gbl_panel_1.rowHeights = new int[]{0, 26, 0, 0, 0};
		 gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		 gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 panel_1.setLayout(gbl_panel_1);
		 
		 txtArea_descripcion = new JTextArea();
		 txtArea_descripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 GridBagConstraints gbc_txtrEscribaLaDescripcion = new GridBagConstraints();
		 gbc_txtrEscribaLaDescripcion.fill = GridBagConstraints.BOTH;
		 gbc_txtrEscribaLaDescripcion.gridheight = 2;
		 gbc_txtrEscribaLaDescripcion.gridwidth = 2;
		 gbc_txtrEscribaLaDescripcion.insets = new Insets(0, 0, 5, 5);
		 gbc_txtrEscribaLaDescripcion.gridx = 0;
		 gbc_txtrEscribaLaDescripcion.gridy = 0;
		 panel_1.add(txtArea_descripcion, gbc_txtrEscribaLaDescripcion);
		 txtArea_descripcion.setForeground(new Color(0, 0, 0));
		 txtArea_descripcion.setLineWrap(true);
		 txtArea_descripcion.setText("Escriba la descripcion que\r\nconsidere");
		 txtArea_descripcion.setForeground(Color.LIGHT_GRAY);
		 txtArea_descripcion.setWrapStyleWord(true);
		
		
		 lblXs = new JLabel("XS:");
		lblXs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblXs = new GridBagConstraints();
		gbc_lblXs.fill = GridBagConstraints.VERTICAL;
		gbc_lblXs.anchor = GridBagConstraints.EAST;
		gbc_lblXs.insets = new Insets(0, 0, 5, 5);
		gbc_lblXs.gridx = 1;
		gbc_lblXs.gridy = 6;
		panel.add(lblXs, gbc_lblXs);
		
		txt_XS = new JTextField("0");
		txt_XS.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txt_XS = new GridBagConstraints();
		gbc_txt_XS.anchor = GridBagConstraints.WEST;
		gbc_txt_XS.insets = new Insets(0, 0, 5, 5);
		gbc_txt_XS.gridx = 2;
		gbc_txt_XS.gridy = 6;
		panel.add(txt_XS, gbc_txt_XS);
		txt_XS.setColumns(4);
		
		 lblS = new JLabel("S:");
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblS = new GridBagConstraints();
		gbc_lblS.fill = GridBagConstraints.VERTICAL;
		gbc_lblS.anchor = GridBagConstraints.EAST;
		gbc_lblS.insets = new Insets(0, 0, 5, 5);
		gbc_lblS.gridx = 1;
		gbc_lblS.gridy = 7;
		panel.add(lblS, gbc_lblS);
		
		txt_S = new JTextField("0");
		txt_S.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txt_S = new GridBagConstraints();
		gbc_txt_S.anchor = GridBagConstraints.WEST;
		gbc_txt_S.insets = new Insets(0, 0, 5, 5);
		gbc_txt_S.gridx = 2;
		gbc_txt_S.gridy = 7;
		panel.add(txt_S, gbc_txt_S);
		txt_S.setColumns(4);
		
		lblM = new JLabel("M:");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.fill = GridBagConstraints.VERTICAL;
		gbc_lblM.anchor = GridBagConstraints.EAST;
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 1;
		gbc_lblM.gridy = 8;
		panel.add(lblM, gbc_lblM);
		
		txt_M = new JTextField("0");
		txt_M.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txt_M = new GridBagConstraints();
		gbc_txt_M.anchor = GridBagConstraints.WEST;
		gbc_txt_M.insets = new Insets(0, 0, 5, 5);
		gbc_txt_M.gridx = 2;
		gbc_txt_M.gridy = 8;
		panel.add(txt_M, gbc_txt_M);
		txt_M.setColumns(4);
		
		lblL = new JLabel("L:");
		lblL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblL = new GridBagConstraints();
		gbc_lblL.fill = GridBagConstraints.VERTICAL;
		gbc_lblL.anchor = GridBagConstraints.EAST;
		gbc_lblL.insets = new Insets(0, 0, 5, 5);
		gbc_lblL.gridx = 1;
		gbc_lblL.gridy = 9;
		panel.add(lblL, gbc_lblL);
		
		txt_L = new JTextField("0");
		txt_L.setForeground(Color.LIGHT_GRAY);
		txt_L.setColumns(4);
		GridBagConstraints gbc_txt_L = new GridBagConstraints();
		gbc_txt_L.anchor = GridBagConstraints.WEST;
		gbc_txt_L.insets = new Insets(0, 0, 5, 5);
		gbc_txt_L.gridx = 2;
		gbc_txt_L.gridy = 9;
		panel.add(txt_L, gbc_txt_L);
		
		lblXl = new JLabel("XL:");
		lblXl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblXl = new GridBagConstraints();
		gbc_lblXl.fill = GridBagConstraints.VERTICAL;
		gbc_lblXl.anchor = GridBagConstraints.EAST;
		gbc_lblXl.insets = new Insets(0, 0, 0, 5);
		gbc_lblXl.gridx = 1;
		gbc_lblXl.gridy = 10;
		panel.add(lblXl, gbc_lblXl);
		
		txt_XL = new JTextField("0");
		txt_XL.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txt_XL = new GridBagConstraints();
		gbc_txt_XL.anchor = GridBagConstraints.WEST;
		gbc_txt_XL.insets = new Insets(0, 0, 0, 5);
		gbc_txt_XL.gridx = 2;
		gbc_txt_XL.gridy = 10;
		panel.add(txt_XL, gbc_txt_XL);
		txt_XL.setColumns(4);
		
		comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Abrigo", "Chaqueta", "Vestido o mono", "Camisa o blusa", "Camiseta", "Pantalon", "Falda"}));
		comboBoxTipo.setBackground(Color.WHITE);
		comboBoxTipo.setMaximumRowCount(8);
		comboBoxTipo.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 3;
		panel.add(comboBoxTipo, gbc_comboBox);
		CambioRadioButton();
		

		
		btnCancelar.addActionListener(new ActionListener() 
		{
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {	
	        	
	        	setVisible(false);
	        }
	        
	    });
		
		btnAceptar.addActionListener(new ActionListener() 
		{
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	if (comprobacion())
	        	{
	        	String nombre=txtNombre.getText();
	        	String marca=txtMarca.getText();
	        	double precio= Double.parseDouble(Precio());
	        	String tipo= SeleccionCombo();
	        	String descripcion= descripcion();
	        	boolean sexo=rdbtnMujer.isSelected();
	        	copyFileUsingJava7Files();
	        	String img=fichero_destino.getName();
	        	
	        	
	        	if(rdbtnTextil.isSelected())
	        	{
	        		int XS=Integer.parseInt(txt_XS.getText());	 
	        		String material=txt_Material.getText();
	        		int S=Integer.parseInt(txt_S.getText());	
	        		int M=Integer.parseInt(txt_M.getText());	
	        		int L=Integer.parseInt(txt_L.getText());	
	        		int XL=Integer.parseInt(txt_XL.getText());	
	        		
	        		if (clsGestor.CrearRopa(nombre, marca, precio, material, XS, S, M, L, XL, sexo, img, tipo, descripcion, tienda))
	        		{
	        			JOptionPane.showMessageDialog(null,"¡Producto subido con éxito!");
	        			setVisible(false);
	        			clsMenuTienda_02 frame= new clsMenuTienda_02(tienda);
	        			frame.setVisible(true);
	        			
	        		}
	        	}
	        	

	        	if(rdbtnTextil.isSelected())
	        	{
	        		int stock =Integer.parseInt(txt_XS.getText());	 
	        		
	        	}
	        	
	        	
	        	
	        }
	        	return;
		}  
	    });
		 
		FocusListener fl= new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(e.getSource()==txtPrecio && (txtPrecio.getText().equals("€")) )
					{
						txtPrecio.setText("");	
						txtPrecio.setForeground(Color.BLACK);
					}
				if(e.getSource()==txtArea_descripcion && (txtArea_descripcion.getText().equals("Escriba la descripcion que\r\nconsidere")) )
				{
					txtArea_descripcion.setText("");	
					txtArea_descripcion.setForeground(Color.BLACK);
				}
				if(e.getSource()==txt_XS && (txt_XS.getText().equals("0")) )
				{
					txt_XS.setText("");	
					txt_XS.setForeground(Color.BLACK);
				}
				if(e.getSource()==txt_S && (txt_S.getText().equals("0")) )
				{
					txt_S.setText("");	
					txt_S.setForeground(Color.BLACK);
				}
				if(e.getSource()==txt_M && (txt_M.getText().equals("0")) )
				{
					txt_M.setText("");	
					txt_M.setForeground(Color.BLACK);
				}
				if(e.getSource()==txt_L && (txt_L.getText().equals("0")) )
				{
					txt_L.setText("");	
					txt_L.setForeground(Color.BLACK);
				}
				if(e.getSource()==txt_XL && (txt_XL.getText().equals("0")) )
				{
					txt_XL.setText("");	
					txt_XL.setForeground(Color.BLACK);
				}
				
					
			}
			@Override
			public void focusLost (FocusEvent e)
			{
				if(e.getSource()==txtPrecio && txtPrecio.getText().isEmpty()) 
					{
						txtPrecio.setText("€");
						txtPrecio.setForeground(Color.LIGHT_GRAY);
						
					}
				
				if(e.getSource()==txtArea_descripcion && txtArea_descripcion.getText().isEmpty()) 
				{
					txtArea_descripcion.setText("Escriba la descripcion que\r\nconsidere");
					txtArea_descripcion.setForeground(Color.LIGHT_GRAY);
					
				}
				
				if(e.getSource()==txt_XS && txt_XS.getText().isEmpty()) 
				{
					txt_XS.setText("0");
					txt_XS.setForeground(Color.LIGHT_GRAY);
					
				}
				
				if(e.getSource()==txt_S && txt_S.getText().isEmpty()) 
				{
					txt_S.setText("0");
					txt_S.setForeground(Color.LIGHT_GRAY);
					
				}
				if(e.getSource()==txt_M && txt_M.getText().isEmpty()) 
				{
					txt_M.setText("0");
					txt_M.setForeground(Color.LIGHT_GRAY);
					
				}
				if(e.getSource()==txt_L && txt_L.getText().isEmpty()) 
				{
					txt_L.setText("0");
					txt_L.setForeground(Color.LIGHT_GRAY);
					
				}
				if(e.getSource()==txt_XL && txt_XL.getText().isEmpty()) 
				{
					txt_XL.setText("0");
					txt_XL.setForeground(Color.LIGHT_GRAY);
					
				}
				
			}
			
			
		};
				
		
			txtPrecio.addFocusListener(fl);
			txtArea_descripcion.addFocusListener(fl);
			txt_XL.addFocusListener(fl);
			txt_L.addFocusListener(fl);
			txt_XS.addFocusListener(fl);
			txt_S.addFocusListener(fl);
			txt_M.addFocusListener(fl);
		
		rdbtnTextil.addActionListener(new ActionListener() 
		{
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {	
	        	
	        	CambioRadioButton();
	        }
	        
	    });
		
		rdbtnCosmetico.addActionListener(new ActionListener() 
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
		
		btnSubirfoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				
				File dirActual = new File( System.getProperty("user.dir")+"\\img." );
				JFileChooser chooser = new JFileChooser( dirActual );
			
				
				FileNameExtensionFilter filtro = new FileNameExtensionFilter ("JPG", "jpg", "png", "PNG");
				chooser.setFileFilter(filtro);
				int returnVal = chooser.showOpenDialog( null );
				
				if (JFileChooser.APPROVE_OPTION == returnVal)
				{
					fichero_origen = chooser.getSelectedFile();
					
					try
					{
						ImageIcon icon = new ImageIcon (fichero_origen.toString());
						
						int multiplicador= icon.getIconHeight()/icon.getIconWidth();
						int anchura= lbl_foto.getHeight()/multiplicador;
						
						Icon icono = new ImageIcon (icon.getImage().getScaledInstance(anchura, lbl_foto.getHeight(), Image.SCALE_SMOOTH));
						
						lbl_foto.setText(null);
						
						lbl_foto.setIcon(icono);
						
						panel_foto.remove(lbl_foto);
						
						panel_foto.add(lbl_foto);
						fotoSubida=true;
						fichero_destino = new File( System.getProperty("user.dir")+"\\src\\img\\"+fichero_origen.getName() );
						

						
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Error abriendo la imagen, elija otra" + ex);
					}
				}

			}
		});
	}
	
	private static void copyFileUsingJava7Files()
	
	   {
	
	        try 
	        {
				Files.copy(fichero_origen.toPath(), fichero_destino.toPath());
			} 
	        catch (IOException e) 
	        {
	        	
	        	int numero = (int) (Math.random() * 33) + 1;
	        	fichero_destino= new File( System.getProperty("user.dir")+"\\src\\img\\"+numero+fichero_origen.getName() );
	        	copyFileUsingJava7Files();
				
			}
	
	    }
		
	
	
	public String descripcion()
	{
		String descripcion;
		if(txtArea_descripcion.getText().equals("Escriba la descripcion que\r\nconsidere")) return null;
		else return txtArea_descripcion.getText();
	}
	
	public String Precio()
	{
		String Precio;
		if(txtPrecio.getText().equals("€")) return null;
		else return txtPrecio.getText();
	}
	public  void CambioRadioButton()
	{
		
		String [] Textil_Mujer= {"Abrigo","Chaqueta","Vestido o Mono","Camisa o blusa", "Camiseta", "Pantalon","Falda"};
		String [] Textil_Hombre= {"Abrigo","Chaqueta","Camisa", "Camiseta", "Pantalon"};
		String [] Cosmetica= {"Cuidado de la piel","Maquillaje","Perfume"};
			
			
		
		if(rdbtnTextil.isSelected() && rdbtnMujer.isSelected())
			{
				comboBoxTipo.removeAllItems();
				MeterLista_ComboBox(Textil_Mujer);
				comboBoxTipo.repaint();
				
				lblL.setVisible(true);
				lblM.setVisible(true);
				lblS.setVisible(true);
				lblXl.setVisible(true);
				txt_S.setVisible(true);
				txt_M.setVisible(true);
				txt_L.setVisible(true);
				txt_XL.setVisible(true);
				lblMaterial.setVisible(true);
				txt_Material.setVisible(true);
				
				lblXs.setText("XS");
				
				
			}
			
			if(rdbtnTextil.isSelected() && rdbtnHombre.isSelected())
			{
				comboBoxTipo.removeAllItems();
				MeterLista_ComboBox(Textil_Hombre);
				comboBoxTipo.repaint();
				
				lblL.setVisible(true);
				lblM.setVisible(true);
				lblS.setVisible(true);
				lblXl.setVisible(true);
				txt_S.setVisible(true);
				txt_M.setVisible(true);
				txt_L.setVisible(true);
				txt_XL.setVisible(true);
				lblMaterial.setVisible(true);
				txt_Material.setVisible(true);
				
				lblXs.setText("XS");
			}
			
			if(rdbtnCosmetico.isSelected())
			{
				comboBoxTipo.removeAllItems();
				MeterLista_ComboBox(Cosmetica);
				comboBoxTipo.repaint();
				
				lblL.setVisible(false);
				lblM.setVisible(false);
				lblS.setVisible(false);
				lblXl.setVisible(false);
				lblMaterial.setVisible(false);
				txt_S.setVisible(false);
				txt_M.setVisible(false);
				txt_L.setVisible(false);
				txt_XL.setVisible(false);
				txt_Material.setVisible(false);
				
				
				lblXs.setText("Stock");
				
				
			}
			
		}
	
	public  void MeterLista_ComboBox(String [] Tipos)
	{
		for(int i =0; i< Tipos.length; i++)
		{
			
			comboBoxTipo.addItem(Tipos[i]);
		}
	}
	
	public String SeleccionCombo()
	{
		String tipo= (String)comboBoxTipo.getSelectedItem();
		String retorno = null;
		if(tipo.toLowerCase().equals("abrigo"))
		{
			retorno="abrigo";
			return retorno;
		}
		if(tipo.toLowerCase().equals("chaqueta"))
		{
			retorno="chaqueta";
			return retorno;
		}
		if(tipo.toLowerCase().equals("vestido o mono"))
		{
			retorno="vestido";
			return retorno;
		}
		if(tipo.toLowerCase().equals("camisa o blusa"))
		{
			retorno="camisa";
			return retorno;
		}
		if(tipo.toLowerCase().equals("camisa"))
		{
			retorno="camisa";
			return retorno;
		}
		if(tipo.toLowerCase().equals("pantalon"))
		{
			retorno="pantalon";
			return retorno;
		}
		if(tipo.toLowerCase().equals("falda"))
		{
			retorno="falda";
			return retorno;
		}
		if(tipo.toLowerCase().equals("cuidado de la piel"))
		{
			retorno="piel";
			return retorno;
		}
		if(tipo.toLowerCase().equals("maquillaje"))
		{
			retorno="maquillaje";
			return retorno;
		}
		if(tipo.toLowerCase().equals("perfume"))
		{
			retorno="perfume";
			return retorno;
		}
		
		return retorno;
	}
	
	/**
	 * Comprueba que todos los txtfields importantes esten rellenos
	 * @return
	 */
	public  boolean comprobacion()
	{
		if(txtNombre.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Por favor, rellene el nombre del producto");   
				return false;
			}
		
		if(txtMarca.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Por favor, rellene la marca del producto");   
				return false;
			}
		if(txt_Material.getText().isEmpty()&& rdbtnTextil.isSelected())
		{
			JOptionPane.showMessageDialog(null,"Por favor, rellene el material principal del producto");   
			return false;
		}
		
		if(txtPrecio.getText().equals("€"))
			{
				JOptionPane.showMessageDialog(null,"Por favor, establezca un precio al producto");   
				return false;
			}
		if(!fotoSubida)
			{
				JOptionPane.showMessageDialog(null,"Por favor, seleccione una imagen para su producto");   
				return false;
			}
		
		return true;
	}

}
