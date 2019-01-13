package LP;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import LN.clsProducto;

public class clsMenuRopaJPanel extends JPanel {
	private static ArrayList <Image>fotos;  
	private static ArrayList<clsProducto>productos;
	int posicionIm;
	int posicionProd;
	private JTextField Descripcion;
	private boolean BotonVer;
	JPanel pScrollPane;
	JScrollPane scrollPane;
	private final static Logger LOGGER = Logger.getLogger("LP.clsMenuRopaJPanel");
	/**
	 * Create the panel.
	 */ 
	public clsMenuRopaJPanel(ArrayList <Image> listaF, int imagen, ArrayList <clsProducto> listaP, int producto) 
	{
		fotos= listaF;
		productos = listaP;
		posicionIm=imagen;
		posicionProd = producto;
		CrearVentana(posicionIm, posicionProd);

	}
	public void CrearVentana(int posIm, int posProd)
	{
		setBackground(Color.WHITE);
		setLayout(null);
		JLabel lblFoto = new JLabel();
		lblFoto.setForeground(Color.WHITE);
		lblFoto.setBackground(Color.WHITE);
		
		lblFoto.setIcon(new ImageIcon(fotos.get(posicionIm)));
		lblFoto.setBounds(34, 27, 353, 508);
		add(lblFoto);
		
		JButton btnVer = new JButton("VER");
		btnVer.setForeground(Color.WHITE);
		btnVer.setBackground(Color.GRAY);
		btnVer.setBounds(272, 546, 107, 23);
		add(btnVer);
		
		btnVer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				 
				clsMenu.BotonVer(productos.get(posicionProd));
				LOGGER.log(Level.INFO, "Sale del boton ver");
				
			}
			});
		//insertar descripci�n
		Descripcion = new JTextField();
		Descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		Descripcion.setText(productos.get(posicionProd).getDescripcion());
		Descripcion.setBounds(44, 547, 179, 20);
		add(Descripcion);
		Descripcion.setColumns(10);

	
	}
	
	private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para no sobreescribir
	static {
		try {
			LOGGER.addHandler( new FileHandler(
		clsMenuRopaJPanel.class.getName()+".log.xml", ANYADIR_A_FIC_LOG ));
		} catch (SecurityException | IOException e) {
			LOGGER.log( Level.SEVERE, "Error en creaci�n fichero log" );
		}
		}
	
}
