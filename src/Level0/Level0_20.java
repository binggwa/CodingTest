package Level0;

public class Level0_20 {
    public String solution(String[] arr) {
        StringBuilder answer = new StringBuilder();
        for (int i=0; i < arr.length; i++) {
            answer.append(arr[i]);
        }
        return answer.toString();
    }
}
