package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;

import lógico.Combo;
import lógico.Componente;
import lógico.TiendaComp;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;

public class Principal extends JFrame {

	private JPanel contentPane;
	private  Dimension dim;

	
	FondoPanel fondo = new FondoPanel();
	public void Principal ()
	{
		this.setContentPane(fondo);
		getComponents();
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		TiendaComp.getInstance().GenerarComponentes();
		ArrayList<Componente> losComponentes = TiendaComp.getInstance().getMisComponentes();
		Combo combo = new Combo(losComponentes, "Vuelta a Clases", 1);
		TiendaComp.getInstance().InsertarCombo(combo);
		setTitle("TecnoShop");
		setBackground(new Color(176, 224, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Componentes");
		menuBar.add(mnNewMenu);

		JMenuItem mntmListadoComponentes = new JMenuItem("Componentes Disponibles");
		mntmListadoComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoComponente list = new ListadoComponente();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnNewMenu.add(mntmListadoComponentes);

		JMenu mnNewMenu_1 = new JMenu("Comprar");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmComprarComp = new JMenuItem("Comprar Componentes");
		mntmComprarComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuVenta menu = new MenuVenta();
				menu.setModal(true);
				menu.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmComprarComp);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Combos Disponibles");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentaCombo menuCombo = new VentaCombo();
				menuCombo.setModal(true);
				menuCombo.setVisible(true);
			}
		});
		
		mnNewMenu_1.add(mntmNewMenuItem);
		
		
		
		
		JMenu mnNewMenu_3 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Contáctanos");
		mnNewMenu_3.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Vias De Contacto");
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Chat Soporte");
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Acerca De ");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_2 = new JMenu("Administración");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crear Componente");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarComponente menu = new RegistrarComponente();
				menu.setModal(true);
				menu.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado de Clientes");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmListaFact = new JMenuItem("Listado de Facturas");
		
		mntmListaFact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaFacturas menu = new ListaFacturas();
				menu.setModal(true);
				menu.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmListaFact);
		
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Ganancias");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Componentes Vendidos");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Chat Clientes");
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Salir");
		mntmNewMenuItem_11.setSelected(true);
		menuBar.add(mntmNewMenuItem_11);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
	}
	public class FondoPanel extends JPanel{
		private Image imagen;
		@Override
		public void paint(Graphics g) {

			imagen = new ImageIcon(getClass().getResource("/Imagen/II.jpeg")).getImage();
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

			setOpacity(0);
			super.paint(g);


		}
	}
}
