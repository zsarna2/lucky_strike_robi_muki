import java.util.regex.*;
import java.io.*;
import java.util.*;

public class Statistics {

    public static void main(String[] args) {
        try {
            File x = new File("output.csv");
            Scanner sc = new Scanner(x);
            while(sc.hasNext()) {
                String text = Scanner.toString(sc);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        String reds = "text";
        Pattern pattern = Pattern.compile("Reds");
        Matcher  matcher = pattern.matcher(reds);

        int count = 0;
        while (matcher.find())
            count++;

        System.out.println(count);
    }
}