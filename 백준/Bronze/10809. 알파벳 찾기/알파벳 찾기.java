import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String S = sc.nextLine();
		
		int[] arr = new int['z' - 'a' + 1];
		
		int cnt = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for(int i = 0; i < S.length(); i++) {
			int idx = S.charAt(i) - 'a';
			if(arr[idx] != -1) {
				cnt++;
				continue;
			}
			arr[idx] = cnt++;
		}
		
		for(int n : arr) {
			sb.append(n + " ");
		}
		
		System.out.println(new String(sb).trim());
		sc.close();
	}
}
