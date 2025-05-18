import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y; 
	}

	@Override
	public int compareTo(Point o) {
		if(this.y == o.y) {
			return this.x - o.x;
		}
		return this.y - o.y;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Point[] arr = new Point[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Point(x, y);
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i].x + " " + arr[i].y);
		}
		br.close();
	}
}
