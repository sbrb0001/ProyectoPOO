package servidor;

import java.io.*;
import java.net.*;

public class Server extends Thread//esta clase es un hilo
{
	
public static void main (String args[])
  {
    ServerSocket sfd = null;
    try
    {
      sfd = new ServerSocket(6000);
    }
    catch (IOException ioe)
    {
      System.out.println("Comunicaci�n rechazada."+ioe);
      System.exit(1);
    }

    while (true)
    {
      try
      {
        Socket nsfd = sfd.accept();//aceptando cualquier peticion
        System.out.println("Conexion aceptada de: "+nsfd.getInetAddress());
        ObjectInputStream FlujoLectura = new ObjectInputStream(nsfd.getInputStream());
        ObjectOutputStream esc= new ObjectOutputStream(new FileOutputStream(new File("tienda_respaldo.dat")));
        ////String linea = FlujoLectura.readUTF();
        ////String text = "";//esta parte has que se mande a reporte de clientes
        /*if (!linea.equals(""))
 	     {
          text = text+" "+ linea;
          
          System.out.println(text);
  	   }*/
        
        int bytes;
        
        try {
        	while ((bytes=FlujoLectura.read())!=-1) {
				esc.write(bytes);
				FlujoLectura.close();
				esc.close();
			}
        } catch(IOException e)
        {
            System.out.println("Error: "+e);
          }
      
      } catch(IOException ioe)
      {
        System.out.println("Error: "+ioe);
      }
    }
  }


}

