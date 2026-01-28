class Solution {
    public String solution(String letter) {
        String[] morse = { 
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---","-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };
        
        String[] sArr = letter.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sArr.length; i++) {
            String s = sArr[i];
            for(int j = 0; j < morse.length; j++) {
                if(s.equals(morse[j])) {
                    sb.append((char)('a' + j));
                }
            }
        }
        
        return sb.toString();
    }
}