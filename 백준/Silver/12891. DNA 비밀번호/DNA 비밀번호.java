import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] checkArr = new int[4];	// 각각 포함되어야 할 개수
	static int[] myArr = new int[4];	// 체크하기 위한 변수
	static int checkedCnt = 0;		// 충족한 개수	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());	// DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken());	// 비밀번호 길이
		
		char[] dna = br.readLine().toCharArray();
	
		int resultCnt = 0;		// 비밀번호가 될 수 있는 종류의 수
		
		st = new StringTokenizer(br.readLine());
		// 만족해야하는 문자 개수
		for(int i = 0; i < checkArr.length; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0) {		// 0이면 어떤 수가 와도 충족
				checkedCnt++;
			}
		}
		
		// 초기 비밀번호 체크
		for(int i = 0; i < P; i++) {
			add(dna[i]);
		}
		
		if(checkedCnt == 4) {
			resultCnt++;
		}
		
		// 한칸씩 밀면서 확인
		for(int i = P; i < S; i++) {
			int j = i - P;
			add(dna[i]);
			remove(dna[j]);
			if(checkedCnt == 4) {
				resultCnt++;
			}
		}
		
		System.out.println(resultCnt);
		br.close();
		
	}
	public static void remove(char c) {
		switch(c) {
		case 'A':
			if(myArr[0] == checkArr[0]) {
				checkedCnt--;
			}
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1] == checkArr[1]) {
				checkedCnt--;
			}
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2] == checkArr[2]) {
				checkedCnt--;
			}
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) {
				checkedCnt--;
			}
			myArr[3]--;
			break;
		}
		
	}

	public static void add(char c) {
		switch(c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0]) {
				checkedCnt++;
			}
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1]) {
				checkedCnt++;
			}
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2] == checkArr[2]) {
				checkedCnt++;
			}
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3]) {
				checkedCnt++;
			}
			break;
		}
		
	}

}