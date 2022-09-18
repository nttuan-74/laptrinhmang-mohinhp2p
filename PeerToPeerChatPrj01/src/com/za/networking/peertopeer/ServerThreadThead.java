package com.za.networking.peertopeer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class ServerThreadThead extends Thread {
   private ServerThead serverThead;
   private Socket socket;
   private PrintWriter printWriter;
   public ServerThreadThead(Socket socket, ServerThead serverThead) {
	   this.serverThead = serverThead;
	   this.socket = socket;
   }
   public void run() {
	   try {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.printWriter = new PrintWriter(socket.getOutputStream(), true);
		while(true) serverThead.sendMessage(bufferedReader.readLine());
	} catch (Exception e) { serverThead.getServerThreads().remove(this);
	}
   }
	public PrintWriter getPrintWriter() {return printWriter; }
}

