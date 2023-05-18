package uptc.edu.co.presenter;
import uptc.edu.co.model.Client;
import uptc.edu.co.model.ManagerModel;
import uptc.edu.co.view.MyFrame;

import java.net.ServerSocket;
import java.net.Socket;

public class ManagerGeneral {
    ContractPlanes.View view;
    ContractPlanes.Model modelPlanes;
    ContractPlanes.Presenter presenter;


    protected ServerSocket serverSocket;

    protected Socket socket;

    private String type;

    private String host;

    private int port;


    public ManagerGeneral(){
        runProject();
    }
    private void createMVP(){
        view = new MyFrame();
        if(type.equalsIgnoreCase("server")){
            modelPlanes = new ManagerModel();

        }

        presenter = new Presenter(this);
        view.setPresenter(presenter);
        modelPlanes.setPresenter(presenter);
        presenter.setView(view);
        presenter.setModel(modelPlanes);
    }
    public void runProject(){
        createMVP();
        view.start();
        modelPlanes.starThread();
    }
}
