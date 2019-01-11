package LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;

import LD.clsBaseDeDatos;
import LN.clsProducto;

public class clsMenu extends JFrame
{
	private static ArrayList<Image> fotos;
	private ArrayList<Image> fotosCamb;
	private static JPanel pScrollPane;
	private static JScrollPane scrollPane;
	private JButton btnCerrarSesion ;
	private final static Logger LOGGER = Logger.getLogger("LP.clsMenu");
	private static ArrayList<clsProducto> productos_BD;
	int posicionIm = 0;
	
	String path = "C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsMenu frame = new clsMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public clsMenu ()
	{	
		CrearVentana();
		//Meterproductos_BD();
		fotos = new ArrayList<Image>();
		fotosCamb = new ArrayList<Image>();
		productos_BD = new ArrayList<clsProducto>();
		MeterImagenesCamB(path);
		InsertarJPanel();
	
		this.addWindowListener(new WindowListener()
		{

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				clsBaseDeDatos.close();
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

		

		
			
			
		});
		
		
		
	}
	
	public void CrearVentana()
	{
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenu.class.getResource("/img/DLZ.png")));
	
		setBackground(Color.WHITE);
		
		JPanel panel_superior = new JPanel();
		panel_superior.setBackground(Color.BLACK);
		getContentPane().add(panel_superior, BorderLayout.NORTH);
		
		JLabel lblDoalzu = new JLabel("D O A L Z U");
		lblDoalzu.setForeground(Color.WHITE);
		lblDoalzu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_superior.add(lblDoalzu);
		
		JPanel panel_superior_2 = new JPanel();
		getContentPane().add(panel_superior_2, BorderLayout.CENTER);
		panel_superior_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_cerrarSesion = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_cerrarSesion.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_cerrarSesion.setBackground(Color.BLACK);
		panel_superior_2.add(panel_cerrarSesion, BorderLayout.NORTH);
		
		JButton btnCarrito = new JButton();
		btnCarrito.setBackground(Color.WHITE);
		panel_cerrarSesion.add(btnCarrito);
		ImageIcon icono_carrito = new ImageIcon(Toolkit.getDefaultToolkit().getImage(clsMenu.class.getResource("/img/Icono.png")));
		btnCarrito.setIcon(icono_carrito);
		
		
	    btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setForeground(Color.BLACK);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCerrarSesion.setBackground(Color.WHITE);
		panel_cerrarSesion.add(btnCerrarSesion);
		
		JPanel panel_JTree = new JPanel();
		panel_superior_2.add(panel_JTree, BorderLayout.WEST);
		panel_JTree.setLayout(new BorderLayout(0, 0));
		
		JTree tree = new JTree();
		tree.setBackground(Color.BLACK);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Productos") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Ropa");
						node_2 = new DefaultMutableTreeNode("Mujer");
							node_2.add(new DefaultMutableTreeNode("Abrigos"));
							node_2.add(new DefaultMutableTreeNode("Chaquetas"));
							node_2.add(new DefaultMutableTreeNode("Vestidos o Monos"));
							node_2.add(new DefaultMutableTreeNode("Camisas y blusas"));
							node_2.add(new DefaultMutableTreeNode("Camisetas"));
							node_2.add(new DefaultMutableTreeNode("Pantalones"));
							node_2.add(new DefaultMutableTreeNode("Faldas"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Hombre");
							node_2.add(new DefaultMutableTreeNode("Abrigos"));
							node_2.add(new DefaultMutableTreeNode("Chaquetas"));
							node_2.add(new DefaultMutableTreeNode("Camisas "));
							node_2.add(new DefaultMutableTreeNode("Camisetas"));
							node_2.add(new DefaultMutableTreeNode("Pantalones"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Cosmetica\t");
						node_2 = new DefaultMutableTreeNode("Mujer");
							node_2.add(new DefaultMutableTreeNode("Cuidado de la piel"));
							node_2.add(new DefaultMutableTreeNode("Maquillaje"));
							node_2.add(new DefaultMutableTreeNode("Perfumes"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Hombre");
							node_2.add(new DefaultMutableTreeNode("Cuidado de la piel"));
							node_2.add(new DefaultMutableTreeNode("Maquillaje"));
							node_2.add(new DefaultMutableTreeNode("Perfumes"));
						node_1.add(node_2);
					add(node_1);
				}
			}
		));
		panel_JTree.add(tree);
		
		JPanel panel_Principal = new JPanel();
		panel_superior_2.add(panel_Principal, BorderLayout.CENTER);
		panel_Principal.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_Principal.add(scrollPane, BorderLayout.CENTER);
		
		pScrollPane = new JPanel();
		pScrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(pScrollPane);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		pScrollPane.setLayout(gbl_panel);
		
		btnCerrarSesion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
                LD.clsBaseDeDatos.close();
              
            	
            }

        });	
		
	
	}
	
	/**
	 * Método para insertar JPanel
	 */
	public void InsertarJPanel() {
		int x=1;
		int y=1;
		int contador=0;
		int posimagen=0;
		boolean salir=false;
		
		for(int i = 0; i < fotos.size(); i++)
		{
			salir=false;
			if(contador==0 && salir==false)
			{
				clsMenuJPanel lblFoto = new clsMenuJPanel(fotos,posimagen);
				GridBagConstraints gbc_lblFoto = new GridBagConstraints();
				gbc_lblFoto.ipadx = 425;
				gbc_lblFoto.ipady = 571;
				gbc_lblFoto.gridx = x;
				gbc_lblFoto.gridy = y;
				pScrollPane.add(lblFoto, gbc_lblFoto);
				posimagen++;
				x=x+5;
				contador++;
				salir=true;
			}
			
			if(contador==1 && salir==false)
			{
				clsMenuJPanel lblFoto = new clsMenuJPanel(fotos,posimagen);
				GridBagConstraints gbc_lblFoto = new GridBagConstraints();
				gbc_lblFoto.ipadx = 425;
				gbc_lblFoto.ipady = 571;
				gbc_lblFoto.gridx = x;
				gbc_lblFoto.gridy = y;
				pScrollPane.add(lblFoto, gbc_lblFoto);
				posimagen++;
				x=x+5;
				contador++;
				salir=true;
			}
			
			if(contador==2 && salir==false)
			{
				clsMenuJPanel lblFoto = new clsMenuJPanel(fotos,posimagen);
				GridBagConstraints gbc_lblFoto = new GridBagConstraints();
				gbc_lblFoto.ipadx = 425;
				gbc_lblFoto.ipady = 571;
				gbc_lblFoto.gridx = x;
				gbc_lblFoto.gridy = y;
				pScrollPane.add(lblFoto, gbc_lblFoto);
				posimagen++;
				x=1;
				y=y+8;
				contador=0;
				salir=true;
			}
		}
	}
	
	public void Meterproductos_BD() {
		clsProducto producto1 = new clsProducto(null, 45,
				"Camiseta manga corta", "Calvin Klein", 123111, null, false,
				null);
		clsProducto producto2 = new clsProducto(null, 25,
				"Camiseta manga larga", "Zara", 123112, null, false, null);
		clsProducto producto3 = new clsProducto(null, 20,
				"Camiseta manga francesa", "Mango", 123113, null, false, null);
		clsProducto producto4 = new clsProducto(null, 17,
				"Camiseta estampada puntos", "Calvin Klein", 123114, null,
				false, null);
		clsProducto producto5 = new clsProducto(null, 5, "Camiseta tirante",
				"Zara", 123115, null, false, null);
		clsProducto producto6 = new clsProducto(null, 23,
				"Camiseta cuello barco", "Mango", 123116, null, false, null);
		clsProducto producto7 = new clsProducto(null, 45, "Blusa manga corta",
				"Calvin Klein", 123117, null, false, null);
		clsProducto producto8 = new clsProducto(null, 25, "Blusa manga larga",
				"Zara", 123118, null, false, null);

		productos_BD.add(producto1);
		productos_BD.add(producto2);
		productos_BD.add(producto3);
		productos_BD.add(producto4);
		productos_BD.add(producto5);
		productos_BD.add(producto6);
		productos_BD.add(producto7);
		productos_BD.add(producto8);

	}
	
	/**
	 * Método para insertar imágenes de camisetas y blusas en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesCamB(String path) {
		String filtro1 = "cam.*.jpg";
		String filtro2 = "cam.*.png";
		Pattern pfiltro1 = Pattern.compile(filtro1, Pattern.CASE_INSENSITIVE);
		Pattern pfiltro2 = Pattern.compile(filtro2, Pattern.CASE_INSENSITIVE);
		fotos.clear();

		File fInic = new File(path);
		if (fInic.isDirectory()) {
			for (File f : fInic.listFiles()) {

				if (pfiltro1.matcher(f.getName()).matches()
						|| pfiltro2.matcher(f.getName()).matches()) {
					Image imagen = null;

					try {
						imagen = ImageIO.read(f);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					fotosCamb.add(imagen);

					fotos.add(imagen);

				}
			}
		}

	}

		private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para
		// no sobreescribir
	static {
	try {
	LOGGER.addHandler(new FileHandler(clsMenuRopa.class.getName()
	+ ".log.xml", ANYADIR_A_FIC_LOG));
	} catch (SecurityException | IOException e) {
	LOGGER.log(Level.SEVERE, "Error en creación fichero log");
	}
	}

	
	

}
