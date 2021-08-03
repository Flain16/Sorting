package old;

import utils.CUtil;
import utils.List;

public class Sorter {

	int[] standardArray, array2, array3, array4;
	long bubbleSortMoves = 0, insertionSortMoves = 0, selectionsortMoves = 0, quicksortSlowMoves = 0;
	long runTimeBubblesort, runTimeInsertionsort, runTimeSelectionsort, runTimeQuicksortSlow;

	public Sorter(int mode, int length) {
		int sortType = mode;
		long timeAtStart = System.currentTimeMillis();
		standardArray = new int[length];
		for (int i = 0; i < standardArray.length; i++) {
			standardArray[i] = (int) (Math.random() * 1000);
		}
		List<Integer> standartList = new List<Integer>();
		for (int i = 0; i < length; i++) {
			standartList.append((int) (Math.random() * 1000));
		}
		//printOut();
		if (standardArray.length < 1000) {
			CUtil.table(standardArray);
			CUtil.table(standartList);
			CUtil.n("Not Sortet ^^");
		}
		if (sortType == 1) {
			CUtil.cn("Type", "Bubblesort");
			bubbleSort(standardArray);
		} else if (sortType == 2) {
			CUtil.cn("Type", "Insertionsort");
			insertionSort(standardArray);
		} else if (sortType == 3) {
			CUtil.cn("Type", "Selectionsort");
			selectionsort(standardArray);
		} else if (sortType == 4) {
			quicksortSlow(standardArray);
			CUtil.cn("Type", "Quicksort");
		} else if (sortType == 6) {
			insertionSort(standartList);
			CUtil.cn("Type", "Insertionsort List");
		} else {
			array2 = new int[standardArray.length];
			for (int i = 0; i < standardArray.length; i++) {
				array2[i] = standardArray[i];
			}
			array3 = new int[standardArray.length];
			for (int i = 0; i < standardArray.length; i++) {
				array3[i] = standardArray[i];
			}
			array4 = new int[standardArray.length];
			for (int i = 0; i < standardArray.length; i++) {
				array4[i] = standardArray[i];
			}

			bubbleSort(standardArray);
			insertionSort(array2);
			selectionsort(array3);
			quicksortSlow(array4);
			//bubblesort best
			if (runTimeBubblesort < runTimeInsertionsort && runTimeBubblesort < runTimeSelectionsort &&
					runTimeBubblesort < runTimeQuicksortSlow) {
				CUtil.n("Bubblesort was the efectiv type with" + bubbleSortMoves +
						"moves than Insertionsort with " + insertionSortMoves + " moves and Selectionsort with " +
						selectionsortMoves + " moves");
				CUtil.n("Bubblesort needs " + runTimeBubblesort + " ms  across"
						+ " from Insertionsort with " + runTimeInsertionsort + " ms and Selectionsort with " +
						runTimeSelectionsort + " ms");
			}
			//Insertionsort best
			else if (runTimeInsertionsort < runTimeBubblesort && runTimeInsertionsort < runTimeSelectionsort &&
					runTimeInsertionsort < runTimeQuicksortSlow) {
				CUtil.n("Insertionsort was the efectiv type with " + insertionSortMoves +
						" moves than Bubblesort with " + bubbleSortMoves + " moves and Selectionsort with " +
						selectionsortMoves + " moves");
				CUtil.n("Insertionsort needs " + runTimeInsertionsort + " ms  across"
						+ " from Bubblesort with " + runTimeBubblesort + " ms and Selectionsort with " +
						runTimeSelectionsort + " ms");
			}
			//Selectionsort best
			else if (runTimeSelectionsort <= runTimeBubblesort && runTimeSelectionsort <= runTimeInsertionsort &&
					runTimeSelectionsort <= runTimeQuicksortSlow) {
				CUtil.n("Selectionsort was the efectiv type with " + selectionsortMoves +
						" moves than Bubblesort with " + bubbleSortMoves + " moves and Insertionsort with " +
						insertionSortMoves + " moves");
				CUtil.n("Selectionsort needs " + runTimeSelectionsort + " ms  across"
						+ " from Bubblesort with " + runTimeBubblesort + " ms and Insertionsort with " +
						runTimeInsertionsort + " ms");
			} else if (runTimeQuicksortSlow < runTimeBubblesort && runTimeQuicksortSlow < runTimeSelectionsort &&
					runTimeQuicksortSlow < runTimeInsertionsort) {
				CUtil.n("Selectionsort was the efectiv type with " + selectionsortMoves +
						" moves than Bubblesort with " + bubbleSortMoves + " moves and Insertionsort with " +
						insertionSortMoves + " moves");
				CUtil.n("Selectionsort needs " + runTimeSelectionsort + " ms  across"
						+ " from Bubblesort with " + runTimeBubblesort + " ms and Insertionsort with " +
						runTimeInsertionsort + " ms");
			}
			//all best
			else {
				CUtil.e("Not clear witch was more effectiv");
			}
		}
		long TimeAtEnd = System.currentTimeMillis();
		long runTime = TimeAtEnd - timeAtStart;
		System.out.println("Totally this needs " + runTime + " ms");
	}

