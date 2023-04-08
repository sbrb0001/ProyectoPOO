package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import lógico.TMadre;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.SpinnerModel;
import javax.swing.JList;

public class RegistrarComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField marcaTxt;
	private JTextField numSerieTxt;
	private JTextField modeloMadretxt;
	private JTextField sockettxt;
	private JTextField ramTxt;
	private JTextField modeloDiscotxt;
	private JTextField marcaTXT;
	private JTextField modeloTXT;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarComponente dialog = new RegistrarComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarComponente() {
		setBounds(100, 100, 525, 471);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		SpinnerNumberModel model = new SpinnerNumberModel(0.00, 0.00, null, 1.00);//esto es para el spiner
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 6, 513, 65);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de Componente: ");
		lblNewLabel.setBounds(6, 23, 139, 16);
		panel.add(lblNewLabel);
		
		
		JComboBox componenteCbx = new JComboBox();
		
		componenteCbx.setModel(new DefaultComboBoxModel(new String[] {" <<Seleccionar>>", "Tarjeta Madre", "Disco Duro", "Memoria Ram", "Microprocedador"}));
		componenteCbx.setBounds(142, 19, 171, 27);
		panel.add(componenteCbx);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 72, 513, 97);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(6, 25, 47, 16);
		panel_1.add(lblNewLabel_1);
		
		marcaTxt = new JTextField();
		marcaTxt.setBounds(49, 20, 239, 26);
		panel_1.add(marcaTxt);
		marcaTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setBounds(300, 25, 47, 16);
		panel_1.add(lblNewLabel_2);
		
		//a mi no me deja modificar en model desde lo visual, tuve que ingeniermela para que todo saliera
		SpinnerNumberModel model0 = new SpinnerNumberModel(0.00, 0.00, null, 1.00);
		JSpinner precioSpn = new JSpinner(model0);
		precioSpn.setEditor(new JSpinner.NumberEditor(precioSpn, "0.00"));
		
		precioSpn.setBounds(345, 20, 143, 26);
		panel_1.add(precioSpn);
		
		JLabel lblNewLabel_3 = new JLabel("Número de Serie:");
		lblNewLabel_3.setBounds(6, 56, 112, 16);
		panel_1.add(lblNewLabel_3);
		
		numSerieTxt = new JTextField();
		numSerieTxt.setBounds(116, 51, 372, 26);
		panel_1.add(numSerieTxt);
		numSerieTxt.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 519, 212);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(6, 170, 513, 224);
		contentPanel.add(panel_3);
		
		
		JPanel tmadrePanel = new JPanel();
		tmadrePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informaci\u00F3n de Tarjeta Madre: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tmadrePanel.setBounds(6, 170, 513, 230);
		contentPanel.add(tmadrePanel);
		tmadrePanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Modelo:");
		lblNewLabel_4.setBounds(6, 32, 61, 16);
		tmadrePanel.add(lblNewLabel_4);
		
		modeloMadretxt = new JTextField();
		modeloMadretxt.setBounds(58, 27, 425, 26);
		tmadrePanel.add(modeloMadretxt);
		modeloMadretxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de conector del Socket:");
		lblNewLabel_5.setBounds(6, 65, 190, 16);
		tmadrePanel.add(lblNewLabel_5);
		
		sockettxt = new JTextField();
		sockettxt.setBounds(186, 60, 297, 26);
		tmadrePanel.add(sockettxt);
		sockettxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Ram Compatible: ");
		lblNewLabel_6.setBounds(6, 98, 111, 16);
		tmadrePanel.add(lblNewLabel_6);
		
		ramTxt = new JTextField();
		ramTxt.setBounds(113, 93, 370, 26);
		tmadrePanel.add(ramTxt);
		ramTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Lista de Conexiones: ");
		lblNewLabel_7.setBounds(6, 132, 149, 16);
		tmadrePanel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Nueva");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(390, 127, 117, 29);
		tmadrePanel.add(btnNewButton);
		
		JPanel discoDuropanel = new JPanel();
		discoDuropanel.setBounds(6, 170, 513, 230);
		contentPanel.add(discoDuropanel);
		discoDuropanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Disco Duro: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		discoDuropanel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Modelo:");
		lblNewLabel_8.setBounds(6, 34, 61, 16);
		discoDuropanel.add(lblNewLabel_8);
		
		modeloDiscotxt = new JTextField();
		modeloDiscotxt.setBounds(6, 50, 391, 26);
		discoDuropanel.add(modeloDiscotxt);
		modeloDiscotxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Tipo de Almacenamiento:");
		lblNewLabel_9.setBounds(6, 88, 167, 16);
		discoDuropanel.add(lblNewLabel_9);
		
		JComboBox discoDurocbx = new JComboBox();
		discoDurocbx.setBounds(6, 116, 167, 27);
		discoDurocbx.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "Gigabytes", "Terabytes"}));
		discoDuropanel.add(discoDurocbx);
		
		JLabel lblNewLabel_10 = new JLabel("Capacidad: ");
		lblNewLabel_10.setBounds(254, 88, 85, 16);
		discoDuropanel.add(lblNewLabel_10);
		JSpinner capacidadspn = new JSpinner(model);
		capacidadspn.setBounds(254, 115, 143, 26);
		capacidadspn.setEditor(new JSpinner.NumberEditor(capacidadspn, "0.00"));
		
		discoDuropanel.add(capacidadspn);
		
		JLabel lblNewLabel_11 = new JLabel("Tipo de Conexión: ");
		lblNewLabel_11.setBounds(6, 155, 126, 16);
		discoDuropanel.add(lblNewLabel_11);
		
		JComboBox conexioncbx = new JComboBox();
		conexioncbx.setBounds(6, 184, 398, 27);
		conexioncbx.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "IDE", "SATA", "SATA-2", "SATA-3"}));
		discoDuropanel.add(conexioncbx);
		
		JPanel memoriaRamPanel = new JPanel();
		memoriaRamPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informaci\u00F3n de Memoria Ram:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		memoriaRamPanel.setBounds(6, 170, 513, 174);
		contentPanel.add(memoriaRamPanel);
		memoriaRamPanel.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Tipo de Almacenamiento: ");
		lblNewLabel_12.setBounds(6, 29, 164, 16);
		memoriaRamPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Capacidad: ");
		lblNewLabel_13.setBounds(258, 29, 79, 16);
		memoriaRamPanel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Tipo de Memoria: ");
		lblNewLabel_14.setBounds(6, 97, 135, 16);
		memoriaRamPanel.add(lblNewLabel_14);
		
			JSpinner memoriaRamCapacidadspn = new JSpinner(model);
			memoriaRamCapacidadspn.setBounds(255, 57, 143, 26);
			memoriaRamCapacidadspn.setEditor(new JSpinner.NumberEditor(memoriaRamCapacidadspn, "0.00"));
			memoriaRamPanel.add(memoriaRamCapacidadspn);
			
			JComboBox almecenamietoMemoriaRamcbx = new JComboBox();
			almecenamietoMemoriaRamcbx.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "GB", "MB"}));
			almecenamietoMemoriaRamcbx.setBounds(6, 57, 164, 27);
			memoriaRamPanel.add(almecenamietoMemoriaRamcbx);
			
			JComboBox memoriaTipoCBX = new JComboBox();
			memoriaTipoCBX.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "DDR", "DDR-2", "DDr-3"}));
			memoriaTipoCBX.setBounds(6, 125, 164, 27);
			memoriaRamPanel.add(memoriaTipoCBX);
			
			JPanel microprocesadorPanel = new JPanel();
			microprocesadorPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Microprocesador: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			microprocesadorPanel.setBounds(6, 170, 507, 185);
			contentPanel.add(microprocesadorPanel);
			microprocesadorPanel.setLayout(null);
			
			JLabel lblNewLabel_15 = new JLabel("Marca: ");
			lblNewLabel_15.setBounds(6, 30, 61, 16);
			microprocesadorPanel.add(lblNewLabel_15);
			
			marcaTXT = new JTextField();
			marcaTXT.setBounds(50, 25, 411, 26);
			microprocesadorPanel.add(marcaTXT);
			marcaTXT.setColumns(10);
			
			JLabel lblNewLabel_16 = new JLabel("Modelo: ");
			lblNewLabel_16.setBounds(6, 63, 61, 16);
			microprocesadorPanel.add(lblNewLabel_16);
			
			modeloTXT = new JTextField();
			modeloTXT.setBounds(60, 58, 401, 26);
			microprocesadorPanel.add(modeloTXT);
			modeloTXT.setColumns(10);
			
			JLabel lblNewLabel_17 = new JLabel("Tipo de conexión: ");
			lblNewLabel_17.setBounds(6, 91, 117, 16);
			microprocesadorPanel.add(lblNewLabel_17);
			
			textField = new JTextField();
			textField.setBounds(123, 86, 338, 26);
			microprocesadorPanel.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_18 = new JLabel("Tipo de Conector para Socket: ");
			lblNewLabel_18.setBounds(6, 119, 193, 16);
			microprocesadorPanel.add(lblNewLabel_18);
			
			textField_1 = new JTextField();
			textField_1.setBounds(6, 139, 455, 26);
			microprocesadorPanel.add(textField_1);
			textField_1.setColumns(10);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		componenteCbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int aux= componenteCbx.getSelectedIndex();
				if (aux<=0) {
					tmadrePanel.setVisible(false);
					discoDuropanel.setVisible(false);
					marcaTxt.setEditable(false);
					numSerieTxt.setEditable(false);
					precioSpn.setEnabled(false);
					memoriaRamPanel.setVisible(false);
					microprocesadorPanel.setVisible(false);
				}
				if (aux==1) {
					tmadrePanel.setVisible(true);
					discoDuropanel.setVisible(false);
					marcaTxt.setEditable(true);
					numSerieTxt.setEditable(true);
					precioSpn.setEnabled(true);
					memoriaRamPanel.setVisible(false);
					microprocesadorPanel.setVisible(false);
				}
				if (aux==2) {
					tmadrePanel.setVisible(false);
					discoDuropanel.setVisible(true);
					marcaTxt.setEditable(true);
					numSerieTxt.setEditable(true);
					precioSpn.setEnabled(true);
					memoriaRamPanel.setVisible(false);
					microprocesadorPanel.setVisible(false);
				}
				if (aux==3) {
					tmadrePanel.setVisible(false);
					discoDuropanel.setVisible(false);
					marcaTxt.setEditable(true);
					numSerieTxt.setEditable(true);
					precioSpn.setEnabled(true);
					memoriaRamPanel.setVisible(true);
					microprocesadorPanel.setVisible(false);
				}
				if (aux==4) {
					tmadrePanel.setVisible(false);
					discoDuropanel.setVisible(false);
					marcaTxt.setEditable(true);
					numSerieTxt.setEditable(true);
					precioSpn.setEnabled(true);
					memoriaRamPanel.setVisible(false);
					microprocesadorPanel.setVisible(true);
				}
				
			}
		});
	}
}

