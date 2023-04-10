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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblContrasea;
	private JTextField textField_1;
	private JButton btnNewButton;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				FileInputStream tiendaFileInputStream;
				FileOutputStream tiendaFileOutputStream;
				ObjectInputStream tiendaLeerObjectInputStream;
				ObjectOutputStream tiendaescribirOutputStream;
				try {
					tiendaFileInputStream = new FileInputStream("tiendaFileInputStream.dat");
					tiendaLeerObjectInputStream = new ObjectInputStream(tiendaFileInputStream);
					TiendaComp temp = (TiendaComp) tiendaLeerObjectInputStream.readObject();
					TiendaComp.setTienda(temp);
					tiendaFileInputStream.close();
					tiendaLeerObjectInputStream.close();
					
				}catch (FileNotFoundException e) {
					try {
					tiendaFileOutputStream = new FileOutputStream("empresa.dat");
					tiendaescribirOutputStream = new ObjectOutputStream(tiendaFileOutputStream);
					Persona aux = new Empleado(null,null,null,null,true, "Admin0","admin","Administrador");
					TiendaComp.getInstance().InsertarPersona(aux);
					tiendaescribirOutputStream.writeObject(TiendaComp.getInstance());
					tiendaFileOutputStream.close(); 
					tiendaescribirOutputStream.close();
						
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
		
		textField = new JTextField();
		textField.setBounds(92, 63, 225, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		lblContrasea = new JLabel("Contraseña: ");
		lblContrasea.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblContrasea.setBounds(92, 107, 106, 16);
		panel.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(92, 135, 225, 32);
		panel.add(textField_1);
		
		JButton iniciarSesionBnt = new JButton("Iniciar Sesión");
		iniciarSesionBnt.setBackground(new Color(255, 255, 255));
		iniciarSesionBnt.setBounds(144, 179, 117, 29);
		panel.add(iniciarSesionBnt);
		
		JLabel lblNewLabel_1 = new JLabel("No tiene una cuenta?");
		lblNewLabel_1.setBackground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(136, 258, 144, 16);
		panel.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Crear Cuenta");
		btnNewButton.setBounds(144, 275, 117, 29);
		panel.add(btnNewButton);
	}
}
