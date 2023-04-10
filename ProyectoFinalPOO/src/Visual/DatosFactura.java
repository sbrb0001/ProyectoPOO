package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import lógico.Combo;
import lógico.Componente;
import lógico.DiscoDuro;
import lógico.Factura;
import lógico.MicroProcesador;
import lógico.Ram;
import lógico.TMadre;
import lógico.TiendaComp;

public class DatosFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];
	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		try {
			DatosFactura dialog = new DatosFactura(args);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DatosFactura(String codigo) {
		setTitle("Datos de factura");
		Factura factura = BuscarFactura(codigo);
		
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
					JLabel lblNombreFactura = new JLabel("New label");
					lblNombreFactura.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblNombreFactura.setBounds(319, 11, 100, 14);
					panel_1.add(lblNombreFactura);
					lblNombreFactura.setText(codigo);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 54, 765, 256);
				panel.add(scrollPane);
				{
					String[] headers = {"Componentes", "Combo", "Precio total"};

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
					
					DatosdeFactura(factura);
				}
			}
		}
	}
	private void DatosdeFactura(Factura factura) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		//String compo = "";
		
		for(Componente componente : factura.getMisComponentes()) {
			//String compo = "";
			
			if(componente instanceof MicroProcesador) {
				rows[0] = "Microprocesador"+" | "+componente.getMarca()+" | "+componente.getNumSerie()+" |  $"+componente.getPrecio();
				
			}
			else if(componente instanceof Ram) {
				rows[0] = "Memoria Ram"+" | "+componente.getMarca()+" | "+componente.getNumSerie()+" |  $"+componente.getPrecio();
				
			}
			else if (componente instanceof TMadre){
				rows[0] = "Tarjeta Madre"+" | "+componente.getMarca()+" | "+componente.getNumSerie()+" |  $"+componente.getPrecio();
				
			}
			else if (componente instanceof DiscoDuro){
				rows[0] = "Disco Duro"+" | "+componente.getMarca()+" | "+componente.getNumSerie()+" |  $"+componente.getPrecio();
				
			}
			//rows[1] = componente.getMarca();
			//rows[2] = componente.getPrecio();
			model.addRow(rows);
			//model.ad
			
		}
		if(factura.getcVendidos()!=null) {
			for(Combo combo : factura.getcVendidos()) {
				if(combo!=null){
				//	String combop = "";
					rows[0] = "";
					rows[1] = combo.getNombre()+"     |     "+"Precio: $"+combo.Precio();
					rows[2] = combo.Precio();
				}
				//rows[2] = combo.Precio();
				//model.addColumn(rows);
				//model.addRow(rows);
			}
		}
		else {
			rows[1] = "N/A";
		}
		model.addRow(rows);
			//model.addRow(rows);
		
	}
	public Factura BuscarFactura(String string) {
		
		for(Factura factura : TiendaComp.getInstance().getMisFacturas()) {
			if(string.equalsIgnoreCase(factura.getCodigo())){
				return factura;
			}
		}
		
		return null;
		
	}

}
