import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		boolean[] isBad = new boolean[(int) (max - min + 1)];
		
		for(long i = 2; i * i <= max; i++) {
			long pow = i * i;
			long start = min / pow;		// 시작 위치
			if(min % pow != 0) {		// 나눠떨어지지않으면 1더한거부터 시작
				start += 1;
			}
			for(long j = start; j * pow <= max; j++) {
				isBad[(int) ((j * pow) - min)] = true;	// min부터 0번 인덱스이기 때문에 min빼줘야함
			}	
		}
		
		int cnt = 0;
		for(int i = 0; i < isBad.length; i++) {
			if(!isBad[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}
