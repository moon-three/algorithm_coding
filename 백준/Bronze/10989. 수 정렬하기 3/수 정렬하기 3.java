import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		// 초기화
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 기수정렬
		radixSort(arr, 5);
		
		for(int i : arr) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}
	
	public static void radixSort(int[] arr, int maxCnt) {
		int[] tmp = new int[arr.length];	// 변경된 값을 임의로 담아둘 배열
		int div = 1;	// 나눌 자릿수
		int cnt = 0;	
		
		while(cnt <= maxCnt) {	// 최대 자릿수만큼 반복
			int[] bucket = new int[10];	// 0부터 9까지의 배열
			
			for(int i = 0; i < arr.length; i++) {	// 각 자릿수의 개수를 구하고
				bucket[arr[i] / div % 10]++;	
			}
			
			for(int i = 1; i < bucket.length; i++) {	// 누적합을 이용 (위치를 알아내기 위해)
				bucket[i] += bucket[i - 1];
			}
			
			for(int i = arr.length - 1; i >= 0; i--) {
				tmp[bucket[arr[i] / div % 10] - 1] = arr[i];
				bucket[arr[i] / div % 10]--;
			}
			
			// 값 복사
			for(int i = 0; i < arr.length; i++) {
				arr[i] = tmp[i];
			}
			
			div *= 10;
			cnt++;
		}
	}
}