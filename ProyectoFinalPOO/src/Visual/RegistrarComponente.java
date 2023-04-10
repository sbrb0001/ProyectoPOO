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
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PRIVATE_MEMBER;

import lógico.Componente;
import lógico.DiscoDuro;
import lógico.MicroProcesador;
import lógico.Ram;
import lógico.TMadre;
import lógico.TiendaComp;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class RegistrarComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField marcaTxt;
	private JTextField numSerieTxt;
	private JTextField modeloMadretxt;
	private JTextField sockettxt;
	private JTextField ramTxt;
	private JTextField modeloDiscotxt;
	private JTextField modeloTXT;
	private JTextField microTipoconexiontxt;
	private JComboBox componenteCbx;
	private JTextField conexiontxt;
	private DefaultListModel modeloo = new DefaultListModel<>();
	private String [] strings = new String[100];
	private int ind =0;
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

		setBounds(100, 100, 525, 469);
		setLocationRelativeTo(null);
		setSize(540,480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setBackground(new Color(173, 216, 230));
		setForeground(new Color(173, 216, 230));;
		SpinnerNumberModel model = new SpinnerNumberModel(0.00, 0.00, null, 1.00);//esto es para el spiner

		JPanel discoDuropanel = new JPanel();
		discoDuropanel.setBackground(new Color(255, 255, 255));
		discoDuropanel.setBounds(6, 170, 528, 230);
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


		JPanel tmadrePanel = new JPanel();
		tmadrePanel.setBackground(new Color(255, 255, 255));
		tmadrePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informaci\u00F3n de Tarjeta Madre: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tmadrePanel.setBounds(6, 170, 528, 230);
		contentPanel.add(tmadrePanel);
		tmadrePanel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Modelo:");
		lblNewLabel_4.setBounds(6, 32, 61, 16);
		tmadrePanel.add(lblNewLabel_4);

		modeloMadretxt = new JTextField();
		modeloMadretxt.setBounds(58, 27, 164, 26);
		tmadrePanel.add(modeloMadretxt);
		modeloMadretxt.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Tipo de conector del Socket:");
		lblNewLabel_5.setBounds(6, 70, 190, 16);
		tmadrePanel.add(lblNewLabel_5);

		sockettxt = new JTextField();
		sockettxt.setBounds(188, 65, 310, 26);
		tmadrePanel.add(sockettxt);
		sockettxt.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Ram Compatible: ");
		lblNewLabel_6.setBounds(228, 32, 111, 16);
		tmadrePanel.add(lblNewLabel_6);

		ramTxt = new JTextField();
		ramTxt.setBounds(339, 27, 159, 26);
		tmadrePanel.add(ramTxt);
		ramTxt.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Lista de Conexiones: ");
		lblNewLabel_7.setBounds(6, 132, 149, 16);
		tmadrePanel.add(lblNewLabel_7);



		JPanel panel_2 = new JPanel();
		panel_2.setBounds(16, 151, 495, 62);
		tmadrePanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();

		list.setValueIsAdjusting(true);
		list.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		scrollPane.setViewportView(list);



		JLabel lblNewLabel_20 = new JLabel("Conexión: ");
		lblNewLabel_20.setBounds(6, 104, 76, 16);
		tmadrePanel.add(lblNewLabel_20);

		conexiontxt = new JTextField();
		conexiontxt.setBounds(80, 99, 262, 26);
		tmadrePanel.add(conexiontxt);
		conexiontxt.setColumns(10);

		JButton btnNewButton = new JButton("Agregar Conexión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				strings[ind]=conexiontxt.getText();
				ind++;
				modeloo.addElement(conexiontxt.getText());
				list.setModel(modeloo);
				conexiontxt.setText("");
			}
		});
		btnNewButton.setBounds(354, 99, 144, 29);
		tmadrePanel.add(btnNewButton);


		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(6, 170, 528, 230);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 6, 528, 65);
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
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 72, 528, 97);
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
		numSerieTxt.setBounds(116, 51, 171, 26);
		panel_1.add(numSerieTxt);
		numSerieTxt.setColumns(10);

		JLabel lblNewLabel_19 = new JLabel("Cantidad: ");
		lblNewLabel_19.setBounds(300, 58, 73, 16);
		panel_1.add(lblNewLabel_19);

		JSpinner cantidadSPN = new JSpinner();
		cantidadSPN.setBounds(364, 51, 124, 26);
		panel_1.add(cantidadSPN);

		JPanel microprocesadorPanel = new JPanel();
		microprocesadorPanel.setBackground(new Color(255, 255, 255));
		microprocesadorPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Microprocesador: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		microprocesadorPanel.setBounds(6, 170, 528, 194);
		contentPanel.add(microprocesadorPanel);
		microprocesadorPanel.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Modelo: ");
		lblNewLabel_16.setBounds(6, 30, 61, 16);
		microprocesadorPanel.add(lblNewLabel_16);

		modeloTXT = new JTextField();
		modeloTXT.setBounds(6, 47, 401, 26);
		microprocesadorPanel.add(modeloTXT);
		modeloTXT.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Tipo de conexión: ");
		lblNewLabel_17.setBounds(6, 82, 117, 16);
		microprocesadorPanel.add(lblNewLabel_17);

		microTipoconexiontxt = new JTextField();
		microTipoconexiontxt.setBounds(6, 104, 401, 26);
		microprocesadorPanel.add(microTipoconexiontxt);
		microTipoconexiontxt.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("Velocidad: ");
		lblNewLabel_18.setBounds(6, 128, 82, 16);
		microprocesadorPanel.add(lblNewLabel_18);

		JSpinner velocidadSPN = new JSpinner(model);
		velocidadSPN.setEditor(new JSpinner.NumberEditor(velocidadSPN, "0.00"));
		velocidadSPN.setBounds(6, 151, 167, 26);
		microprocesadorPanel.add(velocidadSPN);

		JLabel lblNewLabel_15 = new JLabel("Tipo de Procesamiento:");
		lblNewLabel_15.setBounds(245, 128, 179, 16);
		microprocesadorPanel.add(lblNewLabel_15);

		JComboBox velocidadCBX = new JComboBox();
		velocidadCBX.setModel(new DefaultComboBoxModel(new String[] {"<<Selección>>", "MHz ", "GHz"}));
		velocidadCBX.setBounds(245, 152, 162, 27);
		microprocesadorPanel.add(velocidadCBX);

		JPanel memoriaRamPanel = new JPanel();
		memoriaRamPanel.setBackground(new Color(255, 255, 255));
		memoriaRamPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informaci\u00F3n de Memoria Ram:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		memoriaRamPanel.setBounds(6, 170, 528, 174);
		contentPanel.add(memoriaRamPanel);
		memoriaRamPanel.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("Tipo de Almacenamiento: ");
		lblNewLabel_12.setBounds(6, 29, 164, 16);
		memoriaRamPanel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Capacidad: ");
		lblNewLabel_13.setBounds(236, 29, 79, 16);
		memoriaRamPanel.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Tipo de Memoria: ");
		lblNewLabel_14.setBounds(6, 97, 135, 16);
		memoriaRamPanel.add(lblNewLabel_14);

		JSpinner memoriaRamCapacidadspn = new JSpinner(model);
		memoriaRamCapacidadspn.setBounds(236, 56, 143, 26);
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




		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(componenteCbx.getSelectedIndex()!=0) {

							Componente aux= null;
							String marca= marcaTxt.getText();
							double precio= Double.valueOf(precioSpn.getValue().toString());
							String numSerie= numSerieTxt.getText();
							int cantidad= Integer.valueOf(cantidadSPN.getValue().toString());
							

							if(componenteCbx.getSelectedIndex()==1) {
								String modelo=modeloMadretxt.getText();
								String modelo1=sockettxt.getText();
								String modelo2=ramTxt.getText();

								aux= new TMadre(marca, numSerie, cantidad, precio, modelo, modelo1, modelo2, strings);
								strings = new String[100];

								//para que se borren las casillas despues de agregar
								modeloMadretxt.setText("");
								sockettxt.setText("");
								ramTxt.setText("");

							}
							if(componenteCbx.getSelectedIndex()==2) {
								String modelo= modeloDiscotxt.getText();
								double almacenamiento= Double.valueOf(capacidadspn.getValue().toString());
								String tipoConector=null;
								String tipoalmaString=null;
								if(conexioncbx.getSelectedIndex()==1) {
									tipoConector = "IDE";
								}
								else if(conexioncbx.getSelectedIndex()==2) {
									tipoConector = "SATA";
								}
								else if(conexioncbx.getSelectedIndex()==3) {
									tipoConector = "SATA-2";
								}
								else if(conexioncbx.getSelectedIndex()==4) {
									tipoConector = "SATA-3";
								}

								if (discoDurocbx.getSelectedIndex()==1) {

									tipoalmaString="GB";
								}
								if (discoDurocbx.getSelectedIndex()==2) {

									tipoalmaString="TB";
								}
								aux= new DiscoDuro(marca, numSerie, cantidad, precio, modelo, almacenamiento, tipoConector,tipoalmaString);

								modeloDiscotxt.setText("");
								
								conexioncbx.setSelectedIndex(0);
								discoDurocbx.setSelectedIndex(0);
								capacidadspn.setValue(0.00);


							}
							if(componenteCbx.getSelectedIndex()==3) {
								String tipoAlmacenamientoString = null;
								if(almecenamietoMemoriaRamcbx.getSelectedIndex()==1) {
									tipoAlmacenamientoString = "GB";
								}
								else if(almecenamietoMemoriaRamcbx.getSelectedIndex()==2) {
									tipoAlmacenamientoString = "MB";
								}

								String tipoMEMString= memoriaTipoCBX.getName();
								if(memoriaTipoCBX.getSelectedIndex()==1) {
									tipoMEMString = "DDR";
								}
								else if(memoriaTipoCBX.getSelectedIndex()==2) {
									tipoMEMString = "DDR-2";
								}
								else if(memoriaTipoCBX.getSelectedIndex()==3) {
									tipoMEMString = "DDR-3";
								}

								double capacid= Double.valueOf(memoriaRamCapacidadspn.getValue().toString());
								aux = new Ram(marca, numSerie, cantidad, precio, capacid, tipoMEMString, tipoAlmacenamientoString);
								almecenamietoMemoriaRamcbx.setSelectedIndex(0);
								memoriaTipoCBX.setSelectedIndex(0);
								memoriaRamCapacidadspn.setValue(0.00);
								
							}
							
							if(componenteCbx.getSelectedIndex()==4) {
								String modelString = modeloTXT.getText();
								String tipoConexionString= microTipoconexiontxt.getText();
								double velocida = Double.valueOf(velocidadSPN.getValue().toString());
								String tipoVelocidadString=null;
								if (velocidadCBX.getSelectedIndex()==1) {
									tipoVelocidadString= "MHz";

								}if (velocidadCBX.getSelectedIndex()==2) {
									tipoVelocidadString= "GHz";

								}

								aux = new MicroProcesador(marca, numSerie, cantidad, precio, modelString, tipoConexionString, velocida, tipoVelocidadString);//arreglar lo de tipro procesamiento
								velocidadCBX.setSelectedIndex(0);
								velocidadSPN.setValue(0.00);
								microTipoconexiontxt.setText("");
								modeloTXT.setText("");
							}

							marcaTxt.setText("");
							precioSpn.setValue(0.00);
							numSerieTxt.setText("");
							cantidadSPN.setValue(0.00);
							TiendaComp.getInstance().InsertarComp(aux);
							JOptionPane.showMessageDialog(null, "Componente Agregado!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						}else
						{
							//aqui tomamos uso de referencia de exepciones
							if(componenteCbx.getSelectedIndex()==0) {
								JOptionPane.showMessageDialog(null, "Error, debe seleccionar un componente antes de registrar", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}


					}
				});
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
					cantidadSPN.setEnabled(false);
					precioSpn.setEnabled(false);
					memoriaRamPanel.setVisible(false);
					microprocesadorPanel.setVisible(false);
					panel_3.setVisible(true);
				}
				if (aux==1) {
					tmadrePanel.setVisible(true);
					discoDuropanel.setVisible(false);
					marcaTxt.setEditable(true);
					numSerieTxt.setEditable(true);
					precioSpn.setEnabled(true);
					memoriaRamPanel.setVisible(false);
					microprocesadorPanel.setVisible(false);
					cantidadSPN.setEnabled(true);
					panel_3.setVisible(false);

				}
				if (aux==2) {
					tmadrePanel.setVisible(false);
					discoDuropanel.setVisible(true);
					marcaTxt.setEditable(true);
					numSerieTxt.setEditable(true);
					precioSpn.setEnabled(true);
					memoriaRamPanel.setVisible(false);
					microprocesadorPanel.setVisible(false);
					panel_3.setVisible(false);
					cantidadSPN.setEnabled(true);

				}
				if (aux==3) {
					tmadrePanel.setVisible(false);
					discoDuropanel.setVisible(false);
					marcaTxt.setEditable(true);
					numSerieTxt.setEditable(true);
					precioSpn.setEnabled(true);
					memoriaRamPanel.setVisible(true);
					microprocesadorPanel.setVisible(false);
					panel_3.setVisible(false);
					cantidadSPN.setEnabled(true);

				}
				if (aux==4) {
					tmadrePanel.setVisible(false);
					discoDuropanel.setVisible(false);
					marcaTxt.setEditable(true);
					numSerieTxt.setEditable(true);
					precioSpn.setEnabled(true);
					memoriaRamPanel.setVisible(false);
					microprocesadorPanel.setVisible(true);
					panel_3.setVisible(false);
					cantidadSPN.setEnabled(true);

				}

			}
		});
	}
}