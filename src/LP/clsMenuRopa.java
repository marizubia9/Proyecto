package LP;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;


import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JSplitPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * ClsMenuRopa iteko proba 
 * @author ALUMNO
 *
 */
public class clsMenuRopa {
	
	private ArrayList <Image>fotos;  
	private JFrame frame;
	int posicionIm=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsMenuRopa window = new clsMenuRopa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public clsMenuRopa() {
		fotos= new ArrayList<Image>();
		String path = "C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img";
		MeterImagenes(path);
		CrearVentana();
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void CrearVentana() {
	
		//VENTANA GENERAL
	
		frame = new JFrame();
		frame.setTitle("DOALZU");
		frame.setSize( 800, 600 );
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipalEmpresa.class.getResource("/img/DLZ.png")));
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
		scrollPane.setViewportView(pScrollPane);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pScrollPane.setLayout(gbl_panel_1);
		JLabel lblCamisetaOled = new JLabel("CAMISETA OLED");
		GridBagConstraints gbc_lblCamisetaOled = new GridBagConstraints();
		gbc_lblCamisetaOled.insets = new Insets(0, 0, 5, 5);
		gbc_lblCamisetaOled.gridx = 1;
		gbc_lblCamisetaOled.gridy = 2;
		pScrollPane.add(lblCamisetaOled, gbc_lblCamisetaOled);
		
		//DESCRIPCIONES IMAGENES
		JLabel lblBelarritakoak = new JLabel("CAMISETA JILL");
		GridBagConstraints gbc_lblBelarritakoak = new GridBagConstraints();
		gbc_lblBelarritakoak.insets = new Insets(0, 0, 5, 5);
		gbc_lblBelarritakoak.gridx = 6;
		gbc_lblBelarritakoak.gridy = 2;
		pScrollPane.add(lblBelarritakoak, gbc_lblBelarritakoak);

		
		JLabel lblCamisetaTop = new JLabel("CAMISETA TOP");
		GridBagConstraints gbc_lblCamisetaTop = new GridBagConstraints();
		gbc_lblCamisetaTop.insets = new Insets(0, 0, 5, 5);
		gbc_lblCamisetaTop.gridx = 6;
		gbc_lblCamisetaTop.gridy = 19;
		pScrollPane.add(lblCamisetaTop, gbc_lblCamisetaTop);
		
		JLabel lblCamisetaEstampado = new JLabel("CAMISETA ESTAMPADO");
		GridBagConstraints gbc_lblCamisetaEstampado = new GridBagConstraints();
		gbc_lblCamisetaEstampado.insets = new Insets(0, 0, 5, 5);
		gbc_lblCamisetaEstampado.gridx = 1;
		gbc_lblCamisetaEstampado.gridy = 19;
		pScrollPane.add(lblCamisetaEstampado, gbc_lblCamisetaEstampado);
		
		JLabel lblCamisetaMensaje = new JLabel("CAMISETA MENSAJE");
		GridBagConstraints gbc_lblCamisetaMensaje = new GridBagConstraints();
		gbc_lblCamisetaMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblCamisetaMensaje.gridx = 6;
		gbc_lblCamisetaMensaje.gridy = 11;
		pScrollPane.add(lblCamisetaMensaje, gbc_lblCamisetaMensaje);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(fotos.get(posicionIm)));
		posicionIm++;
		
		JLabel lblCamisetaBotonesManga = new JLabel("CAMISETA BOTONES MANGA");
		GridBagConstraints gbc_lblCamisetaBotonesManga = new GridBagConstraints();
		gbc_lblCamisetaBotonesManga.insets = new Insets(0, 0, 5, 5);
		gbc_lblCamisetaBotonesManga.gridx = 1;
		gbc_lblCamisetaBotonesManga.gridy = 11;
		pScrollPane.add(lblCamisetaBotonesManga, gbc_lblCamisetaBotonesManga);
		lblNewLabel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.ipadx = 70;
		gbc_lblNewLabel_1.ipady = 90;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 10;
		pScrollPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		

		
		//LABEL IMAGEN
		JLabel lblFoto = new JLabel();
		lblFoto.setIcon(new ImageIcon(fotos.get(posicionIm)));
		posicionIm++;
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.ipadx = 70;
		gbc_lblFoto.ipady = 99;
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 1;
		pScrollPane.add(lblFoto, gbc_lblFoto);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(fotos.get(posicionIm)));
		posicionIm++;
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.ipady = 90;
		gbc_lblNewLabel.ipadx = 70;
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 1;
		pScrollPane.add(lblNewLabel, gbc_lblNewLabel);
		
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setIcon(new ImageIcon(fotos.get(posicionIm)));
		posicionIm++;
		lblNewLabel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.ipadx = 70;
		gbc_lblNewLabel_3.ipady = 90;
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 18;
		pScrollPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setIcon(new ImageIcon(fotos.get(posicionIm)));
		posicionIm++;
		lblNewLabel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.ipadx = 70;
		gbc_lblNewLabel_4.ipady = 90;
		gbc_lblNewLabel_4.gridx = 6;
		gbc_lblNewLabel_4.gridy = 18;
		pScrollPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(fotos.get(posicionIm)));
		posicionIm++;
		lblNewLabel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.ipadx = 70;
		gbc_lblNewLabel_2.ipady = 90;
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 10;
		pScrollPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		//BOTONES VER
		JButton bVer3 = new JButton("VER");
		bVer3.setForeground(Color.WHITE);
		bVer3.setBackground(Color.GRAY);
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 1;
		gbc_button_8.gridy = 3;
		pScrollPane.add(bVer3, gbc_button_8);
		
		JButton bVer9 = new JButton("VER");
		bVer9.setForeground(Color.WHITE);
		bVer9.setBackground(Color.GRAY);
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 6;
		gbc_button_9.gridy = 3;
		pScrollPane.add(bVer9, gbc_button_9);
		
		JButton bVer = new JButton("VER");
		bVer.setForeground(Color.WHITE);
		bVer.setBackground(Color.GRAY);
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 6;
		gbc_button_3.gridy = 12;
		pScrollPane.add(bVer, gbc_button_3);
		
		JButton bVer1 = new JButton("VER");
		bVer1.setForeground(Color.WHITE);
		bVer1.setBackground(Color.GRAY);
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 12;
		pScrollPane.add(bVer1, gbc_button_2);
		
		JButton button_5 = new JButton("VER");
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(Color.GRAY);
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 6;
		gbc_button_5.gridy = 20;
		pScrollPane.add(button_5, gbc_button_5);
		
		JButton button_4 = new JButton("VER");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(Color.GRAY);
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 1;
		gbc_button_4.gridy = 20;
		pScrollPane.add(button_4, gbc_button_4);
		
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
	
	
	/**
	 * ArrayListRopa
	 * @param path
	 */
	public void MeterImagenes (String path)
	{
		String filtro1 ="cam.*.jpg";
		String filtro2= "cam.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		
		File fInic = new File(path); 
		if (fInic.isDirectory())
		{
			for( File f : fInic.listFiles() ) 
			{
				
				if ( pfiltro1.matcher(f.getName()).matches()  || pfiltro2.matcher(f.getName()).matches())
				{
					Image imagen = null;
				
						try {
							 imagen = ImageIO.read(f);
							} 
						catch (IOException e) 
							{
							// TODO Auto-generated catch block
							e.printStackTrace();
							}

					fotos.add( imagen );
					
				}
			}
		}
		
		
	}
}
