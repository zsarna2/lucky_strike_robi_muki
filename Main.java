import java.util.Random;

public class Main {

    public int randomNumber(){
        Random rand = new Random();
        int  n = rand.nextInt(36);
        return n;
    }

    public static void generateSimulation(int round) {
        for(int i = 0;i < round; i++){
            int r = main.randomNumber();
        }
        
    }

    public static void main(String[] args) {

    }
}