import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {

    public void log(String type, String message){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss").format(new Timestamp(System.currentTimeMillis()));

        System.out.printf("%s: %-32s |%-8s\n", timeStamp, type, message);
        System.out.println("-------------------------------------------------------------------------------");
    }
}