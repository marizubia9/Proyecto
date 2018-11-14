package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class clsAnyadirCarrito extends JFrame
{
	public static void main (String [] args)
	{
		clsAnyadirCarrito frame= new clsAnyadirCarrito();
		frame.setVisible(true);
	}
	public clsAnyadirCarrito()
	{
		setVisible(true);
		//Panel generala
		getContentPane().setForeground(Color.DARK_GRAY);
		setSize( 800, 600 );
		getContentPane().setLayout(null);
		setTitle("DOALZU");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\workspace\\Proyecto\\src\\img\\DLZ.png"));
		setDefaultCloseOperation( JInternalFrame.DISPOSE_ON_CLOSE );
		setBackground(Color.WHITE);
		
		//Goiko zatia
		JPanel goikozatia = new JPanel();
		goikozatia.setBackground(Color.DARK_GRAY);
		goikozatia.setBounds(0, 0, 1400, 100);
		getContentPane().add(goikozatia);
		goikozatia.setLayout(null);
		
		JLabel lblDOA = new JLabel("D O A L Z U");
		lblDOA.setForeground(Color.WHITE);
		lblDOA.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDOA.setBounds(34, 29, 124, 24);
		goikozatia.add(lblDOA);
		
		JPanel behekozatia = new JPanel();
		behekozatia.setBackground(Color.WHITE);
		behekozatia.setBounds(0, 100, 1400, 14000);
		getContentPane().add(behekozatia);
		behekozatia.setLayout(null);
		
		JLabel lblCarrito = new JLabel("CARRITO DE LA COMPRA");
		lblCarrito.setFont(new Font ("Times New Roman", Font.BOLD, 16));
		lblCarrito.setBounds(200, 50, 660, 140);
		behekozatia.add(lblCarrito);
		
		JLabel lblProduccion = new JLabel("PRODUCTO");
		lblProduccion.setFont(new Font ("Times New Roman", Font.PLAIN, 12));
		lblProduccion.setBounds(200, 100, 660, 140);
		behekozatia.add(lblProduccion);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setFont(new Font ("Times New Roman", Font.PLAIN, 12));
		lblDescripcion.setBounds(375, 100, 660, 140);
		behekozatia.add(lblDescripcion);
		
		JLabel lblColor = new JLabel("COLOR");
		lblColor.setFont(new Font ("Times New Roman", Font.PLAIN, 12));
		lblColor.setBounds(550, 100, 660, 140);
		behekozatia.add(lblColor);
		
		JLabel lblTalla = new JLabel("TALLA");
		lblTalla.setFont(new Font ("Times New Roman", Font.PLAIN, 12));
		lblTalla.setBounds(725, 100, 660, 140);
		behekozatia.add(lblTalla);
		
		JLabel lblUnidades = new JLabel("UNIDADES");
		lblUnidades.setFont(new Font ("Times New Roman", Font.PLAIN, 12));
		lblUnidades.setBounds(900, 100, 660, 140);
		behekozatia.add(lblUnidades);

		JLabel lblImporte = new JLabel("IMPORTE");
		lblImporte.setFont(new Font ("Times New Roman", Font.PLAIN, 12));
		lblImporte.setBounds(1075, 100, 660, 140);
		behekozatia.add(lblImporte);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setFont(new Font ("Times New Roman", Font.PLAIN, 12));
		lblEliminar.setBounds(1250, 100, 660, 140);
		behekozatia.add(lblEliminar);
			
	}
}
