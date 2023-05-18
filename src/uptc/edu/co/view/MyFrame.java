package uptc.edu.co.view;
import uptc.edu.co.pojos.RectangleM;
import uptc.edu.co.pojos.Square;
import uptc.edu.co.presenter.ContractPlanes;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame implements ContractPlanes.View {
    private ContractPlanes.Presenter presenter;
    private uptc.edu.co.view.PlaneManagerCreator planeManagerCreator;
    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        initComponent();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public void initComponent() {
        planeManagerCreator = new uptc.edu.co.view.PlaneManagerCreator(this);
        add(planeManagerCreator);
    }
    public PlaneManagerCreator getPlaneManagerCreator() {
        return planeManagerCreator;
    }
    public ContractPlanes.Presenter getPresenter() {
        return presenter;
    }

    public void getSquare(Square square){
//        planeManagerCreator.setSquare(square);
    }

    public void setRectangle(RectangleM rectangle){
        planeManagerCreator.setSquare(rectangle);
    }

    @Override
    public void setPresenter(ContractPlanes.Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void start() {
        setVisible(true);
    }
}
