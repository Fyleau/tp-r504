import java.io.*;
import java.net.*;

public class ServeurUDP
{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket sock = new DatagramSocket(1234);
			while (true)
			{
				System.out.println("-Waiting data");
				byte[] buffer = new byte[1024];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				sock.receive(packet);

				String str = new String(packet.getData(), 0, packet.getLength());
				System.out.println("Reçu : " + str);

				// Renvoi de la chaîne au client (écho)
				InetAddress clientAddr = packet.getAddress();
				int clientPort = packet.getPort();
				DatagramPacket reponse = new DatagramPacket(packet.getData(), packet.getLength(), clientAddr, clientPort);
				sock.send(reponse);
			}
		}
		catch (Exception ex)
		{
			System.out.println("erreur !");
			ex.printStackTrace();
		}
	}
}
