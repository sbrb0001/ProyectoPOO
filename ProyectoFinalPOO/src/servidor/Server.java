package servidor;

import java.io.*;
import java.net.*;

import Visual.LecturaRep;
import Visual.Principal;

public class Server extends Thread//esta clase es un hilo
{
	
public static void main (String args[])
  {
	LecturaRep mandarTextoPrincipal=null;
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
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
       
        int bytes;
        
        try {
        	while ((bytes=FlujoLectura.read())!=-1) {
				esc.write(bytes);
				buffer.write(bytes);
				FlujoLectura.close();
				esc.close();
			}
        	String data = buffer.toString();
        	mandarTextoPrincipal.reportesss(data);
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

