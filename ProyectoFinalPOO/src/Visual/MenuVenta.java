package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import lógico.TiendaComp;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim; 
	private JTextField textMonto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuVenta dialog = new MenuVenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuVenta() {
		TiendaComp.getInstance().GenerarComponentes();
		
		setBounds(100, 100, 533, 373);
		dim = getToolkit().getScreenSize();
		setSize(dim.width-700, dim.height-200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(10, 0, 630, 34);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblMenuVentas = new JLabel("Componentes diponibles: ");
				lblMenuVentas.setBounds(246, 11, 163, 14);
				panel.add(lblMenuVentas);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(10, 44, 630, 437);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_3 = new JLabel("Memorias Ram:");
				lblNewLabel_3.setBounds(506, 2, 114, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Microprocesadores:");
				lblNewLabel_2.setBounds(342, 2, 120, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Discos duros:");
				lblNewLabel_1.setBounds(187, 2, 96, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel = new JLabel("Tarjetas madre:");
				lblNewLabel.setBounds(34, 2, 96, 14);
				panel.add(lblNewLabel);
			}
			
			JScrollPane scrollCarrito = new JScrollPane();
			scrollCarrito.setBounds(248, 263, 137, 163);
			panel.add(scrollCarrito);
			JList listCarrito = new JList();
			scrollCarrito.setViewportView(listCarrito);
		
			JScrollPane scrollTmadres = new JScrollPane();
			scrollTmadres.setBounds(10, 27, 137, 180);
			panel.add(scrollTmadres);
			
			JList listTmadres = new JList();
			scrollTmadres.setViewportView(listTmadres);

			scrollTmadres.setViewportView(listTmadres);
			
			listTmadres.setModel(new AbstractListModel() {
				String[] values = TiendaComp.getInstance().mMadresList();
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			JScrollPane scrollDuros = new JScrollPane();
			scrollDuros.setBounds(166, 27, 137, 180);
			panel.add(scrollDuros);
			
			JList listDiscosDuros = new JList();
			scrollDuros.setViewportView(listDiscosDuros);
			
			listDiscosDuros.setModel(new AbstractListModel() {
				String[] values = TiendaComp.getInstance().mDurosList();
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		
		
			JScrollPane scrollmProcesadores = new JScrollPane();
			scrollmProcesadores.setBounds(325, 27, 137, 180);
			panel.add(scrollmProcesadores);
			
			JList listMicroprocesadores = new JList();
			scrollmProcesadores.setViewportView(listMicroprocesadores);
		
			listMicroprocesadores.setModel(new AbstractListModel() {
				String[] values = TiendaComp.getInstance().mProcesadoresList();
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		
		
			JScrollPane scrollRam = new JScrollPane();
			scrollRam.setBounds(483, 27, 137, 180);
			panel.add(scrollRam);
		
			JList listMemoriaRam = new JList();
			scrollRam.setViewportView(listMemoriaRam);
			
			listMemoriaRam.setModel(new AbstractListModel() {
				String[] values = TiendaComp.getInstance().mRamList();
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			textMonto = new JTextField();
			textMonto.setEditable(false);
			textMonto.setBounds(534, 406, 86, 20);
			panel.add(textMonto);
			textMonto.setColumns(10);
		
			
			JButton btnAgregarAlCarrito = new JButton("Agregar al carrito");
			btnAgregarAlCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(listDiscosDuros.getSelectedValue()!= null) {
						listCarrito.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().ComponentesEnListaCarrito(listDiscosDuros.getSelectedValue().toString());
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						TiendaComp.getInstance().ActualizarListComp(listDiscosDuros.getSelectedValue().toString(), TiendaComp.getInstance().getDiscosD());
						textMonto.setText(TiendaComp.getInstance().monto());
						listDiscosDuros.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().mDurosList();
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
					}
					
					else if(listTmadres.getSelectedValue()!= null) {
						listCarrito.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().ComponentesEnListaCarrito(listTmadres.getSelectedValue().toString());
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						TiendaComp.getInstance().ActualizarListComp(listTmadres.getSelectedValue().toString(), TiendaComp.getInstance().getTMadres());
						textMonto.setText(TiendaComp.getInstance().monto());
						listTmadres.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().mMadresList();
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
					}
					else if(listMicroprocesadores.getSelectedValue()!= null) {
						listCarrito.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().ComponentesEnListaCarrito(listMicroprocesadores.getSelectedValue().toString());
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						TiendaComp.getInstance().ActualizarListComp(listMicroprocesadores.getSelectedValue().toString(), TiendaComp.getInstance().getmProcesadores());
						textMonto.setText(TiendaComp.getInstance().monto());
						listMicroprocesadores.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().mProcesadoresList();
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
					}
					else if(listMemoriaRam.getSelectedValue()!= null) {
						listCarrito.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().ComponentesEnListaCarrito(listMemoriaRam.getSelectedValue().toString());
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						TiendaComp.getInstance().ActualizarListComp(listMemoriaRam.getSelectedValue().toString(), TiendaComp.getInstance().getRams());
						textMonto.setText(TiendaComp.getInstance().monto());
						listMemoriaRam.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().mRamList();
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
					}
				}
			});
			btnAgregarAlCarrito.setBounds(130, 218, 162, 23);
			panel.add(btnAgregarAlCarrito);
			{
				JLabel lblNewLabel_4 = new JLabel("Carrito:");
				lblNewLabel_4.setBounds(293, 245, 46, 14);
				panel.add(lblNewLabel_4);
			}
			
			
			JButton btnEliminardeCarrito = new JButton("Eliminar de carrito");
			btnEliminardeCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (TiendaComp.getInstance().DeDondeEs(listCarrito.getSelectedValue().toString())==0){
						listCarrito.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().ActualizarListCarrito(listCarrito.getSelectedValue().toString());
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						
						listMemoriaRam.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().mRamList();
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});	
					}
					else if (TiendaComp.getInstance().DeDondeEs(listCarrito.getSelectedValue().toString())==1){
						
						listCarrito.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().ActualizarListCarrito(listCarrito.getSelectedValue().toString());
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						
						listMicroprocesadores.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().mProcesadoresList();
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});	
					}
					else if (TiendaComp.getInstance().DeDondeEs(listCarrito.getSelectedValue().toString())==2){
						listCarrito.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().ActualizarListCarrito(listCarrito.getSelectedValue().toString());
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						
						listTmadres.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().mMadresList();
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});	
					}
					else if (TiendaComp.getInstance().DeDondeEs(listCarrito.getSelectedValue().toString())==3){
						listCarrito.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().ActualizarListCarrito(listCarrito.getSelectedValue().toString());
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						
						listDiscosDuros.setModel(new AbstractListModel() {
							String[] values = TiendaComp.getInstance().mDurosList();
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});	
					}
					textMonto.setText(TiendaComp.getInstance().monto());
				}
			});
			btnEliminardeCarrito.setBounds(342, 218, 162, 23);
			panel.add(btnEliminardeCarrito);
			
			JLabel lblNewLabel_5 = new JLabel("Precio total:");
			lblNewLabel_5.setBounds(443, 409, 81, 14);
			panel.add(lblNewLabel_5);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Comprar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
