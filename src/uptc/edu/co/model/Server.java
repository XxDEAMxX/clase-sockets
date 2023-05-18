package uptc.edu.co.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Server {

    Connection connection;
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    public Server(String host, int port){
        init(host, port);
        System.out.println("estado del server "+connection.getHost());
        sedInfo();
    }
    public void init(String host, int port) {
        connection = new Connection();
        connection.setHost(host);
        connection.setPort(port);
        connection.setType("server");
        connection.connect();
    }

    public void sedInfo(){
        try {
            System.out.println("esperando");
            socket = connection.serverSocket.accept();
             System.out.println("conectado");
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            int x = 0;
            /*for (int i = 0; i < 10; i++)*/while(true){
                dataOutputStream.writeUTF("{" + (char)34+ "x"+(char)34+": "+ x++ + ", "+(char)34+"y"+(char)34+": 100, "+(char)34+"width"+(char)34+": 30, "+(char)34+"height"+(char)34+": 30}");
                System.out.println("{" + (char)34+ "x"+(char)34+": "+ x++ + ", "+(char)34+"y"+(char)34+": 100, "+(char)34+"width"+(char)34+": 30, "+(char)34+"height"+(char)34+": 30}");
                if(x>800){
                    x=0;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //dataOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
