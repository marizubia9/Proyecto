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
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;

import LD.clsBaseDeDatos;
import LN.clsCosmetica;
import LN.clsGestor;
import LN.clsProducto;
import LN.clsRopa;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class clsMenu extends JFrame
{	
	private static ArrayList<clsRopa> ropa;
	private static ArrayList<clsCosmetica> cosmetica;
	private static ArrayList<clsProducto> productos;

	private static JPanel pScrollPane;
	private static JScrollPane scrollPane;
	private JButton btnCerrarSesion ;
	private final static Logger LOGGER = Logger.getLogger("LP.clsMenu");

	private static clsGestor gestor;
	String path = "C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img";

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					clsMenu frame = new clsMenu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public clsMenu (clsGestor gestor)
	{	
		ropa=new <clsRopa>ArrayList();
		cosmetica=new <clsCosmetica>ArrayList();
		productos=new <clsProducto>ArrayList();
		CrearVentana();
		this.gestor=gestor;

	
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
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
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
		
		JLabel lblNewLabel = new JLabel("Ordenar por:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		panel_cerrarSesion.add(lblNewLabel);
		
		JComboBox Orden_ComboBox = new JComboBox();
		Orden_ComboBox.setBackground(Color.WHITE);
		Orden_ComboBox.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Precio"}));
		Orden_ComboBox.setSelectedIndex(0);
		panel_cerrarSesion.add(Orden_ComboBox);
		
		JButton btnCarrito = new JButton();
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				clsAnyadirCarrito carrito= new clsAnyadirCarrito(gestor);
				carrito.frame.setVisible(true);
			}
		});
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
					DefaultMutableTreeNode node_3;
					DefaultMutableTreeNode node_4;
					DefaultMutableTreeNode node_5;
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
							node_3 = new DefaultMutableTreeNode("Hombre");
							node_3.add(new DefaultMutableTreeNode("Abrigo"));
							node_3.add(new DefaultMutableTreeNode("Chaqueta"));
							node_3.add(new DefaultMutableTreeNode("Camisa "));
							node_3.add(new DefaultMutableTreeNode("Camiseta"));
							node_3.add(new DefaultMutableTreeNode("Pantalon"));
						node_1.add(node_3);
						add(node_1);
					node_1 = new DefaultMutableTreeNode("Cosmetica\t");
						node_4 = new DefaultMutableTreeNode("Mujer");
							node_4.add(new DefaultMutableTreeNode("Cuidado de la piel"));
							node_4.add(new DefaultMutableTreeNode("Maquillaje"));
							node_4.add(new DefaultMutableTreeNode("Perfumes"));
						node_1.add(node_4);
							node_5 = new DefaultMutableTreeNode("Hombre");
								node_5.add(new DefaultMutableTreeNode("Cuidado de la piel."));
								node_5.add(new DefaultMutableTreeNode("Productos de belleza"));
								node_5.add(new DefaultMutableTreeNode("Perfume"));
						node_1.add(node_5);
					add(node_1);
				}
			}
		));
		panel_JTree.add(tree);
		
		tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
			public void valueChanged(javax.swing.event.TreeSelectionEvent evt) 
			{
				jTree1ValueChanged(evt);
				
			}
		});
		
		JPanel panel_Principal = new JPanel();
		panel_superior_2.add(panel_Principal, BorderLayout.CENTER);
		panel_Principal.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_Principal.add(scrollPane, BorderLayout.CENTER);
		
		CrearScrollPane();
				
		String felicitacion="ZORIONAK! \nComo regalo de cumple tendrás un 10€ de descuento por cada 60€ de compra!";
		if(gestor.cumpleaños()) JOptionPane.showMessageDialog(null, felicitacion );
		
		Orden_ComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(((String)Orden_ComboBox.getSelectedItem()).toLowerCase().equals("nombre")) 
            		{
        				pScrollPane.removeAll();
            			productos=gestor.OrdenarNombre(productos);
            	
            			CrearScrollPane();
            			InsertarJPanel();
            			pScrollPane.repaint();
            			scrollPane.repaint();
            		}
            	if(((String)Orden_ComboBox.getSelectedItem()).toLowerCase().equals("precio")) 
        		{
            		pScrollPane.removeAll();
        			productos=gestor.OrdenarPrecio(productos);
        		
        			CrearScrollPane();
        			InsertarJPanel();
        			pScrollPane.repaint();
        			scrollPane.repaint();
        		}
            	
            	
            }

        });	
		
		btnCerrarSesion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
                LD.clsBaseDeDatos.close();
                clsMenuPrincipal principal =new clsMenuPrincipal();
                principal.setVisible(true);
            	
            }

        });	
		
		ropa=gestor.Ropa();
		for(clsRopa a: ropa)
		{
			productos.add((clsProducto)a);
		}
		productos=gestor.OrdenarNombre(productos);
		InsertarJPanel();
		pScrollPane.repaint();
		scrollPane.repaint();
		
		
	}
	/**
	 * Método para elegir--> "Tipo" de ropa
	 * 
	 * @param tse
1 	 */
	public void jTree1ValueChanged(TreeSelectionEvent tse) 
	{
		String node = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
		
		if (node.equals("Abrigos")) 
		{
			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.Abrigo_M();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
		
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		} 
		}
		if (node.equals("Chaquetas")) {

			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.chaqueta_M();
			System.out.println(productos.size());
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}

			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Vestidos o Monos")) {

			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.vestido_M();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}

			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Camisas y blusas")) 
		{

			
			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.camisa_M();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}
		
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Camisetas")) 
		{

			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.camiseta_M();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}
			
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();
		
		}
		if (node.equals("Pantalones")) 
		{

			
			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.pantalon_M();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}
			
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Faldas")) 
		{

			
			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.falda_M();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}
		
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Abrigo")) 
		{

			
			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.Abrigo_H();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			};
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Chaqueta"))
		{

			
			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.chaqueta_H();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}
			
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Camisa")) 
		{

			
			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.camisa_H();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}
	
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Camiseta")) 
		{

			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}

			ropa=gestor.camiseta_H();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}
			
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();
		}

		if (node.equals("Pantalon")) 
		{

			
			pScrollPane.removeAll();
			if(ropa.size()>=0)
			{
				ropa.clear();
			}
			
			ropa=gestor.pantalon_H();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			for(int i=0; i<ropa.size();i++)
			{
				productos.add((clsProducto)ropa.get(i));
			}
			
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();
		}
		if (node.equals("Cuidado de la piel")) 
		{

			
			pScrollPane.removeAll();
			if(cosmetica.size()>=0)
			{
				cosmetica.clear();
			}
			
			cosmetica=gestor.Piel_M();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			
			for(int i=0; i<cosmetica.size();i++)
			{
				productos.add((clsProducto)cosmetica.get(i));
			}
			
			
		
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Productos de belleza")) 
		{

			
			pScrollPane.removeAll();
			if(cosmetica.size()>=0)
			{
				cosmetica.clear();
			}
			
			cosmetica=gestor.Maquillaje_H();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			
			for(int i=0; i<cosmetica.size();i++)
			{
				productos.add((clsProducto)cosmetica.get(i));
			}
			
			
		
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Perfumes")) 
		{

			
			pScrollPane.removeAll();
			if(cosmetica.size()>=0)
			{
				cosmetica.clear();
			}
			
			cosmetica=gestor.Perfume_M();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			
			for(int i=0; i<cosmetica.size();i++)
			{
				productos.add((clsProducto)cosmetica.get(i));
			}
			
			
		
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Cuidado de la piel."))
		{

			pScrollPane.removeAll();
			if(cosmetica.size()>=0)
			{
				cosmetica.clear();
			}
			
			cosmetica=gestor.Piel_H();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			
			for(int i=0; i<cosmetica.size();i++)
			{
				productos.add((clsProducto)cosmetica.get(i));
			}
			
		
		
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Maquillaje"))
		{

			
			pScrollPane.removeAll();
			if(cosmetica.size()>=0)
			{
				cosmetica.clear();
			}
			
			cosmetica=gestor.Maquillaje_M();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			
			for(int i=0; i<cosmetica.size();i++)
			{
				productos.add((clsProducto)cosmetica.get(i));
			}
			
			
		
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Perfume")) 
		{

			
			pScrollPane.removeAll();
			if(cosmetica.size()>=0)
			{
				cosmetica.clear();
			}
			
			cosmetica=gestor.Perfume_H();
			
			if(productos.size()>=0)
			{
				productos.clear();
			}
			
			for(int i=0; i<cosmetica.size();i++)
			{
				productos.add((clsProducto)cosmetica.get(i));
			}
			
			
		
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
	}

	
	/**
	 * Método para insertar JPanel
	 */
	public void InsertarJPanel() {
		int x=1;
		int y=1;
		int contador=0;
	
		boolean salir=false;
		
		for(int i = 0; i < productos.size(); i++)
		{
			salir=false;
			if(contador==0 && salir==false)
			{ 
				
				clsMenuJPanel lblFoto = new clsMenuJPanel(productos.get(i));
				GridBagConstraints gbc_lblFoto = new GridBagConstraints();
				gbc_lblFoto.ipadx = 425;
				gbc_lblFoto.ipady = 571;
				gbc_lblFoto.gridx = x;
				gbc_lblFoto.gridy = y;
				pScrollPane.add(lblFoto, gbc_lblFoto);
				
				x=x+5;
				contador++;
				salir=true;
			}
			
			if(contador==1 && salir==false)
			{
				clsMenuJPanel lblFoto = new clsMenuJPanel(productos.get(i));
				GridBagConstraints gbc_lblFoto = new GridBagConstraints();
				gbc_lblFoto.ipadx = 425;
				gbc_lblFoto.ipady = 571;
				gbc_lblFoto.gridx = x;
				gbc_lblFoto.gridy = y;
				pScrollPane.add(lblFoto, gbc_lblFoto);
				
				x=x+5;
				contador++;
				salir=true;
			}
			
			if(contador==2 && salir==false)
			{
				clsMenuJPanel lblFoto = new clsMenuJPanel(productos.get(i));
				GridBagConstraints gbc_lblFoto = new GridBagConstraints();
				gbc_lblFoto.ipadx = 425;
				gbc_lblFoto.ipady = 571;
				gbc_lblFoto.gridx = x;
				gbc_lblFoto.gridy = y;
				pScrollPane.add(lblFoto, gbc_lblFoto);
			
				x=1;
				y=y+8;
				contador=0;
				salir=true;
			}
		}
	}
	
	



		private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para
		// no sobreescribir
	static {
	try {
	LOGGER.addHandler(new FileHandler(clsMenu.class.getName()
	+ ".log.xml", ANYADIR_A_FIC_LOG));
	} catch (SecurityException | IOException e) {
	LOGGER.log(Level.SEVERE, "Error en creación fichero log");
	}
	}
	/**
	 * Método llamado desde la clase clsMenu para visualizar la pantalla clsVerProducto1.
	 * @param producto
	 */
	public static void BotonVer(clsProducto producto)
	{
		pScrollPane.setVisible(false);
		pScrollPane.removeAll();
		
		clsVerProducto1 a = new clsVerProducto1(producto,gestor);
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.ipadx = 832;
		gbc_lblFoto.ipady = 580;
		gbc_lblFoto.gridx = 2;
		gbc_lblFoto.gridy = 2;
		
		pScrollPane.add(a, gbc_lblFoto);
		LOGGER.log(Level.INFO, "Llega");
		pScrollPane.setVisible(true);
		pScrollPane.repaint();
		scrollPane.repaint();
	}
	
	public void CrearScrollPane()
	{
		pScrollPane = new JPanel();
		pScrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(pScrollPane);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		pScrollPane.setLayout(gbl_panel);
	}
	
}
