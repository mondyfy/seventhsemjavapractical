package com.sandip.seventhsem;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ClientChat {

	public static void main(String[] args) throws UnknownHostException, IOException {
		@SuppressWarnings("resource")
		//create a socket to connect to the server
		Socket socket = new Socket("localhost", 8000);

		//create an input stream to retrieve data from the server
		DataInputStream fromServer = new DataInputStream(socket.getInputStream());

		//create an output stream to send data to the server
		DataOutputStream toServer = new
		DataOutputStream(socket.getOutputStream());

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String msg;

		while (true) {
			System.out.println("(Client) Enter message to server:");
			msg = sc.nextLine();
			toServer.writeUTF(msg);

			msg = fromServer.readUTF();
			System.out.println("Server:" + msg);
			}
	}

}