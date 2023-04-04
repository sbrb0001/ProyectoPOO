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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Comprar Componentes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuVenta menu = new MenuVenta();
				menu.setModal(true);
				menu.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

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
