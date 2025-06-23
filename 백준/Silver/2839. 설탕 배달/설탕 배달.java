import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// 5를 가장 많이 쓸 수 있는 경우부터 
		// 전부 3으로 나눠지는경우 (-> 봉지가 제일 많이 필요함)
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int answer = -1;
		
		for(int i = N / 5; i >= 0; i--) {
			int remain = N - (5 * i);
			if(remain % 3 == 0) {
				answer = i + (remain / 3);
				break;
			}
		}
		
		System.out.println(answer);
	}
}