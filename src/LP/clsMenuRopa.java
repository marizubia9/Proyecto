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
import java.awt.event.WindowAdapter;

import javax.swing.JDesktopPane;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
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

import com.sun.glass.events.WindowEvent;

import LN.clsGestor;
import LN.clsProducto;
import LN.clsRopa;

/**
 * ClsMenuRopa iteko proba
 * 
 * @author ALUMNO
 *
 */
public class clsMenuRopa {

	private static ArrayList<Image> fotos;
	private ArrayList<Image> fotosCamb;
	private ArrayList<Image> fotosChaq;
	private ArrayList<Image> fotosJer;
	private ArrayList<Image> fotosJeans;
	private ArrayList<Image> fotosFaldas;
	private ArrayList<Image> fotosShorts;

	private ArrayList<Image> fotosAbr;
	private ArrayList<Image> fotosSud;
	private ArrayList<Image> fotosPan;
	private ArrayList<Image> fotosCam;

	private static ArrayList<clsProducto> productos_BD;
	private static ArrayList<clsRopa> productos_BD_BD;
	public JFrame frame = new JFrame();;
	int posicionIm = 0;
	String path = "C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img";

	private static JPanel pScrollPane;
	private static JScrollPane scrollPane;

	private final static Logger LOGGER = Logger.getLogger("LP.clsMenuRopa");

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

		fotos = new ArrayList<Image>();
		fotosCamb = new ArrayList<Image>();
		fotosChaq = new ArrayList<Image>();
		fotosJeans = new ArrayList<Image>();
		fotosFaldas = new ArrayList<Image>();
		fotosShorts = new ArrayList<Image>();
		fotosJer = new ArrayList<Image>();
		fotosAbr = new ArrayList<Image>();
		fotosSud = new ArrayList<Image>();
		fotosPan = new ArrayList<Image>();
		fotosCam = new ArrayList<Image>();

		productos_BD = new ArrayList<clsProducto>();

		// MeterImagenesCamB(path);
		Meterproductos_BD();
		CrearVentana();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void CrearVentana() {

		// VENTANA GENERAL
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DOALZU");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				clsMenuPrincipal.class.getResource("/img/DLZ.png")));
		frame.setLocationRelativeTo(null);

		// GRIDBAGLAYOUT
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		// PANELSUPERIOR
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

		// GRIDBAGLAYOUT DEL PSUPERIOR
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pSuperior1.setLayout(gbl_panel_2);

		// LABEL DOALZU SUPERIOR
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

		// SCROLLPANE
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);

		// PANELDESCROLLPANE
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

		productos_BD_BD = clsGestor.Ropa();

