
public class Main {

    public static void main(String[] args) {
        // write test code here
        clockTime("10:00:00");
    }
    
    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public static boolean allVowels(String string) {
        return string.matches("(a|e|o|i|u|ä|ö)*");
    }
    
    public static boolean clockTime(String string) {
        String[] separatedValues = string.split(":");
        if (separatedValues.length < 3) {
            return false;
        }
        
        boolean validHours = separatedValues[0].matches("(0|1)[0-9]");
        if(!validHours) {
            validHours = separatedValues[0].matches("2[0-3]");
        }
        System.out.println(validHours);
        boolean validMinutes = separatedValues[1].matches("[0-5][0-9]");
        boolean validSeconds = separatedValues[2].matches("[0-5][0-9]");
        
        return validHours && validMinutes && validSeconds;
    }
}
