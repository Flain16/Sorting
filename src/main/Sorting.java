package main;

import algos.BubbleSort;
import gui.SortingGui;
import utils.CUtil;
import old.Sorter;

import java.util.Scanner;

public class Sorting {

    private SortingGui gui;
    private BubbleSort bubbleSort;

    public static void main(String[] args) {
        new Sorting();
    }

    public Sorting(){
        //gui = new SortingGui();
        int[] b = CUtil.generateTable(100,100);
        CUtil.table(b);
        bubbleSort = new BubbleSort(b);
        CUtil.table(bubbleSort.getTable());
    }
}
