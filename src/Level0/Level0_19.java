package Level0;

public class Level0_19 {
    public String solution(String str1, String str2) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            answer.append(str1.charAt(i));
            answer.append(str2.charAt(i));
        }
        return answer.toString(); // 반드시 호출해야 함!
    }
}
