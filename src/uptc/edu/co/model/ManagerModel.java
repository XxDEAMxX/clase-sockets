package uptc.edu.co.model;

import uptc.edu.co.pojos.Square;
import uptc.edu.co.presenter.ContractPlanes;

import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ManagerModel implements ContractPlanes.Model {
    private ContractPlanes.Presenter presenter;
    private Square square;


    public ManagerModel() {
        square = new Square();
        positionRandom();

    }

    public void positionRandom() {
        square.setX(Math.random() * 750);
        square.setY(Math.random() * 550);
    }
    @Override
    public void setPresenter(ContractPlanes.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void starThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    getSquare();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        });
        thread.start();
    }

    @Override
    public Square search(Point point) {
        Rectangle rectangle = new Rectangle( (int)square.getX(), (int)square.getY(), 50, 50);
        if(rectangle.contains(point)){
            return square;
        }
        return null;
    }

    @Override
    public void getSquare() {
        presenter.getSquare(square);
    }

    public void runre(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.start();
    }

}