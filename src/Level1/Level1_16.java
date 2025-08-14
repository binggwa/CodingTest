package Level1;

import java.util.*;

public class Level1_16 {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        // participant 배열을 순회하면서 HashMap에 이름을 카운트
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // completion 배열을 순회하면서 해당 이름의 카운트를 감소
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // HashMap을 순회하여 value가 0보다 큰 이름 찾기
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        return "";
    }
}
