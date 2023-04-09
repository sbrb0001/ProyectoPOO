package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import lógico.Componente;
import lógico.DiscoDuro;
import lógico.Factura;
import lógico.MicroProcesador;
import lógico.Ram;
import lógico.TMadre;
import lógico.TiendaComp;
import javax.swing.border.EtchedBorder;

public class ListaFacturas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaFacturas dialog = new ListaFacturas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaFacturas() {
		setBounds(100, 100, 554, 379);
		setSize(800, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 892, 310);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 11, 765, 40);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					panel_2.setBackground(Color.LIGHT_GRAY);
					panel_2.setBounds(-12, 11, 780, 26);
					panel_1.add(panel_2);
					panel_2.setLayout(null);
					{
						JLabel lblFacturas = new JLabel("Facturas emitidas");
						lblFacturas.setBounds(342, 7, 130, 14);
						panel_2.add(lblFacturas);
					}
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 54, 765, 245);
				panel.add(scrollPane);
				{
					String[] headers = {"Factura","Comprador","Disco Duros", "Ram", "Microprocesador","Tarjetas Madre","Precio Total"};

					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);

					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					{
						JPanel buttonPane = new JPanel();
						buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
						buttonPane.setBounds(10, 313, 764, 37);
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
					
					ListaFactura();
				}
			}
		}
	}
	private void ListaFactura() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		String serie = null;
		for (Factura factura : TiendaComp.getInstance().getMisFacturas()) {
			rows[0] = factura.getCodigo();
			rows[1] = factura.getPersona().getNombre();
			
			int cant1=0, cant2=0, cant3=0, cant4=0;
			
			for(Componente componente : factura.getMisComponentes()) {
				
				if(componente instanceof MicroProcesador) {
					cant1++;
				}
				else if(componente instanceof Ram) {
					cant2++;
				}
				else if (componente instanceof TMadre){
					cant3++;
				}
				else if (componente instanceof DiscoDuro){
					cant4++;
				}
			}
			rows[2] = cant4;
			rows[3] = cant2;
			rows[4] = cant1;
			rows[5] = cant3;
		//	rows[5] = TiendaQueso.getInstance().montodeFactura(factura);
		//	rows[2] = factura.getMisQuesos();
		//	rows[3] = factura.getMisQuesos();
			//rows[4] = factura.getMisQuesos();
			model.addRow(rows);
		}
	}
}
