import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 끊어진 기타줄 수
		int M = Integer.parseInt(st.nextToken());	// 가게
		
		int min = Integer.MAX_VALUE;
		
		int[] arr = {Integer.MAX_VALUE, Integer.MAX_VALUE};
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	// 6개 한 세트
			int b = Integer.parseInt(st.nextToken());	// 개당
			if(a < arr[0]) {
				arr[0] = a;
			}
			if(b < arr[1]) {
				arr[1] = b;
			}
		}
		
		
		int a = arr[0];	// 6개 한 세트
		int b = arr[1];	// 개당
		int price = b * N;	// 초기가격 = 전부 낱개로 산 가격
		if(N < 6) {
			if(a < price) {	// 세트로 하나 산 가격
				price = a;
			}
		} else {
			if(N % 6 == 0) {	// 세트로 산 가격
				if(a * (N / 6) < price) {
					price = a * (N / 6);
				}
			} else {					
				int tmp = a * (N / 6) + b * (N % 6);	// 세트 + 잔량낱개
				if(tmp < price) {
					price = tmp;
				}
				tmp = a * (N / 6 + 1);		// 전부 세트로 사는경우
				if(tmp < price) {
					price = tmp;
				}
			}
		}
		
		if(price < min) {
			min = price;
		}
			
		System.out.println(min);
		br.close();
		
	}
}
