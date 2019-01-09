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
import java.util.ArrayList;

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

import LN.clsProducto;

public class clsVerProducto1 extends JPanel
{
	/**
	 * 
	 */
	/**
	 * 
	 */
	private ArrayList <Image>fotos;  
	private ArrayList<clsProducto>listaProductos;
	private ArrayList <clsProducto>listaAnyadidos;
	int posicionIm;
	int posicionProd;
	

	

	public clsVerProducto1(ArrayList <Image> listaF, int imagen, ArrayList <clsProducto> listaP, int producto)
	{
		fotos= listaF;
		listaProductos = listaP;
		posicionIm=imagen;
		posicionProd = producto;
		CrearVentana(posicionIm, posicionProd);

	}

	/**
	 * Create the panel.
	 * @return 
	 */ 
	public void CrearVentana(int posIm, int posProd)
	{
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblFoto = new JLabel();
		lblFoto.setForeground(Color.WHITE);
		lblFoto.setBackground(Color.WHITE);
		

		lblFoto.setIcon(new ImageIcon(fotos.get(posicionIm)));
		lblFoto.setBounds(-15, 93, 354, 456);
		add(lblFoto);
		
		JLabel lblDescripcion = new JLabel(listaProductos.get(posicionProd).getDescripcion());
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(512, 111, 263, 40);
		add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel();
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		double precio = listaProductos.get(posicionProd).getPrecio();
		lblPrecio.setText(String.valueOf(precio));
		lblPrecio.setBounds(512, 176, 174, 34);
		add(lblPrecio);
		
		JLabel lblMarca = new JLabel(listaProductos.get(posicionProd).getMarca());
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarca.setBounds(510, 232, 135, 34);
		add(lblMarca);
		
		JLabel lblCodigo = new JLabel();
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		long codigo = listaProductos.get(posicionProd).getCodigo();
		lblCodigo.setText(String.valueOf(codigo));
		lblCodigo.setBounds(512, 288, 123, 27);
		add(lblCodigo);
		
		JButton btnAnyadirAlCarrito = new JButton("ANYADIR AL CARRITO");
		btnAnyadirAlCarrito.setBounds(395, 372, 174, 34);
		add(btnAnyadirAlCarrito);
		
		JLabel lblDescripcin = new JLabel("DESCRIPCION");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescripcin.setBounds(367, 125, 98, 16);
		add(lblDescripcin);
		
		JLabel lblPrecio_1 = new JLabel("PRECIO");
		lblPrecio_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio_1.setBounds(367, 182, 87, 23);
		add(lblPrecio_1);
		
		JLabel lblMarca_1 = new JLabel("MARCA");
		lblMarca_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca_1.setBounds(367, 243, 76, 16);
		add(lblMarca_1);
		
		JLabel lblCodigo_1 = new JLabel("CODIGO");
		lblCodigo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigo_1.setBounds(367, 295, 66, 14);
		add(lblCodigo_1);
		
		btnAnyadirAlCarrito.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				clsProducto anyadido = new clsProducto(null,precio, listaProductos.get(posicionProd).getDescripcion(), listaProductos.get(posicionProd).getMarca(), codigo, null, listaProductos.get(posProd).isSexo(), null);
				listaAnyadidos = new ArrayList<clsProducto>();
				listaAnyadidos.add(anyadido);
				clsAnyadirCarrito a = new clsAnyadirCarrito(fotos, posIm, listaAnyadidos);
				
			}
			});
	}
}

	


