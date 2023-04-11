package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class ModifInfo extends JDialog {
	
	JEditorPane editorPane = new JEditorPane();
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifInfo dialog = new ModifInfo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifInfo() {
		
		setBackground(new Color(173, 216, 230));
		setTitle("Modificar Información");
		setBounds(100, 100, 484, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informacion de Tienda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				editorPane = new JEditorPane();
				panel.add(editorPane, BorderLayout.CENTER);
				//String currentContent = editorPane.getText().toString();
			
				
				 
				
				
			}

		}
		{
			
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String vString;
						vString= editorPane.getText().toString();
						try {
				            FileWriter archivo = new FileWriter("archivo.txt");
				            archivo.write(vString);
				           
				            archivo.close();
				           			
				        } catch (IOException w) {
				            JOptionPane.showConfirmDialog(null, "Ocurrió un error al crear o escribir en el archivo! " , "Guardar Info", JOptionPane.WARNING_MESSAGE);
				            
				            w.printStackTrace();
				        }
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
