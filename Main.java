import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        try {
            if (Integer.parseInt(args[0]) <= 0) {
                logger.log("error", "illegal round number given");
            } else {
            
                Simulation test = Main.generateSimulation(Integer.parseInt(args[0]));
                Simulator simulator = new Simulator(test, logger);
                Result result = simulator.run();

                Map<String, Integer> treeMap = new TreeMap<String, Integer>(result.resstats.stats);
                for (Map.Entry<String, Integer> entry : treeMap.entrySet()){
                    String name = entry.getKey();
                    String value = entry.getValue().toString();  
                    logger.log(name,value);
                }
                logger.log("the numbers you win with",result.number);
                logger.log("the color",result.color);
                logger.log("the evenness",result.evenodd);
                logger.log("the dozen",result.dozen);
                logger.log("the half",result.half);
                logger.log("the column",result.column);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log("error","type how many rounds you want to simulate");
        }
    }
}