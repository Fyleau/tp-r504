import java.io.*;
import java.net.*;

public class Clienthttp
{
	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Usage: java Clienthttp <nom_de_domaine>");
			return;
		}

		try
		{
			String host = args[0];
			int port = 80;

			// Ouverture de la socket TCP sur le port 80 de l'hôte
			Socket socket = new Socket(host, port);

			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			InputStreamReader isw = new InputStreamReader(socket.getInputStream());

			BufferedWriter bufOut = new BufferedWriter(osw);
			BufferedReader bufIn = new BufferedReader(isw);

			// Requête HTTP 1.0
			String request = "GET / HTTP/1.0\r\nHost: " + host + "\r\n\r\n";
			bufOut.write(request, 0, request.length());
			bufOut.flush();

			// Lecture de la réponse ligne par ligne
			String line = bufIn.readLine();
			while (line != null)
			{
				System.out.println(line);
				line = bufIn.readLine();
			}

			bufIn.close();
			bufOut.close();
			socket.close();
		}
		catch (Exception ex)
		{
			System.out.println("erreur !");
			ex.printStackTrace();
		}
	}
}
