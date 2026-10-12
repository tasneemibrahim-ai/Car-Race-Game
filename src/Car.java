public class Car extends Thread {
    private static int counter =0;
    private int id;
    private int position_x ;
    private int position_y ;
    private int speed = 2000;
    String State;
    int block_counter ;


    public Car() {
        position_x = counter*2;
        position_y = 0;
        id=counter;
        counter++;
        State = "ready";
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Car.counter = counter;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getstate() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }


    @Override
    public void run() {

        if(Math.random()*100<=2){

            setState("block");
        }
        if (getstate().equals("block")) {
            block_counter++;
            if (block_counter == Main.block_time){
                setState("ready");
                block_counter = 0;
            }
        }


        else if (getstate().equals("ready")) {

            if (!move(position_x, position_y,getid())) {

                try {
                    Thread.sleep(Main.obstacle_time);
                } catch (InterruptedException e) {

                }
            }
        }
    }





    public synchronized boolean move(int x,int y,int id) {
        System.out.println(id +" x:"+ position_x+" y:"+position_y);
        if(position_y+1==24&Main.id_winner==-1){
            Main.id_winner=id;
            return true;
        }
        if (update_position(x, y + 1)) {
            return true;
        }if(x+1==id*2+1){
            if(update_position(x+1,y)){
                return true;
            }
        }if(x-1==id*2){
            if(update_position(x-1,y)){
                return true;
            }
        }
        return false;
    }
    public synchronized boolean update_position(int x,int y){
        if( y<Main.length_of_track){

            if (Main.track[x][y] ==0 ||Main.track[x][y] ==Main.boostZone){
                check_weather();
                try{
                    sleep(2500-this.speed);

                }catch(InterruptedException e){

                }

                if (Main.track[x][y] == Main.boostZone){
                    this.position_x = x;
                    this.position_y = y;
                    move(position_x,position_y,id);
                }else{
                    this.position_x = x;
                    this.position_y = y;
                    return true;
                }
            }
        }return false;
    }
    public void check_weather(){
        if (Weather.getWeather_state()==0){
            this.speed=2000;
        }else if(Weather.getWeather_state()==1){
            this.speed=1000;
        }else {
            this.speed=500;
        }
    }





}