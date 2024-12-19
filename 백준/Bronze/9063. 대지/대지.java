import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] xArr = new int[count];
		int[] yArr = new int[count];
		
		sc.nextLine();
		
		for(int i = 0; i < count; i++) {
			String value = sc.nextLine();
			
			xArr[i] = Integer.parseInt(value.split(" ")[0]);
			yArr[i] = Integer.parseInt(value.split(" ")[1]);
		}
		
		Arrays.sort(xArr);
		Arrays.sort(yArr);
		
		int width = (xArr[count-1] - xArr[0]) * (yArr[count-1] - yArr[0]);
				
		System.out.println(width);
	}
}