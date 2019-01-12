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
import javax.swing.JTree;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;

import LN.clsGestor;
import LN.clsRopa;
import LN.clsTienda;

public class clsMenuTienda_02 extends JFrame
{	private static ArrayList<clsRopa> ropa;
	private static ArrayList<Image> fotos;
	private ArrayList<Image> fotosCamb;
	private static JPanel pScrollPane;
	private static JScrollPane scrollPane;
	private static JPanel panel_JTree; 
	private static JTree tree; 
	private clsGestor gestor;
	String path = "C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img";
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					clsMenuTienda_02 frame = new clsMenuTienda_02(tienda);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public clsMenuTienda_02 (clsGestor gestor)
	{
		CrearVentana();
		fotos = new ArrayList<Image>();
		this.gestor=gestor;
		fotosCamb = new ArrayList<Image>();


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
		
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setForeground(Color.BLACK);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCerrarSesion.setBackground(Color.WHITE);
		panel_cerrarSesion.add(btnCerrarSesion);
		
		JPanel panel_principal = new JPanel();
		panel_superior_2.add(panel_principal, BorderLayout.CENTER);
		panel_principal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_subirProducto = new JPanel();
		panel_subirProducto.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_subirProducto.setBackground(Color.BLACK);
		panel_principal.add(panel_subirProducto, BorderLayout.NORTH);
		panel_subirProducto.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
		
		JLabel lblSubirProducto = new JLabel("Subir Producto: ");
		lblSubirProducto.setForeground(Color.WHITE);
		panel_subirProducto.add(lblSubirProducto);
		
		JButton btnSubirProducto = new JButton();
		btnSubirProducto.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				clsSubirProducto_02 frame= new clsSubirProducto_02( gestor);
				frame.setVisible(true);
				
			}
		});
		btnSubirProducto.setBackground(Color.WHITE);
		panel_subirProducto.add(btnSubirProducto);
		ImageIcon icono_subir = new ImageIcon(Toolkit.getDefaultToolkit().getImage(clsMenuTienda_02.class.getResource("/img/upload.png")));
		btnSubirProducto.setIcon(icono_subir);
		
		panel_JTree = new JPanel();
		panel_JTree.setBackground(Color.WHITE);
		panel_principal.add(panel_JTree, BorderLayout.WEST);
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
								node_5.add(new DefaultMutableTreeNode("Cuidado de la piel"));
								node_5.add(new DefaultMutableTreeNode("Maquillaje"));
								node_5.add(new DefaultMutableTreeNode("Perfume"));
						node_1.add(node_5);
					add(node_1);
				}
			}
		));
		panel_JTree.add(tree);
		
		tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
			public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
				jTree1ValueChanged(evt);
			}
		});
		
		scrollPane = new JScrollPane();
		panel_principal.add(scrollPane, BorderLayout.CENTER);
		
		pScrollPane = new JPanel();
		pScrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(pScrollPane);
		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		pScrollPane.setLayout(gbl_panel_1);
		
		btnCerrarSesion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
                LD.clsBaseDeDatos.close();
              
            	
            }

        });	
	}
	/**
	 * M�todo para elegir--> "Tipo" de ropa
	 * 
	 * @param tse
1 	 */
	public void jTree1ValueChanged(TreeSelectionEvent tse) {
		String node = tse.getNewLeadSelectionPath().getLastPathComponent()
				.toString();
		
		if (node.equals("Abrigos")) {
			ropa.clear();
			ropa=gestor.Abrigo_M();
			//MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		} 
		if (node.equals("Chaquetas")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Vestidos o Monos")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Camisas y blusas")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Camisetas")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Pantalones")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Faldas")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Abrigo")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Chaqueta")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Camisa")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Camiseta")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Pantalon")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Cuidado de la piel")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Maquillaje")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Perfumes")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Cuidado de la piel")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Maquillaje")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
		if (node.equals("Perfume")) {

			
			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		}
	}

	/**
	 * M�todo para insertar JPanel
	 */
	public void InsertarJPanel() {
		int x=1;
		int y=1;
		int contador=0;
	
		boolean salir=false;
		
		
		for(int i = 0; i < ropa.size(); i++)
		{
			salir=false;
			if(contador==0 && salir==false)
			{
				clsMenuJPanel lblFoto = new clsMenuJPanel(ropa.get(i));
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
				clsMenuJPanel lblFoto = new clsMenuJPanel(ropa.get(i));
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
				clsMenuJPanel lblFoto = new clsMenuJPanel(ropa.get(i));
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
		
	}}}
	
	


