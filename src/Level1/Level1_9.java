package Level1;

public class Level1_9 {
    public String solution(String X, String Y) {
        // 1. 숫자 빈도 카운트
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) countX[c - '0']++;
        for (char c : Y.toCharArray()) countY[c - '0']++;

        // 2. 공통 숫자를 큰 숫자부터 결과에 추가
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int common = Math.min(countX[i], countY[i]); // 짝지을 수 있는 개수
            for (int j = 0; j < common; j++) sb.append(i);
        }

        // 3. 결과가 없으면 "-1"
        if (sb.length() == 0) return "-1";

        // 4. 결과가 모두 0이면 "0"
        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}
