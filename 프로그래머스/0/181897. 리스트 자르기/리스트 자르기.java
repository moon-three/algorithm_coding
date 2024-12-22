import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
      
        // switch 로 풀고 for 문 돌리면 될 거 같음
  
        int start = slicer[0];
        int end = slicer[1];
        int range = 1;
        
        switch (n) {
        case 1 :	// n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
        	start = 0;
        	break;
        case 2 :	// n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
        	end = num_list.length - 1;
        	break;
        case 3 :	// n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
        	break;
        case 4 : 	// n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
        	range = slicer[2];
        	break;
        }
        
       List<Integer> list = new ArrayList<>();
        
        for(int i = start; i <= end; i += range) {
        	list.add(num_list[i]);
        }
        
        // 리스트를 int[] 배열로 변환
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        // stream()은 List에 있는 요소들을 순차적으로 처리할 수 있도록 Stream 객체를 생성하는 메서드
        // 이렇게 생성된 Stream 객체는 데이터 처리 파이프라인을 통해 요소들을 변환하거나 필터링할 수 있는 방법을 제공
        
        return answer;
    }
}