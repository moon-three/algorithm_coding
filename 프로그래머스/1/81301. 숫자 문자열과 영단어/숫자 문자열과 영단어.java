import java.util.HashMap;

class Solution {
    public int solution(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
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

        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                result.append(ch);
            } else {
                sb.append(ch);
                String word = sb.toString();
                if (hm.containsKey(word)) {
                    result.append(hm.get(word));
                    sb = new StringBuilder();
                }
            }
        }

        return Integer.parseInt(result.toString());
    }
}