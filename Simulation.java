import java.util.*;
import java.io.*;
import java.io.LineNumberReader;

public class Simulation {

    static final int[] reds = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
    static final int[] blacks = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
    static final int[] evens =  {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22 ,24, 26, 28, 30, 32, 34, 36};
    static final int[] odds = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
    static final int[] firstdozen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    static final int[] seconddozen = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    static final int[] thirddozen = {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
    static final int[] firsthalf = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    static final int[] secondhalf = {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
    static final int[] firstcolumn = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
    static final int[] secondcolumn = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
    static final int[] thirdcolumn = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};

    public static String[] content;

    public Simulation(String[] content) {
        this.content = content;
    }

    public Simulation(){
        this.content = getZones();
    }

    public static HashMap<String, int[]> getHashMap() {
        HashMap<String, int[]> strike = new HashMap<String, int[]>();
        strike.put("Reds", Simulation.reds);
        strike.put("Blacks", Simulation.blacks);
        strike.put("Evens", Simulation.evens);
        strike.put("Odds", Simulation.odds);
        strike.put("Frist dozen", Simulation.firstdozen);
        strike.put("Second dozen", Simulation.seconddozen);
        strike.put("Third dozen", Simulation.thirddozen);
        strike.put("First half", Simulation.firsthalf);
        strike.put("Second half", Simulation.secondhalf);
        strike.put("First column", Simulation.firstcolumn);
        strike.put("Second column", Simulation.secondcolumn);
        strike.put("Third column", Simulation.thirdcolumn);
        return strike;
    }

    public String[] getZones(){
        Random rand = new Random();
        int  randomNumber = rand.nextInt(36);
        HashMap<String, int[]> strike = Simulation.getHashMap();
        String[] zones = new String[6];
        int counter = 1;
        zones[0] = Integer.toString(randomNumber);
        
        if (randomNumber == 0) {
            String[] zeroZone = new String[6];
            for (int i =0; i < 6; i++){
                zeroZone[i] = "Zero";
            }
            return zeroZone;
        }
        for (Map.Entry<String, int[]> entry : strike.entrySet()){
            String key = entry.getKey();
            int[] value = entry.getValue();

            for (int i : value){
                if (i == randomNumber){
                    zones[counter] = key;
                    counter++;
                }
            }
        }
        return zones;
    }

    public void generateData(){
        try {
        FileWriter writer = new FileWriter("output.csv", true);
        String appender = "";
        for(String element: getZones()) {
            writer.write(appender + element);
            appender = ",";
        }
        writer.write("\n");
        writer.flush();
        writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Simulation load(){
        Simulation loadedSim = new Simulation();
        try {
            int counter = 0;
            BufferedReader reader = new BufferedReader(new FileReader("output.csv"));
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            reader.close();
            BufferedReader x = new BufferedReader(new FileReader("output.csv"));
            String dataRow = x.readLine();
            String[] loadedContent = new String[6 * lines];
            while(dataRow != null){
                String[] dataArray = dataRow.split(",");
                for (String item:dataArray) {
                    loadedContent[counter] = item;
                    counter++;
                }
                dataRow = x.readLine();
            }
            x.close();
            loadedSim.content = loadedContent;
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedSim;
    }
}