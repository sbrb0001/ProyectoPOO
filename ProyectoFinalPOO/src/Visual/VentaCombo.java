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
import lógico.Factura;
import lógico.MicroProcesador;
import lógico.Ram;
import lógico.TMadre;
import lógico.TiendaComp;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentaCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String [] ListaCombo = new String[100];
	ArrayList<Combo> comboFact = new ArrayList<Combo>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Factura factura) {
		try {
			VentaCombo dialog = new VentaCombo(factura);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentaCombo(Factura factura) {
		setBackground(new Color(173, 216, 230));

		ListaCombo = new String[100];
		ComboList();
		//ListaCombo = new String[100];
		setTitle("Venta de Combos");
		setBounds(100, 100, 535, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
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
		panel_1.setBackground(new Color(255, 255, 255));
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
			buttonPane.setBackground(new Color(255, 255, 255));
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
			//factura.setCodigo(TiendaComp.getInstance().CrearCodigoFact());
			
			//TiendaComp.getInstance().InsertarFact(factura);
			buttonPane.add(btnNewButton);
			{
				JButton okButton = new JButton("Comprar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String n = listComp.getSelectedValue().toString();
						ActualizarLista(n);
						//TiendaComp.getInstance().InsertarFact(factura);
						
						if(BuscarFactura(factura.getCodigo())) {
							factura.setcVendidos(ComboFactura(n));
						}
						else {
							factura.setcVendidos(ComboFactura(n));
						//	factura.setcVendidos(ComboFactura(n));
					//		factura.setCodigo(TiendaComp.getInstance().CrearCodigoFact());
					//		TiendaComp.getInstance().InsertarFact(factura);
							factura.setPersona(TiendaComp.getInstance().PersonaLogg());
							factura.setMisComponentes(null);
						}
						//factura.setcVendidos(ComboFactura(n));
					//	factura.setPersona(TiendaComp.getInstance().PersonaLogg());
					//	factura.setMisComponentes(null);
						JOptionPane.showMessageDialog(null, "Combo adquirido!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						//
						scrollPane.setViewportView(listComp);
						//TiendaComp.getInstance().InsertarFact(factura);
						
					//	dispose();
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
	
	public ArrayList<Combo> ComboFactura(String string) {
		
		//ArrayList<Combo> comboFact = new ArrayList<Combo>();
		for(Combo combo : TiendaComp.getInstance().getcVendidos()) {
			if(string.contains(combo.getNombre())) {
				comboFact.add(combo);
			}
		}
		return comboFact;
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
							
						}
					}
				}
			}
		}
		return;
	}
	
	public boolean BuscarFactura(String codigo) {
		
		if(codigo == null) {
			return false;
		}
		for(Factura factura : TiendaComp.getInstance().getMisFacturas()) {
			if(codigo.equalsIgnoreCase(factura.getCodigo())) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
}
