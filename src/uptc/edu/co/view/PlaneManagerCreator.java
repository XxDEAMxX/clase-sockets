package uptc.edu.co.view;
import uptc.edu.co.pojos.RectangleM;
import uptc.edu.co.pojos.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlaneManagerCreator extends JPanel {

    private RectangleM square;
    private MouseListener mouseListener;
    private MouseMotionListener mouseMotionListener;
    private Boolean pause = true;
    private MyFrame myFrame;
    public PlaneManagerCreator(MyFrame myFrame){
        this.myFrame = myFrame;
        requestFocusInWindow();
        setFocusable(true);
        Controler();
        setVisible(true);
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseMotionListener);
        setBackground(Color.black);
    }

    public void setSquare(RectangleM square){
        System.out.println("aqui");
        this.square = square;
        repaint();
    }

    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(Color.WHITE);
        try {
            int textX = (int) Math.round(square.getX());
            int textY = (int) Math.round(square.getY());
            g2d.drawRect(textX, textY, square.getWidth(),square.getHeight());
        }catch (Exception e){
        }

    }

    Square auxSquare;
    public void Controler(){
        mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if(auxSquare!=null){
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
               ;
                auxSquare = myFrame.getPresenter().search(e.getPoint());
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        mouseMotionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
                    if (auxSquare != null) {
                        auxSquare.setX(e.getX());
                        auxSquare.setY(e.getY());
                    }
                }
            }
            @Override
            public void mouseMoved(MouseEvent e) {}
        };
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke("ESCAPE");
        String actionKey = "escapeAction";
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, actionKey);
        getActionMap().put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pause) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    popupMenu.setPreferredSize(new Dimension(100, 100));
                    JMenuItem reiniciarMenuItem = new JMenuItem("Reiniciar");
                    reiniciarMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
                    reiniciarMenuItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });
                    popupMenu.add(reiniciarMenuItem);
                    JMenuItem salirMenuItem = new JMenuItem("Salir del juego");
                    salirMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
                    salirMenuItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    popupMenu.add(salirMenuItem);
                    popupMenu.show(myFrame, 380, 250);
                } else {

                }
            }
        });
    }
}