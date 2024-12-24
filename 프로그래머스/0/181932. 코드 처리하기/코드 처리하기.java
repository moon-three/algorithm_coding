class Solution {
    public String solution(String code) {
        String answer = "";
        
        // 모드를 따로 저장 후 짝수,홀수 구분    
        int[] mode = new int[code.length()];
        int modeValue = 0;
        
        // 1을 만나면 mode에 1을 더한다(mode가 짝수면 0이라는 의미)
        for(int i = 0; i < code.length(); i++) {
        	if(code.charAt(i) == '1') modeValue += 1;
        	mode[i] += modeValue;
        }       
        
        for(int i = 0; i < mode.length; i++) {
        	char ch = code.charAt(i);
        	
        	// mode가 0일때 : code[i]가 1이 아니면 짝수인 code[i]만 문자열 저장
        	if(mode[i] % 2 == 0 && i % 2 == 0 && ch != '1') answer += ch + "";
        	
        	// mode가 1일때 : code[i]가 1이 아니면 홀수인 code[i]만 문자열 저장	
        	else if (mode[i] % 2 != 0 && i % 2 != 0 && ch != '1') answer += ch + "";       	
        }
      
        if(answer == "") answer = "EMPTY";

        return answer;
    }
}