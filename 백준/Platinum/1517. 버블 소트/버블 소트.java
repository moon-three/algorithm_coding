import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] tmp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr, tmp, 0, arr.length - 1);
		System.out.println(cnt);
		br.close();
	}
	
	public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid + 1, end);
			merge(arr, tmp, start, end, mid);
		}
	}
	
	public static void merge(int[] arr, int[] tmp, int start, int end, int mid) {
		int p = start;		// 왼쪽 배열 시작 인덱스
		int q = mid + 1;	// 오른쪽 배열 시작 인덱스
		int idx = p;
		
		while(p <= mid || q <= end) {
			if(p <= mid && q <= end) {
				if(arr[p] <= arr[q]) {
					tmp[idx++] = arr[p++];
				} else {	// arr[q](오른쪽배열의 데이터)가 더 작은 경우
					tmp[idx++] = arr[q++];
					cnt += mid - p + 1;	// swap (mid 부터 왼쪽배열 값 인덱스차이만큼)
				}
			} else if(p <= mid && q > end) {
				tmp[idx++] = arr[p++];
			} else {
				tmp[idx++] = arr[q++];
			}
		}
		
		for(int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
	}
	
}