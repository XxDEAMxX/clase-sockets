package uptc.edu.co.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import netscape.javascript.JSObject;
import uptc.edu.co.pojos.RectangleM;
import uptc.edu.co.pojos.Square;
import uptc.edu.co.view.MyFrame;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Client {

    Connection connection;

    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    String aux = "";

    RectangleM rectangle;
    Gson gson;

    MyFrame myFrame;
    public Client(String host, int port){
        gson = new Gson();
        myFrame = new MyFrame();
        init(host, port);
        receive();





    }

    public void receive(){
        try {
            dataInputStream = new DataInputStream(connection.socket.getInputStream());

            System.out.println("esperando datos");
            while (true) {
                try {
                    aux = dataInputStream.readUTF();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(aux);
                rectangle = gson.fromJson(aux, RectangleM.class);
                setRectangle(rectangle);
                //dataInputStream.close();
            }
            } catch(IOException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

    public void setRectangle(RectangleM rectangle){
        myFrame.setRectangle(rectangle);
    }

    public void init(String host, int port) {
        connection = new Connection();
        connection.setHost(host);
        connection.setPort(port);
        connection.setType("client");
        connection.connect();
    }

}
