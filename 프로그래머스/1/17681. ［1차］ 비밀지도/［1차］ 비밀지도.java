class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String b1 = toBinary(n, arr1[i]);
            String b2 = toBinary(n, arr2[i]);
            for(int j = 0; j < n; j++) {
                if(b1.charAt(j) == '0' && b2.charAt(j) == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }  
        return answer;
    }
    
    public String toBinary(int n, int d) {
        return String.format("%"+ n + "s", Integer.toBinaryString(d)).replace(" ", "0");
    }
}