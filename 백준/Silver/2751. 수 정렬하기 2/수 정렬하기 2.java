import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];	// 주어진 배열
		int[] tmp = new int[N];
		
		// 배열 초기화
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(arr, tmp, 0, arr.length - 1);
		
		for(int n : arr) {
			System.out.println(n);
		}
		br.close();
	}
	
	public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			// 재귀함수 -> 가장 작은 부분으로 쪼개서 서서히 정렬됨 (분할)
			mergeSort(arr, tmp, start, mid);	// 배열의 좌측부분
			mergeSort(arr, tmp, mid + 1, end);	// 배열의 우측부분
			merge(arr, tmp, start, end, mid);
		}
	}
	
	public static void merge(int[] arr, int[] tmp, int start, int end, int mid) {
		int p = start;
		int q = mid + 1;
		int idx = p;	// tmp 의 인덱스 값
		
		while(p <= mid || q <= end) {
			if(p <= mid && q <= end) {
				if(arr[p] <= arr[q]) {
					tmp[idx++] = arr[p++];
				} else {
					tmp[idx++] = arr[q++];
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