package Level1;

import java.util.*;

public class Level1_14 {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] left = {0,0};
        int[] right = {2,0};

        Map<Integer, int[]> keyIndex = new HashMap<>();
        keyIndex.put(1, new int[]{0,3});
        keyIndex.put(2, new int[]{1,3});
        keyIndex.put(3, new int[]{2,3});
        keyIndex.put(4, new int[]{0,2});
        keyIndex.put(5, new int[]{1,2});
        keyIndex.put(6, new int[]{2,2});
        keyIndex.put(7, new int[]{0,1});
        keyIndex.put(8, new int[]{1,1});
        keyIndex.put(9, new int[]{2,1});
        keyIndex.put(0, new int[]{1,0});

        for(int n : numbers) {
            int[] target = keyIndex.get(n);

            // 1,4,7 무조건 왼손
            if (n == 1 || n == 4 || n == 7) {
                left = target.clone();
                answer.append("L");
                continue;
            }

            // 3,6,9 무조건 오른손
            if (n == 3 || n == 6 || n == 9) {
                right = target.clone();
                answer.append("R");
                continue;
            }

            // 나머지(2,5,8,0)는 거리 비교
            int rDistance = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);
            int lDistance = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);

            if (lDistance < rDistance) {
                left = target.clone();
                answer.append("L");
            } else if (lDistance > rDistance) {
                right = target.clone();
                answer.append("R");
            } else {
                if (isRightHand(hand)) {
                    right = target.clone();
                    answer.append("R");
                } else {
                    left = target.clone();
                    answer.append("L");
                }
            }
        }
        return answer.toString();
    }

    public boolean isRightHand(String hand) {
        return hand.equalsIgnoreCase("right");
    }

}