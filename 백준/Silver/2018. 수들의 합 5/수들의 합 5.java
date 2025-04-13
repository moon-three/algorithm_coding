import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int start = 1;
		int end = 1;
		int count = 1;	// 자기 자신인 경우
		int sum = 1;	
		
		while(end < N) {
			
			if(sum == N) {
				count++;
				sum -= start;
				start++;
				end++;
				sum += end;
			} else if(sum > N) {
				sum -= start;
				start++;
			} else {
				end++;
				sum += end;
			}
			
		}
		
		System.out.println(count);
		sc.close();
	}
}