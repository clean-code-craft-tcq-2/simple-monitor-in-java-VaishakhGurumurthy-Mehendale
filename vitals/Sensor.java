package vitals;

public class Sensor {

    float lowerLimit;
    float upperLimit;
    float warningPerc;

    Sensor(float lowerLimit, float upperLimit, int warningPerc){
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.warningPerc = warningPerc;
    }
    


    protected boolean isWarningApproached(float value){
        float WARNING_CONST = (this.upperLimit * this.warningPerc) / 100 ;
        float lowerEnd = this.lowerLimit + WARNING_CONST ;
        float upperEnd = this.upperLimit - WARNING_CONST ;

        if( value <= lowerEnd ){
            PrintEngine.printCode(1, this.getClass().getName());
            return true;
        }
        if( value >= upperEnd){
            PrintEngine.printCode(2, this.getClass().getName());
            return true;
        }

        return false;

    }

    protected boolean isInRange(float value){
        boolean sensorState = (this.lowerLimit <= value) && (value <= this.upperLimit);
        this.printErrorCondition(sensorState);
        return sensorState;
    }

    protected void printErrorCondition(boolean sensorState){
        if(!sensorState)
            PrintEngine.printCode(3, this.getClass().getName());
    }

}
