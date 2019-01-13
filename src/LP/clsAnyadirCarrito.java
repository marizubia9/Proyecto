package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import LN.clsCosmetica;
import LN.clsGestor;
import LN.clsProducto;
import LN.clsRopa;

import java.awt.FlowLayout;
import java.io.File;

public class clsAnyadirCarrito extends JFrame
{
	private JPanel contentPane;
	private static ArrayList <Image>fotos;  
	private static ArrayList<clsProducto>listaAnyadidos;
	private static clsProducto anyadido;
	static int posicionIm;
	static int posicionAny;
	private static ArrayList<String> tallas;
	private static ArrayList<Integer> unidades;
	private JLabel lblFoto;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panelProducto;
	private double total;
	private JLabel labelPonerTalla;
	private clsGestor gestor;
	private clsProducto producto;
	private String talla;
	private int unidad;
	private File imagen;
	private ImageIcon icon;

	public static JFrame frame = new JFrame();
	
//	public static void main(String[] args) 
//	{
//		EventQueue.invokeLater(new Runnable() 
//		{
//			public void run() 
//			{
//				try 
//				{
//					clsAnyadirCarrito window = new clsAnyadirCarrito(listaAnyadidos, tallas, unidades);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Constructor de esta clase, al que se le envían desde la clase VerProducto la lista de añadidos a su carrito, sus correspondientes
	 * tallas y la cantidad. El ArrayList de listaAnyadidos, está guardado en el gestor, para que mientras que el usuario mantenga la sesión
	 * iniciada se guarden los productos que ha ido añadiendo a la lista. Lo mismo con los ArrayLists de tallas y unidades.
	 * @param any
	 * @param talla1
	 * @param uds
	 */
	public clsAnyadirCarrito(clsGestor gestor)
	{
		this.gestor = gestor;
		total =0;
		posicionAny = 0;
		listaAnyadidos =clsGestor.getListaAnyadidos();
		tallas = gestor.getTallas();
		unidades = gestor.getUnidades();
		
		CrearVentana(posicionAny);
		
	}

