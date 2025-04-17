import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] cArr = s.toCharArray();
	
		Arrays.sort(cArr);
		
		for(int i = cArr.length - 1; i >= 0; i--) {
			System.out.print(cArr[i]);
		}
		
		sc.close();
	}
}
