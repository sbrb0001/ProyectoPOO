package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import lógico.Combo;
import lógico.Componente;
import lógico.DiscoDuro;
import lógico.MicroProcesador;
import lógico.Ram;
import lógico.TMadre;
import lógico.TiendaComp;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentaCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String [] ListaCombo = new String[100];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentaCombo dialog = new VentaCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentaCombo() {

		ComboList();
		setTitle("Venta de Combos");
		setBounds(100, 100, 535, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setSize(700,450);
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 53, 664, 310);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 644, 288);
		panel.add(scrollPane);
		
		JList listComp = new JList();

		listComp.setModel(new AbstractListModel() {
			String[] values = ListaCombo;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listComp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 11, 664, 35);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Combos disponibles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(255, 0, 139, 35);
		panel_1.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnNewButton = new JButton("Ver descripción");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						DescripcionCombo list = new DescripcionCombo(listComp.getSelectedValue().toString());
						list.setModal(true);
						list.setVisible(true);
					
				}
			});
			buttonPane.add(btnNewButton);
			{
				JButton okButton = new JButton("Comprar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ActualizarLista(listComp.getSelectedValue().toString());
						ListaCombo = new String[100];
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public String [] ComboList() {
		
		int ind=0;
		for(Combo combo : TiendaComp.getInstance().getcVendidos()) {
			if(combo.getCant()>0) {
				ListaCombo[ind]=combo.getNombre()+"   ||   "+String.valueOf(CantMadres(combo))+"  Tarjetas Madre"+"   |   "+String.valueOf(CantMicro(combo))+"  Microprocesadores"+"   |   "+String.valueOf(CantDiscos(combo))+"  Discos duros"+"   |   "+String.valueOf(CantRams(combo))+"  Memorias Ram"+" || "+" $"+String.valueOf(combo.Precio()-(combo.Precio()*0.1));
				ind++;
			}
		}
		
		return null;
	}
	
	public double PrecioCombo(Combo combo) {
		
		double monto = 0;
		for(Componente componente : combo.getLosComponentes()) {
			monto+=componente.getCant();
		}
		
		return monto;
	}
	
	public int CantMadres(Combo combo) {
		
		int cant =0;
		for(Componente componente : combo.getLosComponentes()) {
			if(componente instanceof TMadre) {
				cant++;
			}
		}
		
		return cant;
	}
	
	public int CantMicro(Combo combo) {
		
		int cant =0;
		for(Componente componente : combo.getLosComponentes()) {
			if(componente instanceof MicroProcesador) {
				cant++;
			}
		}
		
		return cant;
	}
	
	public int CantRams(Combo combo) {
		
		int cant =0;
		for(Componente componente : combo.getLosComponentes()) {
			if(componente instanceof Ram) {
				cant++;
			}
		}
		
		return cant;
	}
	
	public int CantDiscos(Combo combo) {
		
		int cant =0;
		for(Componente componente : combo.getLosComponentes()) {
			if(componente instanceof DiscoDuro) {
				cant++;
			}
		}
		
		return cant;
	}
	
	public void ActualizarLista(String seleccionado) {
		
		for(Combo combo : TiendaComp.getInstance().getcVendidos()) {
			if(seleccionado.contains(combo.getNombre())) {
				combo.setCant(combo.getCant()-1);
			}
			if(combo.getCant() == 0) {
				for(int ind =0; ListaCombo[ind]!= null; ind++) {
					
					if(ListaCombo[ind].equalsIgnoreCase(seleccionado)) {
						for(int indice = ind; ListaCombo[indice]!=null;) {
							ListaCombo[indice]=ListaCombo[indice+1];
							//combo.setCant(0);
							//System.out.println(componente.cant);
							return;
						}
					}
				}
			}
		}
		
	}
}
