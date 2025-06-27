import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		BigInteger factorial = BigInteger.ONE;
		int cnt = 0;
		
		for(int i = 2; i <= N; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}

		String s = String.valueOf(factorial);

		String[] sArr = s.split("");
		for(int i = sArr.length - 1; i >= 0; i--) {
			if(sArr[i].equals("0")) {
				cnt++;
			} else {
				break;
			}
		}

		System.out.println(cnt);
		sc.close();
		
	}
}
