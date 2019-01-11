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

public class clsAnyadirCarrito extends JFrame
{
	/**
	 * 
	 */
	/**
	 * 
	 */
	private JPanel contentPane;
	private static ArrayList <Image>fotos;  
	private ArrayList<clsProducto>listaAnyadidos=new ArrayList <clsProducto>();
	private static clsProducto anyadido;
	static int posicionIm;
	static int posicionAny;
	private static String talla;
	private static String unidades;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					clsAnyadirCarrito frame = new clsAnyadirCarrito(fotos, posicionIm, anyadido, talla, unidades);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public clsAnyadirCarrito(ArrayList <Image> listaF, int posIm, clsProducto any, String talla1, String uds)
	{
		fotos= listaF;
		anyadido = any;
		talla =talla1;
		unidades = uds;
		listaAnyadidos=new ArrayList <clsProducto>();
		listaAnyadidos.add(anyadido);
		posicionIm = posIm;
		CrearVentana(posicionIm);

	}

	/**
	 * Create the panel.
	 * @return 
	 */ 
	public void CrearVentana(int posIm)
	{
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{218, 134, -34, 112, 90, 109, 88, 91, 93, 183, 0};
		gridBagLayout.rowHeights = new int[]{65, 56, 85, 91, 94, 102, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 10;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JLabel lblProducto = new JLabel("PRODUCTO");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblProducto = new GridBagConstraints();
		gbc_lblProducto.anchor = GridBagConstraints.SOUTH;
		gbc_lblProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProducto.gridx = 1;
		gbc_lblProducto.gridy = 2;
		contentPane.add(lblProducto, gbc_lblProducto);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 2;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		JLabel lblNewLabel = new JLabel("TALLA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblUnidades = new JLabel("UNIDADES");
		lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblUnidades = new GridBagConstraints();
		gbc_lblUnidades.anchor = GridBagConstraints.SOUTH;
		gbc_lblUnidades.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidades.gridx = 5;
		gbc_lblUnidades.gridy = 2;
		contentPane.add(lblUnidades, gbc_lblUnidades);
		
		JLabel lblMarca_1 = new JLabel("MARCA");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblMarca_1 = new GridBagConstraints();
		gbc_lblMarca_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblMarca_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca_1.gridx = 6;
		gbc_lblMarca_1.gridy = 2;
		contentPane.add(lblMarca_1, gbc_lblMarca_1);
		
		JLabel lblTienda = new JLabel("TIENDA");
		lblTienda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTienda = new GridBagConstraints();
		gbc_lblTienda.anchor = GridBagConstraints.SOUTH;
		gbc_lblTienda.insets = new Insets(0, 0, 5, 5);
		gbc_lblTienda.gridx = 7;
		gbc_lblTienda.gridy = 2;
		contentPane.add(lblTienda, gbc_lblTienda);
		
		JLabel lblPrecio_1 = new JLabel("PRECIO");
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPrecio_1 = new GridBagConstraints();
		gbc_lblPrecio_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblPrecio_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio_1.gridx = 8;
		gbc_lblPrecio_1.gridy = 2;
		contentPane.add(lblPrecio_1, gbc_lblPrecio_1);
		
		posicionAny =0;
		for (int i=0; i<listaAnyadidos.size(); i++)
		{
		JLabel lblFoto = new JLabel("");
//		lblFoto.setIcon(new ImageIcon(fotos.get(posicionIm)));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.VERTICAL;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 3;
		ImageIcon icon = new ImageIcon (fotos.get(posicionIm).toString());
		
//		ImageIcon icono = new ImageIcon (icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
		lblFoto.setIcon(icon);
		contentPane.add(lblFoto, gbc_label_3);
		
		JLabel lblDescripcion = new JLabel(anyadido.getDescripcion());
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 3;
		gbc_lblDescripcion.gridy = 3;
		contentPane.add(lblDescripcion, gbc_lblDescripcion);
		double precio = anyadido.getPrecio();
		
		JLabel labelTalla = new JLabel(talla);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 3;
		contentPane.add(labelTalla, gbc_label);
		
		JLabel labelUnidades = new JLabel(unidades);
		GridBagConstraints gbc_labelU = new GridBagConstraints();
		gbc_labelU.insets = new Insets(0, 0, 5, 5);
		gbc_labelU.gridx = 5;
		gbc_labelU.gridy = 3;
		contentPane.add(labelUnidades, gbc_labelU);
		
		JLabel lblMarca = new JLabel(listaAnyadidos.get(posicionAny).getMarca());
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 6;
		gbc_lblMarca.gridy = 3;
		contentPane.add(lblMarca, gbc_lblMarca);
		
		JLabel labelTienda = new JLabel(anyadido.getTienda());
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 7;
		gbc_label_2.gridy = 3;
		contentPane.add(labelTienda, gbc_label_2);
		
		JLabel lblPrecio = new JLabel();
		lblPrecio.setText(String.valueOf(precio));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 8;
		gbc_lblPrecio.gridy = 3;
		contentPane.add(lblPrecio, gbc_lblPrecio);
		}
	}
//	}
}
