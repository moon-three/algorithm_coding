import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// N이 가장 큰 경우 -> 1,000,000
		// 1,000,000 보다 큰 소수이면서 팰린드롬인 수를 찾아야함
		// -> 소수를 구할 때 넉넉하게 10,000,000까지 구해놓기 
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[10000001];	
		
		for(int i = 2; i < arr.length; i++) {
			arr[i] = i;
		}
		
		for(int i = 2; i < Math.sqrt(arr.length); i++) {
			if(arr[i] == 0) {
				continue;
			}
			for(int j = i * i; j < arr.length; j += i) {
				arr[j] = 0;
			}
		}
		
		for(int i = N; i < arr.length; i++) {
			if(arr[i] != 0 && isPalindrome(arr[i])) {
				System.out.println(arr[i]);
				break;
			}
		}
		
		sc.close();
	}
	
	public static boolean isPalindrome(int n) {
		
		char[] chs = String.valueOf(n).toCharArray();

		int left = 0;
		int right = chs.length - 1;
		
		while(left < right) {
			if(chs[left] != chs[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
}