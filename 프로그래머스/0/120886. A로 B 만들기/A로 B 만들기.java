class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        
        int[] arr = new int['z' - 'a' + 1];
        
        for(int i = 0; i < before.length(); i++) {
            arr[before.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < after.length(); i++) {
            arr[after.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                return 0;
            }
        }
        
        return answer;
    }
}