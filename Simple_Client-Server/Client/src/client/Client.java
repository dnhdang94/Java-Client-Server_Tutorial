package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static final int SERVER_PORT = 8888;
	
	private static Socket socket = null;
	
	private static BufferedReader in = null;
	private static PrintWriter out = null;

	public static void main(String[] args) {
		InetAddress addr = null;
		SocketAddress sockAddr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sockAddr = new InetSocketAddress(addr, SERVER_PORT);
		socket = new Socket();
		if (socket == null) {
			System.out.println("Can not create socket!");
			return;
		}
		try {
			socket.connect(sockAddr);
			System.out.println("Your address is: " + socket.getLocalSocketAddress() + ", port: " + socket.getLocalPort());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		String line = null;
		while (true) {
			System.out.print("Enter your string: ");
			line = sc.nextLine();
			out.println(line);
			try {
				line = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Server sends data back: " + line);
		}
	}

}
