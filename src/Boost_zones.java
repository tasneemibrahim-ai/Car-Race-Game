import javax.swing.*;

public class Boost_zones extends Thread {

    @Override
    public synchronized void run() {

        int x_random =(int) (Math.random()*Main.width_of_track);
        int y_random =(int) (Math.random()*Main.length_of_track);
        int count =0;
        synchronized (this){
            while(count <1){
                if(Main.track[x_random][y_random] == 0){
                    add_Boost_Zones(x_random,y_random);
                    count++;
                }else{
                     x_random =(int) (Math.random()*Main.width_of_track);
                     y_random =(int) (Math.random()*Main.length_of_track);
                }
            }
        }


        try {
            Thread.sleep(Main.boost_zone_time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        remove_Boost_Zones(x_random,y_random);

    }public synchronized void add_Boost_Zones(int x_random,int y_random){

        Main.track[x_random][y_random] = Main.boostZone;
        System.out.println("boost in"+x_random+" "+y_random);

    }public synchronized void remove_Boost_Zones(int x_random,int y_random){

        Main.track[x_random][y_random] = 0;
    }
}
