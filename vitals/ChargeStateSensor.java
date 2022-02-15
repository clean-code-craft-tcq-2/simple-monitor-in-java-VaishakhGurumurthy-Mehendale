package vitals;

public class ChargeStateSensor extends Sensor{

    ChargeStateSensor(float lowerLimit, float upperLimit, int warningPerc) {
        super(lowerLimit, upperLimit, warningPerc);
    }

}
