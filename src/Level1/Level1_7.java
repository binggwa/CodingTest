package Level1;

public class Level1_7 {
    public int[] solution(String[] wallpaper) {
        int H = wallpaper.length;
        int W = wallpaper[0].length();

        // 최소/최대 좌표 초기화
        int lux = Integer.MAX_VALUE;  // 최소 행
        int luy = Integer.MAX_VALUE;  // 최소 열
        int rdx = Integer.MIN_VALUE;  // 최대 행
        int rdy = Integer.MIN_VALUE;  // 최대 열

        // 모든 좌표 탐색
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }
}
