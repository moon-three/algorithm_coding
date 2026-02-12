class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        for(String key : keyinput) {  
            move(answer, board, key);
        }
        return answer;
    }
    
    public void move(int[] answer, int[] board, String dir) {
         switch(dir) {
                case "up":
                    if(answer[1] < board[1] / 2) {
                        answer[1]++;
                    }
                    break;
                case "down":
                    if(answer[1] > -board[1] / 2) {
                        answer[1]--;
                    }
                    break;
                case "left": 
                    if(answer[0] > -board[0] / 2) {
                        answer[0]--;
                    }
                    break;
                case "right": 
                    if(answer[0] < board[0] / 2) {
                        answer[0]++;
                    }
                    break;
            }
    }
    
}