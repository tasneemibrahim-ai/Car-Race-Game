import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    static int id_winner=-1;
    public static  int number_of_car = 4;
    public static int width_of_track = number_of_car*2; // number_of_car * 2 or 3
    public static int length_of_track = 50;
    public static int[][] track = new int[width_of_track][length_of_track];
    public static ArrayList<Car> car_id=new ArrayList<Car>();
    public static int obstacle = 1000;
    public static int number_obstacle = 5;
    public static int boostZone = 1001;
    public static int number_boostZone = 5;
    static ExecutorService pool = Executors.newFixedThreadPool(2);
    public static int obstacle_time=5000;
    public static int boost_zone_time=5000;
    public static int block_time=5;


    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<number_of_car;i++){
            Car car=new Car();
            car_id.add(car);
        }
        Weather weather=new Weather();
        weather.start();
        Random_Boost_Zones random_boost_zones=new Random_Boost_Zones();
        random_boost_zones.start();
        GameGUI GUI =new GameGUI();
        GUI.start();
        Random_Obstacles random_obstacles=new Random_Obstacles();
        random_obstacles.start();
        Round_Robin(car_id);





    }
    public static void add_car(){
        number_of_car++;
        Car car=new Car();
        car_id.add(car);
    }

    public static void Dispatcher(ArrayList<Car> array_threads  , int index){


        pool.execute(array_threads.get(index));
    }
    public static void Round_Robin(ArrayList<Car> array_threads) throws InterruptedException {
        boolean flag=false;
        int count=0;
        while (count<500) {
            if (flag){
                break;
            }
            for (int i = 0; i < array_threads.size(); i++) {
                if (id_winner!=-1){
                    System.out.println("the winner is "+id_winner);
                    String winnerMessage = "Car " + id_winner + " wins!";
                    JOptionPane.showMessageDialog(GameGUI.fr, winnerMessage, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    flag=true;
                    break;
                }
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    continue;
                }


                Dispatcher(array_threads, i);
//                count++;
//                if (count==20){
//                    add_car();
//                }
            }
        }
    }

}