package com.sandip.seventhsem;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerChat {

	public static void main(String[] args) throws IOException {
		//create a server socket
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(8000);
		//listen for client request
		Socket socket = serverSocket.accept();

		//create data input and output streams
		DataInputStream inputFromClient = new
		DataInputStream(socket.getInputStream());
		DataOutputStream outputToClient = new
		DataOutputStream(socket.getOutputStream());

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String msg;

		while (true) {
			msg = inputFromClient.readUTF();
			System.out.println("Client says:" + msg);
			System.out.println("(Server) Enter message to client:");
			msg = sc.nextLine();
			outputToClient.writeUTF(msg);
			}
	}

}
