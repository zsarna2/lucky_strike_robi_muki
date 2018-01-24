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
        
        Simulation test = Main.generateSimulation(Integer.parseInt(args[0]));
        Logger logger = new Logger();
        logger.log("csv file content", Arrays.toString(test.content));

    }
}