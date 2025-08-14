package Level1;

public class Level1_17 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;

        // 스케쥴에서 지정시간을 받아옴
        for(int i=0; i<schedules.length; i++) {
            // 스케쥴 / 100 int로 시간만 빼내고, 스케쥴 % 100 으로 분만 빼내고 분+10으로 H와 M에 저장
            int h = schedules[i] / 100;
            int m = schedules[i] % 100 + 10;
            // 만약 분이 60을 넘는다면, 분-60, 시+1
            if(m >= 60) {
                m = m-60;
                h = h+1;
            }
            int timeLimit = h * 100 + m;
            // timelogs에서 for j로 0부터 7일 굴려서 체크
            for(int j=0; j<7; j++) {
                // 만약 timelogs[i][j] 가 timeLimit보다 크면,
                // 이 때 해당 날짜가 토요일이나 일요일이 아니라면,(j+startday % 7 = 6도 7도 아니면)
                if(timelogs[i][j] > timeLimit && (j+startday != 6 && j+startday != 7 && j+startday != 13)) {
                    // 선물받을 직원수 감소 후 루프 탈출
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
}
