import uptc.edu.co.model.Client;
import uptc.edu.co.model.Connection;
import uptc.edu.co.model.Server;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        if (args.length == 3) {
            System.out.println(args[0] + " " + args[1] + " " + args[2]);

        String typeConnection = args[0];
        String host = args[1];
        int port = Integer.parseInt(args[2]);

        if(typeConnection.equalsIgnoreCase("server")) {
            Server server = new Server(host, port);
        }

        if(typeConnection.equalsIgnoreCase("client")) {
            Client client = new Client(host, port);
        }
        }else {
            System.out.println("parametros no completos");
        }
    }
}
