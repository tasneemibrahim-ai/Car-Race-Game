import javax.swing.*;
import java.awt.*;

public class Obstacles extends Thread {
    public void run() {
        int x_random = (int) (Math.random() * Main.width_of_track);
        int y_random = (int) (Math.random() * Main.length_of_track);
        int count = 0;
        synchronized (this) {
            while (count < 1) {
                if (Main.track[x_random][y_random] == 0) {
                    add_Obstacles(x_random, y_random);
                    count++;
                } else {
                    x_random = (int) (Math.random() * Main.width_of_track);
                    y_random = (int) (Math.random() * Main.length_of_track);
                }
            }
        }

        try {
            Thread.sleep(Main.obstacle_time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        remove_Obstacles(x_random, y_random);

    }

    public synchronized void add_Obstacles(int x_random, int y_random) {

        Main.track[x_random][y_random] = Main.obstacle;
        System.out.println("obstacle in" + x_random + " " + y_random);
//        JPanel obstaclePanel = new JPanel();
//        obstaclePanel.setSize(50, 26);
//        JLabel obstaclelabel = new JLabel(new ImageIcon("C:\\Users\\Rana\\IdeaProjects\\Operating_system\\src\\obstacle (1).jpg"));
//        obstaclePanel.add(obstaclelabel);
//        obstaclePanel.setLocation(y_random*50, x_random*88);
//        Color color = Color.decode("#757577");
//        obstaclePanel.setBackground(color);
//        GameGUI.background.add(obstaclePanel);
    }

    public synchronized void remove_Obstacles(int x_random, int y_random) {

        Main.track[x_random][y_random] = 0;
//        for (int i = 0; i < GameGUI.background.getComponentCount(); i++) {
//            java.awt.Component comp = GameGUI.background.getComponent(i);
//            if (comp.getX() == x_random && comp.getY() == y_random) {
//                GameGUI.background.remove(comp);
//                break;
//            }
//        }

//        GameGUI.background.revalidate();
    }
}



