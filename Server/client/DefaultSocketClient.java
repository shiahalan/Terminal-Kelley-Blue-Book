package client;

import java.io.*;
import java.net.Socket;

public class DefaultSocketClient extends Thread {
    
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private BufferedReader stdIn;
    private Socket sock;
    private String strHost;
    private int iPort;
    private CarModelOptionsIO clientFTP;
    private SelectCarOptions clientProtocol;

    public DefaultSocketClient(String strHost, int iPort) {

        this.strHost = strHost;
        this.iPort = iPort;

    }


    public void establishConnection() {
        try {

            this.sock = new Socket(strHost, iPort);
            out = new ObjectOutputStream(sock.getOutputStream());
            in = new ObjectInputStream(sock.getInputStream());
            stdIn = new BufferedReader(new InputStreamReader (System.in));

            clientFTP = new CarModelOptionsIO();
            clientProtocol = new SelectCarOptions();
        }
        catch (IOException e) {
            System.err.println("Error getting IO with connection to host ... ");
            System.exit(1);
        }
    }
    public void handleConnection() {
      Object fromServer, toServer = null;

      try {

          while ((fromServer = in.readObject()) != null) {

              System.out.println(fromServer.toString());

              if (clientProtocol.isAutomobile(fromServer)) {
                  clientProtocol.configureAuto(fromServer);
              }
              System.out.println("Response to Server: ");
              toServer = stdIn.readLine();
              if (toServer.toString().contains(".prop")) {
                  toServer = clientFTP.loadPropertiesFile(toServer.toString());
              }
              if (toServer.toString().contains(".txt")) {
                  toServer = clientFTP.loadTextFile(toServer.toString());
              }

              sendOutput(toServer);
              System.out.println("");

              if (toServer.equals("0")) {
                  break;
              }
          }

          in.close();

      }
      catch (ClassNotFoundException e) {
          System.err.println("Error in downloaded object");
          System.exit(1);
      }
      catch (IOException e) {
          System.err.println("Error in IO stream");
          System.exit(1);
      }

  }

  public void sendOutput(Object obj) {
      try {
          out.writeObject(obj);
      }
      catch (IOException e) {
          System.err.println("Error in IO stream while sending object to host");
          System.exit(1);
      }
  }

  @Override
  public void run() {
      establishConnection();
      handleConnection();
      try {
          out.close();
          stdIn.close();
          sock.close();
      }
      catch (IOException e) {
          System.err.println("Error ending client connection");
          System.exit(1);
      }
  }
  
}