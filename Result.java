import java.util.HashMap;
import java.util.*;

public class Result {

    String number;
    String color;
    String evenodd;
    String half;
    String dozen;
    String column;
    String zero;
    Statistics resstats;

    public Result(Statistics resstats) {
        this.resstats = resstats;

        HashMap<String, Integer> colors = new HashMap<String, Integer>();
        HashMap<String, Integer> halfes = new HashMap<String, Integer>();
        HashMap<String, Integer> evenodds = new HashMap<String, Integer>();
        HashMap<String, Integer> dozens = new HashMap<String, Integer>();
        HashMap<String, Integer> columns = new HashMap<String, Integer>();
        HashMap<String, Integer> numbers = new HashMap<String, Integer>();
        HashMap<String, Integer> zeros = new HashMap<String, Integer>();

        for (Map.Entry<String, Integer> entry : resstats.stats.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (key.equals("Reds") || key.equals("Blacks")) {
                colors.put(key, value);
            } else if (key.equals("First half") || key.equals("Second half")) {
                halfes.put(key, value);
            } else if (key.equals("Evens") || key.equals("Odds")) {
                evenodds.put(key, value);
            } else if (key.equals("First dozen") || key.equals("Second dozen") || key.equals("Third dozen")) {
                dozens.put(key, value);
            } else if (key.equals("First column") || key.equals("Second column") || key.equals("Third column")) {
                columns.put(key, value);
            } else if (key.equals("Zero")) {
                zeros.put(key, value);
            } else {
                numbers.put(key, value);
            }
        }

        this.color = Result.getKeyByMaxValue(colors);
        this.half = Result.getKeyByMaxValue(halfes);
        this.evenodd = Result.getKeyByMaxValue(evenodds);
        this.dozen = Result.getKeyByMaxValue(dozens);
        this.column = Result.getKeyByMaxValue(columns);
        this.number = Result.getKeyByMaxValue(numbers);
        this.zero = Result.getKeyByMaxValue(zeros);

    }

    public static String getKeyByMaxValue(HashMap<String, Integer> myMap) {
        String maxKey = "";
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
            maxEntry = entry;
            }
        }
        maxKey = maxEntry.getKey();
        return maxKey;
    }
}