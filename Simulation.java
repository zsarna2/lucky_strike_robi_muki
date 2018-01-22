import java.util.*;

public class Simulation {

    static final int[] reds = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
    static final int[] blacks = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
    final int zero = 0;
    final int[] evens =  {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22 ,24, 26, 28, 30, 32, 34, 36};
    final int[] odds = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
    final int[] firstdozen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    final int[] seconddozen = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    final int[] thirddozen = {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
    final int[] firsthalf = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    final int[] secondhalf = {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
    final int[] firstcolumn = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
    final int[] secondcolumn = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
    final int[] thirdcolumn = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};

    public static HashMap<String, int[]> getHashMap() {
        HashMap<String, int[]> myMap = new HashMap<String, int[]>();
        myMap.put("Reds", Simulation.reds);
        myMap.put("Blacks", Simulation.blacks);
        return myMap;
    }
    //HashMap<String, int[]> myMap = new HashMap<String, int[]>();
    

    public static void main(String[] args) {
        /*Simulation simulation = new Simulation();
        simulation.myMap.put("Reds", simulation.reds);
        simulation.myMap.put("Blacks", simulation.blacks);
        System.out.println(Arrays.toString(simulation.myMap.get("Reds")));
        */
        HashMap<String, int[]> table = new HashMap<String, int[]>();
        table = Simulation.getHashMap();
        System.out.println(Arrays.toString(table.get("Reds")));
    }
}