import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int exp = 0;
	static int min = 0;
	static int L;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());	// 이벤트맵 
		int B = Integer.parseInt(st.nextToken());	// 심신 수련관
		int C = Integer.parseInt(st.nextToken());	// 사우나
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());	// 수련관 티켓
		int V = Integer.parseInt(st.nextToken());	// 사우나 티켓
		
		L = Integer.parseInt(br.readLine());
		
		useTicket(V, C);
		useTicket(S, B);
		
		while (L < 250) {
			exp += A;
			min++;
			if(exp >= 100) {
				exp -= 100;
				L++;
			}
		}	
		
		System.out.println(min);
		br.close();
	}
	
	public static void useTicket(int ticket, int expPerMin) {
		while (L < 250 && ticket > 0) {
			for(int i = 0; i < 30; i++) {
				if(L >= 250) {
					break;
				}
				exp += expPerMin;
				min++;
				if(exp >= 100) {
					exp -= 100;
					L += 1;
				}
			}
			ticket--;
		}
	}
}
