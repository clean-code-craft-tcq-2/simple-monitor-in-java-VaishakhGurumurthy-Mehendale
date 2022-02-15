package vitals;

public class Main {

    static TemperatureSensor temperatureSensor;
    static ChargeStateSensor chargeStateSensor;
    static ChargeRateSensor chargeRateSensor;
    static int LANGUAGE_CODE;

    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return temperatureSensor.isInRange(temperature) && chargeStateSensor.isInRange(soc) && chargeRateSensor.isInRange(chargeRate);
    }

    static void init(){

        /*
            Set defaults.
            assign lower and upper limits for each sensor

            initialize additional sensors here
        */

        LANGUAGE_CODE = 1; //0 -> English | 1 -> German
        temperatureSensor = new TemperatureSensor(0, 45, 5);
        chargeStateSensor = new ChargeStateSensor(20, 80, 5);
        chargeRateSensor = new ChargeRateSensor( 0.0f, 0.8f, 5);

    }

    static void unitTests(){

        assert (temperatureSensor.isInRange(45));
        assert (temperatureSensor.isInRange(48) == false);

        assert (chargeStateSensor.isInRange(21));
        assert (chargeStateSensor.isInRange(81) == false);

        assert (chargeRateSensor.isInRange(0.8f));
        assert (chargeRateSensor.isInRange(0.9f) == false);



        assert (temperatureSensor.isWarningApproached(45));
        assert (temperatureSensor.isWarningApproached(32) == false);

        assert (chargeStateSensor.isWarningApproached(21));
        assert (chargeStateSensor.isWarningApproached(60) == false);

        assert (chargeRateSensor.isWarningApproached(0.8f));
        assert (chargeRateSensor.isWarningApproached(0.5f) == false);

    }

    static void functionalityTests(){
        assert(batteryIsOk(25, 70, 0.7f));
        assert(batteryIsOk(25, 85, 0.0f) == false);
    }

    public static void main(String[] args) {
        init();
        unitTests();
        functionalityTests();
    }
}
