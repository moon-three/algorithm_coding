class Solution {
    public String solution(int[] numbers, String hand) {

        char[] L = {1, 4, 7, '*'};
        char[] M = {2, 5, 8, 0};
        char[] R = {3, 6, 9, '#'};

        int[] leftHand = new int[]{3,0};
        int[] rightHand = new int[]{3,2};

        StringBuilder sb = new StringBuilder();
        for(int data : numbers) {
            for(int i = 0; i < 4; i++) {
                if(data == L[i]) {
                    leftHand = new int[]{i,0};
                    sb.append("L");
                    break;
                }
                if(data == R[i]) {
                    rightHand = new int[]{i,2};
                    sb.append("R");
                    break;
                }
                if(data == M[i]) {
                    int[] mid = new int[]{i,1};
                    int leftDiff = Math.abs(mid[0]-leftHand[0]) + Math.abs(mid[1]-leftHand[1]);
                    int rightDiff = Math.abs(mid[0]-rightHand[0]) + Math.abs(mid[1]-rightHand[1]);

                    if(leftDiff > rightDiff) {
                        rightHand = mid;
                        sb.append("R");
                    } else if (leftDiff < rightDiff) {
                        leftHand = mid;
                        sb.append("L");
                    } else {
                        if(hand.equals("left")) {
                            leftHand = mid;
                            sb.append("L");
                        } else {
                            rightHand = mid;
                            sb.append("R");
                        }
                    }
                }
            }
        }

        return sb.toString();
    }
}