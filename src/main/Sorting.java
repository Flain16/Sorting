package main;

import utils.CUtil;

public class Sorting {

    private int[] unsorted;

    public Sorting(){
        System.out.println("Starting");
    }

    public void genTable(int length, int maxValue){
        unsorted = CUtil.generateTable(length, maxValue);
    }

    public int[] getUnsorted(){
        return unsorted;
    }
}