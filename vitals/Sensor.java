package vitals;

public class Sensor {

    float lowerLimit;
    float upperLimit;
    int warningPerc;
    float WARNING_CONST;

    Sensor(float lowerLimit, float upperLimit, int warningPerc){
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.warningPerc = warningPerc;
        this.WARNING_CONST = (this.upperLimit * this.warningPerc) / 100 ;
    }

    protected boolean isWarningApproached(float value){

        return islowerWarningReached(value) || isUpperWarningReached(value);

    }

    protected boolean islowerWarningReached(float value){
        float lowerEnd = this.lowerLimit + this.WARNING_CONST ;
        if( value <= lowerEnd ){
            PrintEngine.printWarningCode(1, this.getClass().getName());
            return true;
        }
        return false;
    }

    protected boolean isUpperWarningReached(float value){
        float upperEnd = this.upperLimit - this.WARNING_CONST ;
        if( value >= upperEnd){
            PrintEngine.printWarningCode(2, this.getClass().getName());
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
            PrintEngine.printErrorCode(1, this.getClass().getName());
    }

}
