package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import lógico.Componente;
import lógico.DiscoDuro;
import lógico.MicroProcesador;
import lógico.Ram;
import lógico.TMadre;
import lógico.TiendaComp;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListadoComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoComponente dialog = new ListadoComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoComponente() {
		setBackground(new Color(173, 216, 230));
		
		setForeground(new Color(173, 216, 230));;
		setBounds(100, 100, 671, 424);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setVgap(17);
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Tipo de Componente: ");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(lblNewLabel);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Targeta Madre", "Disco Duro", "Memoria Ram", "Microprocesador"}));
				panel.add(comboBox);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String[] cabecera = {"Tipo", "Marca","Número de Serie", "Cantidad","Precio"};
					table = new JTable();
					scrollPane.setViewportView(table);
					model= new DefaultTableModel();
					model.setColumnIdentifiers(cabecera);
					table.setModel(model);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton_1 = new JButton("Eliminar");
				buttonPane.add(btnNewButton_1);
			}
			{
				JButton btnNewButton = new JButton("Modificar");
				buttonPane.add(btnNewButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadComponent();
	}

	private void loadComponent() {
		
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		
		for (Componente aux : TiendaComp.getInstance().getMisComponentes()) {
			
			rows[1]=aux.getMarca();
			rows[2]=aux.getNumSerie();
			rows[3]=aux.getCant();
			rows[4]=aux.getPrecio();
			
			if (aux instanceof TMadre) {
				rows[0]= "Targeta Madre";
				
			}
			if (aux instanceof DiscoDuro) {
				rows[0]= "Disco Duro";
				
			}
			if (aux instanceof Ram) {
				rows[0]= "Memoria Ram";
				
			}
			if (aux instanceof MicroProcesador) {
				rows[0]= "Microprocesador";
				
			}
			model.addRow(rows);
			
		}
	
		
	}

}
