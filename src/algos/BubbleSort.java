package algos;

import utils.CUtil;

public class BubbleSort {

    private long time = 0, startTime = 0;
    private int[] table;

    public BubbleSort(int[] array){
        setStartTime();
        boolean moved = false;
        boolean running = true;
        while(running){
            moved =  false;
            for(int i = 1; i < array.length;i++){
                if(array[i - 1] > array[i]) {
                    moved = true;
                    int b = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = b;
                    CUtil.table(array);
                }
            }
            if(!moved){
                running = false;
            }
        }
        table = array;
        setTime();
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

    public int[] getTable() {
        return table;
    }
}
