class Solution {
    public int solution(int[] array) {
        int[] arr = new int[1000];
        
        for(int i = 0; i < array.length; i++) {
            arr[array[i]]++; 
        }
        
        int answer = 0;
        int max = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                answer = i;
                cnt = 1;
            } else if(arr[i] == max) {
                cnt++;
            }
        }
        
        return cnt > 1 ? -1 : answer;
    }
}