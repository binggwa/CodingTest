package Level1;

import java.util.*;

public class Level1_1 {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 이름을 인덱스로 매핑
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(friends[i], i);
        }

        int[][] giftTable = new int[n][n];   // 누가 누구에게 몇 개 줬는지
        int[] given = new int[n];           // 각자 준 선물 수
        int[] received = new int[n];        // 각자 받은 선물 수
        int[] nextMonthReceive = new int[n]; // 다음 달 받을 선물 수

        // 선물 기록 처리
        for (String g : gifts) {
            String[] parts = g.split(" ");
            int giver = idxMap.get(parts[0]);
            int receiver = idxMap.get(parts[1]);
            giftTable[giver][receiver]++;
            given[giver]++;
            received[receiver]++;
        }

        // 선물 지수 계산
        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = given[i] - received[i];
        }

        // 모든 친구 쌍 검사
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) continue;

                int aToB = giftTable[i][j];
                int bToA = giftTable[j][i];

                if (aToB > bToA) {
                    nextMonthReceive[i]++;
                } else if (aToB < bToA) {
                    nextMonthReceive[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) {
                        nextMonthReceive[i]++;
                    } else if (giftIndex[i] < giftIndex[j]) {
                        nextMonthReceive[j]++;
                    }
                    // 지수도 같으면 아무 일도 없음
                }
            }
        }

        // 가장 많이 받는 친구의 수
        int answer = 0;
        for (int cnt : nextMonthReceive) {
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
