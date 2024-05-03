package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DefaultServerSocket extends Thread {
    
    private int port_no;
    private ServerSocket server;

    public DefaultServerSocket(int port_no) {

        this.port_no = port_no;

        try {
            this.server = new ServerSocket(this.port_no);
        } catch (IOException e) {
            System.err.println("Error: Cannot listen on port: " + this.port_no);
            System.exit(1);
        }
    }
    
    @Override
    public void run() {



        while (true) {

            Socket clientSocket = null;
            try {
                
                clientSocket = server.accept();
                System.out.println("Connection Established!");

            } catch (IOException e) {
                System.err.println("Error: Could not connect to the client");
                System.exit(1);
            }

            new DefaultSocketClient(clientSocket).start();
        }
    }
}