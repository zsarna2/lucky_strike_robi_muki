import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Statistics {

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }


    public static void stats() {
        HashMap<String, Integer> total = new HashMap<String, Integer>();
        int[] oppnumbers1 = new int[36];
        String[] oppzones = {"Zero", "Reds", "Blacks", "Evens", "Odds", "Frist dozen", "Second dozen", "Third dozen", "First half", "Second half", "Fist column", "Second column", "Third column"};
        for (int i = 1;i <= 36;i++) {
            oppnumbers1[i-1] = i;
        }
        String[] oppnumbers2=Arrays.toString(oppnumbers1).split("[\\[\\]]")[1].split(", ");

        Simulation text = Simulation.load();
        for (String item : text.content) {
            if (Statistics.isInteger(item)) {
                for (String item2 : oppnumbers2) {
                    if (item2.equals(item)) {
                        if (!total.containsKey(item2)){
                            total.put(item2, 1);
                        } else {
                            int temp = total.get(item2);
                            temp++;
                            total.put(item2, temp);
                        }
                    }
                }
            }
        }

        for (String item : oppzones) {
            String matches = Arrays.toString(text.content);

            Pattern pattern = Pattern.compile(item);
            Matcher  matcher = pattern.matcher(matches);
            int zonecount = 0;
            while (matcher.find())
                zonecount++;
            if (item.equals("Zero")) {
                zonecount = zonecount / 6;
            }
            total.put(item, zonecount);
        }

        for (String zone : total.keySet()) {
            String value = total.get(zone).toString();
            System.out.println(zone + ": " + value);
        }
    }
}