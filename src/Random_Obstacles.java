public class Random_Obstacles extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i=0;i<Main.number_obstacle;i++){
                Obstacles obstacles=new Obstacles();
                obstacles.start();
            }
            try {
                Thread.sleep(Main.obstacle_time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
