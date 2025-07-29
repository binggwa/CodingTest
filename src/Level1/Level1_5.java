package Level1;

import java.util.*;

public class Level1_5 {
    public String[] solution(String[] players, String[] callings) {
        // 이름 → 등수
        Map<String, Integer> nameToRank = new HashMap<>();
        // 등수 → 이름 (players 배열이 바로 역할)

        for (int i = 0; i < players.length; i++) {
            nameToRank.put(players[i], i);
        }

        for (String name : callings) {
            int curRank = nameToRank.get(name);
            int frontRank = curRank - 1;

            // 현재 이름과 앞 선수 이름
            String frontName = players[frontRank];

            // players 배열에서 위치 스왑
            players[frontRank] = name;
            players[curRank] = frontName;

            // nameToRank 맵에서도 순위 업데이트
            nameToRank.put(name, frontRank);
            nameToRank.put(frontName, curRank);
        }

        return players;
    }
}
