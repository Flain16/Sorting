package old;

import Utils.CUtil;
import Utils.Sorter;

import java.util.Scanner;

public class SortingMain {

	private static boolean withConsole = true;
	private boolean running = true;
	private int length = 0;
	private int mode = 0;

	public static void main(String[] args) {
		new SortingMain();
	}

	public SortingMain(){
		while (running){
			CUtil.n("Write a int to start");
			CUtil.n("1 = Bubblesort");
			CUtil.n("2 = Insertion");
			CUtil.n("3 = Selection");
			CUtil.n("4 = not availabel");
			CUtil.n("5 = Compare all");
			CUtil.n("6 = Insertion Lists");
			CUtil.n("7 = Exit program");
			Scanner modeSc = new Scanner(System.in);
			mode = modeSc.nextInt();
			if(mode != 7){
				CUtil.n("Mode " + mode + " choosen");
				CUtil.n("Write a length for the array");
				CUtil.e("More than 1 million are not recomended");
				Scanner lengthSc = new Scanner(System.in);
				length = lengthSc.nextInt();
				if(length > 999999) {
					CUtil.er("Length " + length, "is not recomended");
				}
				else {
					CUtil.n("Array length of " + length);
				}
			}
			if(mode == 7){
				running = false;
			}else {
				new Sorter(mode,length);
			}
		}
	}
}
