import java.util.*;

public class Main {

    public static Simulation generateSimulation(int round) {
        Simulation simulationResult = new Simulation();
        for (int i = 0; i < round; i++) {
            simulationResult.generateData();
        }
        simulationResult = Simulation.load();
        return simulationResult;
    }

    public static void main(String[] args) {

        Logger logger = new Logger();
        if (Integer.parseInt(args[0]) <= 0) {
            logger.log("error", "illegal round number given");
        } else {
        
            Simulation test = Main.generateSimulation(Integer.parseInt(args[0]));
        
            logger.log("csv file content", Arrays.toString(test.content));
        }
    }
}