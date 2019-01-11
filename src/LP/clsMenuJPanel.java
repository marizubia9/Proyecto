package LP;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class clsMenuJPanel extends JPanel {
	private static ArrayList <Image>fotos;  
	int posicionIm;
	private JTextField Descripcion;
	private boolean BotonVer;
	JPanel pScrollPane;
	JScrollPane scrollPane;
	private final static Logger LOGGER = Logger.getLogger("LP.clsMenuJPanel");
	/**
	 * Create the panel.
	 */
	public clsMenuJPanel(ArrayList <Image> listaF, int imagen) {

		posicionIm=imagen;
		fotos= listaF;
		CrearVentana(posicionIm);
	}
	
	public void CrearVentana(int posIm)
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
		
//		btnVer.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				 
//				clsMenuRopa.BotonVer(posicionIm,posicionProd);
//				LOGGER.log(Level.INFO, "Sale del boton ver");
//				
//			}
//			});
		//insertar descripción
		Descripcion = new JTextField();
		Descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		Descripcion.setText("Camiseta con mangas largas");
		Descripcion.setBounds(44, 547, 179, 20);
		add(Descripcion);
		Descripcion.setColumns(10);
	}

}
