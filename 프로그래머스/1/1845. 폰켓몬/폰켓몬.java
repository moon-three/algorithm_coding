import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // set 개수가 더 크면 배열의 반, set 개수가 더 작으면 set 개수
        
//      List list = Arrays.asList(nums); // int[] 로 들어와서 안되는건가..
//      Set set = new HashSet(list);
        
//      if(set.size() >= (nums.length / 2)) {
//          answer = nums.length / 2;
//      } else answer = set.size();
        
        // --> primitive 배열은 WrapperClass List 로 바로 변환되지 않는다
        // --> set.add로 담아줘야해 ...
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        int half = nums.length / 2;    // 배열 길이의 절반
        int kind = set.size();         // 종류의 개수 
        answer = half < kind ? half : kind;
        
        return answer;
    }
}