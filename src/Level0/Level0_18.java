package Level0;

public class Level0_18 {
    public String solution(String my_string, String overwrite_string, int s) {
        String front = my_string.substring(0, s);
        String back = "";
        int endIndex = s + overwrite_string.length();
        if (endIndex < my_string.length()) {
            back = my_string.substring(endIndex);
        }
        return front + overwrite_string + back;
    }
}
