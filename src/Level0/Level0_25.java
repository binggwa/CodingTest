package Level0;

public class Level0_25 {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;

        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if (ch == '1') {
                mode = 1 - mode;  // 0 <-> 1 모드 전환
            } else {
                if (mode == 0 && i % 2 == 0) {
                    ret.append(ch);
                } else if (mode == 1 && i % 2 == 1) {
                    ret.append(ch);
                }
            }
        }

        return ret.length() > 0 ? ret.toString() : "EMPTY";
    }
}
