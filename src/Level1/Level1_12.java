package Level1;

public class Level1_12 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zero_count = 0;
        int highest;
        int lowest;

        for (int i=0; i<lottos.length; i++) {
            if (lottos[i] == 0) {
                zero_count++;
            }
            for (int j=0; j<win_nums.length; j++) {
                if (lottos[i] == win_nums[j] && lottos[i] != 0) {
                    count++;
                }
            }
        }

        lowest = Math.min(6, 7-count);
        highest = Math.min(6, 7-(count+zero_count));

        answer[0] = highest;
        answer[1] = lowest;

        return answer;
    }
}
