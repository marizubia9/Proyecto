package LP;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LN.clsProducto;
import LN.clsRopa;

public class clsMenuTiendaJPanel extends JPanel {
	private static ArrayList <Image>fotos;  
	private ImageIcon icon;
	private JTextField Descripcion;
	private boolean BotonVer;
	private clsProducto producto;
	JLabel lblFoto;
	Icon icono;
	int multiplicador;
	File imagen;
	int anchura;
	public boolean cambiarpanel=false;
	JPanel pScrollPane;
	JScrollPane scrollPane;
	private final static Logger LOGGER = Logger.getLogger("LP.clsMenuJPanel");
	private JButton btnEditar;
	/**
	 * Create the panel.
	 */
	public clsMenuTiendaJPanel(clsProducto producto) {
		
		this.producto=producto;
		lblFoto = new JLabel();
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenu.class.getResource("/img/" + producto.getImg())));
		imagen=new File(System.getProperty("user.dir")+"\\src\\img\\" + producto.getImg());
		icon = new ImageIcon (imagen.toString());
		CrearVentana();

	}
	
	public void CrearVentana()
	{
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblFoto.setForeground(Color.WHITE);
		lblFoto.setBackground(Color.WHITE);
		
		
		lblFoto.setBounds(34, 27, 353, 508);
		add(lblFoto);
		
		
		multiplicador= icon.getIconHeight()/icon.getIconWidth();
		anchura= lblFoto.getHeight()/multiplicador;
		icono = new ImageIcon (icon.getImage().getScaledInstance(anchura, lblFoto.getHeight(), Image.SCALE_SMOOTH));
		lblFoto.setIcon(icono);
		
		JButton btnVer = new JButton("VER");
		btnVer.setForeground(Color.WHITE);
		btnVer.setBackground(Color.GRAY);
		btnVer.setBounds(301, 546, 86, 23);
		add(btnVer);
		
		btnVer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				 
				clsMenuTienda_02.BotonVer(producto);
				LOGGER.log(Level.INFO, "Sale del boton ver");
				
			}
			});
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(Color.GRAY);
		btnEditar.setBounds(211, 546, 80, 23);
		add(btnEditar);
		btnEditar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				 
				clsMenuTienda_02.btnEditar(producto);
				LOGGER.log(Level.INFO, "Sale del boton ver");
				
			}
			});
		//insertar descripción
		Descripcion = new JTextField();
		Descripcion.setEditable(false);
		Descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		Descripcion.setText(producto.getNombre());
		Descripcion.setBounds(34, 547, 173, 20);
		add(Descripcion);
		Descripcion.setColumns(10);

	}
}
