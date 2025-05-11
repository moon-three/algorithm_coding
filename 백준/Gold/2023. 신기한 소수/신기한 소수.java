import java.util.Scanner;

public class Main {
	
	public static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 자릿수
		
		// 왼쪽부터 한자리씩 늘려가며 소수인지 구하기
		// 	1) 2, 3, 5, 7이 한자리 소수 
		// 	2) 짝수는 소수가 아니므로 홀수만 비교

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
		
		sc.close();
	}
	
	public static void DFS(int num, int depth) {
		if(depth == N) {
			System.out.println(num);
			return;
		}
		for(int i = 1; i < 10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			
			if(isPrime(num * 10 + i)) {
				DFS(num * 10 + i, depth + 1);
			}
		}
	}
	
	public static boolean isPrime(int num) {
		
		for(int i = 2; i < num / 2; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}