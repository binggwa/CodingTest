package Level1;

public class Level1_15 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] basket = new int[moves.length];
        int basketIndex = 0;

        for(int n : moves) {                                    // foreach를 통해 moves 숫자를 한번씩 다 받아옴
            for(int i = 0; i < board.length; i++) {             // 정사각형 판이므로 board.length를 높이로 설정
                if(board[i][n-1] != 0) {                        // moves에서 받아온 숫자 n-1이 board의 열이므로 열 순회를 통해 0이 아닌 값을 찾음
                    basket[basketIndex] = board[i][n-1];        // board[n-1]을 순회해서, 0이 아닌 숫자가 나오면, 해당 값을 결과바구니로 복사하고, 해당 칸을 0으로 바꿈
                    basketIndex++;
                    board[i][n-1] = 0;
                    // 결과바구니에서 같은 숫자가 만나면 둘 모두 결과바구니에서 빼고 answer count +2
                    if(basketIndex >= 2 && basket[basketIndex-1] == basket[basketIndex-2]) {
                        basket[basketIndex-1] = 0;
                        basket[basketIndex-2] = 0;
                        basketIndex = basketIndex - 2;
                        answer += 2;
                    }
                    break;
                }
            }
        }

        return answer;
    }

}
