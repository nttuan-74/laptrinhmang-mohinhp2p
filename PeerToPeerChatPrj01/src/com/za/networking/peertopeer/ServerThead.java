package com.za.networking.peertopeer;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;
public class ServerThead extends Thread {
	private ServerSocket serverSocket;
	private Set<ServerThreadThead> serverThreadThreads = new HashSet<ServerThreadThead>();
	public ServerThead(String portNumb) throws IOException {
		serverSocket = new ServerSocket(Integer.valueOf(portNumb));
	}
	public void run() {
		try {
			while (true) {
				ServerThreadThead serverThreadThead = new ServerThreadThead(serverSocket.accept(), this);
				serverThreadThreads.add(serverThreadThead);
				serverThreadThead.start();
			}
		} catch (Exception e) { e.printStackTrace();
		}
	}
	void sendMessage(String message) {
		try { serverThreadThreads.forEach(t-> t.getPrintWriter().println(message));
			
		} catch (Exception e) { e.printStackTrace();}
	}
	public Set<ServerThreadThead> getServerThreads (){ return serverThreadThreads; }
}

	


