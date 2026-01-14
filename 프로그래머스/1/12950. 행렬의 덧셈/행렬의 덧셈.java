class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        
        answer = new int[arr1.length][arr1[0].length];
        
        for(int n = 0; n < arr1.length; n++) {
            for(int m = 0; m < arr1[0].length; m++) {
                answer[n][m] = arr1[n][m] + arr2[n][m];
            }
        }
        
        return answer;
    }
}