import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Word implements Comparable<Word>{

	String word = "";
	
	public Word(String word) {
		this.word = word;
	}
	
	@Override
	public int compareTo(Word o) {
		
		if(this.word.length() == o.word.length()) {
			return this.word.compareTo(o.word);
		}
		
		return this.word.length() - o.word.length();
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			set.add(s);
		}
		
		List<Word> list = new ArrayList<>();
		
		for(String s : set) {
			list.add(new Word(s));
		}
	
		Collections.sort(list);
	
		for(Word w : list) {
			sb.append(w.word).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}