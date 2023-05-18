package uptc.edu.co.presenter;
import uptc.edu.co.pojos.Square;

import java.awt.*;

public interface ContractPlanes {
    public interface View{
        void setPresenter(Presenter presenter);
        void start();
        void getSquare(Square square);

    }
    public interface Model{
        void setPresenter(Presenter presenter);
        void starThread();
        Square search (Point point);
        void getSquare();
        void runre();
    }
    public interface Presenter{
        void setView(View view);
        void setModel(Model model);
        Square search(Point point);
        void getSquare(Square square);

    }
}
