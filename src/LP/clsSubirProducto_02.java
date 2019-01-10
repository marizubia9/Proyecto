package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class clsSubirProducto_02 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_foto;
	private ButtonGroup GrupoTextilCosmetico;
	private	JRadioButton rdbtnTextil;
	private	JRadioButton rdbtnCosmetico;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JTextField txt_XS;
	private JTextField txt_S;
	private JTextField txt_M;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsSubirProducto_02 frame = new clsSubirProducto_02();
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
	public clsSubirProducto_02() {
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
		
		JPanel panel_foto = new JPanel();
		panel_foto.setBackground(Color.WHITE);
		FlowLayout fl_panel_foto = (FlowLayout) panel_foto.getLayout();
		fl_panel_foto.setHgap(140);
		fl_panel_foto.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_foto, BorderLayout.SOUTH);
		
		lbl_foto = new JLabel("FOTO");
		panel_foto.add(lbl_foto);
		lbl_foto.setSize(100, 100);
		
		JPanel panel_principal = new JPanel();
		panel_principal.setBackground(Color.WHITE);
		getContentPane().add(panel_principal, BorderLayout.CENTER);
		panel_principal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_subirFoto = new JPanel();
		panel_subirFoto.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_subirFoto.getLayout();
		flowLayout.setHgap(100);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_principal.add(panel_subirFoto, BorderLayout.SOUTH);
		
		JButton btnSubirfoto = new JButton();
		btnSubirfoto.setText("Subir foto ");
		panel_subirFoto.add(btnSubirfoto);
		ImageIcon icono_subir = new ImageIcon(Toolkit.getDefaultToolkit().getImage(clsSubirProducto_02.class.getResource("/img/upload.png")));
		btnSubirfoto.setIcon(icono_subir);
		
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
		rdbtnTextil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_tipo.add(rdbtnTextil);
		
		rdbtnCosmetico = new JRadioButton("Cosmetico");
		rdbtnCosmetico.setBackground(Color.WHITE);
		rdbtnCosmetico.setSelected(true);
		rdbtnCosmetico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_tipo.add(rdbtnCosmetico);
		
		GrupoTextilCosmetico=new ButtonGroup();
		GrupoTextilCosmetico.add(rdbtnTextil);
		GrupoTextilCosmetico.add(rdbtnCosmetico);
		
		JPanel panel_central = new JPanel();
		panel_central.setBackground(Color.WHITE);
		panel_principal.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel_central.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{93, 174, 122, 111, 177, 0};
		gbl_panel.rowHeights = new int[] {36, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.WEST;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.fill = GridBagConstraints.VERTICAL;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 3;
		gbc_lblSexo.gridy = 2;
		panel.add(lblSexo, gbc_lblSexo);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBackground(Color.WHITE);
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_rdbtnMujer = new GridBagConstraints();
		gbc_rdbtnMujer.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnMujer.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnMujer.gridx = 4;
		gbc_rdbtnMujer.gridy = 2;
		panel.add(rdbtnMujer, gbc_rdbtnMujer);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarca.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 1;
		gbc_lblMarca.gridy = 3;
		panel.add(lblMarca, gbc_lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		GridBagConstraints gbc_txtMarca = new GridBagConstraints();
		gbc_txtMarca.anchor = GridBagConstraints.WEST;
		gbc_txtMarca.insets = new Insets(0, 0, 5, 5);
		gbc_txtMarca.gridx = 2;
		gbc_txtMarca.gridy = 3;
		panel.add(txtMarca, gbc_txtMarca);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBackground(Color.WHITE);
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
		gbc_rdbtnHombre.fill = GridBagConstraints.BOTH;
		gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnHombre.gridx = 4;
		gbc_rdbtnHombre.gridy = 3;
		panel.add(rdbtnHombre, gbc_rdbtnHombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 4;
		panel.add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField();
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.anchor = GridBagConstraints.WEST;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.gridx = 2;
		gbc_txtPrecio.gridy = 4;
		panel.add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(4);
		
		JLabel lblTipoDeProducto = new JLabel("Tipo de Producto");
		lblTipoDeProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTipoDeProducto = new GridBagConstraints();
		gbc_lblTipoDeProducto.fill = GridBagConstraints.BOTH;
		gbc_lblTipoDeProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeProducto.gridx = 3;
		gbc_lblTipoDeProducto.gridy = 4;
		panel.add(lblTipoDeProducto, gbc_lblTipoDeProducto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(5);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 4;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblCantidadDiponible = new JLabel("Cantidad Diponible:");
		lblCantidadDiponible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCantidadDiponible = new GridBagConstraints();
		gbc_lblCantidadDiponible.fill = GridBagConstraints.VERTICAL;
		gbc_lblCantidadDiponible.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidadDiponible.gridx = 1;
		gbc_lblCantidadDiponible.gridy = 5;
		panel.add(lblCantidadDiponible, gbc_lblCantidadDiponible);
		
		JLabel lblXs = new JLabel("XS:");
		lblXs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblXs = new GridBagConstraints();
		gbc_lblXs.fill = GridBagConstraints.VERTICAL;
		gbc_lblXs.anchor = GridBagConstraints.EAST;
		gbc_lblXs.insets = new Insets(0, 0, 5, 5);
		gbc_lblXs.gridx = 1;
		gbc_lblXs.gridy = 6;
		panel.add(lblXs, gbc_lblXs);
		
		txt_XS = new JTextField();
		GridBagConstraints gbc_txt_XS = new GridBagConstraints();
		gbc_txt_XS.anchor = GridBagConstraints.WEST;
		gbc_txt_XS.insets = new Insets(0, 0, 5, 5);
		gbc_txt_XS.gridx = 2;
		gbc_txt_XS.gridy = 6;
		panel.add(txt_XS, gbc_txt_XS);
		txt_XS.setColumns(4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descripcion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridheight = 6;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 6;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{177, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 26, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JTextArea txtrEscribaLaDescripcion = new JTextArea();
		GridBagConstraints gbc_txtrEscribaLaDescripcion = new GridBagConstraints();
		gbc_txtrEscribaLaDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtrEscribaLaDescripcion.gridheight = 4;
		gbc_txtrEscribaLaDescripcion.gridwidth = 2;
		gbc_txtrEscribaLaDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtrEscribaLaDescripcion.gridx = 0;
		gbc_txtrEscribaLaDescripcion.gridy = 0;
		panel_1.add(txtrEscribaLaDescripcion, gbc_txtrEscribaLaDescripcion);
		txtrEscribaLaDescripcion.setForeground(new Color(0, 0, 0));
		txtrEscribaLaDescripcion.setLineWrap(true);
		txtrEscribaLaDescripcion.setText("Escriba la descripcion que\r\nconsidere");
		txtrEscribaLaDescripcion.setWrapStyleWord(true);
		
		JLabel lblS = new JLabel("S:");
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblS = new GridBagConstraints();
		gbc_lblS.fill = GridBagConstraints.VERTICAL;
		gbc_lblS.anchor = GridBagConstraints.EAST;
		gbc_lblS.insets = new Insets(0, 0, 5, 5);
		gbc_lblS.gridx = 1;
		gbc_lblS.gridy = 7;
		panel.add(lblS, gbc_lblS);
		
		txt_S = new JTextField();
		GridBagConstraints gbc_txt_S = new GridBagConstraints();
		gbc_txt_S.anchor = GridBagConstraints.WEST;
		gbc_txt_S.insets = new Insets(0, 0, 5, 5);
		gbc_txt_S.gridx = 2;
		gbc_txt_S.gridy = 7;
		panel.add(txt_S, gbc_txt_S);
		txt_S.setColumns(4);
		
		JLabel lblM = new JLabel("M:");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.fill = GridBagConstraints.VERTICAL;
		gbc_lblM.anchor = GridBagConstraints.EAST;
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 1;
		gbc_lblM.gridy = 8;
		panel.add(lblM, gbc_lblM);
		
		txt_M = new JTextField();
		GridBagConstraints gbc_txt_M = new GridBagConstraints();
		gbc_txt_M.anchor = GridBagConstraints.WEST;
		gbc_txt_M.insets = new Insets(0, 0, 5, 5);
		gbc_txt_M.gridx = 2;
		gbc_txt_M.gridy = 8;
		panel.add(txt_M, gbc_txt_M);
		txt_M.setColumns(4);
		
		JLabel lblL = new JLabel("L:");
		lblL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblL = new GridBagConstraints();
		gbc_lblL.fill = GridBagConstraints.VERTICAL;
		gbc_lblL.anchor = GridBagConstraints.EAST;
		gbc_lblL.insets = new Insets(0, 0, 5, 5);
		gbc_lblL.gridx = 1;
		gbc_lblL.gridy = 9;
		panel.add(lblL, gbc_lblL);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 9;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(4);
		
		JLabel lblXl = new JLabel("XL:");
		lblXl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblXl = new GridBagConstraints();
		gbc_lblXl.fill = GridBagConstraints.VERTICAL;
		gbc_lblXl.anchor = GridBagConstraints.EAST;
		gbc_lblXl.insets = new Insets(0, 0, 5, 5);
		gbc_lblXl.gridx = 1;
		gbc_lblXl.gridy = 10;
		panel.add(lblXl, gbc_lblXl);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 10;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(4);
		
		

		
		
		
	}

}
