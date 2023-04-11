package Visual;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lógico.Empleado;
import lógico.Persona;
import lógico.TiendaComp;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usuariotxt;
	private JLabel lblContrasea;
	private JButton crearCuentabtn;
	private JPasswordField contrasenatxt;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				FileInputStream tienda;
				FileOutputStream tienda2;
				ObjectInputStream tiendaRead;
				ObjectOutputStream tiendaWrite;
				try {
					tienda = new FileInputStream("tienda.dat");
					tiendaRead = new ObjectInputStream(tienda);
					TiendaComp temp = (TiendaComp) tiendaRead.readObject();
					TiendaComp.setTienda(temp);
					tienda.close();
					tiendaRead.close();
					
				}catch (FileNotFoundException e) {
					try {
					tienda2 = new FileOutputStream("tienda.dat");
					tiendaWrite = new ObjectOutputStream(tienda2);
					Persona aux = new Empleado(null,null,null,null,true, "admin","admin","Administrador");
					TiendaComp.getInstance().InsertarPersona(aux);
					tiendaWrite.writeObject(TiendaComp.getInstance());
					tienda2.close(); 
					tiendaWrite.close();
						
					}catch (FileNotFoundException e1) {
					}catch (IOException e1) {
						
					}
				}catch (IOException e) {
					
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(new Color(135, 206, 235));
		setTitle("Iniciar Sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 367);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel.setBounds(92, 35, 61, 16);
		panel.add(lblNewLabel);
		
		usuariotxt = new JTextField();
		usuariotxt.setBounds(92, 63, 225, 32);
		panel.add(usuariotxt);
		usuariotxt.setColumns(10);
		
		lblContrasea = new JLabel("Contraseña: ");
		lblContrasea.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblContrasea.setBounds(92, 107, 106, 16);
		panel.add(lblContrasea);
		
		JButton iniciarSesionBnt = new JButton("Iniciar Sesión");
		iniciarSesionBnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TiendaComp.getInstance().confirmLogin(usuariotxt.getText(), contrasenatxt.getPassword())) {
					//confirma si el usuario existe, luego cuando se logea se entra a la pantalla principal
					Principal jframe = new Principal();
					dispose();
					jframe.setVisible(true);
			
				}
			}
		});
		iniciarSesionBnt.setBackground(new Color(255, 255, 255));
		iniciarSesionBnt.setBounds(144, 179, 117, 29);
		panel.add(iniciarSesionBnt);
		
		JLabel lblNewLabel_1 = new JLabel("No tiene una cuenta?");
		lblNewLabel_1.setBackground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(136, 258, 144, 16);
		panel.add(lblNewLabel_1);
		
		crearCuentabtn = new JButton("Crear Cuenta");
		crearCuentabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersona persona = new RegistrarPersona();
				persona.setModal(true);
				persona.setVisible(true);
			}
		});
		crearCuentabtn.setBounds(144, 275, 117, 29);
		panel.add(crearCuentabtn);
		
		contrasenatxt = new JPasswordField();
		contrasenatxt.setBounds(92, 135, 225, 32);
		panel.add(contrasenatxt);
	}
}
