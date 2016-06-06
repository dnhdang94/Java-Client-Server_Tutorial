package socket_connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketConnection {
	
	private static Socket socket;

	public static void main(String[] args) {
		socket = new Socket();
		if (socket == null) {
			System.out.println("Can not create socket!");
			return;
		}
		InetAddress addr = null;
		InetSocketAddress sockAddr = null;
		try {
			addr = InetAddress.getByName(args[1]);
			sockAddr = new InetSocketAddress(addr, 80);
			socket.connect(sockAddr);
			System.out.println("Your address: " + socket.getLocalSocketAddress().toString() + ", port: " + socket.getLocalPort());
			System.out.println("Connect to: " + socket.getRemoteSocketAddress().toString() + ", port: " + socket.getPort());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