	/**
	 * Create the panel.
	 * @return 
	 */ 
	public void CrearVentana(int posAny)
	{
		frame.setSize(1000, 800);
		frame.setTitle("DOALZU");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		frame.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{846, 0};
		gridBagLayout.rowHeights = new int[]{489, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setBackground(Color.WHITE);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		scrollPane.resize(d);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(scrollPane );
						
			AñadirElementos();

	}
	
	public void AñadirElementos()
	{
		total =0;
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setBounds(0, 0, 984, 800);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{218, 134, 208, 98, 90, 95, 163, 108, 59, 0};
		gbl_panel.rowHeights = new int[]{65, 56, 85, 91, 94, 115, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		panel.resize(d);
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 9;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_1.resize(d);
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{163, 46, 0};
		gbl_panel_1.rowHeights = new int[]{14, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("D O A L Z U");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblProducto = new JLabel("PRODUCTO");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblProducto = new GridBagConstraints();
		gbc_lblProducto.anchor = GridBagConstraints.SOUTH;
		gbc_lblProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProducto.gridx = 1;
		gbc_lblProducto.gridy = 2;
		panel.add(lblProducto, gbc_lblProducto);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);
		
		JLabel lblNewLabel = new JLabel("TALLA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblUnidades = new JLabel("UNIDADES");
		lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblUnidades = new GridBagConstraints();
		gbc_lblUnidades.anchor = GridBagConstraints.SOUTH;
		gbc_lblUnidades.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidades.gridx = 4;
		gbc_lblUnidades.gridy = 2;
		panel.add(lblUnidades, gbc_lblUnidades);
		
		JLabel lblMarca_1 = new JLabel("MARCA");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblMarca_1 = new GridBagConstraints();
		gbc_lblMarca_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblMarca_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca_1.gridx = 5;
		gbc_lblMarca_1.gridy = 2;
		panel.add(lblMarca_1, gbc_lblMarca_1);
		
		JLabel lblTienda = new JLabel("TIENDA");
		lblTienda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTienda = new GridBagConstraints();
		gbc_lblTienda.anchor = GridBagConstraints.SOUTH;
		gbc_lblTienda.insets = new Insets(0, 0, 5, 5);
		gbc_lblTienda.gridx = 6;
		gbc_lblTienda.gridy = 2;
		panel.add(lblTienda, gbc_lblTienda);
		
		JLabel lblPrecio_1 = new JLabel("PRECIO");
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPrecio_1 = new GridBagConstraints();
		gbc_lblPrecio_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblPrecio_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio_1.gridx = 7;
		gbc_lblPrecio_1.gridy = 2;
		panel.add(lblPrecio_1, gbc_lblPrecio_1);

		int y = 3;
		posicionAny =0;
		for (int i=0; i<listaAnyadidos.size(); i++)
		{
			
				panelProducto = new JPanel();
				panelProducto.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
				panelProducto.setBackground(Color.WHITE);
				GridBagConstraints gbc_panel_11 = new GridBagConstraints();
				gbc_panel_11.gridwidth = 7;
				gbc_panel_11.insets = new Insets(0, 0, 5, 5);
				gbc_panel_11.fill = GridBagConstraints.BOTH;
				gbc_panel_11.gridx = 1;
				gbc_panel_11.gridy = y;

				panelProducto.resize(d);
				panel.add(panelProducto, gbc_panel_11);
				
		GridBagLayout gbl_panelProducto = new GridBagLayout();
		gbl_panelProducto.columnWidths = new int[]{173, 158, 107, 100, 119, 111, 93, 29, 0};
		gbl_panelProducto.rowHeights = new int[]{86, 0};
		gbl_panelProducto.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelProducto.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelProducto.setLayout(gbl_panelProducto);
		
		JLabel lblPonerFoto = new JLabel("HEMENArgazkia");
		GridBagConstraints gbc_lblPonerFoto = new GridBagConstraints();
		gbc_lblPonerFoto.fill = GridBagConstraints.BOTH;
		gbc_lblPonerFoto.insets = new Insets(0, 0, 0, 5);
		gbc_lblPonerFoto.gridx = 0;
		gbc_lblPonerFoto.gridy = 0;
		
		panelProducto.add(lblPonerFoto, gbc_lblPonerFoto);
//		imagen=new File(System.getProperty("user.dir")+"\\src\\img\\" +listaAnyadidos.get(posicionAny).getImg());
//		icon = new ImageIcon (imagen.toString());
//		int multiplicador= icon.getIconHeight()/icon.getIconWidth();
//		int anchura= lblPonerFoto.getHeight()/multiplicador;
//		Icon icono = new ImageIcon (icon.getImage().getScaledInstance(anchura, lblPonerFoto.getHeight(), Image.SCALE_SMOOTH));
//		lblPonerFoto.setIcon(icono);
//	
		System.out.println(lblPonerFoto.getWidth());
		JLabel lblPonerNombre = new JLabel(listaAnyadidos.get(posicionAny).getNombre());
		GridBagConstraints gbc_lblPonerNombre = new GridBagConstraints();
		gbc_lblPonerNombre.fill = GridBagConstraints.VERTICAL;
		gbc_lblPonerNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblPonerNombre.gridx = 1;
		gbc_lblPonerNombre.gridy = 0;
		panelProducto.add(lblPonerNombre, gbc_lblPonerNombre);
		
		if(listaAnyadidos.get(posicionAny) instanceof clsRopa)
		{
			labelPonerTalla = new JLabel(tallas.get(posicionAny).toString());
			GridBagConstraints gbc_labelPonerTalla = new GridBagConstraints();
			gbc_labelPonerTalla.insets = new Insets(0, 0, 0, 5);
			gbc_labelPonerTalla.gridx = 2;
			gbc_labelPonerTalla.gridy = 0;
			panelProducto.add(labelPonerTalla, gbc_labelPonerTalla);
		}
		
		if(listaAnyadidos.get(posicionAny) instanceof clsCosmetica)
		{
			labelPonerTalla = new JLabel("U");
			GridBagConstraints gbc_labelPonerTalla = new GridBagConstraints();
			gbc_labelPonerTalla.insets = new Insets(0, 0, 0, 5);
			gbc_labelPonerTalla.gridx = 2;
			gbc_labelPonerTalla.gridy = 0;
			panelProducto.add(labelPonerTalla, gbc_labelPonerTalla);
		}
		
		
		JLabel labelPonerUnidades = new JLabel(unidades.get(posicionAny).toString());
		GridBagConstraints gbc_labelPonerUnidades = new GridBagConstraints();
		gbc_labelPonerUnidades.insets = new Insets(0, 0, 0, 5);
		gbc_labelPonerUnidades.gridx = 3;
		gbc_labelPonerUnidades.gridy = 0;
		panelProducto.add(labelPonerUnidades, gbc_labelPonerUnidades);
		
		JLabel labelPonerMarca = new JLabel(listaAnyadidos.get(posicionAny).getMarca());
		GridBagConstraints gbc_labelPonerMarca = new GridBagConstraints();
		gbc_labelPonerMarca.anchor = GridBagConstraints.WEST;
		gbc_labelPonerMarca.insets = new Insets(0, 0, 0, 5);
		gbc_labelPonerMarca.gridx = 4;
		gbc_labelPonerMarca.gridy = 0;
		panelProducto.add(labelPonerMarca, gbc_labelPonerMarca);
		
		JLabel labelPonerTienda = new JLabel(gestor.NombreTienda(listaAnyadidos.get(posicionAny).getTienda()));
		GridBagConstraints gbc_labelPonerTienda = new GridBagConstraints();
		gbc_labelPonerTienda.insets = new Insets(0, 0, 0, 5);
		gbc_labelPonerTienda.gridx = 5;
		gbc_labelPonerTienda.gridy = 0;
		panelProducto.add(labelPonerTienda, gbc_labelPonerTienda);
		
		JLabel labelPonerPrecio = new JLabel();
		labelPonerPrecio.setText(String.valueOf(listaAnyadidos.get(posicionAny).getPrecio()));
		GridBagConstraints gbc_labelPonerPrecio = new GridBagConstraints();
		gbc_labelPonerPrecio.anchor = GridBagConstraints.EAST;
		gbc_labelPonerPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_labelPonerPrecio.gridx = 6;
		gbc_labelPonerPrecio.gridy = 0;
		panelProducto.add(labelPonerPrecio, gbc_labelPonerPrecio);
		
		JLabel labelPonerEuro = new JLabel("\u20AC");
		labelPonerEuro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_labelPonerEuro = new GridBagConstraints();
		gbc_labelPonerEuro.gridx = 7;
		gbc_labelPonerEuro.gridy = 0;
		panelProducto.add(labelPonerEuro, gbc_labelPonerEuro);
		
		JButton btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 9;
		gbc_btnEliminar.gridy = 0;
		panelProducto.add(btnEliminar, gbc_btnEliminar);
		total = total + listaAnyadidos.get(posicionAny).getPrecio(); 
		y ++;
		posicionAny++;
		btnEliminar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (listaAnyadidos.size()>=1)
				{
					listaAnyadidos.remove(posicionAny-1);
					panel.removeAll();
					AñadirElementos();
					panel.repaint();
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "No tiene ningun producto anyadido al carrito");
				}
				
			}
			});		
		}
		panelProducto = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelProducto.getLayout();
		flowLayout.setVgap(20);
		panelProducto.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.gridwidth = 7;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = y+1;
		panelProducto.resize(d);
		
		
		
