package LP;



import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JLabel;
import java.awt.Font;

public class clsMenuRopa extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsMenuRopa frame = new clsMenuRopa();
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
	public clsMenuRopa() {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Panel generala
		getContentPane().setForeground(Color.DARK_GRAY);
		setSize( 800, 600 );
		getContentPane().setLayout(null);
		setTitle("DOALZU");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\DLZ.png"));
		setDefaultCloseOperation( JInternalFrame.DISPOSE_ON_CLOSE );
		setBackground(Color.WHITE);
		
		//Goiko zatia
		JPanel pSuperior = new JPanel();
		pSuperior.setBackground(Color.DARK_GRAY);
		pSuperior.setBounds(0, 0, 784, 87);
		getContentPane().add(pSuperior);
		pSuperior.setLayout(null);
		
		JLabel lblDOA = new JLabel("D O A L Z U");
		lblDOA.setForeground(Color.WHITE);
		lblDOA.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDOA.setBounds(34, 29, 124, 24);
		pSuperior.add(lblDOA);
		
		clsPanelFondoBarra clsPanelFondoBarra_ = new clsPanelFondoBarra();
		clsPanelFondoBarra_.setBounds(198, 0, 154, 87);
		pSuperior.add(clsPanelFondoBarra_);
		
		clsPanelFondoBarra clsPanelFondoBarra__1 = new clsPanelFondoBarra();
		clsPanelFondoBarra__1.setBounds(351, 0, 148, 87);
		pSuperior.add(clsPanelFondoBarra__1);
		
		clsPanelFondoBarra clsPanelFondoBarra__2 = new clsPanelFondoBarra();
		clsPanelFondoBarra__2.setBounds(499, 0, 148, 87);
		pSuperior.add(clsPanelFondoBarra__2);
		
		clsPanelFondoBarra clsPanelFondoBarra__3 = new clsPanelFondoBarra();
		clsPanelFondoBarra__3.setBounds(642, 0, 142, 87);
		pSuperior.add(clsPanelFondoBarra__3);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("ROPA") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Mujer");
						node_1.add(new DefaultMutableTreeNode("Abrigo"));
						node_1.add(new DefaultMutableTreeNode("Mono"));
						node_1.add(new DefaultMutableTreeNode("Chaqueta"));
						node_1.add(new DefaultMutableTreeNode("Sudadera"));
						node_1.add(new DefaultMutableTreeNode("Faldas"));
						node_1.add(new DefaultMutableTreeNode("Pantalones"));
						node_1.add(new DefaultMutableTreeNode("Zapatos"));
						node_1.add(new DefaultMutableTreeNode("Accesorios"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Hombre");
						node_1.add(new DefaultMutableTreeNode("Abrigo"));
						node_1.add(new DefaultMutableTreeNode("Cazadora"));
						node_1.add(new DefaultMutableTreeNode("Traje"));
						node_1.add(new DefaultMutableTreeNode("Pantalones"));
						node_1.add(new DefaultMutableTreeNode("Camisas"));
						node_1.add(new DefaultMutableTreeNode("Camisetas"));
						node_1.add(new DefaultMutableTreeNode("Polos"));
						node_1.add(new DefaultMutableTreeNode("Sudaderas"));
						node_1.add(new DefaultMutableTreeNode("Zapatos"));
					add(node_1);
					add(new DefaultMutableTreeNode(""));
				}
			}
		));
		tree.setBackground(Color.DARK_GRAY);
		tree.setBounds(0, 87, 199, 475);
		getContentPane().add(tree);
		
		
		

		

		
		
		

	}
}
