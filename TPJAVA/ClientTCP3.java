import java.io.*;
import java.net.*;

public class ClientTCP3
{
	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Usage: java ClientTCP3 <message>");
			return;
		}

		try
		{
			Socket socket = new Socket("localhost", 2016);

			DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
			DataInputStream dIn = new DataInputStream(socket.getInputStream());

			// Envoi du message passé en paramètre
			dOut.writeUTF(args[0]);

			// Lecture et affichage de la réponse inversée
			String reponse = dIn.readUTF();
			System.out.println("Réponse inversée du serveur : " + reponse);

			socket.close();
		}
		catch (Exception ex)
		{
			System.out.println("erreur !");
			ex.printStackTrace();
		}
	}
}
