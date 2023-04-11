package Visual;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;
import java.awt.Dialog.ModalExclusionType;


public class Reporte extends Frame implements ActionListener
{
  static Socket sfd = null;
  static DataInputStream EntradaSocket;
  static DataOutputStream SalidaSocket;
  static TextField salida;
  static TextArea entrada;  
  String texto=null;

  public Reporte()
  {
	
  	setBackground(new Color(255, 255, 240));
    setTitle("Chat Reportes");
    setSize(357,250);
    salida = new TextField(30);
    salida.addActionListener(this);
	
    entrada = new TextArea();
    entrada.setBackground(new Color(240, 248, 255));
    entrada.setEditable(false);
	
    add("South",salida);
    add("Center", entrada);
    setVisible(true);
  }

  public static void main(String[] args)
  {
	  JOptionPane.showMessageDialog(null, "Los reportes se responderan via Email!", "Aviso", JOptionPane.WARNING_MESSAGE);
	  Reporte reporte = new Reporte();
    try
    {
      sfd = new Socket("122.0.0.1",6000);
      EntradaSocket = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
      SalidaSocket = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
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
    while (true)
    {
      try
      {
    	
        String linea = EntradaSocket.readUTF();
        entrada.append(linea+"\n");
      }
      catch(IOException ioe)
      {
	System.exit(1);
      }
    }
  }
  
  public void actionPerformed (ActionEvent e)
  {
	  
    texto = salida.getText();
    salida.setText("");
    try
    {
      SalidaSocket.writeUTF(texto);
      SalidaSocket.flush();
    }
    catch (IOException ioe)
    {
      System.out.println("Error: "+ioe);
    }
  }
  
  public boolean handleEvent(Event e)
  {
	    if ((e.target == this) && (e.id == Event.WINDOW_DESTROY))
	    {
	      if (sfd != null)
	      {
		try
		{
		  sfd.close();
		}
		catch (IOException ioe)
		{
		  System.out.println("Error: "+ioe);
		}
		this.dispose();
	      }
	    }
	    return true;
	  }
	}

