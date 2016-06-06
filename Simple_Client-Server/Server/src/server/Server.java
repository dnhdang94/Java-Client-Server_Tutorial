package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static final String SERVER_NAME = "r3df0x!74116";
	public static final int PUB_PORT = 8888;

	private static ServerSocket myService = null;
	private static Socket client = null;
	
	private static BufferedReader in = null;
	private static PrintWriter out = null;
	
	public static void main(String[] args) {
		try {
			myService = new ServerSocket(PUB_PORT);
			System.out.println("Server starts at: " + myService.getLocalSocketAddress() + ", port: " + myService.getLocalPort());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			client = myService.accept();
			System.out.println("New connection from: " + client.getInetAddress().toString() + ", port: " + client.getPort());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			try {
				String line = in.readLine();
				out.println(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
