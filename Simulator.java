public class Simulator {

    Simulation simulation;
    Logger logger;


    public Simulator(Simulation simulation, Logger logger) {
        this.simulation = simulation;
        this.logger = logger;
    }

    public Result run() {
        Statistics statResult = new Statistics();

        Result result = new Result(statResult);

        return result;

    }
}