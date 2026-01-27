import java.util.HashMap;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        HashMap<String, Integer> hm =  new HashMap<>();
        hm.put("zero", 0);
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);
        hm.put("four", 4);
        hm.put("five", 5);
        hm.put("six", 6);
        hm.put("seven", 7);
        hm.put("eight", 8);
        hm.put("nine", 9);
        
        StringBuilder sb = new StringBuilder();
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if('0' <= ch && ch <= '9') {
                result += ch;
                continue;
            }
            sb.append(ch);
            if(sb.toString().length() >= 3) {
                for(int j = 0; j < hm.size(); j++) {
                    if(hm.containsKey(sb.toString())) {
                        result += hm.get(sb.toString());
                        sb = new StringBuilder();
                    }
                }
            }
        }
        
        answer = Integer.parseInt(result);
        return answer;
    }
}