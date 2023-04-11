package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegistrarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField cedulatxt;
	private JTextField nombretxt;
	private JTextField telefonotxt;
	private JTextField direcciontxt;
	private JTextField usuariotxt;
	private JTextField ocupaciontxt;
	private JTextField cargotxt;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPersona dialog = new RegistrarPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPersona() {
		setTitle("Crear Cuenta");
		setBounds(100, 100, 547, 401);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setBackground(new Color(173, 216, 230));
		setForeground(new Color(173, 216, 230));;
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 6, 535, 57);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tipo de Cuenta: ");
		lblNewLabel.setBounds(6, 18, 103, 16);
		panel.add(lblNewLabel);

		JComboBox tipoCuentaCBX = new JComboBox();

		tipoCuentaCBX.setModel(new DefaultComboBoxModel(new String[] {" <<Seleccionar>>", "Cliente", "Empleado"}));
		tipoCuentaCBX.setBounds(108, 14, 167, 27);
		panel.add(tipoCuentaCBX);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n General:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 62, 535, 185);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cédula: ");
		lblNewLabel_1.setBounds(320, 25, 51, 16);
		panel_1.add(lblNewLabel_1);

		cedulatxt = new JTextField();
		cedulatxt.setBounds(370, 20, 159, 26);
		panel_1.add(cedulatxt);
		cedulatxt.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre: ");
		lblNewLabel_2.setBounds(6, 25, 61, 16);
		panel_1.add(lblNewLabel_2);

		nombretxt = new JTextField();
		nombretxt.setBounds(62, 20, 249, 26);
		panel_1.add(nombretxt);
		nombretxt.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Teléfono: ");
		lblNewLabel_3.setBounds(6, 53, 77, 16);
		panel_1.add(lblNewLabel_3);

		telefonotxt = new JTextField();
		telefonotxt.setBounds(72, 48, 159, 26);
		panel_1.add(telefonotxt);
		telefonotxt.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Contreseña: ");
		lblNewLabel_4.setBounds(6, 82, 89, 16);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Dirección: ");
		lblNewLabel_5.setBounds(6, 110, 77, 16);
		panel_1.add(lblNewLabel_5);

		direcciontxt = new JTextField();
		direcciontxt.setBackground(new Color(245, 245, 245));
		direcciontxt.setBounds(6, 127, 523, 52);
		panel_1.add(direcciontxt);
		direcciontxt.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Nombre de Usuario:");
		lblNewLabel_6.setBounds(243, 53, 128, 16);
		panel_1.add(lblNewLabel_6);

		usuariotxt = new JTextField();
		usuariotxt.setBounds(370, 48, 159, 26);
		panel_1.add(usuariotxt);
		usuariotxt.setColumns(10);
		
				JPanel panelCliente = new JPanel();
				panelCliente.setBackground(new Color(255, 255, 255));
				panelCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelCliente.setBounds(6, 248, 535, 76);
				contentPanel.add(panelCliente);
				panelCliente.setLayout(null);
				
						JLabel lblNewLabel_7 = new JLabel("Ocupación: ");
						lblNewLabel_7.setBounds(6, 28, 85, 16);
						panelCliente.add(lblNewLabel_7);
						
								ocupaciontxt = new JTextField();
								ocupaciontxt.setBounds(82, 23, 190, 26);
								panelCliente.add(ocupaciontxt);
								ocupaciontxt.setColumns(10);
								
								panelCliente.setVisible(false);

		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBackground(new Color(255, 255, 255));
		panelEmpleado.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpleado.setBounds(6, 248, 535, 76);
		contentPanel.add(panelEmpleado);
		panelEmpleado.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Cargo: ");
		lblNewLabel_8.setBounds(6, 28, 61, 16);
		panelEmpleado.add(lblNewLabel_8);

		cargotxt = new JTextField();
		cargotxt.setColumns(10);
		cargotxt.setBounds(55, 23, 207, 26);
		panelEmpleado.add(cargotxt);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar Cuenta");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tipoCuentaCBX.getSelectedIndex()!=0) {
							
						}else {
							JOptionPane.showMessageDialog(null, "Error, debe seleccionar un tipo de cuenta antes de registrarse", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(82, 77, 206, 26);
		panel_1.add(passwordtxt);
		panelEmpleado.setVisible(false);
		nombretxt.setEnabled(false);
		telefonotxt.setEnabled(false);
		cedulatxt.setEnabled(false);
		direcciontxt.setEnabled(false);
		passwordtxt.setEnabled(false);
		

		tipoCuentaCBX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux= tipoCuentaCBX.getSelectedIndex();
				if(tipoCuentaCBX.getSelectedIndex()==0) {
					panelCliente.setVisible(false);
					panelEmpleado.setVisible(false);
					nombretxt.setEnabled(false);
					telefonotxt.setEnabled(false);
					cedulatxt.setEnabled(false);
					direcciontxt.setEnabled(false);
					passwordtxt.setEnabled(false);

				}
				if(tipoCuentaCBX.getSelectedIndex()==1) {
					panelCliente.setVisible(true);
					panelEmpleado.setVisible(false);
					nombretxt.setEnabled(true);
					telefonotxt.setEnabled(true);
					cedulatxt.setEnabled(true);
					direcciontxt.setEnabled(true);
					passwordtxt.setEnabled(true);

				}
				if(tipoCuentaCBX.getSelectedIndex()==2) {
					panelCliente.setVisible(false);
					panelEmpleado.setVisible(true);
					nombretxt.setEnabled(true);
					telefonotxt.setEnabled(true);
					cedulatxt.setEnabled(true);
					direcciontxt.setEnabled(true);
					passwordtxt.setEnabled(true);
				}

			}
		});

	}

}
