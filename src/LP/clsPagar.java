package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import LN.clsGestor;

/**
 * Clase para pagar
 * @author ALUMNO
 *
 */
public class clsPagar extends JFrame {

	private JPanel contentPane;
	private JTextField textNumero;
	private JTextField textTitular;
	private JTextField textValidez;
	private JTextField txtCVC;
	private static double total1;
	private clsGestor gestor;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					clsPagar frame = new clsPagar(total1);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Create the frame.
	 * @param total 
	 * @param gestor 
	 */
	public clsPagar(double total, clsGestor gestor) 
	{
		this.gestor= gestor;
		total1= total;
		setTitle("DOALZU");
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsMenu.class.getResource("/img/DLZ.png")));
	

		
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDoalzu = new JLabel("D O A L Z U");
		lblDoalzu.setForeground(Color.BLACK);
		lblDoalzu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblDoalzu = new GridBagConstraints();
		gbc_lblDoalzu.ipadx = 20;
		gbc_lblDoalzu.insets = new Insets(30, 20, 5, 5);
		gbc_lblDoalzu.gridx = 1;
		gbc_lblDoalzu.gridy = 1;
		panel.add(lblDoalzu, gbc_lblDoalzu);
		
		
		JLabel lblVisa_1 = new JLabel();
		GridBagConstraints gbc_lblVisa_1 = new GridBagConstraints();
		gbc_lblVisa_1.insets = new Insets(50, 0, 5, 5);
		gbc_lblVisa_1.gridx = 2;
		gbc_lblVisa_1.gridy = 4;
		panel.add(lblVisa_1, gbc_lblVisa_1);
		lblVisa_1.setIcon(new ImageIcon(clsPagar.class.getResource("/img/Visa1.png")));
		
		
		JLabel lblEstosCamposSon = new JLabel("Estos campos son obligatorios (*)");
		lblEstosCamposSon.setForeground(SystemColor.scrollbar);
		GridBagConstraints gbc_lblEstosCamposSon = new GridBagConstraints();
		gbc_lblEstosCamposSon.anchor = GridBagConstraints.EAST;
		gbc_lblEstosCamposSon.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstosCamposSon.gridx = 3;
		gbc_lblEstosCamposSon.gridy = 6;
		panel.add(lblEstosCamposSon, gbc_lblEstosCamposSon);
		//lblVisa.setIcon(new ImageIcon(clsPagar.class.getResource("/img/Visa.png")));
		
		JLabel lblNumero = new JLabel("N\u00FAmero *");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumero.anchor = GridBagConstraints.EAST;
		gbc_lblNumero.gridx = 2;
		gbc_lblNumero.gridy = 7;
		panel.add(lblNumero, gbc_lblNumero);
		
		textNumero = new JTextField();
		GridBagConstraints gbc_textNumero = new GridBagConstraints();
		gbc_textNumero.ipadx = 90;
		gbc_textNumero.insets = new Insets(0, 0, 5, 5);
		gbc_textNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumero.gridx = 3;
		gbc_textNumero.gridy = 7;
		panel.add(textNumero, gbc_textNumero);
		textNumero.setColumns(20);
		
		JLabel lblTitular = new JLabel("Titular *");
		lblTitular.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTitular = new GridBagConstraints();
		gbc_lblTitular.anchor = GridBagConstraints.EAST;
		gbc_lblTitular.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitular.gridx = 2;
		gbc_lblTitular.gridy = 9;
		panel.add(lblTitular, gbc_lblTitular);
		
		textTitular = new JTextField();
		textTitular.setColumns(20);
		GridBagConstraints gbc_textTitular = new GridBagConstraints();
		gbc_textTitular.insets = new Insets(0, 0, 5, 5);
		gbc_textTitular.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTitular.gridx = 3;
		gbc_textTitular.gridy = 9;
		panel.add(textTitular, gbc_textTitular);
		
		JLabel lblValidez = new JLabel("Validez *");
		lblValidez.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblValidez = new GridBagConstraints();
		gbc_lblValidez.anchor = GridBagConstraints.EAST;
		gbc_lblValidez.insets = new Insets(0, 0, 5, 5);
		gbc_lblValidez.gridx = 2;
		gbc_lblValidez.gridy = 11;
		panel.add(lblValidez, gbc_lblValidez);
		
		textValidez = new JTextField();
		textValidez.setColumns(20);
		GridBagConstraints gbc_textValidez = new GridBagConstraints();
		gbc_textValidez.insets = new Insets(0, 0, 5, 5);
		gbc_textValidez.fill = GridBagConstraints.HORIZONTAL;
		gbc_textValidez.gridx = 3;
		gbc_textValidez.gridy = 11;
		panel.add(textValidez, gbc_textValidez);
		
		JLabel lblCvc = new JLabel("CVC *");
		lblCvc.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCvc = new GridBagConstraints();
		gbc_lblCvc.anchor = GridBagConstraints.EAST;
		gbc_lblCvc.insets = new Insets(0, 0, 5, 5);
		gbc_lblCvc.gridx = 2;
		gbc_lblCvc.gridy = 13;
		panel.add(lblCvc, gbc_lblCvc);
		
		txtCVC = new JTextField();
		txtCVC.setColumns(20);
		GridBagConstraints gbc_txtCVC = new GridBagConstraints();
		gbc_txtCVC.insets = new Insets(0, 0, 5, 5);
		gbc_txtCVC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCVC.gridx = 3;
		gbc_txtCVC.gridy = 13;
		panel.add(txtCVC, gbc_txtCVC);
		
		JLabel lblPrecio1 = new JLabel("Precio:");
		lblPrecio1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPrecio1 = new GridBagConstraints();
		gbc_lblPrecio1.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio1.gridx = 3;
		gbc_lblPrecio1.gridy = 14;
		panel.add(lblPrecio1, gbc_lblPrecio1);
		
		JLabel label = new JLabel("30,9");
		label.setText(String.valueOf(total));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 14;
		panel.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 14;
		panel.add(label_1, gbc_label_1);
		
		JButton btnComprar = new JButton("Pagar");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnComprar.setForeground(Color.WHITE);
		btnComprar.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnComprar = new GridBagConstraints();
		gbc_btnComprar.insets = new Insets(0, 0, 0, 5);
		gbc_btnComprar.gridx = 4;
		gbc_btnComprar.gridy = 15;
		panel.add(btnComprar, gbc_btnComprar);
		
		btnComprar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            	if(textNumero.getText().equals("") || textTitular.getText().equals("") || textValidez.getText().equals("")|| txtCVC.getText().equals("") )
            	{
            		JOptionPane.showMessageDialog(null,"Por favor, rellene todos los campos.");
            	}
            	else
            	{
            		//Enviar correo 
					clsEnviarEmail email=new clsEnviarEmail(gestor.getUsuario().getCorreo(),"Pagar");
            		gestor.AnyadirCompra();
            		clsAnyadirCarrito.Cerrar();
            		setVisible(false);
            	}
            }

        });
		
	}
	
	
	

}
