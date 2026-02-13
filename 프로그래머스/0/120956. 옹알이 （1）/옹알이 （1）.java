class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canDo = { "aya", "ye", "woo", "ma" };
        
        for(String s : babbling) {
            for(int i = 0; i < canDo.length; i++) {
                s = s.replace(canDo[i], " ");
            }
            s = s.replaceAll(" ", "");
            if(s.equals("")) {
                answer++;
            }
        }
        return answer;
    }
}