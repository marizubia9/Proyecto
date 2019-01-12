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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import LN.clsCosmetica;
import LN.clsProducto;
import LN.clsRopa;

import javax.swing.JComboBox;

public class clsEditarRopa extends JPanel
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
	private JTextField txtXS;
	private JTextField txtS;
	private JTextField txtM;
	private JTextField txtL;
	private JTextField txtXL;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtDescripcion;
	private JLabel lblFoto;
	private int multiplicador;
	private JTextField txtMaterial;

	

	public clsEditarRopa(clsProducto prod)
	{
		
		producto = prod;
		imagen=new File(System.getProperty("user.dir")+"\\src\\img\\" + producto.getImg());
		icon = new ImageIcon (imagen.toString());
		this.producto=prod;


		
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
		lblFoto.setBounds(-15, 93, 354, 456);
		add(lblFoto);
		
		 multiplicador= icon.getIconHeight()/icon.getIconWidth();
		int anchura= lblFoto.getHeight()/multiplicador;
		Icon icono = new ImageIcon (icon.getImage().getScaledInstance(anchura, lblFoto.getHeight(), Image.SCALE_SMOOTH));
		lblFoto.setIcon(icono);
		
		txtDescripcion = new JTextField(producto.getDescripcion());
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDescripcion.setBounds(512, 234, 263, 40);
		add(txtDescripcion);
		double precio = (producto.getPrecio());
		
		txtMarca = new JTextField(producto.getMarca());
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMarca.setBounds(512, 305, 135, 34);
		add(txtMarca);
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(389, 494, 174, 34);
		add(btnGuardar);
		
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
		
	
		txtNombre = new JTextField(producto.getNombre());
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setBounds(512, 93, 151, 32);
		add(txtNombre);
		
		JLabel labelEuro = new JLabel("\u20AC");
		labelEuro.setBackground(Color.WHITE);
		labelEuro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelEuro.setBounds(579, 428, 46, 14);
		add(labelEuro);
		
		txtPrecio = new JTextField(String.valueOf(producto.getPrecio()));
		txtPrecio.setBounds(528, 426, 41, 20);
		add(txtPrecio);
		txtPrecio.setColumns(10);
		

		
	
		

		

		

		

		

		

		if(producto instanceof clsRopa)
		{
			JLabel lblXs = new JLabel("XS");
			lblXs.setBounds(397, 182, 22, 14);
			add(lblXs);
			
			JLabel lblXL = new JLabel("XL");
			lblXL.setBounds(528, 182, 46, 14);
			add(lblXL);
			
			JLabel lblM = new JLabel("M");
			lblM.setBounds(455, 182, 14, 14);
			add(lblM);
			
			JLabel lblS = new JLabel("S");
			lblS.setBounds(429, 182, 14, 14);
			add(lblS);
			
			JLabel lblL = new JLabel("L");
			lblL.setBounds(495, 182, 46, 14);
			add(lblL);
	
			
			txtXS = new JTextField(String.valueOf(((clsRopa) producto).getStock_XS()));
			txtXS.setBounds(389, 207, 22, 20);
			add(txtXS);
			txtXS.setColumns(10);
			
			txtS = new JTextField(String.valueOf(((clsRopa) producto).getStock_S()));
			txtS.setColumns(10);
			txtS.setBounds(423, 207, 22, 20);
			add(txtS);
			
			txtM = new JTextField(String.valueOf(((clsRopa) producto).getStock_M()));
			txtM.setColumns(10);
			txtM.setBounds(455, 207, 22, 20);
			add(txtM);
			
			txtL = new JTextField(String.valueOf(((clsRopa) producto).getStock_L()));
			txtL.setColumns(10);
			txtL.setBounds(487, 207, 22, 20);
			add(txtL);
			
			txtXL = new JTextField(String.valueOf(((clsRopa) producto).getStock_XL()));
			txtXL.setColumns(10);
			txtXL.setBounds(519, 207, 22, 20);
			add(txtXL);
			
			txtMaterial = new JTextField(((clsRopa) producto).getMaterial());
			txtMaterial.setBounds(512, 364, 135, 34);
			add(txtMaterial);
			txtMaterial.setColumns(10);
			
			JLabel lblMaterial = new JLabel("MATERIAL");
			lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMaterial.setBounds(367, 369, 87, 23);
			add(lblMaterial);
			
		}
		if(producto instanceof clsCosmetica)
		{
			repaint();
			JLabel lblStock = new JLabel("STOCK");
			lblStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblStock.setBounds(367, 183, 46, 14);
			add(lblStock);
			
			txtStock = new JTextField(String.valueOf(((clsCosmetica) producto).getStock()));
			txtStock.setBounds(512, 181, 86, 20);
			add(txtStock);
			txtStock.setColumns(10);
		}
		
		
		
		

		btnGuardar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String nombre=txtNombre.getText();
	        	String marca=txtMarca.getText();
	        	String material=txtMaterial.getText();
	        	if(nombre.equals(null) || marca.equals(null)|| material.equals(null))
	        	{
	        		JOptionPane.showMessageDialog(null,"Rellene todos los campos.");
	        	}
	        	double precio;
	        	try
	        	{
	        		precio= Double.parseDouble(txtPrecio.getText());
	        	}
	        	catch(Exception e1)
	        	{
	        		JOptionPane.showMessageDialog(null,"Vuelva a introducir el precio.");
	        		return;
	        	}

	        	String descripcion= txtDescripcion.getText();
        	
				if(producto instanceof clsCosmetica)
				{
					try
					{
						int stock=Integer.parseInt(txtStock.getText());
					}
					catch(Exception e1)
		        	{
		        		JOptionPane.showMessageDialog(null,"Vuelva a introducir el stock adecuadamente.");
		        		return;
		        	}
					
				}
				if(producto instanceof clsRopa)
				{
				
					try
					{	
						int stock_XS=Integer.parseInt(txtXS.getText());
						int stock_S=Integer.parseInt(txtS.getText());
						int stock_M=Integer.parseInt(txtM.getText());
						int stock_L=Integer.parseInt(txtL.getText());
						int stock_XL=Integer.parseInt(txtXL.getText());
					}
					catch(Exception e3)
		        	{
		        		JOptionPane.showMessageDialog(null,"Vuelva a introducir el stock adecuadamente.");
		        		return;
		        	}
				}
			}
			});
	}
}

	


