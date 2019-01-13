package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import LN.clsCosmetica;
import LN.clsGestor;
import LN.clsProducto;
import LN.clsRopa;

import javax.swing.JComboBox;

public class clsVerProductoTienda extends JPanel
{
	/**
	 * 
	 */
	/**
	 * 
	 */
	private ArrayList <Image>fotos;  
	private clsProducto producto;
	private ArrayList <clsProducto>listaAnyadidos;
	int posicionIm;
	int posicionProd;
	double total;
	File imagen;
	ImageIcon icon;
	private JLabel txtXS;
	private JLabel txtS;
	private JLabel txtM;
	private JLabel txtL;
	private JLabel txtXL;
	private JLabel txtStock;
	private JLabel txtPrecio;
	private JLabel txtNombre;
	private JLabel txtMarca;
	private JLabel txtDescripcion;
	private JLabel lblFoto;
	private int multiplicador;
	private JLabel txtMaterial;
	private clsGestor gestor;

	

	public clsVerProductoTienda(clsProducto prod, clsGestor gestor)
	{
		
		producto = prod;
		imagen=new File(System.getProperty("user.dir")+"\\src\\img\\" + producto.getImg());
		icon = new ImageIcon (imagen.toString());
		this.producto=prod;
		this.gestor=gestor;

		
		CrearVentana();

	}

	/**
	 * Create the panel.
	 * @return 
	 */ 
	public void CrearVentana()
	{
		
		setVisible(true);
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblFoto = new JLabel();
		lblFoto.setForeground(Color.WHITE);
		lblFoto.setBackground(Color.WHITE);
		lblFoto.setBounds(10, 93, 329, 430);
		add(lblFoto);
		
		multiplicador= icon.getIconHeight()/icon.getIconWidth();
		int anchura= lblFoto.getHeight()/multiplicador;
		Icon icono = new ImageIcon (icon.getImage().getScaledInstance(anchura, lblFoto.getHeight(), Image.SCALE_SMOOTH));
		lblFoto.setIcon(icono);
		
		txtDescripcion = new JLabel(producto.getDescripcion());
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDescripcion.setBounds(512, 234, 263, 40);
		add(txtDescripcion);
		double precio = (producto.getPrecio());
		
		txtMarca = new JLabel(producto.getMarca());
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMarca.setBounds(512, 305, 135, 34);
		add(txtMarca);
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditar.setBounds(389, 494, 174, 34);
		add(btnEditar);
		
		JLabel lblDescripcin = new JLabel("DESCRIPCION");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcin.setBounds(367, 246, 98, 16);
		add(lblDescripcin);
		
		JLabel lblPrecio_1 = new JLabel("PRECIO");
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio_1.setBounds(369, 424, 87, 23);
		add(lblPrecio_1);
		
		JLabel lblMarca_1 = new JLabel("MARCA");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarca_1.setBounds(367, 314, 76, 16);
		add(lblMarca_1);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(367, 109, 87, 14);
		add(lblNombre);
		
	
		txtNombre = new JLabel(producto.getNombre());
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setBounds(512, 100, 151, 32);
		add(txtNombre);
		
		JLabel labelEuro = new JLabel("\u20AC");
		labelEuro.setBackground(Color.WHITE);
		labelEuro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelEuro.setBounds(579, 428, 46, 14);
		add(labelEuro);
		
		txtPrecio = new JLabel(String.valueOf(producto.getPrecio()));
		txtPrecio.setBounds(528, 426, 41, 20);
		add(txtPrecio);
		
		if(producto instanceof clsRopa)
		{
			JLabel lblXs = new JLabel("XS");
			lblXs.setBounds(509, 162, 22, 14);
			add(lblXs);
			
			JLabel lblXL = new JLabel("XL");
			lblXL.setBounds(634, 162, 46, 14);
			add(lblXL);
			
			JLabel lblM = new JLabel("M");
			lblM.setBounds(573, 162, 22, 14);
			add(lblM);
			
			JLabel lblS = new JLabel("S");
			lblS.setBounds(541, 162, 22, 14);
			add(lblS);
			
			JLabel lblL = new JLabel("L");
			lblL.setBounds(605, 162, 30, 14);
			add(lblL);
	
			txtXS = new JLabel(String.valueOf(((clsRopa) producto).getStock_XS()));
			txtXS.setBounds(512, 187, 22, 20);
			add(txtXS);
			
			txtS = new JLabel(String.valueOf(((clsRopa) producto).getStock_S()));
			txtS.setBounds(541, 187, 22, 20);
			add(txtS);
			
			txtM = new JLabel(String.valueOf(((clsRopa) producto).getStock_M()));
			txtM.setBounds(573, 187, 22, 20);
			add(txtM);
			
			txtL = new JLabel(String.valueOf(((clsRopa) producto).getStock_L()));
			txtL.setBounds(603, 187, 22, 20);
			add(txtL);
			
			txtXL = new JLabel(String.valueOf(((clsRopa) producto).getStock_XL()));
			txtXL.setBounds(634, 187, 22, 20);
			add(txtXL);
			
			txtMaterial = new JLabel(((clsRopa) producto).getMaterial());
			txtMaterial.setBounds(512, 364, 135, 34);
			add(txtMaterial);
			
			JLabel lblMaterial = new JLabel("MATERIAL");
			lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMaterial.setBounds(367, 369, 87, 23);
			add(lblMaterial);
			
			JLabel lblNewLabel = new JLabel("STOCK");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(367, 174, 46, 14);
			add(lblNewLabel);
			
		}
		if(producto instanceof clsCosmetica)
		{
			repaint();
			JLabel lblStock = new JLabel("STOCK");
			lblStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblStock.setBounds(367, 183, 46, 14);
			add(lblStock);
			
			txtStock = new JLabel(String.valueOf(((clsCosmetica) producto).getStock()));
			txtStock.setBounds(512, 181, 86, 20);
			add(txtStock);
		}
		
		

		btnEditar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				setVisible(false);
				clsMenuTienda_02.btnEditar(producto);
				
			}
			});
	}
}

	


