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

public class clsAnyadirCarrito extends JPanel
{
	/**
	 * 
	 */
	/**
	 * 
	 */
	private ArrayList <Image>fotos;  
	private ArrayList<clsProducto>listaAnyadidos;
	int posicionIm;
	int posicionAny;
	

	public clsAnyadirCarrito(ArrayList <Image> listaF, int posIm, ArrayList <clsProducto> listaA)
	{
		fotos= listaF;
		listaAnyadidos = listaA;
		posicionIm = posIm;
		CrearVentana(posicionIm, posicionAny);

	}

	/**
	 * Create the panel.
	 * @return 
	 */ 
	public void CrearVentana(int posIm, int posAny)
	{
		setBackground(Color.WHITE);
		setLayout(null);
		posAny=0;
			
		JLabel lblFoto = new JLabel();
		lblFoto.setForeground(Color.WHITE);
		lblFoto.setBackground(Color.WHITE);
		

		lblFoto.setIcon(new ImageIcon(fotos.get(posicionIm)));
		lblFoto.setBounds(10, 93, 354, 456);
		add(lblFoto);
		
		JLabel lblDescripcion = new JLabel(listaAnyadidos.get(posAny).getDescripcion());
		lblDescripcion.setBounds(432, 136, 218, 40);
		add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel();
		double precio = listaAnyadidos.get(posAny).getPrecio();
		lblPrecio.setText(String.valueOf(precio));
		lblPrecio.setBounds(432, 181, 174, 34);
		add(lblPrecio);
		
		JLabel lblMarca = new JLabel(listaAnyadidos.get(posAny).getMarca());
		lblMarca.setBounds(432, 237, 174, 34);
		add(lblMarca);
		
		JLabel lblCodigo = new JLabel(listaAnyadidos.get(posAny).getCodigo());
		lblCodigo.setBounds(432, 282, 123, 27);
		add(lblCodigo);
		
		JButton btnComprar = new JButton("PROCEDER CON LA COMPRA");
		btnComprar.setBounds(483, 402, 135, 34);
		add(btnComprar);
		
		btnComprar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				clsMenuRopa.AnyadirCarrito(fotos, posIm, listaAnyadidos);

			}
			});
	}
//	}
}

	


