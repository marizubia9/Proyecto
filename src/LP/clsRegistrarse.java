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
import com.toedter.calendar.JDateChooser;



public class clsRegistrarse extends JFrame 
{
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblDoalzu;
	private JLabel lblEscribeTusDatos;
	private JTextField txtEmail; 
	private JTextField txtContraseña;
	private JTextField txtRepetirContraseña;
	private JTextField txtNombre=null;
	private JTextField txtApellidos;
	private JTextField txtNIF;
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
	
	public clsRegistrarse()
	{
		
		
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
		txtEmail = new JTextField("Email");
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
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
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
		
		FocusListener fl= new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(e.getSource()==txtEmail)  txtEmail.setText("");
				if(e.getSource()==txtNombre)  txtNombre.setText("");
				if(e.getSource()==txtContraseña)  txtContraseña.setText("");
				if(e.getSource()==txtLocalidad)  txtLocalidad.setText("");
				if(e.getSource()==txtRepetirContraseña)  txtRepetirContraseña.setText("");
				if(e.getSource()==txtApellidos)  txtApellidos.setText("");
			
					
			}
			@Override
			public void focusLost (FocusEvent e)
			{
				if(e.getSource()==txtEmail && txtEmail.getText().isEmpty()) txtEmail.setText("Email");
				if(e.getSource()==txtNombre && txtNombre.getText().isEmpty())  txtNombre.setText("Nombre");
				if(e.getSource()==txtContraseña && txtContraseña.getText().isEmpty())  txtContraseña.setText("Contraseña");
				if(e.getSource()==txtLocalidad && txtLocalidad.getText().isEmpty())  txtLocalidad.setText("Localidad");
				if(e.getSource()==txtRepetirContraseña && txtRepetirContraseña.getText().isEmpty())  txtRepetirContraseña.setText("Contraseña");
				if(e.getSource()==txtApellidos && txtApellidos.getText().isEmpty())  txtApellidos.setText("Apellidos");
			}
			
			
		};
		
				
		txtEmail.addFocusListener(fl);
		txtNombre.addFocusListener(fl);
		txtContraseña.addFocusListener(fl);
		txtLocalidad.addFocusListener(fl);
		txtRepetirContraseña.addFocusListener(fl);
		txtApellidos.addFocusListener(fl);
		
//		if(txtEmail.getText()==null && (!txtEmail.isFocusOwner())) txtEmail.setText("Email");
		
		
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
			
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
			lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFechaDeNacimiento.setBounds(143, 288, 140, 14);
			contentPane.add(lblFechaDeNacimiento);
			
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(141, 313, 95, 20);
			contentPane.add(dateChooser);
//			
		
			
			
			
			
			
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
			txtNIF = new JTextField("CIF");
			txtNIF.setForeground(Color.LIGHT_GRAY);
			txtNIF.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNIF.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtNIF.setBackground(Color.WHITE);
			txtNIF.setBounds(313, 242, 140, 23);
			contentPane.add(txtNIF);
			
			//Escribir IBAN
			txtIban = new JTextField("IBAN");
			txtIban.setForeground(Color.LIGHT_GRAY);
			txtIban.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtIban.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtIban.setBackground(Color.WHITE);
			txtIban.setBounds(143, 298, 140, 23);
			contentPane.add(txtIban);
	      
			contentPane.repaint();
			
		
		
		FocusListener fl2= new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(e.getSource()==txtIban)  txtIban.setText("");
				if(e.getSource()==txtNIF)  txtNIF.setText("");
					
			}
		};
				
		txtIban.addFocusListener(fl2);
		txtNIF.addFocusListener(fl2);
	}
	}
}
	

	
	
	
	
	