		// TREE
		JTree tree = new JTree();
		tree.setShowsRootHandles(true);
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
							node_2.add(new DefaultMutableTreeNode("Vestidos"));
							node_2.add(new DefaultMutableTreeNode("Camisas y blusas"));
							node_2.add(new DefaultMutableTreeNode("Camisetas"));
							node_2.add(new DefaultMutableTreeNode("Sudaderas"));
							node_2.add(new DefaultMutableTreeNode("Pantalones"));
							node_2.add(new DefaultMutableTreeNode("Jeans"));
							node_2.add(new DefaultMutableTreeNode("Monos"));
							node_2.add(new DefaultMutableTreeNode("Faldas"));
							node_2.add(new DefaultMutableTreeNode("Shorts"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Hombre");
							node_2.add(new DefaultMutableTreeNode("Abrigos"));
							node_2.add(new DefaultMutableTreeNode("Chaquetas"));
							node_2.add(new DefaultMutableTreeNode("Trajes"));
							node_2.add(new DefaultMutableTreeNode("Camisas "));
							node_2.add(new DefaultMutableTreeNode("Camisetas"));
							node_2.add(new DefaultMutableTreeNode("Sudaderas"));
							node_2.add(new DefaultMutableTreeNode("Pantalones"));
							node_2.add(new DefaultMutableTreeNode("Jeans"));
							node_2.add(new DefaultMutableTreeNode("Blazers"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Cosmetica\t");
						node_1.add(new DefaultMutableTreeNode("Cuerpo"));
						node_1.add(new DefaultMutableTreeNode("Rostro"));
						node_2 = new DefaultMutableTreeNode("Maquillaje");
							node_2.add(new DefaultMutableTreeNode("Ojos"));
						node_1.add(node_2);
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
	 * M�todo para insertar JPanel
	 */
	public void InsertarJPanel() {
		int x = 1;
		int y = 1;
		boolean parX = false;
		boolean parY = false;
		int posimagen = 0;
		int posproducto = 0;
		boolean cambl = false;
		boolean chaqueta = false;
		boolean falda = false;
		boolean jeans = false;
		boolean shorts = false;
		boolean jersey = false;

		for (int i = 0; i < productos_BD.size(); i++) {
			if (parX == false && parY == false || parX == false && parY == true) {
				clsMenuRopaJPanel lblFoto = new clsMenuRopaJPanel(fotos,
						posimagen, productos_BD, posproducto);
				GridBagConstraints gbc_lblFoto = new GridBagConstraints();
				gbc_lblFoto.ipadx = 454;
				gbc_lblFoto.ipady = 580;
				gbc_lblFoto.gridx = x;
				gbc_lblFoto.gridy = y;
				pScrollPane.add(lblFoto, gbc_lblFoto);
				LOGGER.log(Level.INFO, "A�ade al pScrollPane");
				posimagen++;
				posproducto++;
				x = 6;
				parX = true;
			}

			else {
				if (parX == true && parY == false) {

					clsMenuRopaJPanel lblFoto = new clsMenuRopaJPanel(fotos,
							posimagen, productos_BD, posproducto);
					GridBagConstraints gbc_lblFoto = new GridBagConstraints();
					gbc_lblFoto.ipadx = 454;
					gbc_lblFoto.ipady = 580;
					gbc_lblFoto.gridx = x;
					gbc_lblFoto.gridy = y;
					pScrollPane.add(lblFoto, gbc_lblFoto);
					posimagen++;
					posproducto++;
					x = 1;
					y = y + 8;
					parX = false;
					parY = true;

				} else {
					if (parX == true && parY == true) {

						clsMenuRopaJPanel lblFoto = new clsMenuRopaJPanel(
								fotos, posimagen, productos_BD, posproducto);
						GridBagConstraints gbc_lblFoto = new GridBagConstraints();
						gbc_lblFoto.ipadx = 454;
						gbc_lblFoto.ipady = 580;
						gbc_lblFoto.gridx = x;
						gbc_lblFoto.gridy = y;
						pScrollPane.add(lblFoto, gbc_lblFoto);
						posimagen++;
						posproducto++;
						x = 1;
						y = y + 8;
						parX = false;
						parY = false;

					}
				}
			}

		}
	}

	/**
	 * M�todo para elegir--> "Tipo" de ropa
	 * 
	 * @param tse
	 */
	public void jTree1ValueChanged(TreeSelectionEvent tse) {
		String node = tse.getNewLeadSelectionPath().getLastPathComponent()
				.toString();
		if (node.equals("Camisas y blusas")) {

			MeterImagenesCamB(path);
			InsertarJPanel();
			pScrollPane.repaint();
			scrollPane.repaint();

		} else {
			if (node.equals("Jersey")) {
				LOGGER.log(Level.INFO, "Elige bien");
				MeterImagenesJersey(path);
				InsertarJPanel();
				pScrollPane.repaint();
				scrollPane.repaint();

			} else {
				if (node.equals("Chaquetas")) {
					MeterImagenesChaq(path);
					InsertarJPanel();
					pScrollPane.repaint();
					scrollPane.repaint();

				} else {
					if (node.equals("Shorts")) {
						MeterImagenesShorts(path);
						InsertarJPanel();
						pScrollPane.repaint();
						scrollPane.repaint();
					}

					else {
						if (node.equals("Jeans")) {
							LOGGER.log(Level.INFO, "Elige bien");
							MeterImagenesJeans(path);
							InsertarJPanel();
							pScrollPane.repaint();
							scrollPane.repaint();
						} else {
							if (node.equals("Faldas")) {
								MeterImagenesFaldas(path);
								InsertarJPanel();
								pScrollPane.repaint();
								scrollPane.repaint();
							} else {
								if (node.equals("Abrigos")) {
									MeterImagenesAbrigos(path);
									InsertarJPanel();
									pScrollPane.repaint();
									scrollPane.repaint();
								} else {
									if (node.equals("Sudaderas")) {
										MeterImagenesSudaderas(path);
										InsertarJPanel();
										pScrollPane.repaint();
										scrollPane.repaint();
									} else {
										if (node.equals("Pantalones")) {
											MeterImagenesPantalones(path);
											InsertarJPanel();
											pScrollPane.repaint();
											scrollPane.repaint();
										} else {
											if (node.equals("Camisetas")) {
												MeterImagenesCamisetas(path);
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

				}
			}
		}
	}

	/**
	 * M�todo para insertar im�genes de camisetas y blusas en el arraylist
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

	/**
	 * M�todo para insertar im�genes de chaquetas en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesChaq(String path) {
		String filtro1 = "chaq.*.jpg";
		String filtro2 = "chaq.*.png";
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

	/**
	 * M�todo para insertar im�genes de jerseys en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesJersey(String path) {
		String filtro1 = "jer.*.jpg";
		String filtro2 = "jer.*.png";
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

	/**
	 * M�todo para insertar im�genes de jeans en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesJeans(String path) {
		String filtro1 = "jeans.*.jpg";
		String filtro2 = "jeans.*.png";
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

	/**
	 * M�todo para insertar im�genes de faldas en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesFaldas(String path) {
		String filtro1 = "fal.*.jpg";
		String filtro2 = "fal.*.png";
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

	/**
	 * M�todo para insertar im�genes de shorts en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesShorts(String path) {
		String filtro1 = "shorts.*.jpg";
		String filtro2 = "shorts.*.png";
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

	/**
	 * M�todo para insertar im�genes de jerseys en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesAbrigos(String path) {
		String filtro1 = "Abr.*.jpg";
		String filtro2 = "Abr.*.png";
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

	/**
	 * M�todo para insertar im�genes de jerseys en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesSudaderas(String path) {
		String filtro1 = "sud.*.jpg";
		String filtro2 = "sud.*.png";
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

	/**
	 * M�todo para insertar im�genes de pantalones en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesPantalones(String path) {
		String filtro1 = "pan.*.jpg";
		String filtro2 = "pan.*.png";
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

	/**
	 * M�todo para insertar im�genes de camisetas en el arraylist
	 * 
	 * @param path
	 */

	public void MeterImagenesCamisetas(String path) {
		String filtro1 = "camis.*.jpg";
		String filtro2 = "camis.*.png";
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

	public static void BotonVer(int posicionimagen, int posicionproducto) {
		int posimagen = posicionimagen;
		int posproducto = posicionproducto;

		pScrollPane.setVisible(false);
		pScrollPane.removeAll();
		
		clsProducto producto = new clsProducto(productos_BD.get(posproducto).getNombre(), productos_BD.get(posproducto).getPrecio(), productos_BD.get(posproducto).getDescripcion(),productos_BD.get(posproducto).getMarca(), productos_BD.get(posproducto).getCodigo(), productos_BD.get(posproducto).getTienda(), productos_BD.get(posproducto).isSexo(), null); 
		clsVerProducto1 a = new clsVerProducto1(fotos, posimagen, producto);
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.ipadx = 832;
		gbc_lblFoto.ipady = 580;
		gbc_lblFoto.gridx = 2;
		gbc_lblFoto.gridy = 2;

		pScrollPane.add(a, gbc_lblFoto);
		LOGGER.log(Level.INFO, "Llega");
		pScrollPane.repaint();
		scrollPane.repaint();
		pScrollPane.setVisible(true);

	}

	/**
	 * M�todo para anyadir al carrito
	 * 
	 * @param listaF
	 * @param imagen
	 * @param listaA
	 */

//	public static void AnyadirCarrito(ArrayList<Image> listaF, int imagen,
//			ArrayList<clsProducto> listaA) {
//		int posimagen = imagen;
//
//		ArrayList<clsProducto> listaAnyadidos = listaA;
//		System.out.println(listaAnyadidos.size());
//
//		for (int i = 0; i < listaAnyadidos.size(); i++) {
//			pScrollPane.removeAll();
//			clsAnyadirCarrito a = new clsAnyadirCarrito(fotos, posimagen,
//					listaAnyadidos);
//			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
//			gbc_lblFoto.ipadx = 832;
//			gbc_lblFoto.ipady = 580;
//			gbc_lblFoto.gridx = 2;
//			gbc_lblFoto.gridy = 2;
//
//			pScrollPane.add(a, gbc_lblFoto);
//			pScrollPane.repaint();
//			scrollPane.repaint();
//		}
//	}

	private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para
															// no sobreescribir
	static {
		try {
			LOGGER.addHandler(new FileHandler(clsMenuRopa.class.getName()
					+ ".log.xml", ANYADIR_A_FIC_LOG));
		} catch (SecurityException | IOException e) {
			LOGGER.log(Level.SEVERE, "Error en creaci�n fichero log");
		}
	}

}