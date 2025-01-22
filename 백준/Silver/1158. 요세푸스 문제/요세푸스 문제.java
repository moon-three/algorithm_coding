import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		IntStream.range(1, N + 1).forEach(x -> queue.add(x));
		
		int count = 0;
		
		while (!queue.isEmpty()) {
			int data = queue.poll();
			count++;
			
			if(count % K == 0) {
				list.add(data);
			} else {
				queue.add(data);
			}
		}
		
		String result = String.valueOf(list).replace("[", "<").replace("]", ">");
		System.out.println(result);
		
		br.close();
	}
}