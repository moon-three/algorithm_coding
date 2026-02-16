class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        double[] avgs = new double[score.length];
        for(int i = 0; i < score.length; i++) {
            avgs[i] = (score[i][0] + score[i][1]) / 2.0;
        }
        
        for(int i = 0; i < avgs.length; i++) {
            int rank = 1;
            for(int j = 0; j < avgs.length; j++) {
                if(avgs[i] < avgs[j]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }
 
        return answer;
    }
}