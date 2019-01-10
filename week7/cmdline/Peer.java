package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * P7.20
 * Peer for a simple client-server application.
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException {
    	this.name = nameArg;
    	this.sock = sockArg;
    	this.in = new BufferedReader(new InputStreamReader(sockArg.getInputStream()));
    	this.out = new BufferedWriter(new OutputStreamWriter(sockArg.getOutputStream()));
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
    	try {
    		String line = this.in.readLine();
			while (line != null) {
                if (line.equals(EXIT)) {
                    shutDown();
                    line = null;
                }
				System.out.println("Other: " + line);
				line = this.in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
    	try {
    		String input = "Connected";
    		while (input != null) {
    			input = readString();
    			if (!input.equals(EXIT)) {
    				this.out.write(input);
    				this.out.newLine();
    				this.out.flush();
    			} else {
    				this.out.write("Exit confirmed.");
    	    		System.out.println("System shutting down.");
    				shutDown();
    				input = null;
    			}
    		}
    	
    	
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * Closes the connection, the sockets will be terminated.
     */
    public void shutDown() {
    	try {
	    	sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**  returns name of the peer object.*/
    public String getName() {
        return name;
    }

    /** read a line from the default input. */
    static public String readString() {
        //System.out.print());
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
