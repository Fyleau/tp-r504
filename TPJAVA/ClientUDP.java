import java.io.*;
import java.net.*;

public class ClientUDP
{
	public static void main(String[] args)
	{
		try
		{
			String s = "Hello World";
			byte[] data = s.getBytes();

			InetAddress addr = InetAddress.getLocalHost();
			System.out.println("adresse=" + addr.getHostName());

			DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1234);
			DatagramSocket sock = new DatagramSocket();
			sock.send(packet);
			System.out.println("Envoyé : " + s);

			// Attente de l'écho du serveur
			byte[] buffer = new byte[1024];
			DatagramPacket packetRecu = new DatagramPacket(buffer, buffer.length);
			sock.receive(packetRecu);

			String recu = new String(packetRecu.getData(), 0, packetRecu.getLength());
			System.out.println("Réponse reçue du serveur : " + recu);

			sock.close();
		}
		catch (Exception ex)
		{
			System.out.println("erreur !");
			ex.printStackTrace();
		}
	}
}
