class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        
        int point = phone_number.length() - 4;
        
        for(int i = 0; i < point; i++) {
            sb.append("*");
        }
        
        sb.append(phone_number.substring(point));
        
        return sb.toString();
    }
}