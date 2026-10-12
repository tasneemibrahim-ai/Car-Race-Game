public class Weather extends Thread{
    private static int weather_state;  //0:sunny 1:rainy 2:foggy

    public static int getWeather_state() {
        return weather_state;
    }

    public static void setWeather_state(int weather_state) {
        Weather.weather_state = weather_state;
    }

    @Override
    public void run() {
        while (true){
            int state= (int)(Math.random()*3);
            setWeather_state(state);
            System.out.println(state);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
