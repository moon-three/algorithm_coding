import java.util.List;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        List<Character> list = List.of('a', 'e', 'i', 'o', 'u');
        
        for(int i = 0; i < my_string.length(); i++) {
        	if(list.contains(my_string.charAt(i))) {
        		continue;
        	}
        	answer += my_string.charAt(i);
        }
        
        return answer;
    }
}