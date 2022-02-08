package vitals;

public class Sensor {

    float lowerLimit;
    float upperLimit;

    Sensor(float lowerLimit, float upperLimit){
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    protected boolean isInRange(float value){
        boolean sensorState = (this.lowerLimit <= value) && (value <= this.upperLimit);
        printCondition(sensorState);
        return sensorState;
    }

    protected void printCondition(boolean sensorState){
        if(!sensorState)
            System.out.println(this.getClass().getName()+ " is out of range!");
    }

}
