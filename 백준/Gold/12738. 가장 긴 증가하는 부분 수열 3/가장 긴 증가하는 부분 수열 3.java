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
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		System.out.println(getLength(N, arr));
		
		br.close();
	}
	
	public static int getLength(int N, long[] arr) {
		
		List<Long> list = new ArrayList<>();
		for(long l : arr) {
			int idx = Collections.binarySearch(list, l);
			if(idx < 0) idx = -(idx + 1);
			if(idx == list.size()) list.add(l);
			else list.set(idx, l);
		}
		
		return list.size();
	}	
}