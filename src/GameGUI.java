import javax.swing.*;
import java.awt.*;

public class GameGUI extends Thread{
    public  static JFrame fr;
    static JLabel background = new JLabel("",new ImageIcon("C:/Users/Rana/IdeaProjects/Operating_system/src/race.jpg"),JLabel.CENTER);

    @Override
    public void run() {
        fr = new JFrame("Car Game");
        fr.setLayout(null);
        background.setBounds(0,0,1502,746);
        fr.add(background);
        JPanel[] carpanels=new JPanel[Main.number_of_car];
        for (int i = 0; i < Main.number_of_car; i++) {
            JPanel carPanel = new JPanel();
            carPanel.setSize(200, 100);
            carpanels[i]=carPanel;
        }
        JLabel[] carlabels=new JLabel[Main.number_of_car];
        for (int i = 0; i < Main.number_of_car; i++) {
            JLabel carlabel = new JLabel(new ImageIcon("C:\\Users\\Rana\\IdeaProjects\\Operating_system\\src\\car1-removebg-preview.png"));
            carlabels[i]=carlabel;
            carpanels[i].add(carlabels[i]);
            carpanels[i].setLocation(Main.car_id.get(i).getPosition_y()*50,Main.car_id.get(i).getPosition_x()*100);
            Color color=Color.decode("#757577");
            carpanels[i].setBackground(color);
            background.add(carpanels[i]);
        }
        fr.setSize(1600, 746);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true){
            for (int i = 0; i < Main.number_of_car; i++) {
                carpanels[i].setLocation(Main.car_id.get(i).getPosition_y()*50,Main.car_id.get(i).getPosition_x()*88);

            }
//            for (int i = 0; i <Main.length_of_track ; i++) {
//                for (int j = 0; j < Main.width_of_track; j++) {
//                    if (Main.track[j][i]==1000){
//                        JPanel obstaclePanel = new JPanel();
//                        obstaclePanel.setSize(728, 368);
//                      JLabel obstaclelabel = new JLabel(new ImageIcon("C:\\Users\\Rana\\IdeaProjects\\Operating_system\\src\\obstacle.jpg"));
//                      obstaclePanel.add(obstaclelabel);
//                      obstaclePanel.setLocation(j,i);
//                      Color color=Color.decode("#757577");
//                      obstaclePanel.setBackground(color);
//                       background.add(obstaclePanel);
//                    }
                }
            }
        }
//    }
//
//}


