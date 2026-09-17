import java.io.*;
import java.net.*;

public class ClientTCP2
{
	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Usage: java ClientTCP2 <message>");
			return;
		}

		try
		{
			Socket socket = new Socket("localhost", 2016);
			DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

			dOut.writeUTF(args[0]);

			dOut.close();
			socket.close();
		}
		catch (Exception ex)
		{
			System.out.println("erreur !");
			ex.printStackTrace();
		}
	}
}
