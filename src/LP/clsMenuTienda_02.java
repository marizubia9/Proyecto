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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class clsMenuTienda_02 extends JFrame
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
					clsMenuTienda_02 frame = new clsMenuTienda_02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public clsMenuTienda_02 ()
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
		panel_subirProducto.setBackground(Color.WHITE);
		panel_principal.add(panel_subirProducto, BorderLayout.NORTH);
		panel_subirProducto.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
		
		JLabel lblSubirProducto = new JLabel("Subir Producto: ");
		panel_subirProducto.add(lblSubirProducto);
		
		JButton btnSubirProducto = new JButton();
		btnSubirProducto.setBackground(Color.WHITE);
		panel_subirProducto.add(btnSubirProducto);
		ImageIcon icono_subir = new ImageIcon(Toolkit.getDefaultToolkit().getImage(clsMenuTienda_02.class.getResource("/img/upload.png")));
		btnSubirProducto.setIcon(icono_subir);
		
		panel_JTree = new JPanel();
		panel_JTree.setBackground(Color.WHITE);
		panel_principal.add(panel_JTree, BorderLayout.WEST);
		panel_JTree.setLayout(new BorderLayout(0, 0));
		
		
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
	
		
	}
	
	


