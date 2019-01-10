package LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class clsMenu extends JFrame
{
	
	private static JPanel pScrollPane;
	private static JScrollPane scrollPane;
	private static JPanel panel_JTree; 
	private static JTree tree; 

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
		
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setForeground(Color.BLACK);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCerrarSesion.setBackground(Color.WHITE);
		panel_cerrarSesion.add(btnCerrarSesion);
		
		panel_JTree = new JPanel();
		panel_JTree.setBorder(null);
		panel_JTree.setBackground(Color.WHITE);
		panel_superior_2.add(panel_JTree, BorderLayout.WEST);
		panel_JTree.setLayout(new BorderLayout(10, 0));
		
		tree = new JTree();
		tree.setShowsRootHandles(true);
		tree.setBackground(Color.WHITE);
		tree.setRootVisible(false);
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
		panel_JTree.add(tree, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		panel_superior_2.add(scrollPane, BorderLayout.CENTER);
		
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
		
	}
	
	
	
}
