class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        // 오른쪽이면 끝에꺼 뽑고 나머지
        // 왼쪽이면 1번인덱스부터 뽑고 끝에 처음꺼
        
        if (direction.equals("right")) {
        	answer[0] = numbers[numbers.length - 1];
        	
        	for(int i = 0; i < numbers.length - 1; i++) {
        		answer[i + 1] = numbers[i];
        	}
        }
        
        if(direction.equals("left")) {
        	for(int i = 0; i < numbers.length - 1; i++) {
        		answer[i] = numbers[i + 1];
        	}
        	answer[numbers.length - 1] = numbers[0];
        }
 
        return answer;
    }
}