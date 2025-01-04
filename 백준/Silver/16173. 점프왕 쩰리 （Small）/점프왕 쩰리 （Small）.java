import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int value;
	
	public Node(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
}


public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Node[][] node = new Node[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				node[i][j] = new Node(i, j, Integer.parseInt(st.nextToken()));	
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node[0][0]);		// 시작점을 먼저 queue에 넣는다
		boolean flag = false;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();	// 현재 위치를 queue에서 꺼낸다
			if(now.value == -1) {
				flag = true;
				break;	
			}
			if(now.value == 0) {
				continue;
			}
			if(now.x + now.value < N) {
				queue.add(node[now.x + now.value][now.y]);
			} 
			if(now.y + now.value < N) {
				queue.add(node[now.x][now.y + now.value]);
			}		
		}	
		
		if(flag) System.out.println("HaruHaru");
		else System.out.println("Hing");
		
		br.close();
	}
}