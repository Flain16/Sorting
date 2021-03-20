package old;

import java.util.Scanner;
import Utils.List;

public class CUtil {

    public static void cn(String klasse, String text) {
		System.out.print(klasse +" : ");
		System.out.println(text);
	}
	
	public static void er(String classe, String text) {
		System.err.print(classe + " : ");
		System.err.println(text);
	}
	
	public static void n(String text) {
		System.out.println(text);
	}
	
	public static void e(String text) {
		System.err.println(text);
	}
		
	public static void k(String klasse,String text) {
		System.err.println("/");
		System.err.println("/");
		System.err.println("in " + klasse +  " was a critical  error");
		System.err.println("/");
		System.err.println(text);
		System.err.println("/");
		System.err.println("/");
	}
	
	public static void table(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print("[" + i + "]");
			System.out.print(" ");
		}
		System.out.println("");
		for(int b = 0; b < array.length; b++){
			if(array[b] < 10){
				System.out.print("  " + array[b]);
			}
			else if(array[b] < 100){
				System.out.print(" " + array[b]);
			}
			else {
				System.out.print("" + array[b]);
			}
			System.out.print(" ");
		}
		System.out.println("");
	}
	
	public static void table(List<Integer> list){
		list.toFirst();
		int i = 1;
		while(list.hasAccess()){
			System.out.print("[" + i + "]");
			System.out.print(" ");
			list.next(); i++;
		}
		System.out.println("");
		list.toFirst();
		while(list.hasAccess()){
			if(list.getContent() < 10){
				System.out.print("  " + list.getContent());
			}
			else if(list.getContent() < 100){
				System.out.print(" " + list.getContent());
			}
			else {
				System.out.print("" + list.getContent());
			}
			System.out.print(" ");
			list.next();
		}
		System.out.println("");
	}
	
	public int cScannerInt() {
		Scanner modeSc = new Scanner(System.in);
    	int number = modeSc.nextInt();
    	modeSc.close();
    	return  number;
	}
}