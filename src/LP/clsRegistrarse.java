package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;



public class clsRegistrarse extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblDoalzu;
	private JLabel lblEscribeTusDatos;
	private JTextField txtContraseña;
	private JTextField txtRepetirContraseña;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtCIF;
	private JTextField txtLocalidad;
	private JComboBox comboBoxDias;
	private JComboBox comboBoxmeses;
	private JComboBox comboBoxyear;
	private JTextField lblFechaNacimiento;
	private JTextField txtIban;
	private JLabel lblContacto;
	private JLabel lblNumero;
	private boolean radiobutton;
	JLabel label_1;
	JLabel label; 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					clsRegistrarse frame = new clsRegistrarse();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public clsRegistrarse() {
		
		
		//Ventana
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 426);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Contacto
		lblContacto = new JLabel();
		lblContacto.setText("Contacto");
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblContacto.setBorder(null);
		lblContacto.setBackground(Color.WHITE);
		lblContacto.setBounds(499, 0, 208, 36);
		contentPane.add(lblContacto);
		
		lblNumero = new JLabel();
		lblNumero.setForeground(Color.GRAY);
		lblNumero.setText("943227684");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 8));
		lblNumero.setBorder(null);
		lblNumero.setBackground(Color.WHITE);
		lblNumero.setBounds(549, 8, 69, 23);
		contentPane.add(lblNumero);
		
		//DOALZU
		lblDoalzu = new JLabel();
		lblDoalzu.setBackground(Color.WHITE);
		lblDoalzu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDoalzu.setForeground(Color.BLACK);
		lblDoalzu.setText("D O A L Z U");
		lblDoalzu.setBounds(24, 11, 110, 36);
		lblDoalzu.setBorder(null);
	
		contentPane.add(lblDoalzu);
		
		//Escribir tus datos personales
		lblEscribeTusDatos = new JLabel();
		lblEscribeTusDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEscribeTusDatos.setBackground(Color.WHITE);
		lblEscribeTusDatos.setText("Escribe tus datos personales");
		lblEscribeTusDatos.setBounds(190, 35, 208, 36);
		lblEscribeTusDatos.setBorder(null);
		contentPane.add(lblEscribeTusDatos);
		
		//Escribir email
		JTextField txtEmail = new JTextField("Email");
		txtEmail.setForeground(Color.LIGHT_GRAY);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(143, 144, 140, 23);
		txtEmail.setBorder( new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(txtEmail);	

		//Escribir Contraseña
		txtContraseña = new JTextField("Contrase\u00F1a");
		txtContraseña.setForeground(Color.LIGHT_GRAY);
		txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContraseña.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtContraseña.setBackground(Color.WHITE);
		txtContraseña.setBounds(143, 192, 140, 23);
		contentPane.add(txtContraseña);
		
		//Repetir Contraseña
		txtRepetirContraseña = new JTextField("Repetir Contrase\u00F1a");
		txtRepetirContraseña.setForeground(Color.LIGHT_GRAY);
		txtRepetirContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRepetirContraseña.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRepetirContraseña.setBackground(Color.WHITE);
		txtRepetirContraseña.setBounds(313, 192, 140, 23);
		contentPane.add(txtRepetirContraseña);
		
		//Escribir nombre
		txtNombre = new JTextField("Nombre");
		txtNombre.setForeground(Color.LIGHT_GRAY);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(143, 242, 140, 23);
		contentPane.add(txtNombre);
		
		
		//Escribir localidad
		txtLocalidad = new JTextField("Localidad");
		txtLocalidad.setForeground(Color.LIGHT_GRAY);
		txtLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLocalidad.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtLocalidad.setBackground(Color.WHITE);
		txtLocalidad.setBounds(313, 298, 140, 23);
		contentPane.add(txtLocalidad);
		
		//Boton registrar
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setBounds(467, 347, 110, 30);
		contentPane.add(btnRegistrar);		
		
		//Radio button particular
		JRadioButton rdbtnParticular = new JRadioButton("Particular");
		rdbtnParticular.setSelected(true);
		rdbtnParticular.setBackground(Color.WHITE);
		rdbtnParticular.setBounds(200, 78, 83, 23);
		contentPane.add(rdbtnParticular);
		
		//Radio button empresa
		JRadioButton rdbtnEmpresa = new JRadioButton("Empresa");
		rdbtnEmpresa.setBackground(Color.WHITE);
		rdbtnEmpresa.setBounds(296, 78, 83, 23);
		contentPane.add(rdbtnEmpresa);
		
		//Crear grupo radio button
		ButtonGroup GrupoParticularEmpresa=new ButtonGroup();
		GrupoParticularEmpresa.add(rdbtnParticular);	
		GrupoParticularEmpresa.add(rdbtnEmpresa);
	
		radiobutton=true;
		CambioRadioButton();
		
		rdbtnParticular.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	
	        	radiobutton=true;
	        	CambioRadioButton();
	    	
	        }
	    });
		
		rdbtnEmpresa.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	          
	        	radiobutton=false;
	        	CambioRadioButton();
	        }
	    });
		
	}
	
	
	//Metodo para actualizar panel Particular/Empresa
	public void CambioRadioButton()
	{
		if (radiobutton==true)
		{
			
			//Escribir apellidos
			txtApellidos = new JTextField("Apellidos");
			txtApellidos.setForeground(Color.LIGHT_GRAY);
			txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtApellidos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtApellidos.setBackground(Color.WHITE);
			txtApellidos.setBounds(313, 242, 140, 23);
			contentPane.add(txtApellidos);
	      
	    	
			//Fecha de nacimiento
			comboBoxDias = new JComboBox();
			comboBoxDias.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			comboBoxDias.setSize(37, 20);
			comboBoxDias.setMaximumSize(new Dimension(225, 25));
			comboBoxDias.setLocation(128, 337);
			this.getContentPane().add(comboBoxDias);
			
			label = new JLabel("/");
			label.setBounds(170, 336, 11, 23);
			contentPane.add(label);
			
			comboBoxmeses = new JComboBox();
			comboBoxmeses.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			comboBoxmeses.setBounds(190, 337, 37, 20);
			contentPane.add(comboBoxmeses);
			
			label_1 = new JLabel("/");
			label_1.setBounds(232, 335, 11, 24);
			contentPane.add(label_1);
			
			comboBoxyear = new JComboBox();
			comboBoxyear.setModel(new DefaultComboBoxModel(new String[] { "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
			comboBoxyear.setBounds(253, 337, 58, 20);
			contentPane.add(comboBoxyear);
//			
			lblFechaNacimiento = new JTextField("Fecha de nacimiento");
			lblFechaNacimiento.setEditable(false);
			lblFechaNacimiento.setForeground(Color.LIGHT_GRAY);
			lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFechaNacimiento.setBorder(null);
			lblFechaNacimiento.setBackground(Color.WHITE);
			lblFechaNacimiento.setBounds(143, 298, 140, 23);
			contentPane.add(lblFechaNacimiento);
			
			contentPane.repaint();
		}
		
		
		if (radiobutton==false)
		{
			//Borrar objetos de Particular
			contentPane.remove(comboBoxyear);
			contentPane.remove(comboBoxmeses);
			contentPane.remove(comboBoxDias);
			contentPane.remove(label_1);
			contentPane.remove(label);
			contentPane.remove(txtApellidos);
			contentPane.remove(lblFechaNacimiento);
	    	//Escribir apellidos
	    	txtCIF = new JTextField("CIF");
			txtCIF.setForeground(Color.LIGHT_GRAY);
			txtCIF.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCIF.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtCIF.setBackground(Color.WHITE);
			txtCIF.setBounds(313, 242, 140, 23);
			contentPane.add(txtCIF);
			
			//Escribir IBAN
			txtIban = new JTextField("IBAN");
			txtIban.setForeground(Color.LIGHT_GRAY);
			txtIban.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtIban.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtIban.setBackground(Color.WHITE);
			txtIban.setBounds(143, 298, 140, 23);
			contentPane.add(txtIban);
	      
			contentPane.repaint();
			
		}
	}
	

	
	FocusListener fl = new FocusAdapter()
	{

		@Override
		public void focusGained(FocusEvent e) 
		{
			if(e.getSource()==txtNombre)
				{
					txtNombre.setText("");
					System.out.println("el foco está en el nombre");
				}
		}
	}; 
	txtNombre.addFocusListener( fl );
	
	
	
	
	
}
