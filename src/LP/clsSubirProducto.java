package LP;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;


import javax.swing.JButton;

import LN.clsConstantes.enTipoCosmetico;
import LN.clsConstantes.enTipoRopa;



public class clsSubirProducto extends JFrame
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private boolean radiobutton;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	
	private static String ficheros;
	private static String path;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					clsSubirProducto frame = new clsSubirProducto();
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
	public clsSubirProducto() 
	{
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsSubirProducto.class.getResource("/img/DLZ.png")));
		setBackground(Color.WHITE);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setBorder(null);
		contentPane.add(splitPane);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Menu") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Mi Ropa");
						node_1.add(new DefaultMutableTreeNode("Camisetas"));
						node_1.add(new DefaultMutableTreeNode("Tops"));
						node_1.add(new DefaultMutableTreeNode("Pantalones"));
						node_1.add(new DefaultMutableTreeNode("Faldas"));
						node_1.add(new DefaultMutableTreeNode("...."));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Cosmetica");
						node_1.add(new DefaultMutableTreeNode("Cara"));
						node_1.add(new DefaultMutableTreeNode("Labio"));
						node_1.add(new DefaultMutableTreeNode("Ojo"));
						node_1.add(new DefaultMutableTreeNode("..."));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Subir producto");
					node_1.add(new DefaultMutableTreeNode("..."));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Envios en tramitacion");
						node_1.add(new DefaultMutableTreeNode(""));
					add(node_1);
				}
			}
		));
		tree.setVisibleRowCount(30);
		tree.setBorder(null);
		tree.setFont(new Font("Arial", tree.getFont().getStyle(), tree.getFont().getSize()));
		tree.setForeground(Color.BLACK);
		tree.setBackground(Color.BLACK);
		splitPane.setLeftComponent(tree);
		
		scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		scrollPane.setLayout(null);
		
		JLabel lblSubirProducto = new JLabel("SUBIR PRODUCTO");
		lblSubirProducto.setBounds(5, 3, 182, 56);
		lblSubirProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.add(lblSubirProducto);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigo.setBounds(40, 70, 106, 45);
		scrollPane.add(lblCodigo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(38, 120, 77, 45);
		scrollPane.add(lblTipo);
		
		JRadioButton rdbtnRopa = new JRadioButton("Ropa");
		rdbtnRopa.setSelected(true);
		rdbtnRopa.setBounds(247, 115, 182, 56);
		scrollPane.add(rdbtnRopa);
		
		JRadioButton rdbtnCosmetico = new JRadioButton("Cosmetico");
		rdbtnCosmetico.setSelected(true);
		rdbtnCosmetico.setBounds(492, 115, 182, 56);
		scrollPane.add(rdbtnCosmetico);
		
		textField_4= new JTextField();
		comboBox = new JComboBox();
		comboBox.setBounds(336, 171, 135, 20);
		for (enTipoRopa a: enTipoRopa.values())
		{
			comboBox.addItem(a.toString());
		}
		scrollPane.add(comboBox);
		
		
//		comboBox.addActionListener(new ActionListener() 
//		{
//			@Override
//			public void actionPerformed(ActionEvent e) 
//			{
//				textField_4.remove(comboBox);
//				textField_4.setText(comboBox.getSelectedItem().toString());
//			}
//			
//			
//			
//		});
		
		JLabel lblDescripcion_1 = new JLabel("Descripcion");
		lblDescripcion_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescripcion_1.setBounds(38, 224, 182, 56);
		scrollPane.add(lblDescripcion_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 225, 438, 56);
		scrollPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(38, 283, 125, 56);
		scrollPane.add(lblPrecio);
		
		textField = new JTextField();
		textField.setBounds(187, 297, 70, 30);
		scrollPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidad.setBounds(40, 328, 135, 56);
		scrollPane.add(lblCantidad);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 342, 70, 30);
		scrollPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(335, 416, 182, 135);
		scrollPane.add(lblFoto);
		
		File fichero; 
		JButton btnSubirImagen = new JButton("Subir imagen");
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
						
						Icon icono = new ImageIcon (icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
					
						lblFoto.setText(null);
						
						lblFoto.setIcon(icono);
						
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Error abriendo la imagen" + ex);
					}
				}

			}
		});
		btnSubirImagen.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubirImagen.setBounds(40, 416, 125, 33);
		scrollPane.add(btnSubirImagen);
		
		
		ButtonGroup GrupoRopaCosmetico=new ButtonGroup();
		GrupoRopaCosmetico.add(rdbtnRopa);	
		GrupoRopaCosmetico.add(rdbtnCosmetico);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 82, 86, 20);
		scrollPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSubirProducto = new JButton("SUBIR PRODUCTO");
		btnSubirProducto.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubirProducto.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) 
		{
			}
		});
		btnSubirProducto.setBounds(539, 501, 155, 38);
		scrollPane.add(btnSubirProducto);
		
		
		radiobutton=true;

		rdbtnRopa.addActionListener(new ActionListener() 
		{
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {	
	        	
	        	CambioRadioButton(radiobutton=true);
	        }
	        
	    });
		
		rdbtnCosmetico.addActionListener(new ActionListener() 
		{
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	CambioRadioButton(radiobutton=false);
	        }
	    	
	    }		
				);
				

	
	}
	


	
	private  void CambioRadioButton(boolean radiobutton)
	{
		
		if(radiobutton==true)
		{
			comboBox.removeAllItems();
			this.CargarComboRopa();
			
		}
		
		if(radiobutton==false)
		{
			comboBox.removeAllItems();
			this.CargarComboCosmetico();
			
		}
		
	}
	
	public void jTree1ValueChanged( TreeSelectionEvent tse ) 
	{
	     String node = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
	    if( node.equals("Subir producto") ) 
	    {
	    	clsSubirProducto.main(null);
	    	System.out.println("ABRIGO");
	    } else if( node.equals("Mi Ropa") ) 
	    {
	       // play video

	    }
	}
	
	private void CargarComboRopa()
	{
		
		for (enTipoRopa a: enTipoRopa.values())
			{
				comboBox.addItem(a.toString());
				comboBox.repaint();
				scrollPane.add(comboBox);
			}
	}
	
	private void CargarComboCosmetico()
	{
			for (enTipoCosmetico a: enTipoCosmetico.values())
			{
				comboBox.addItem(a.toString());
				comboBox.repaint();
				scrollPane.add(comboBox);
			}

	}
}
