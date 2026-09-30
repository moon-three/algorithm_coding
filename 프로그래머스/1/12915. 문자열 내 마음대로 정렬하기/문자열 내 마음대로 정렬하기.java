import java.util.*;

class Solution {
    class Letter implements Comparable<Letter>{
        String word;
        char ch;
        
        public Letter(String word, char ch) {
            this.word = word;
            this.ch = ch;
        }
        
        public int compareTo(Letter o) {
            if(this.ch == o.ch) return this.word.compareTo(o.word);
            return this.ch - o.ch;
        }
    }
    
    public String[] solution(String[] strings, int n) {
        
        String[] answer = new String[strings.length];
        Letter[] letters = new Letter[strings.length];
        
        for(int i = 0; i < strings.length; i++) {
            Letter letter = new Letter(strings[i], strings[i].charAt(n));
            letters[i] = letter;
        }
        
        Arrays.sort(letters);
        
        for(int i = 0; i < letters.length; i++) {
            answer[i] = letters[i].word;
        }
        
        return answer;
    }
}