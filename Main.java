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
                try {                
                    Simulation test = Main.generateSimulation(Integer.parseInt(args[0]));
                    Simulator simulator = new Simulator(test, logger);
                    Result result = simulator.run();
                    Map<String, Integer> sortedStats = new TreeMap<String, Integer>(result.resstats.stats);

                    while (true) {
                        logger.logWithoutTimestamp("1","View Results");
                        logger.logWithoutTimestamp("2","View Statistics");
                        logger.logWithoutTimestamp("3","View Both");
                        logger.logWithoutTimestamp("4","Exit");
                        Scanner sc = new Scanner(System.in);
                        String option = sc.next();
                        logger.clearConsole();
                        if (option != null) {
                            if (option.equals("2")) {
                                logger.logWithoutTimestamp("Stats","");
                                for (Map.Entry<String, Integer> entry : sortedStats.entrySet()){
                                    String name = entry.getKey();
                                    String value = entry.getValue().toString();  
                                    logger.log(name,value);
                                }
                                logger.logWithoutTimestamp("","");
                                continue;
                            }
                            else if (option.equals("1")) {
                                logger.logWithoutTimestamp("Results","");
                                logger.logWithoutTimestamp("the numbers you win with",result.number);
                                logger.logWithoutTimestamp("the color to double your cash",result.color);
                                logger.logWithoutTimestamp("the numbers you bet must be",result.evenodd);
                                logger.logWithoutTimestamp("or its must be in the",result.half);
                                logger.logWithoutTimestamp("to triple your cash, bet the",result.dozen);
                                logger.logWithoutTimestamp("or the",result.column);
                                logger.logWithoutTimestamp("","");
                                continue;
                            }
                            else if (option.equals("3")){
                                logger.logWithoutTimestamp("Results","");
                                logger.logWithoutTimestamp("the numbers you win with",result.number);
                                logger.logWithoutTimestamp("the color to double your cash",result.color);
                                logger.logWithoutTimestamp("the numbers you bet must be",result.evenodd);
                                logger.logWithoutTimestamp("or its must be in the",result.half);
                                logger.logWithoutTimestamp("to triple your cash, bet the",result.dozen);
                                logger.logWithoutTimestamp("or the",result.column);
                                logger.logWithoutTimestamp("","");
                                logger.logWithoutTimestamp("Stats","");
                                for (Map.Entry<String, Integer> entry : sortedStats.entrySet()){
                                    String name = entry.getKey();
                                    String value = entry.getValue().toString();  
                                    logger.log(name,value);
                                }
                                logger.logWithoutTimestamp("","");
                                continue;
                            }
                            else if (option.equals("4")){
                                logger.clearConsole();
                                break;
                            }
                            else {
                                logger.logWithoutTimestamp("Fatal Error","Try to type a number from the menu");
                            }
                        }
                        else {
                            logger.logWithoutTimestamp("Fatal Error","Try to type a number from the menu");
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    logger.log("error","type how many rounds you want to simulate");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log("Error","Type a round number!");
        }
    }
}