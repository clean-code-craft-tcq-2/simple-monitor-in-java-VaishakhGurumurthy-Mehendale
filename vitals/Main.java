package vitals;

public class Main {

    static TemperatureSensor temperatureSensor;
    static ChargeStateSensor chargeStateSensor;
    static ChargeRateSensor chargeRateSensor;

    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return temperatureSensor.isInRange(temperature) && chargeStateSensor.isInRange(soc) && chargeRateSensor.isInRange(chargeRate);
    }

    static void init(){

        /*
            Set defaults.
            assign lower and upper limits for each sensor

            initialize additional sensors here
        */

        temperatureSensor = new TemperatureSensor(0, 45);
        chargeStateSensor = new ChargeStateSensor(20, 80);
        chargeRateSensor = new ChargeRateSensor( 0.0f, 0.8f);

    }

    static void unitTests(){

        assert (temperatureSensor.isInRange(45));
        assert (temperatureSensor.isInRange(48) == false);

        assert (chargeStateSensor.isInRange(21));
        assert (chargeStateSensor.isInRange(81) == false);

        assert (chargeRateSensor.isInRange(0.8f));
        assert (chargeRateSensor.isInRange(0.9f) == false);

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
