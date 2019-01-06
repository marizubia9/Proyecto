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

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.factories.FormFactory;
//
//import net.miginfocom.swing.MigLayout;

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

import LN.clsProducto;

/**
 * ClsMenuRopa iteko proba 
 * @author ALUMNO
 *
 */
public class clsMenuRopa {
	
	private static ArrayList <Image>fotos;  
	private ArrayList <Image>fotosCamb;  
	private ArrayList <Image>fotosChaq; 
	private ArrayList <Image>fotosJer;
	private ArrayList <Image>fotosJeans;
	private ArrayList <Image>fotosFaldas;
	private ArrayList <Image>fotosShorts;
	
	private ArrayList <Image>fotosAbr;
	private ArrayList <Image>fotosSud;
	private ArrayList <Image>fotosPan;
	private ArrayList <Image>fotosCam;
	
	private static ArrayList <clsProducto>productos;
	public JFrame frame=new JFrame();;
	int posicionIm=0;
	String path = "C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img";
	
	private static JPanel pScrollPane;
	private static JScrollPane scrollPane;
	
	

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
		fotosCamb= new ArrayList<Image>();
		fotosChaq= new ArrayList<Image>();
		fotosJeans= new ArrayList<Image>();
		fotosFaldas= new ArrayList<Image>();
		fotosShorts= new ArrayList<Image>();
		fotosJer= new ArrayList<Image>();
		fotosAbr= new ArrayList<Image>();
		fotosSud= new ArrayList<Image>();
		fotosPan= new ArrayList<Image>();
		fotosCam= new ArrayList<Image>();
		
		productos = new ArrayList<clsProducto>();
		

