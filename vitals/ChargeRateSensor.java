package vitals;

public class ChargeRateSensor extends Sensor{

    ChargeRateSensor(float lowerLimit, float upperLimit, int warningPerc) {
        super(lowerLimit, upperLimit, warningPerc);
    }

}
