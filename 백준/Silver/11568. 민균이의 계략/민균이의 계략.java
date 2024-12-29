import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(maxNumber(N, arr));
	}
	
	public static int maxNumber (int N, int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int num : arr) {
			int pos = Collections.binarySearch(list, num);
			if(pos < 0) pos = -(pos + 1);
			if(pos == list.size()) list.add(num);
			else list.set(pos, num);
		}
		
		return list.size();
	}
}