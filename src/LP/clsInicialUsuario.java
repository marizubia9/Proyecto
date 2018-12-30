package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import LP.clsPanelFondo;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class clsInicialUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsInicialUsuario frame = new clsInicialUsuario();
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
	public clsInicialUsuario() {
		
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsInicialUsuario.class.getResource("/img/DLZ.png")));
		setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		

		
//		clsPanelFondo pPrincipal=new clsPanelFondo();
//		splitPane.setRightComponent(pPrincipal);
		
		
	}
}