public class Random_Boost_Zones extends Thread{

    public void run() {
        while (true){
            for (int i=0;i<Main.number_boostZone;i++){
                Boost_zones Boost_zones =new Boost_zones();
                Boost_zones.start();
            }
            try {
                Thread.sleep(Main.boost_zone_time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

