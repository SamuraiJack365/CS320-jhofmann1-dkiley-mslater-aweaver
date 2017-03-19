package xyz.jhofmann1.cs320.main;

import java.util.Scanner;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8090);

		// Create and register a webapp context
		WebAppContext handler = new WebAppContext();
		handler.setContextPath("/jhofmann1");
		handler.setWar("./war"); // web app is in the war directory of the project
		server.setHandler(handler);
		
		// Use 20 threads to handle requests
		server.setThreadPool(new QueuedThreadPool(20));
		
		// Start the server
		server.start();
		
		// Wait for the user to type "quit"
		System.out.println("Web server started, type quit to shut down");
		Scanner keyboard = new Scanner(System.in);
		while (keyboard.hasNextLine()) {
			String line = keyboard.nextLine();
			if (line.trim().toLowerCase().equals("quit")) {
				break;
			}
		}
		
		System.out.println("Shutting down...");
		keyboard.close();
		server.stop();
		server.join();
		System.out.println("Server has shut down, exiting");
	}
}
