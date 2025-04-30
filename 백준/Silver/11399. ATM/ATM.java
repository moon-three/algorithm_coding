import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// 삽입정렬로 문제풀어보기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sum = new int[N];
		int total = 0;
		
		// 배열 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 삽입정렬
		for(int i = 1; i < N; i++) {
			int idx = i;		// 인덱스
			int value = arr[i];	// 해당 값
			// 정렬된 데이터와 비교하기
			for(int j = i - 1; j >= 0; j--) {	
				if(arr[j] < value) {	// 정렬된 마지막 데이터보다 값이 더 크면
					idx = j + 1;
					break;	 // 더이상 비교할 필요가 없다
				}
				if(j == 0) {
					idx = 0;
				}
			}
			// 배열 재정렬
			for(int j = i; j > idx; j--) {
				arr[j] = arr[j -1];
			}
			// 구한 인덱스에 값 넣기
			arr[idx] = value;
		}
		// 합배열
		sum[0] = arr[0];
		for(int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		// 계산
		for(int i : sum) {
			total += i;
		}
		
		System.out.println(total);
		br.close();
	}
}