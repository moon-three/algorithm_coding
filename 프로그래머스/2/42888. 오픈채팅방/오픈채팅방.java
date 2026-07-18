import java.util.*;

class Solution {
    class Action {
        String action;
        String id;

        public Action(String action, String id) {
            this.action = action;
            this.id = id;
        }
    }
    
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<Action> actions = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++) {
            String[] sArr = record[i].split(" ");
            if(sArr[0].equals("Enter") || sArr[0].equals("Change")) {
                map.put(sArr[1], sArr[2]);
            }
            
            if(sArr[0].equals("Change")) continue;
            actions.add(new Action(sArr[0], sArr[1]));
        }
        
        String[] result = new String[actions.size()];
        
        for(int i = 0; i < actions.size(); i++) {
            String name = map.get(actions.get(i).id);
            if(actions.get(i).action.equals("Enter")) {
                result[i] = name + "님이 들어왔습니다.";
            } else {
                result[i] = name + "님이 나갔습니다.";
            }
        }
        
        return result;
    }
}