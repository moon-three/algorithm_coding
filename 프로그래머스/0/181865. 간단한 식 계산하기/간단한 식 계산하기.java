class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] s = binomial.split(" ");
        
        int a = Integer.parseInt(s[0]);
        String b = s[1];
        int c = Integer.parseInt(s[2]);
      
        switch (b) {
            case "+":
                answer = a + c;
                break;
            case "-":
                answer = a - c;
                break;
            case "*":
                answer = a * c;
                break;     
        }
       
        return answer;
    }
}