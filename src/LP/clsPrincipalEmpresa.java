package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class clsPrincipalEmpresa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsPrincipalEmpresa frame = new clsPrincipalEmpresa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public clsPrincipalEmpresa() 
	{
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipalEmpresa.class.getResource("/img/DLZ.png")));
		setBackground(Color.WHITE);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setBorder(null);
		contentPane.add(splitPane);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Menu") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Mi Ropa");
						node_1.add(new DefaultMutableTreeNode("Camisetas"));
						node_1.add(new DefaultMutableTreeNode("Tops"));
						node_1.add(new DefaultMutableTreeNode("Pantalones"));
						node_1.add(new DefaultMutableTreeNode("Faldas"));
						node_1.add(new DefaultMutableTreeNode("...."));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Cosm\u00E9tica");
						node_1.add(new DefaultMutableTreeNode("Cara"));
						node_1.add(new DefaultMutableTreeNode("Labio"));
						node_1.add(new DefaultMutableTreeNode("Ojo"));
						node_1.add(new DefaultMutableTreeNode("..."));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Envios en tramitaci\u00F3n");
						node_1.add(new DefaultMutableTreeNode(""));
					add(node_1);
				}
			}
		));
		tree.setVisibleRowCount(30);
		tree.setBorder(null);
		tree.setFont(new Font("Arial", tree.getFont().getStyle(), tree.getFont().getSize()));
		tree.setForeground(Color.BLACK);
		tree.setBackground(Color.BLACK);
		splitPane.setLeftComponent(tree);
		
		ScrollPane scrollPane = new ScrollPane();
		splitPane.setRightComponent(scrollPane);
	}

}
