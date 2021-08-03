package algos;

import utils.CUtil;

public class InsertionSort {

    private long time = 0, startTime = 0;
    private int[] table;

    public int[] insertionSort(int[] array, boolean debug){
        setStartTime();
        if(debug){
            CUtil.n("InsertionSort started");
        }
        for (int i = 1; i < array.length; i++) {
            for (int b = 0; b < i; b++) {
                if (array[i] < array[b]) {
                    int d = array[i];
                    array[i] = array[b];
                    array[b] = d;
                    if(printTime() && debug){
                        CUtil.table(array);
                    }
                }
            }
        }
        setTime();
        table = array;
        return table;
    }

    public void setStartTime(){
        startTime = System.currentTimeMillis();
    }

    public void setTime(){
        time = System.currentTimeMillis() - startTime;
    }

    public long getTime() {
        return time;
    }

    public boolean printTime(){
        long tTime = System.currentTimeMillis() - startTime;
        if(tTime % 200 == 2){
            return true;
        }
        else{
            return false;
        }
    }

    public int[] getTable() {
        return table;
    }
}