		//MeterImagenesCamB(path);
		MeterProductos();
		CrearVentana();
		frame.setVisible(true);
		
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void CrearVentana() {
	
		//VENTANA GENERAL
		frame.setSize( 800, 600 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DOALZU");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		frame.setLocationRelativeTo(null);
	
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
		 scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		//PANELDESCROLLPANE
		pScrollPane = new JPanel();
		pScrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(pScrollPane);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pScrollPane.setLayout(gbl_panel_1);
		
		

		
		

		
		//TREE
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Ropa") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Mujer");
						node_1.add(new DefaultMutableTreeNode("Chaquetas"));
						node_1.add(new DefaultMutableTreeNode("Jersey"));
						node_1.add(new DefaultMutableTreeNode("Camisetas y blusas"));
						node_1.add(new DefaultMutableTreeNode("Jeans"));
						node_1.add(new DefaultMutableTreeNode("Faldas"));
						node_1.add(new DefaultMutableTreeNode("Shorts"));
						node_1.add(new DefaultMutableTreeNode(""));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Hombre");
						node_1.add(new DefaultMutableTreeNode("Abrigos"));
						node_1.add(new DefaultMutableTreeNode("Sudaderas"));
						node_1.add(new DefaultMutableTreeNode("Pantalones"));
						node_1.add(new DefaultMutableTreeNode("Camisetas"));
						//ArrayList <Image> fotosChaq=new fotosChaq <Image> ArrayList();
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
	 * Método para insertar JPanel
	 */
	public void InsertarJPanel()
	{
		int x=1;
		int y=1;
		boolean parX=false;
		boolean parY=false;
		int posimagen = 0;
		int posproducto = 0;
		boolean cambl=false;
		boolean chaqueta=false;
		boolean falda=false;
		boolean jeans=false;
		boolean shorts=false;
		boolean jersey=false;
		

		for(int i = 0; i<productos.size(); i++)
		{
			if(parX==false && parY==false ||parX==false && parY==true)
			{
				clsMenuRopaJPanel lblFoto = new clsMenuRopaJPanel(fotos,posimagen, productos, posproducto);
				GridBagConstraints gbc_lblFoto = new GridBagConstraints();
				gbc_lblFoto.ipadx = 454;
				gbc_lblFoto.ipady = 580;
				gbc_lblFoto.gridx = x;
				gbc_lblFoto.gridy = y;
				pScrollPane.add(lblFoto, gbc_lblFoto);
				posimagen++;
				posproducto++;
				x=6;
				parX=true;
				}
				
			else
			{
				if(parX==true && parY==false)
				{
					
					clsMenuRopaJPanel lblFoto = new clsMenuRopaJPanel(fotos,posimagen,productos, posproducto);
					GridBagConstraints gbc_lblFoto = new GridBagConstraints();
					gbc_lblFoto.ipadx = 454;
					gbc_lblFoto.ipady = 580;
					gbc_lblFoto.gridx = x;
					gbc_lblFoto.gridy = y;
					pScrollPane.add(lblFoto, gbc_lblFoto);
					posimagen++;
					posproducto++;
					x=1;
					y=y+8;
					parX=false;
					parY=true;
					
				}else
				{
					if(parX==true && parY==true)
					{
						
						clsMenuRopaJPanel lblFoto = new clsMenuRopaJPanel(fotos,posimagen, productos, posproducto);
						GridBagConstraints gbc_lblFoto = new GridBagConstraints();
						gbc_lblFoto.ipadx = 454;
						gbc_lblFoto.ipady = 580;
						gbc_lblFoto.gridx = x;
						gbc_lblFoto.gridy = y;
						pScrollPane.add(lblFoto, gbc_lblFoto);
						posimagen++;
						posproducto++;
						x=1;
						y=y+8;
						parX=false;
						parY=false;
						
					}
				}
			}
						
		}
		}
	
	
	/**
	 * Método para elegir--> "Tipo" de ropa
	 * @param tse
	 */
	public void jTree1ValueChanged( TreeSelectionEvent tse ) {
	     String node = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
	    if( node.equals("Camisetas y blusas") ) {
	    	
	    	MeterImagenesCamB(path);
	    	InsertarJPanel();
	    	pScrollPane.repaint();
	    	scrollPane.repaint();
	    
	    
	    
	    	
	    } else 
	    	{
	    	if( node.equals("Jersey") ) 
	    	{
	    		MeterImagenesJersey (path);
	    		InsertarJPanel();
    	    	pScrollPane.repaint();
    	    	scrollPane.repaint();
    	    	
	    	}else
	    	{
	    		if( node.equals("Chaquetas") ) 
		    	{
	    			MeterImagenesChaq(path);
	    			InsertarJPanel();
	    	    	pScrollPane.repaint();
	    	    	scrollPane.repaint();
	    	    	
		    	}else
		    	{
		    		if( node.equals("Shorts") ) 
			    	{
		    			MeterImagenesShorts(path);
		    			InsertarJPanel();
		    	    	pScrollPane.repaint();
		    	    	scrollPane.repaint();
			    	}
			    	
		    		else
			    	{
		    			if( node.equals("Jeans") ) 
		    	    	{
		    				MeterImagenesJeans(path);
		    	    		InsertarJPanel();
		        	    	pScrollPane.repaint();
		        	    	scrollPane.repaint();
		    	    	}else
		    	    	{
		    	    		if( node.equals("Faldas") ) 
		    		    	{
		    	    			MeterImagenesFaldas (path);
			    	    		InsertarJPanel();
			        	    	pScrollPane.repaint();
			        	    	scrollPane.repaint();
		    		    	}
		    	    		else
		    	    		{
		    	    			if( node.equals("Abrigos") ) 
			    		    	{
		    	    				MeterImagenesAbrigos (path);
				    	    		InsertarJPanel();
				        	    	pScrollPane.repaint();
				        	    	scrollPane.repaint();
			    		    	}
		    	    			else
		    	    			{
			    	    			if( node.equals("Sudaderas") ) 
				    		    	{
			    	    				MeterImagenesSudaderas (path);
					    	    		InsertarJPanel();
					        	    	pScrollPane.repaint();
					        	    	scrollPane.repaint();
				    		    	}	
			    	    			else
			    	    			{
			    	    				if( node.equals("Pantalones") ) 
					    		    	{
			    	    					MeterImagenesPantalones (path);
						    	    		InsertarJPanel();
						        	    	pScrollPane.repaint();
						        	    	scrollPane.repaint();
					    		    	}	
			    	    				else
			    	    				{
			    	    					if( node.equals("Camisetas") ) 
						    		    	{
			    	    						MeterImagenesCamisetas (path);
							    	    		InsertarJPanel();
							        	    	pScrollPane.repaint();
							        	    	scrollPane.repaint();
						    		    	}	
			    	    				}
			    	    			}
		    	    			}
		    	    		}
		    		    	
		    	}
	    	}
	    
	    	}}}
	}
	
	
	/**
	 * Método para insertar imágenes de camisetas y blusas en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesCamB (String path)
	{
		String filtro1 ="cam.*.jpg";
		String filtro2= "cam.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	/**
	 * Método para insertar imágenes de chaquetas en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesChaq (String path)
	{
		String filtro1 ="chaq.*.jpg";
		String filtro2= "chaq.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	
	/**
	 * Método para insertar imágenes de jerseys en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesJersey (String path)
	{
		String filtro1 ="jer.*.jpg";
		String filtro2= "jer.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	/**
	 * Método para insertar imágenes de jeans en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesJeans (String path)
	{
		String filtro1 ="jeans.*.jpg";
		String filtro2= "jeans.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	/**
	 * Método para insertar imágenes de faldas en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesFaldas (String path)
	{
		String filtro1 ="fal.*.jpg";
		String filtro2= "fal.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	
	/**
	 * Método para insertar imágenes de shorts en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesShorts (String path)
	{
		String filtro1 ="shorts.*.jpg";
		String filtro2= "shorts.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	
	/**
	 * Método para insertar imágenes de jerseys en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesAbrigos (String path)
	{
		String filtro1 ="Abr.*.jpg";
		String filtro2= "Abr.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	
	/**
	 * Método para insertar imágenes de jerseys en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesSudaderas (String path)
	{
		String filtro1 ="sud.*.jpg";
		String filtro2= "sud.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	/**
	 * Método para insertar imágenes de pantalones en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesPantalones (String path)
	{
		String filtro1 ="pan.*.jpg";
		String filtro2= "pan.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	
	/**
	 * Método para insertar imágenes de camisetas en el arraylist
	 * @param path
	 */
	
	public void MeterImagenesCamisetas (String path)
	{
		String filtro1 ="camis.*.jpg";
		String filtro2= "camis.*.png";		
		Pattern pfiltro1 = Pattern.compile( filtro1, Pattern.CASE_INSENSITIVE ); 
		Pattern pfiltro2 = Pattern.compile( filtro2, Pattern.CASE_INSENSITIVE ); 
		fotos.clear();
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

						fotosCamb.add( imagen );
						
						fotos.add(imagen);
					
				}
			}
		}
		
		
		
	}
	
	public void MeterProductos ()
	{
		clsProducto producto1 = new clsProducto (45, "Camiseta manga corta", "Calvin Klein", "123jjj", null);
		clsProducto producto2 = new clsProducto (25, "Camiseta manga larga", "Zara", "123jjk", null);
		clsProducto producto3 = new clsProducto (20, "Camiseta manga francesa", "Mango", "123jjl", null);
		clsProducto producto4 = new clsProducto (17, "Camiseta estampada puntos", "Calvin Klein", "123jjm", null);
		clsProducto producto5 = new clsProducto (5, "Camiseta tirante", "Zara", "123jjn", null);
		clsProducto producto6 = new clsProducto (23, "Camiseta cuello barco", "Mango", "123jjo", null);
		clsProducto producto7 = new clsProducto (45, "Blusa manga corta", "Calvin Klein", "123jjp", null);
		clsProducto producto8 = new clsProducto (25, "Blusa manga larga", "Zara", "123jjq", null);
		
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);
		productos.add(producto5);
		productos.add(producto6);
		productos.add(producto7);
		productos.add(producto8);
		

		
	}
	
	public static void BotonVer(int posicionimagen, int posicionproducto)
	{
		int posimagen=posicionimagen;
		int posproducto= posicionproducto;
		
		pScrollPane.setVisible(false);
		pScrollPane.removeAll();
		clsVerProducto1 a = new clsVerProducto1(fotos, posimagen, productos, posproducto);
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.ipadx = 832;
		gbc_lblFoto.ipady = 580;
		gbc_lblFoto.gridx = 2;
		gbc_lblFoto.gridy = 2;
		
		pScrollPane.add(a, gbc_lblFoto);
		pScrollPane.repaint();
		scrollPane.repaint();
		pScrollPane.setVisible(true);
				
	}
	
	public static void AnyadirCarrito (ArrayList <Image> listaF, int imagen, ArrayList <clsProducto> listaA)
	{
		int posimagen=imagen;
		
		ArrayList<clsProducto>listaAnyadidos = listaA;
		System.out.println(listaAnyadidos.size());
		
		for(int i = 0; i<listaAnyadidos.size(); i++)
		{
		pScrollPane.removeAll();
		clsAnyadirCarrito a = new clsAnyadirCarrito(fotos, posimagen, listaAnyadidos);
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.ipadx = 832;
		gbc_lblFoto.ipady = 580;
		gbc_lblFoto.gridx = 2;
		gbc_lblFoto.gridy = 2;
		
		pScrollPane.add(a, gbc_lblFoto);
		pScrollPane.repaint();
		scrollPane.repaint();
		}
	}
	
}