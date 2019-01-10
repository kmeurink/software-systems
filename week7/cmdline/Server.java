
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	//Checking for the expected amount of arguments.
    	if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(0);
        }
    	//Establishing server socket
    	//Retrieve serverName
    	String serverName = args[0];
    	int port = 0;
        Socket clientSocket = null;
        ServerSocket s = null;
    	
    	//Retrieve server port.
    	try {
    		port = Integer.parseInt(args[1]);
    	} catch (NumberFormatException e) {
    	    System.out.println(USAGE);
    	    System.out.println("ERROR: port " + args[1]
    	                    + " is not an integer");
    	    System.exit(0);
    	}
    	try {
			s = new ServerSocket(port);
		    System.out.println("Listening on port: " + port);
        } catch (IOException e) {
        	e.printStackTrace();
        }
    	try {
            clientSocket = s.accept();
			System.out.println("Connected");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    	try {
            // create Peer object and start the two-way communication
            Peer server = new Peer(serverName, clientSocket);
            Thread streamInputHandlerS = new Thread(server);
            streamInputHandlerS.start();
            server.handleTerminalInput();
            server.shutDown();
        } catch (IOException e) {
        	e.printStackTrace();
        }
    	
    }

} // end of class Server
