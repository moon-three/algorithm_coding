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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// StringTokenizer => 띄어쓰기를 기준으로 읽어온다
		
		int[] arr = new int[N];
		for(int i = N - 1; i >= 0; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(subCount(N, arr));
		
		br.close();		
	}	

	public static int subCount(int N, int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int i : arr) {
			int pos = Collections.binarySearch(list, i);
			if(pos < 0) pos = -(pos + 1);
			if(pos == list.size()) list.add(i);
			else list.set(pos, i);
		}
		return N - list.size();
	}
}