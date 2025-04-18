import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
}

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Point> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Point p = new Point(x, y);
			list.add(p);
		}		
		
		Collections.sort(list);
		
		for(Point p : list) {
			sb.append(p.x + " " + p.y + "\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}
}