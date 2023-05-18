package uptc.edu.co.presenter;

import uptc.edu.co.model.Client;
import uptc.edu.co.model.Server;
import uptc.edu.co.pojos.Square;

import java.awt.*;

public class Presenter implements ContractPlanes.Presenter{
    private ContractPlanes.View view;
    private ContractPlanes.Model model;
    private uptc.edu.co.presenter.ManagerGeneral managerGeneral;
    public Presenter(uptc.edu.co.presenter.ManagerGeneral managerGeneral){
        this.managerGeneral = managerGeneral;
    }
    @Override
    public void setView(ContractPlanes.View view) {
        this.view = view;
    }
    @Override
    public void setModel(ContractPlanes.Model model) {
        this.model = model;
    }
    @Override
    public Square search(Point point) {
        return model.search(point);
    }

    @Override
    public void getSquare(Square square) {
        view.getSquare(square);
    }

    public static void main(String[] args) {
        new ManagerGeneral();
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
