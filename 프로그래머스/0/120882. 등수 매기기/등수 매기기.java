class Solution {
    public int[] solution(int[][] score) {
        int length = score.length;
        int[] answer = new int[length];
        
        double[] avgs = new double[length];
        for(int i = 0; i < length; i++) {
            avgs[i] = (score[i][0] + score[i][1]) / 2.0;
        }
        
        for(int i = 0; i < length; i++) {
            int rank = 1;
            for(int j = 0; j < length; j++) {
                if(avgs[i] < avgs[j]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }
 
        return answer;
    }
}