package utils;

public class Time {

    public long setStartTime(){
        return System.currentTimeMillis();
    }

    public long setTime(int startTime){
        return (System.currentTimeMillis() - startTime);
    }

    public boolean printTime(int startTime){
        long tTime = System.currentTimeMillis() - startTime;
        if(tTime % 200 == 2){
            return true;
        }
        else{
            return false;
        }
    }
}
