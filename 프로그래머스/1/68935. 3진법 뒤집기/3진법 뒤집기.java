class Solution {
    public int solution(int n) {

        String toThree = Integer.toString(n, 3);
        String reverse = "";
        for(int i = toThree.length() - 1; i >= 0; i--) {
            reverse += toThree.charAt(i);
        }
        
        return Integer.parseInt(reverse, 3);
    }
}