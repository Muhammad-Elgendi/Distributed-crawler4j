package jadeapplication;

import java.io.*;

import java.net.Socket;
import java.util.Base64;
import java.util.Properties;

/**
 * Class Whois
 *
 * @author Erik C. Thauvin (erik@skytouch.com)
 * @version 1.0.2
 */
public class Whois {

    /**
     * Method main
     *
     * The Truth is Out There!
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Display usage if there are no command line arguments
        if (args.length < 1) {
            System.out.println("Usage: java Whois query[@<whois.server>]");

            return;
        }

        // Default server is whois.geektools.com
        String server = "whois.geektools.com";

        // Default server port is 43
        int port = 43;

//		// Load the properties file.
//		try
//		{
//			final FileInputStream in = new FileInputStream("Whois.properties");
//			final Properties app = new Properties();
//
//			app.load(in);
//
//			// Get the server property
//			server = (app.getProperty("server", server));
//
//			// Get the port property
//			try
//			{
//				port = Integer.parseInt(app.getProperty("port"));
//			}
//			catch (NumberFormatException e)
//			{
//				// Do nothing!
//			}
//
//			in.close();
//		}
//		catch (FileNotFoundException e)
//		{
//			// Do nothing!
//		}
//		catch (IOException e)
//		{
//			System.err.println("Whois: an error occurred while loading the properties file: " + e);
//		}
        // Build the whois query using command line arguments
        final StringBuffer buff = new StringBuffer(args[0]);

        for (int i = 1; i < args.length; i++) {
            buff.append(" " + args[i]);
        }

        // Convert string buffer to string
        String query = buff.toString();

        // The whois server can be specified after "@"
        // e.g.: query@whois.networksolutions.com
        final int at = query.lastIndexOf("@");
        final int len = query.length();

        if ((at != -1)) {
            // Remove the @ if last character in query
            // e.g.: john@doe.com@
            if (at == (len - 1)) {
                query = query.substring(0, len - 1);
            } else {
                // The whois server is specified after "@"
                server = query.substring(at + 1, len);
                // The whois query is specified before "@"
                query = query.substring(0, at);
            }
        }

        try {
            // Establish connection to whois server & port
            final Socket connection = new Socket(server, port);
            final PrintStream out
                    = new PrintStream(connection.getOutputStream());
            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line = "";

            // Send the whois query
            out.println(query);
            // Display the whois server's address & port
            System.out.println("[" + server + ":" + port + "]");

            // Read/display the query's result
            while (in.readLine() != null) {
                line += "\n" + in.readLine();
            }
            in.close();
            System.out.println(line + "\n");
            if (line.contains("has no information for that domain")) {
                System.out.println("Domain is available");
            } else {
                System.out.println("Domain isn't available");
            }

        } catch (java.net.UnknownHostException e) {
            // Unknown whois server
            System.err.println("Whois: unknown host: " + server);

            return;
        } catch (IOException e) {
            // Could not connect to whois server
            System.err.println("Whois: " + e);

            return;
        }
    }

    public static boolean isAvailable(String query) throws IOException {

        // Default server is whois.geektools.com
        String server = "whois.geektools.com";

        // Default server port is 43
        int port = 43;

        // The whois server can be specified after "@"
        // e.g.: query@whois.networksolutions.com
        final int at = query.lastIndexOf("@");
        final int len = query.length();

        if ((at != -1)) {
            // Remove the @ if last character in query
            // e.g.: john@doe.com@
            if (at == (len - 1)) {
                query = query.substring(0, len - 1);
            } else {
                // The whois server is specified after "@"
                server = query.substring(at + 1, len);
                // The whois query is specified before "@"
                query = query.substring(0, at);
            }
        }

        // Establish connection to whois server & port
        final Socket connection = new Socket(server, port);
        final PrintStream out
                = new PrintStream(connection.getOutputStream());
        final BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String line = "";

        // Send the whois query
        out.println(query);

        // Read/display the query's result
        while (in.readLine() != null) {
            line += in.readLine();
        }
        in.close();
        return line.contains("has no information for that domain");
    }

    /**
     * Extracts the domain name from {@code url} by means of String manipulation
     * rather than using the {@link URI} or {@link URL} class.
     *
     * @param url is non-null.
     * @return the domain name within {@code url}.
     */
    public static String getUrlDomainName(String url) {
        String domainName = url;

        int index = domainName.indexOf("://");

        if (index != -1) {
            // keep everything after the "://"
            domainName = domainName.substring(index + 3);
        }

        index = domainName.indexOf('/');

        if (index != -1) {
            // keep everything before the '/'
            domainName = domainName.substring(0, index);
        }

        // check for and remove a preceding 'www'
        // followed by any sequence of characters (non-greedy)
        // followed by a '.'
        // from the beginning of the string
        domainName = domainName.replaceFirst("^www.*?\\.", "");

        return domainName;
    }

    public static String objectToString(Serializable obj) throws IOException {
        String serializedObject = "";
        // serialize the object

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream so = new ObjectOutputStream(bo);
        so.writeObject(obj);
        so.flush();
        serializedObject = bo.toString();
        return serializedObject;
    }

    public static Object stringToObject(String str) throws IOException, ClassNotFoundException {
        byte b[] = str.getBytes();
        ByteArrayInputStream bi = new ByteArrayInputStream(b);
        ObjectInputStream si = new ObjectInputStream(bi);
        return si.readObject();
    }
    
      /** Read the object from Base64 string. */
   public static Object fromString( String s ) throws IOException ,
                                                       ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream( 
                                        new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
   }

    /** Write the object to a Base64 string. */
    public static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray()); 
    }
}
