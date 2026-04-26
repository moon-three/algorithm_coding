class Solution {
    public int solution(int a, int b) {
    
        int value = gcd(a, b);
        b /= value;
        
        while(b % 5 == 0) b /= 5;
        while(b % 2 == 0) b /= 2;
        
        if(b == 1) return 1;
        else return 2;

    }
    
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}