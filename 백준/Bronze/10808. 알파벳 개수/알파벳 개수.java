import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		int[] arr = new int[(int)'z' - (int)'a' + 1];
		
		for(int i = 0; i < s.length(); i++) {
			arr[(int)s.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(arr[arr.length - 1]);
		
		sc.close();
	}
}
