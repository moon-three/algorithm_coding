import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String bookNum = sc.nextLine();
		
		int starIndex = bookNum.indexOf('*');
		int sum = 0;
		
		for(int i = 0; i < bookNum.length(); i++) {
			if(i == starIndex) {
				continue;
			}
			
			int num = bookNum.charAt(i) - '0';
			if(i % 2 == 0) {
				sum += num;
			} else {
				sum += num * 3;
			}
		}
		
		for(int i = 0; i <= 9; i++) {	// 0부터 9까지 하나씩 넣어보기
			
			int tmp = sum + (starIndex % 2 == 0 ? i : i * 3);
			
			if(tmp % 10 == 0) {		// 그 값이 10으로 나눠지면 종료
				System.out.println(i);
				break;
			}	
		}

		sc.close();
	}
}