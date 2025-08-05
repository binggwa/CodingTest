package Level1;

import java.util.*;

public class Level1_11 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];

        // 유저 인덱스 매핑 (id → index)
        Map<String, Integer> userIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            userIndex.put(id_list[i], i);
        }

        // 신고 기록 저장 (신고자 → 피신고자) 중복 제거
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String user : id_list) reportMap.put(user, new HashSet<>());

        for (String r : report) {
            String[] parts = r.split(" ");
            String from = parts[0];
            String to = parts[1];
            reportMap.get(from).add(to); // 중복 자동 제거
        }

        // 피신고자별 신고 횟수
        Map<String, Integer> reportedCount = new HashMap<>();
        for (String user : id_list) reportedCount.put(user, 0);

        for (String reporter : reportMap.keySet()) {
            for (String target : reportMap.get(reporter)) {
                reportedCount.put(target, reportedCount.get(target) + 1);
            }
        }

        // 정지된 유저 집합
        Set<String> banned = new HashSet<>();
        for (String user : id_list) {
            if (reportedCount.get(user) >= k) banned.add(user);
        }

        // 각 유저별 메일 수 계산
        for (String reporter : reportMap.keySet()) {
            int cnt = 0;
            for (String target : reportMap.get(reporter)) {
                if (banned.contains(target)) cnt++;
            }
            answer[userIndex.get(reporter)] = cnt;
        }

        return answer;
    }
}