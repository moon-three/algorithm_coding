class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] sArr = my_string.split(" ");
        
        boolean isMinus = false;
        for(String s : sArr) {
            if(s.equals("+")) isMinus = false;
            else if(s.equals("-")) isMinus = true;
            else {
                int value = Integer.parseInt(s);
                if(isMinus) answer -= value;
                else answer += value;
            }
        }
        
        return answer;
    }
}