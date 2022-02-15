package vitals;


import java.util.HashMap;
import java.util.Map;

public class PrintEngine {

    private static Map<Integer, String> errorMessages = new HashMap<>();
    private static Map<Integer, String> lowerLimWarnings = new HashMap<>();
    private static Map<Integer, String> upperLimWarnings = new HashMap<>();

    static {
        errorMessages.put(0, " Sensor value out of range");
        errorMessages.put(1, " Sensorwert außerhalb des Bereichs");

        lowerLimWarnings.put(0, " Sensor approaching lower Limit");
        lowerLimWarnings.put(1, " Sensor nähert sich dem unteren Grenzwert");

        upperLimWarnings.put(0, " Sensor approaching upper Limit");
        upperLimWarnings.put(1, " Sensor nähert sich dem oberen Grenzwert");
    }


    public static void printErrorCode( int code, String sensorType ){

        switch (code) {

            case 1 :
                    System.out.println(sensorType + errorMessages.get(Main.LANGUAGE_CODE));
                    break;
        }

    }

    public static void printWarningCode(int code, String sensorType) {

        switch (code) {
            case 1:
                //Print Lower Limit Warning Info
                System.out.println(sensorType + lowerLimWarnings.get(Main.LANGUAGE_CODE));
                break;
            case 2:
                //Print Upper Limit Warning
                System.out.println(sensorType + upperLimWarnings.get(Main.LANGUAGE_CODE));
                break;
        }
    }



}
