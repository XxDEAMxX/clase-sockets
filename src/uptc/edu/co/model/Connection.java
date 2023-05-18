package uptc.edu.co.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {

    protected ServerSocket serverSocket;

    protected Socket socket;

    private String type;

    private String host;

    private int port;


    public Connection() {
    }

    public void connect() {
        try {
            switch (type) {
                case "server": {
                    serverSocket = new ServerSocket(port);
                    socket = new Socket();
                    break;
                }
                case "client": {
                    socket = new Socket(host, port);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }



}
