package Level1;

public class Level1_3 {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;  // 보드 크기
        int count = 0;         // 같은 색 개수

        // 방향: 우, 하, 상, 좌
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        String color = board[h][w];

        for (int i = 0; i < 4; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];

            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                if (board[h_check][w_check].equals(color)) {
                    count++;
                }
            }
        }

        return count;
    }
}
