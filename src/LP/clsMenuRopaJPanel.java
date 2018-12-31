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
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class clsMenuRopaJPanel extends JPanel {
	private ArrayList <Image>fotos;  
	int posicionIm;
	private JTextField Descripcion;
	/**
	 * Create the panel.
	 */ //BESTE METODO BATEN IN
	public clsMenuRopaJPanel(ArrayList <Image> listaF, int imagen) {
		fotos= listaF;
		posicionIm=imagen;
		CrearVentana(posicionIm);

	}
	public void CrearVentana(int posIm)
	{
		setBackground(Color.WHITE);
		setLayout(null);
		JLabel lblFoto = new JLabel();
		lblFoto.setForeground(Color.WHITE);
		lblFoto.setBackground(Color.WHITE);
		System.out.println(fotos.size());
		lblFoto.setIcon(new ImageIcon(fotos.get(posicionIm)));
		lblFoto.setBounds(34, 27, 353, 508);
		add(lblFoto);
		
		JButton btnVer = new JButton("VER");
		btnVer.setForeground(Color.WHITE);
		btnVer.setBackground(Color.GRAY);
		btnVer.setBounds(272, 546, 107, 23);
		add(btnVer);
		
		//insertar descripción
		Descripcion = new JTextField();
		Descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		Descripcion.setText("CAMISETA");
		Descripcion.setBounds(44, 547, 179, 20);
		add(Descripcion);
		Descripcion.setColumns(10);

	}
	
	
}
