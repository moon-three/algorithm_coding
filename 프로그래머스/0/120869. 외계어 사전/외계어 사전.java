import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        int[] arr = new int[dic.length];
        
        for(int i = 0; i < spell.length; i++) {
            for(int j = 0; j < dic.length; j++) {
                if(!dic[j].contains(spell[i])) {
                    continue;
                }
                arr[j]++;
            }
        }
        
        for(int n : arr) {
            if(n == spell.length) return 1;
        }
        
        return 2;
    }
}