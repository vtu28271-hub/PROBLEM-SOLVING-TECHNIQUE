import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class dateandtime {
       public static String findDay(int month, int day, int year) {
   
    Calendar cal = Calendar.getInstance();
    cal.set(year, month - 1, day);

    String[] days = {
        "SUNDAY", "MONDAY", "TUESDAY",
        "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"
    };

    return days[cal.get(Calendar.DAY_OF_WEEK) - 1];

    }

}

public class Solution {