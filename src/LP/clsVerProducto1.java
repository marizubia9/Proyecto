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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import LN.clsGestor;
import LN.clsProducto;

import javax.swing.JComboBox;

public class clsVerProducto1 extends JPanel
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
	private ArrayList <String>tallas;
	private ArrayList <String>unidades;
	int posicionIm;
	int posicionProd;
	double total;
	File imagen;
	ImageIcon icon;

	

	public clsVerProducto1(clsProducto prod)
	{
		System.out.println("ENTRA");
		producto = prod;
		imagen=new File(System.getProperty("user.dir")+"\\src\\img\\" + producto.getImg());
		icon = new ImageIcon (imagen.toString());
		
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
		
		JLabel lblFoto = new JLabel();
		lblFoto.setForeground(Color.WHITE);
		lblFoto.setBackground(Color.WHITE);
		lblFoto.setBounds(-15, 93, 354, 456);
		add(lblFoto);
		
		int multiplicador= icon.getIconHeight()/icon.getIconWidth();
		int anchura= lblFoto.getHeight()/multiplicador;
		Icon icono = new ImageIcon (icon.getImage().getScaledInstance(anchura, lblFoto.getHeight(), Image.SCALE_SMOOTH));
		lblFoto.setIcon(icono);
		
		JLabel lblDescripcion = new JLabel(producto.getDescripcion());
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(512, 134, 263, 40);
		add(lblDescripcion);
		JLabel lblPrecio = new JLabel();
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		double precio = (producto.getPrecio());
		lblPrecio.setText(String.valueOf(precio));
		lblPrecio.setBounds(512, 380, 174, 34);
		add(lblPrecio);
		
		JLabel lblMarca = new JLabel(producto.getMarca());
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarca.setBounds(512, 259, 135, 34);
		add(lblMarca);
		
		JLabel lblCodigo = new JLabel();
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		long codigo = producto.getCodigo();
		lblCodigo.setText(String.valueOf(codigo));
		lblCodigo.setBounds(512, 185, 123, 27);
		add(lblCodigo);
		
		JButton btnAnyadirAlCarrito = new JButton("Anyadir al carrito");
		btnAnyadirAlCarrito.setBounds(389, 494, 174, 34);
		add(btnAnyadirAlCarrito);
		
		JLabel lblDescripcin = new JLabel("DESCRIPCION");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcin.setBounds(367, 146, 98, 16);
		add(lblDescripcin);
		
		JLabel lblPrecio_1 = new JLabel("PRECIO");
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio_1.setBounds(367, 386, 87, 23);
		add(lblPrecio_1);
		
		JLabel lblMarca_1 = new JLabel("MARCA");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarca_1.setBounds(367, 268, 76, 16);
		add(lblMarca_1);
		
		JLabel lblCodigo_1 = new JLabel("CODIGO");
		lblCodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo_1.setBounds(367, 185, 66, 14);
		add(lblCodigo_1);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(367, 109, 87, 14);
		add(lblNombre);
		
		JLabel lblTalla = new JLabel("TALLA");
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTalla.setBounds(367, 224, 76, 14);
		add(lblTalla);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(512, 223, 66, 20);
		comboBox.addItem("XS");
		comboBox.addItem("S");
		comboBox.addItem("M");
		comboBox.addItem("L");
		comboBox.addItem("XL");
		add(comboBox);
		
		JLabel lblTienda = new JLabel("TIENDA");
		lblTienda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTienda.setBounds(367, 308, 46, 14);
		add(lblTienda);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidad.setBounds(367, 349, 66, 16);
		add(lblCantidad);
		
		JComboBox comboBoxCantidad = new JComboBox();
		comboBoxCantidad.setBounds(512, 347, 64, 20);
		comboBoxCantidad.addItem("1");
		comboBoxCantidad.addItem("2");
		comboBoxCantidad.addItem("3");
		comboBoxCantidad.addItem("4");
		comboBoxCantidad.addItem("5");
		add(comboBoxCantidad);
	
		JLabel labelNombre = new JLabel(producto.getNombre());
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNombre.setBounds(512, 109, 87, 14);
		add(labelNombre);
		
		JLabel labelEuro = new JLabel("\u20AC");
		labelEuro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelEuro.setBounds(577, 390, 46, 14);
		add(labelEuro);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(367, 462, 66, 14);
		add(lblTotal);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		String valorCombo = comboBoxCantidad.getSelectedItem().toString();
		int cantidad = Integer.parseInt(valorCombo);
		total = precio*cantidad;
		label.setText(String.valueOf(total));
		label.setBounds(512, 456, 51, 27);
		add(label);
		
		JLabel labelEuroTotal = new JLabel("\u20AC");
		labelEuroTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelEuroTotal.setBounds(577, 462, 46, 14);
		add(labelEuroTotal);
		
		JLabel labelTienda1 = new JLabel(producto.getTienda());
		labelTienda1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTienda1.setBounds(512, 307, 111, 16);
		add(labelTienda1);
		
		
		comboBoxCantidad.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				remove(label);
				String valorCombo = comboBoxCantidad.getSelectedItem().toString();
				int cantidad = Integer.parseInt(valorCombo);
				total = precio*cantidad;
				label.setText(String.valueOf(total));
				label.setBounds(512, 518, 51, 27);
				add(label);
				
			}
			
			});
		
		btnAnyadirAlCarrito.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				clsProducto anyadido = new clsProducto(producto.getNombre(),total, producto.getDescripcion(), producto.getMarca(), codigo, producto.getTienda(), producto.isSexo(), producto.getImg());
				String talla = comboBox.getSelectedItem().toString();
				String unidad = comboBoxCantidad.getSelectedItem().toString();
				listaAnyadidos = clsGestor.ListaAnyadidos(anyadido);
				tallas= clsGestor.Tallas(talla);
				unidades = clsGestor.Unidades (unidad);
				
				clsAnyadirCarrito a = new clsAnyadirCarrito(listaAnyadidos, tallas, unidades);
				clsAnyadirCarrito.main(null);
				
				
			}
			});
	}
}

	


