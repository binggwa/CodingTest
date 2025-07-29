package Level1;

public class Level1_6 {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();
        int[] pos = new int[2];

        for (int i = 0; i < H; i++) {
            int idx = park[i].indexOf('S');
            if (idx != -1) {
                pos[0] = i;
                pos[1] = idx;
                break;
            }
        }

        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};
        String dirs = "NSWE";

        for (String route : routes) {
            String[] cmd = route.split(" ");
            char dir = cmd[0].charAt(0);
            int dist = Integer.parseInt(cmd[1]);

            int dirIdx = dirs.indexOf(dir);
            int nh = pos[0];
            int nw = pos[1];

            boolean canMove = true;

            for (int i = 1; i <= dist; i++) {
                int th = pos[0] + dh[dirIdx] * i;
                int tw = pos[1] + dw[dirIdx] * i;

                if (th < 0 || th >= H || tw < 0 || tw >= W || park[th].charAt(tw) == 'X') {
                    canMove = false;
                    break;
                }
                nh = th;
                nw = tw;
            }

            if (canMove) {
                pos[0] = nh;
                pos[1] = nw;
            }
        }

        return pos;
    }
}
