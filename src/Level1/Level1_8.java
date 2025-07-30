package Level1;

import java.util.*;

public class Level1_8 {
    public int[] solution(String today, String[] terms, String[] privacies) {

        // 날짜를 "YYYY.MM.DD" → 일수로 변환하는 메서드
        private int toDays(String date) {
            String[] arr = date.split("\\.");
            int y = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int d = Integer.parseInt(arr[2]);
            return y * 12 * 28 + m * 28 + d;
        }

        // today를 일수로 변환
        int todayVal = toDays(today);

        // 약관 유효기간 Map에 저장 (약관명 → 개월 수)
        Map<String, Integer> termMap = new HashMap<>();
        for (String t : terms) {
            String[] parts = t.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        // 파기할 개인정보 번호 저장
        List<Integer> expired = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            int collectDate = toDays(parts[0]);    // 수집일
            int termMonths = termMap.get(parts[1]); // 해당 약관 개월 수

            // 보관 가능 종료일 = 수집일 + (개월 * 28) - 1
            int expireDate = collectDate + (termMonths * 28) - 1;

            // 만약 today가 보관 가능일보다 크면 파기 대상
            if (todayVal > expireDate) {
                expired.add(i + 1); // 번호는 1부터 시작
            }
        }

        int[] result = new int[expired.size()];

        for (int i = 0; i < expired.size(); i++) {
            result[i] = expired.get(i);
        }

        return result;
    }
}
