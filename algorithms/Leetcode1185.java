import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

class Solution {
    
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate d = LocalDate.of(year, month, day);
        
        DayOfWeek dayAsCaps = d.getDayOfWeek();
        return dayAsCaps.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}
