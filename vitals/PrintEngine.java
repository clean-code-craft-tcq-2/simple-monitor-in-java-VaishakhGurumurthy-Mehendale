package vitals;

public class PrintEngine {

    public static void printCode( int code, String sensorType ){

        switch (code) {
            case 1 ->
                    //Print Lower Limit Warning Info
                    System.out.println("Caution!!" + sensorType + "Sensor approaching lower Limit");
            case 2 ->
                    //Print Upper Limit Warning
                    System.out.println("Caution!!" + sensorType + " Sensor approaching upper Limit");
            case 3 -> System.out.println(" Attention!!" + sensorType + " Sensor values out of range. ");
        }

    }



}
