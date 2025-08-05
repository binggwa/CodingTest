package Level1;

public class Level1_10 {
    public String solution(String[] survey, int[] choices) {
        // R-T, C-F, J-M, A-N 순서로 인덱스 매핑
        String types = "RTCFJMAN";
        int[] scores = new int[8]; // 8개 성격 유형 점수 저장

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int diff = choices[i] - 4; // 4는 중립 기준

            if (diff > 0) { // 동의 → second 점수 증가
                scores[types.indexOf(second)] += diff;
            } else if (diff < 0) { // 비동의 → first 점수 증가
                scores[types.indexOf(first)] += -diff;
            }
        }

        // 최종 성격 유형 계산
        StringBuilder result = new StringBuilder();
        result.append(scores[0] >= scores[1] ? "R" : "T");
        result.append(scores[2] >= scores[3] ? "C" : "F");
        result.append(scores[4] >= scores[5] ? "J" : "M");
        result.append(scores[6] >= scores[7] ? "A" : "N");

        return result.toString();
    }
}