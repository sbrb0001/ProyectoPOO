package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;

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
import lógico.Empleado;
import lógico.TiendaComp;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JEditorPane;

public class Principal extends JFrame {

	private JPanel contentPane;
	private  Dimension dim;
	static Socket sfd = null;
	static ObjectInputStream EntradaSocket;
	static DataOutputStream SalidaSocket;
	
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
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FileOutputStream tienda2;
				ObjectOutputStream tiendaWrite;
				try {
					tienda2 = new FileOutputStream("tienda.dat");
					tiendaWrite = new ObjectOutputStream(tienda2);
					tiendaWrite.writeObject(TiendaComp.getInstance());
				}catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
			}
 			
		});
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
		
	/*	JMenuItem mntmNewMenuItem = new JMenuItem("Combos Disponibles");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentaCombo menuCombo = new VentaCombo();
				menuCombo.setModal(true);
				menuCombo.setVisible(true);
			}
		});*/
		
	//	mnNewMenu_1.add(mntmNewMenuItem);
		
		
		
		
		JMenu mnNewMenu_3 = new JMenu("Ayuda");
		
		if (TiendaComp.getEmpleadoLogeado()!=null) {
			if(TiendaComp.getEmpleadoLogeado().getCargo().equalsIgnoreCase("Administrador")) {
				mnNewMenu_3.setVisible(false);
			}else {
				mnNewMenu_3.setVisible(true);	
			}
		}
		if (TiendaComp.getClienteLogeado()!=null) {
			
			mnNewMenu_3.setVisible(true);	
			
		}
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Contáctanos");
		mnNewMenu_3.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Vias De Contacto");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//en esta parte se utilizo archivos para leer la info de la tienda
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Reportar Problema");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
			    {
					Reporte menu = new Reporte();
					menu.setVisible(true);
			      sfd = new Socket("122.0.0.1",6000);
			      ObjectInputStream aux = new ObjectInputStream(new FileInputStream(new File("tienda.dat")));
			      SalidaSocket = new DataOutputStream((sfd.getOutputStream()));
			      
			     //EntradaSocket= new ObjectInputStream((sfd.getInputStream()));
			      //String ejemplo = new String("Esto es una prueba nueva");
			      int bytes;
			      try
			      {
			        //SalidaSocket.writeUTF(ejemplo);
			       // SalidaSocket.flush();
			    		while ((bytes=aux.read())!=-1) {
			    			SalidaSocket.write(bytes);
							SalidaSocket.flush();
						}
			      }
			      catch (IOException ioe)
			      {
			        System.out.println("Error: "+ioe);
			      }
			    }
			    catch (UnknownHostException uhe)
			    {
			      System.out.println("No se puede acceder al servidor.");
			      System.exit(1);
			    }
			    catch (IOException ioe)
			    {
			      System.out.println("Comunicaci�n rechazada.");
			      System.exit(1);
			    }
			
			}
			
			
			
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Acerca De ");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenu administracionmeNu = new JMenu("Administración");
		//pa que no vea un cliente o empleado que no sea administrador
		
	
		
		if (TiendaComp.getEmpleadoLogeado()!=null) {
			if(TiendaComp.getEmpleadoLogeado().getCargo().equalsIgnoreCase("Administrador")) {
				administracionmeNu.setVisible(true);
			}else {
				administracionmeNu.setVisible(false);	
			}
		}
		if (TiendaComp.getClienteLogeado()!=null) {
			
				administracionmeNu.setVisible(false);	
			
		}
		menuBar.add(administracionmeNu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crear Componente");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarComponente menu = new RegistrarComponente();
				menu.setModal(true);
				menu.setVisible(true);
			}
		
		});
		administracionmeNu.add(mntmNewMenuItem_2);
		
		JMenuItem Crearcomb = new JMenuItem("Crear Combo");
		Crearcomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCombo combo = new CrearCombo();
				combo.setModal(true);
				combo.setVisible(true);
			}
		});
		administracionmeNu.add(Crearcomb);
		
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado de Clientes");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoCliente menu = new ListadoCliente();
				menu.setModal(true);
				menu.setVisible(true);
			}
		});
		administracionmeNu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmListaFact = new JMenuItem("Listado de Facturas");
		
		mntmListaFact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaFacturas menu = new ListaFacturas();
				menu.setModal(true);
				menu.setVisible(true);
			}
		});
		administracionmeNu.add(mntmListaFact);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Componentes Vendidos");
		administracionmeNu.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_2 = new JMenu("Configuracion Soporte");
		administracionmeNu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Reportes");
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar Información");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Cerrar Sesión");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login =new Login();
				dispose();
				login.setVisible(true);
			}
		});
		mntmNewMenuItem_11.setSelected(true);
		menuBar.add(mntmNewMenuItem_11);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
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
