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

public class clsVerProducto1 extends JFrame 
{

	private ArrayList <Image>fotos;  
	JFrame frame;
	int posicionIm=0;
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsVerProducto1 frame = new clsVerProducto1();
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
	public clsVerProducto1() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DOALZU");
		
		//GRIDBAGLAYOUT
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
				gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
				gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				frame.getContentPane().setLayout(gridBagLayout);
				
				
				//PANELSUPERIOR
				JPanel pSuperior = new JPanel();
				pSuperior.setBackground(Color.WHITE);
				pSuperior.setForeground(Color.WHITE);
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.anchor = GridBagConstraints.NORTH;
				gbc_panel.ipady = -50;
				gbc_panel.gridy = 0;
				gbc_panel.gridx = 0;
				gbc_panel.gridwidth = 6;
				gbc_panel.insets = new Insets(0, 0, 5, 0);
				gbc_panel.fill = GridBagConstraints.HORIZONTAL;
				frame.getContentPane().add(pSuperior, gbc_panel);
				
				
				JPanel pSuperior1 = new JPanel();
				pSuperior1.setBackground(Color.GRAY);
				GridBagConstraints gbc_panel_2 = new GridBagConstraints();
				gbc_panel_2.gridwidth = 6;
				gbc_panel_2.insets = new Insets(0, 0, 5, 5);
				gbc_panel_2.fill = GridBagConstraints.BOTH;
				gbc_panel_2.gridx = 0;
				gbc_panel_2.gridy = 0;
				frame.getContentPane().add(pSuperior1, gbc_panel_2);
				
				//GRIDBAGLAYOUT DEL PSUPERIOR
				GridBagLayout gbl_panel_2 = new GridBagLayout();
				gbl_panel_2.columnWidths = new int[]{0, 0};
				gbl_panel_2.rowHeights = new int[]{0, 0, 0};
				gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
				gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				pSuperior1.setLayout(gbl_panel_2);
				
				//LABEL DOALZU SUPERIOR
				JLabel lblDoalzu = new JLabel("D O A L Z U");
				lblDoalzu.setForeground(Color.WHITE);
				lblDoalzu.setFont(new Font("Times New Roman", Font.BOLD, 20));
				GridBagConstraints gbc_lblDoalzu = new GridBagConstraints();
				gbc_lblDoalzu.gridheight = 2;
				gbc_lblDoalzu.insets = new Insets(0, 0, 0, 0);
				gbc_lblDoalzu.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblDoalzu.gridx = 0;
				gbc_lblDoalzu.gridy = 0;
				pSuperior1.add(lblDoalzu, gbc_lblDoalzu);
				
				//SCROLLPANE
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridheight = 4;
				gbc_scrollPane.gridwidth = 5;
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 1;
				frame.getContentPane().add(scrollPane, gbc_scrollPane);
				
				//PANELDESCROLLPANE
				JPanel pScrollPane = new JPanel();
				pScrollPane.setBackground(Color.WHITE);
				scrollPane.setColumnHeaderView(pScrollPane);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				pScrollPane.setLayout(gbl_panel_1);
				
				JLabel lblNewLabel = new JLabel("New label");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.gridheight = 8;
				gbc_lblNewLabel.gridwidth = 8;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 5;
				gbc_lblNewLabel.gridy = 4;
				pScrollPane.add(lblNewLabel, gbc_lblNewLabel);
				posicionIm++;
				posicionIm++;
				posicionIm++;
				posicionIm++;
				posicionIm++;
				posicionIm++;
				
			
				//TREE
				JTree tree = new JTree();
				tree.setModel(new DefaultTreeModel(
					new DefaultMutableTreeNode("JTree") {
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

						}
					}
				));
				tree.setBackground(Color.GRAY);
				GridBagConstraints gbc_tree = new GridBagConstraints();
				gbc_tree.ipadx = -80;
				gbc_tree.ipady = 99;
				gbc_tree.gridheight = 4;
				gbc_tree.insets = new Insets(0, 0, 0, 5);
				gbc_tree.fill = GridBagConstraints.BOTH;
				gbc_tree.gridx = 0;
				gbc_tree.gridy = 1;
				frame.getContentPane().add(tree, gbc_tree);
				tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
			        public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
			            jTree1ValueChanged(evt);
			        }
			    });
				
				
	}
	/**
	 * Treen aukeraketa iteko metodoa.
	 * @param tse
	 */
	public void jTree1ValueChanged( TreeSelectionEvent tse ) {
	     String node = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
	    if( node.equals("Abrigo") ) {
	        // play audio
	    	System.out.println("ABRIGO");
	    } else if( node.equals("Cazadora") ) {
	       // play video
	    	System.out.println("CAZADORA");
	    }
	}
	

}
