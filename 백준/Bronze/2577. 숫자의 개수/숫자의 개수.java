import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		String value = String.valueOf(A * B * C);
		
		int[] arr = new int[10];
		
		for(int i = 0; i < value.length(); i++) {
			int num = Integer.parseInt(value.charAt(i) + "");
			arr[num]++;
		}

		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		sc.close();
	}
}