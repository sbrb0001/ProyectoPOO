package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import lógico.Combo;
import lógico.Componente;
import lógico.DiscoDuro;
import lógico.Factura;
import lógico.MicroProcesador;
import lógico.Ram;
import lógico.TMadre;
import lógico.TiendaComp;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class DescripcionCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];
	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		try {
			DescripcionCombo dialog = new DescripcionCombo(args);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DescripcionCombo(String string) {
		setTitle("Descripción del Combo");
		Combo combo = BuscarCombo(string);
		
		setBounds(100, 100, 528, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setSize(800, 400);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 892, 310);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_1.setBounds(10, 11, 765, 32);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNombreCombo = new JLabel("New label");
					lblNombreCombo.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblNombreCombo.setBounds(319, 11, 100, 14);
					panel_1.add(lblNombreCombo);
					lblNombreCombo.setText(combo.getNombre());
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 54, 765, 256);
				panel.add(scrollPane);
				{
					String[] headers = {"Componentes","Marca","Numero de serie", "Precio"};

					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);

					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					{
						JPanel buttonPane = new JPanel();
						buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
						buttonPane.setBounds(10, 321, 764, 37);
						contentPanel.add(buttonPane);
						buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
						
						JButton btnSalir = new JButton("Salir");
						buttonPane.add(btnSalir);
						btnSalir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
							}
						});
						btnSalir.setEnabled(true);
					}
					
					ListaComponentes(combo);
				}
			}
		}
	}
	private void ListaComponentes(Combo combo) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
			
		for(Componente componente : combo.getLosComponentes()) {
			
			if(componente instanceof MicroProcesador) {
				rows[0] = "Microprocesador";
				
			}
			else if(componente instanceof Ram) {
				rows[0] = "Memoria Ram";
				
			}
			else if (componente instanceof TMadre){
				rows[0] = "Tarjeta Madre";
				
			}
			else if (componente instanceof DiscoDuro){
				rows[0] = "Disco Duro";
				
			}
			rows[1] = componente.getMarca();
			rows[2] = componente.getNumSerie();
			rows[3] = componente.getPrecio();
			model.addRow(rows);
		}

			//model.addRow(rows);
		
	}
	public Combo BuscarCombo(String string) {
		
		for(Combo combo : TiendaComp.getInstance().getcVendidos()) {
			if(string.contains(combo.getNombre())){
				return combo;
			}
		}
		
		return null;
		
	}
}