		JLabel lblTotal = new JLabel ("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.gridx = 8;
		gbc_lblTotal.gridy = 0;
		panelProducto.add(lblTotal, gbc_lblTotal);
		
		JLabel lblPonerTotal = new JLabel ();
		lblPonerTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		if (gestor.cumpleaños())
		{
			int ahorro = (int) ((total / 60) * 10);
			total = total - ahorro;
		}
		lblPonerTotal.setText(String.valueOf(total));
		GridBagConstraints gbc_lblPonerTotal = new GridBagConstraints();
		gbc_lblPonerTotal.anchor = GridBagConstraints.EAST;
		gbc_lblPonerTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblPonerTotal.gridx = 9;
		gbc_lblPonerTotal.gridy = 0;
		panelProducto.add(lblPonerTotal, gbc_lblPonerTotal);
		
		JLabel labelEuroTotal = new JLabel ("€");
		labelEuroTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblEuroTotal = new GridBagConstraints();
		gbc_lblEuroTotal.gridx = 8;
		gbc_lblEuroTotal.gridy = 0;
		panelProducto.add(labelEuroTotal, gbc_lblEuroTotal);
		
		JButton btnNewButton = new JButton("Tramitar Pedido");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (listaAnyadidos.size()>0)
				{
					clsPagar a = new clsPagar (total, gestor);
					a.setVisible(true);
				}
				else {
					JOptionPane.showConfirmDialog(null, "No hay ningun producto que tramitar, sigue comprando");
					frame.setVisible(false);
				}
				
				
			}
		});
		panelProducto.add(btnNewButton);
		
		JButton btnSeguirComprando = new JButton("Seguir Comprando");
		btnSeguirComprando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
			}
		});
		btnSeguirComprando.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelProducto.add(btnSeguirComprando);
		
		
		
	}
	
	public static void Cerrar()
	{
		frame.setVisible(false);
	}
}
