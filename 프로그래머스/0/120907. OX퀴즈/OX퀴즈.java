class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++) {
            String[] sArr = quiz[i].split(" ");

            int a = Integer.parseInt(sArr[0]);
            int b = Integer.parseInt(sArr[2]);
            boolean isPlus = sArr[1].equals("+")? true : false;
            
            int result = 0;
            if(isPlus) result = a + b;
            else result = a - b;
            
            if(result == Integer.parseInt(sArr[4])) answer[i] = "O";
            else answer[i] = "X";
        }
        
        return answer;
    }
}