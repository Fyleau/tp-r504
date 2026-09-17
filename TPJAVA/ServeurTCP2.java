import java.io.*;
import java.net.*;

public class ServeurTCP2
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket socketserver = new ServerSocket(2016);
			System.out.println("Serveur TCP2 en attente de connexions sur le port 2016...");

			while (true)
			{
				Socket socket = socketserver.accept();
				System.out.println("Connexion d'un client");

				DataInputStream dIn = new DataInputStream(socket.getInputStream());
				System.out.println("Message: " + dIn.readUTF());

				socket.close();
			}
		}
		catch (Exception ex)
		{
			System.out.println("erreur !");
			ex.printStackTrace();
		}
	}
}