	public void bubbleSort(int[] array) {
		long start = System.currentTimeMillis();
		boolean bufferNoChange = true;
		int round = 0;
		long moves = 0;
		while (bufferNoChange) {
			bufferNoChange = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					int h = array[i];
					array[i] = array[i + 1];
					array[i + 1] = h;
					bufferNoChange = true;
					moves++;
				}
			}
			round++;
			if (standardArray.length > 100000 && round % 10 == 2) {
				runTimeBubblesort = System.currentTimeMillis() - start;
				CUtil.cn("Bubblesort", "Runing since " + runTimeBubblesort / 1000 + " seconds");
			}
			//CUtil.cn("Bubblesort", "Round " + round + " and " + moves + " moves");			
		}
		if (standardArray.length < 1000) {
			CUtil.table(array);
		}
		CUtil.cn("Bubblesort", "finish with " + round + " Rounds, needs " + moves + " moves");
		bubbleSortMoves = moves;
		long end = System.currentTimeMillis();
		runTimeBubblesort = end - start;
	}

	public void insertionSort(int[] array) {
		long start = System.currentTimeMillis();
		int round = 0;
		long move = 0;
		for (int i = 1; i < array.length; i++) {
			for (int b = 0; b < i; b++) {
				if (array[i] < array[b]) {
					int d = array[i];
					array[i] = array[b];
					array[b] = d;
					move++;
				}
			}
			round++;
			//CUtil.cn("Insertionsort", "Round " + round + " and " + move + " moves");		
		}
		if (standardArray.length < 1000) {
			CUtil.table(array);
		}
		CUtil.cn("Insertionsort", "finish with " + round + " Rounds, needs " + move + " moves");
		insertionSortMoves = move;
		long end = System.currentTimeMillis();
		runTimeInsertionsort = end - start;
	}

	public void selectionsort(int[] array) {
		long start = System.currentTimeMillis();
		long move = 0;
		int round = 0;
		for (int i = 0; i < array.length; i++) {
			int smalest = i;
			for (int b = i; b < array.length; b++) {
				if (array[b] < array[smalest]) {
					smalest = b;
					move++;
				}
			}
			int d = array[smalest];
			array[smalest] = array[i];
			array[i] = d;
			round++;
		}
		if (standardArray.length < 1000) {
			CUtil.table(array);
		}
		CUtil.cn("Selectionsort", "finish with " + round + " Rounds, needs " + move + " moves");
		selectionsortMoves = move;
		long end = System.currentTimeMillis();
		runTimeSelectionsort = end - start;
	}

	public void quicksortSlow(int[] array) {
		int l = 0, r = array.length;
		while (l != r) {
			array = sortPartArray(array, l, r);
		}
		CUtil.table(array);
	}

	public int[] sortPartArray(int[] array, int l, int r) {
		int[] newArray = new int[array.length];
		int pivot = array.length - 1, k = 0;
		;
		for (int i = l; i < r; i++) {
			if (array[i] < array[pivot]) {
				newArray[k] = array[i];
				k++;
			}
		}
		newArray[k++] = array[pivot];
		for (int i = l; i < r; i++) {
			if (array[i] > array[pivot]) {
				newArray[k] = array[i];
				k++;
			}
		}
		return newArray;
	}

	public void insertionSort(List<Integer> list) {
		long start = System.currentTimeMillis();
		List<Integer> liste = list;
		List<Integer> secondList = new List<Integer>();
		liste.toFirst();
		while (!liste.isEmpty()) {
			Integer akt = list.getContent();
			list.remove();
			secondList.toFirst();
			while (secondList.hasAccess() && akt > (secondList.getContent())) {
				secondList.next();
			}
			if (secondList.hasAccess()) {
				secondList.insert(akt);
			} else {
				secondList.append(akt);
			}
		}
		list.concat(secondList);
		if (standardArray.length < 1000) {
			CUtil.table(list);
		}
		long end = System.currentTimeMillis();
		runTimeInsertionsort = end - start;
	}
}